package hibernate;
import java.util.ArrayList;
import model.Voorwerp;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Iterator;
import java.util.List;

/**
 * Created by thibaut on 31/10/2016.
 */
public class ManageVoorwerp {
    public Integer addVoorwerp(Voorwerp v) {

        SessionFactory factory = SessionFactorySingleton.getInstance().getSessionFactory();
        Session session = factory.openSession();
        Transaction tx = null;
        Integer voorwerpId = null;
        try {
            tx = session.beginTransaction();
            voorwerpId = (Integer)session.save(v);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return voorwerpId;
    }


    public List<Voorwerp> listVoorwerp( ){
        SessionFactory factory = SessionFactorySingleton.getInstance().getSessionFactory();

        Session session = factory.openSession();
        Transaction tx = null;
        List<Voorwerp> voorwerpen = new ArrayList<Voorwerp>();
        try{
            tx = session.beginTransaction();
           voorwerpen = session.createQuery("FROM Voorwerp").list();

            tx.commit();

        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return voorwerpen;
    }


    public void updateVoorwerpId(Voorwerp a, int integer ){
        SessionFactory factory = SessionFactorySingleton.getInstance().getSessionFactory();
        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            Voorwerp voorwerp =(Voorwerp) session.get(Voorwerp.class, integer);
            voorwerp.setVoorwerpId(integer);
            session.update(voorwerp);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }


}

