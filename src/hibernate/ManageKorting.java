package hibernate;
import java.util.ArrayList;

import model.Korting;
import model.Voorwerp;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.Iterator;
import java.util.List;

/**
 * Created by thibaut on 31/10/2016.
 */
public class ManageKorting {
    public Integer addKorting(Korting k) {

        SessionFactory factory = SessionFactorySingleton.getInstance().getSessionFactory();
        Session session = factory.openSession();
        Transaction tx = null;
        Integer kortingId = null;
        try {
            tx = session.beginTransaction();
            kortingId = (Integer)session.save(k);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return kortingId;
    }


    public List<Korting> listKorting( ){
        SessionFactory factory = SessionFactorySingleton.getInstance().getSessionFactory();

        Session session = factory.openSession();
        Transaction tx = null;
        List<Korting> kortingen = new ArrayList<Korting>();
        try{
            tx = session.beginTransaction();
            kortingen = session.createQuery("FROM Korting where active = true").list();

            tx.commit();

        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return kortingen;
    }


    public void updateKorting(Korting a ){
        SessionFactory factory = SessionFactorySingleton.getInstance().getSessionFactory();
        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            session.update(a);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

    public boolean deleteKortingByID(int id){
        SessionFactory factory = SessionFactorySingleton.getInstance().getSessionFactory();
        Session session = factory.openSession();
        Korting k = null;
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            k = session.load(Korting.class,id);
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

    public Korting getKortingByid(int id){
        SessionFactory factory = SessionFactorySingleton.getInstance().getSessionFactory();

        Session session = factory.openSession();
        Transaction tx = null;
     Korting k = null;
        try{
            tx = session.beginTransaction();
            k = session.get(Korting.class, id);
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return k;
    }


}

