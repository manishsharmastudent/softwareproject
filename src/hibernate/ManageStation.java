package hibernate;

import model.Station;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
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


    public List<Station> listStations( ){
        SessionFactory factory = SessionFactorySingleton.getInstance().getSessionFactory();

        Session session = factory.openSession();
        Transaction tx = null;
        List<Station> stations = new ArrayList<Station>();
        try{
            tx = session.beginTransaction();
            stations = session.createQuery("FROM Station").list();
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return stations;
    }
    public Station getStationById(int id) {
        SessionFactory factory = SessionFactorySingleton.getInstance().getSessionFactory();
        Session session = factory.openSession();
        Station station = null;
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            station = (Station) session.get(Station.class, id);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
            return station;
        }
    }
    public List<Station> getAllStationsBoxes() {
        SessionFactory factory = SessionFactorySingleton.getInstance().getSessionFactory();

        Session session = factory.openSession();
        Transaction tx = null;
        List<Station> stations = new ArrayList<Station>();
        try {
            tx = session.beginTransaction();
            stations = session.createQuery("FROM Station").list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return stations;
    }
}
