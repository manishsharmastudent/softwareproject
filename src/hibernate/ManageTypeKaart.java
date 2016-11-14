package hibernate;
import model.TypeKaart;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

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


    public void listTypeKaarten( ){
        SessionFactory factory = SessionFactorySingleton.getInstance().getSessionFactory();

        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            List typeKaarten = session.createQuery("FROM TypeKaart").list();
            for (Iterator iterator =
                 typeKaarten.iterator(); iterator.hasNext();){
                TypeKaart a = (TypeKaart) iterator.next();
                System.out.println("typeKaart id: " + a.getId());

            }
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }


    public void updateType(Integer id, TypeKaart type ){
        SessionFactory factory = SessionFactorySingleton.getInstance().getSessionFactory();
        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            TypeKaart kaart =(TypeKaart) session.get(TypeKaart.class, id);
            kaart.setNaam(type.getNaam());
            session.update(kaart);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }


}

