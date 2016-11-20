package hibernate;

import model.Station;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Iterator;
import java.util.List;

/**
 * Created by Manish on 30/10/2016.
 */
public class ManageStation {

    /* Method to CREATE an Abonnement in the database */
    public Integer addStation(Station st){

        SessionFactory factory = SessionFactorySingleton.getInstance().getSessionFactory();
        Session session = factory.openSession();
        Transaction tx = null;
        Integer abonnementId = null;
        try{
            tx = session.beginTransaction();

           abonnementId = (Integer)session.save(st);

              //  session.save(st);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return abonnementId;
    }


    public void listStations( ){
        SessionFactory factory = SessionFactorySingleton.getInstance().getSessionFactory();

        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            List abonnementen = session.createQuery("FROM Station").list();
            for (Iterator iterator =
                 abonnementen.iterator(); iterator.hasNext();){
                Station st = (Station) iterator.next();
                System.out.println("Station id: " + st.getStationId());

            }
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }
}
