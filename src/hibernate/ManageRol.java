package hibernate;

import model.Rol;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Robbe on 30/10/2016.
 */
public class ManageRol {

    /* Method to CREATE a Klant in the database */
    public Integer addRol(Rol a){

        SessionFactory factory = SessionFactorySingleton.getInstance().getSessionFactory();
        Session session = factory.openSession();
        Transaction tx = null;
        Integer rolId = null;
        try{
            tx = session.beginTransaction();

            rolId = (Integer)session.save(a);

            //  session.save(a);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return rolId;
    }


    public List<Rol> listRollen( ){
        SessionFactory factory = SessionFactorySingleton.getInstance().getSessionFactory();
        Session session = factory.openSession();
        Transaction tx = null;
        List<Rol> rollen = new ArrayList<Rol>();

        try{
            tx = session.beginTransaction();
            rollen = session.createQuery("FROM Rol").list();
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return rollen;
    }


    public Rol getRol(int rolId){
        SessionFactory factory = SessionFactorySingleton.getInstance().getSessionFactory();
        Session session = factory.openSession();
        Rol rol = null;
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            rol = (Rol) session.createQuery("FROM Rol WHERE rolId = :rol").setParameter("rol", rolId).uniqueResult();
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return rol;
    }


}
