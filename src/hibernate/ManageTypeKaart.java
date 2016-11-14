package hibernate;
import model.Korting;
import model.TypeKaart;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by thibaut on 31/10/2016.
 */
public class ManageTypeKaart {
    public Integer addTypeKaart(TypeKaart a) {

        SessionFactory factory = SessionFactorySingleton.getInstance().getSessionFactory();
        Session session = factory.openSession();
        Transaction tx = null;
        Integer id = null;
        try {
            tx = session.beginTransaction();
            id = (Integer) session.save(a);

            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return id;
    }


    public List<TypeKaart> listTypeKaarten( ){
        SessionFactory factory = SessionFactorySingleton.getInstance().getSessionFactory();
        List<TypeKaart> typekaarten = new ArrayList<TypeKaart>();

        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            typekaarten = session.createQuery("FROM TypeKaart where active = true").list();

            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
            return typekaarten;
        }
    }


    public void updateTypeKaart(TypeKaart type ){
        SessionFactory factory = SessionFactorySingleton.getInstance().getSessionFactory();
        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();

            session.update(type);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }
    public TypeKaart getTypeKaartById(int id){
        SessionFactory factory = SessionFactorySingleton.getInstance().getSessionFactory();

        Session session = factory.openSession();
        Transaction tx = null;
        TypeKaart tk = null;
        try{
            tx = session.beginTransaction();
            tk =  (TypeKaart) session.get(TypeKaart.class, id);
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return tk;
    }

    public List<TypeKaart> getTypeKaartByKorting(Korting k){
        SessionFactory factory = SessionFactorySingleton.getInstance().getSessionFactory();

        Session session = factory.openSession();
        Transaction tx = null;
        List<TypeKaart> typeKaarten = new ArrayList<TypeKaart>();
        try{
            tx = session.beginTransaction();
            String hql = "FROM TypeKaart WHERE korting = :korting AND active = true";
            Query query = session.createQuery(hql);
            query.setParameter("korting", k);

            typeKaarten = query.list();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return typeKaarten;
    }

    public boolean deleteTypeKaartById(int id){
        SessionFactory factory = SessionFactorySingleton.getInstance().getSessionFactory();
        Session session = factory.openSession();
        TypeKaart k = null;
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            k = (TypeKaart) session.load(TypeKaart.class,id);
            session.delete(k);
            //This makes the pending delete to be done
            session.flush() ;
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
            return true;
        }
    }
}

