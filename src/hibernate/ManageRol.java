package hibernate;

import model.Rol;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Iterator;
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


    public void listRollen( ){
        SessionFactory factory = SessionFactorySingleton.getInstance().getSessionFactory();

        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            List klanten = session.createQuery("FROM Rol").list();
            for (Iterator iterator =
                 klanten.iterator(); iterator.hasNext();){
                Rol a = (Rol) iterator.next();
            }
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }


    public Rol getRol(int rolId){
        SessionFactory factory = SessionFactorySingleton.getInstance().getSessionFactory();
        Session session = factory.openSession();
        Rol rol = null;
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            /*
            tx = session.beginTransaction();
            String hql = "FROM Klant WHERE rijksregisterNummer = :rrn";
            Klant klant = (Klant) session.createQuery(hql).uniqueResult();
            query.setParameter("rrn",rijksregisterNummer);
            klanten = query.list();
*/
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
