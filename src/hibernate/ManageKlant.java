package hibernate;

import model.Klant;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Iterator;
import java.util.List;

/**
 * Created by Robbe on 30/10/2016.
 */
public class ManageKlant {

    /* Method to CREATE a Klant in the database */
    public Integer addKlant(Klant a){

        SessionFactory factory = SessionFactorySingleton.getInstance().getSessionFactory();
        Session session = factory.openSession();
        Transaction tx = null;
        Integer klantId = null;
        try{
            tx = session.beginTransaction();

            session.save(a);

            //  session.save(a);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return klantId;
    }


    public void listKlanten( ){
        SessionFactory factory = SessionFactorySingleton.getInstance().getSessionFactory();

        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            List klanten = session.createQuery("FROM Klant").list();
            for (Iterator iterator =
                klanten.iterator(); iterator.hasNext();){
                Klant a = (Klant) iterator.next();
            }
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }


    public Klant getKlant(String rijksregisterNummer){
        SessionFactory factory = SessionFactorySingleton.getInstance().getSessionFactory();
        Session session = factory.openSession();
        Klant klant = null;
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
            klant = (Klant) session.createQuery("FROM Klant WHERE rijksregisterNummer = :rrn").setParameter("rrn", rijksregisterNummer).uniqueResult();
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return klant;
    }


}
