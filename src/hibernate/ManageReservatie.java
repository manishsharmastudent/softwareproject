package hibernate;

import model.Reservatie;
import model.Station;
import model.Ticket;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rik Van Belle on 31/12/2016.
 */
public class ManageReservatie {
    public int addReservatie(Reservatie reservatie){

        SessionFactory factory = SessionFactorySingleton.getInstance().getSessionFactory();
        Session session = factory.openSession();
        Transaction tx = null;
        Integer reservatienr = null;
        try{
            tx = session.beginTransaction();

            reservatienr = (Integer)session.save(reservatie);

            //  session.save(st);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return reservatienr;
    }
    public void updateReservatie(Reservatie reservatie){
        SessionFactory factory = SessionFactorySingleton.getInstance().getSessionFactory();
        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            session.update(reservatie);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }
    public Reservatie getReservatieById(int id){
        SessionFactory factory = SessionFactorySingleton.getInstance().getSessionFactory();
        Session session = factory.openSession();
        Reservatie reservatie = null;
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            reservatie = session.get(Reservatie.class, id);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
            return reservatie;
        }
    }
    public List<Reservatie> listReservaties(){
        SessionFactory factory = SessionFactorySingleton.getInstance().getSessionFactory();

        Session session = factory.openSession();
        Transaction tx = null;
        List<Reservatie> reservatieList = new ArrayList<Reservatie>();
        try{
            tx = session.beginTransaction();
            reservatieList = session.createQuery("FROM Reservatie").list();

            tx.commit();

        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return reservatieList;
    }
    public List<Reservatie> getReservatieByGroepsnaam(String groepsnaam){
        SessionFactory factory = SessionFactorySingleton.getInstance().getSessionFactory();

        Session session = factory.openSession();
        Transaction tx = null;
        List<Reservatie> reservatieList = new ArrayList<>();
        Query query= null;
        try{
            tx = session.beginTransaction();
            String hql = "FROM Reservatie WHERE groepsnaam = :groepsnaam AND active = true";
            query = session.createQuery(hql);
            query.setParameter("groepsnaam", groepsnaam);
            reservatieList = query.list();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return reservatieList;
    }
    public List<Reservatie> getReservatieByVertrekStation(Station vertrekStation){
        SessionFactory factory = SessionFactorySingleton.getInstance().getSessionFactory();

        Session session = factory.openSession();
        Transaction tx = null;
        List<Reservatie> reservatieList = new ArrayList<>();
        Query query= null;
        try{
            tx = session.beginTransaction();
            String hql = "FROM Reservatie WHERE vertrekStation = :station AND active = true";
            query = session.createQuery(hql);
            query.setParameter("station", vertrekStation);
            reservatieList = query.list();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return reservatieList;
    }
    public List<Reservatie> getReservatieByAankomstStation(Station aankomstStation){
        SessionFactory factory = SessionFactorySingleton.getInstance().getSessionFactory();

        Session session = factory.openSession();
        Transaction tx = null;
        List<Reservatie> reservatieList = new ArrayList<>();
        Query query= null;
        try{
            tx = session.beginTransaction();
            String hql = "FROM Reservatie WHERE aankomstStation = :station AND active = true";
            query = session.createQuery(hql);
            query.setParameter("station", aankomstStation);
            reservatieList = query.list();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return reservatieList;
    }
}

