package hibernate;
import java.util.ArrayList;

import model.Route;
import model.Voorwerp;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.Iterator;
import java.util.List;
import java.util.Vector;

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


    public Vector<Voorwerp> listVoorwerp( ){
        SessionFactory factory = SessionFactorySingleton.getInstance().getSessionFactory();

        Session session = factory.openSession();
        Transaction tx = null;
        List<Voorwerp> voorwerpen = new ArrayList<Voorwerp>();
        try{
            tx = session.beginTransaction();
           voorwerpen = session.createQuery("FROM Voorwerp where active = true").list();

            tx.commit();

        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        Vector<Voorwerp>vw = new Vector<Voorwerp>();
        for (int i = 0; i < voorwerpen.size();i++){
            vw.add(voorwerpen.get(i));
        }
        return vw;
    }


    public void updateVoorwerp(Voorwerp a){
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

    public Voorwerp getVoorwerpById(int id){

        SessionFactory factory = SessionFactorySingleton.getInstance().getSessionFactory();
        Session session = factory.openSession();
        Voorwerp v = null;
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            v =  (Voorwerp) session.get(Voorwerp.class, id);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
            return v;
        }
    }

    public List<Voorwerp> getVoorwerpByTreinId(int id){
        SessionFactory factory = SessionFactorySingleton.getInstance().getSessionFactory();

        Session session = factory.openSession();
        Transaction tx = null;
        List<Voorwerp> voorwerpen = new ArrayList<Voorwerp>();
        try{
            tx = session.beginTransaction();
            String hql = "FROM Voorwerp WHERE trein = :id AND active = true";
            Query query = session.createQuery(hql);
            query.setParameter("id", id);

            voorwerpen = query.list();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return voorwerpen;
    }

    public List<Voorwerp> getVoorwerpByRoute(Route r){
        SessionFactory factory = SessionFactorySingleton.getInstance().getSessionFactory();

        Session session = factory.openSession();
        Transaction tx = null;
        List<Voorwerp> voorwerpen = new ArrayList<Voorwerp>();
        try{
            tx = session.beginTransaction();
            String hql = "FROM Voorwerp WHERE route = :route AND active = true";
            Query query = session.createQuery(hql);
            query.setParameter("route", r);

            voorwerpen = query.list();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return voorwerpen;

    }

    public List<Voorwerp> getVoorwerpByKleur(String kleur){
        SessionFactory factory = SessionFactorySingleton.getInstance().getSessionFactory();

        Session session = factory.openSession();
        Transaction tx = null;
        List<Voorwerp> voorwerpen = new ArrayList<Voorwerp>();
        try{
            tx = session.beginTransaction();
            String hql = "FROM Voorwerp WHERE kleur like :kleur AND active = true";
            Query query = session.createQuery(hql);
            query.setParameter("kleur", kleur);

            voorwerpen = query.list();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return voorwerpen;

    }


    public boolean deleteVoorwerpById(int id){
        SessionFactory factory = SessionFactorySingleton.getInstance().getSessionFactory();
        Session session = factory.openSession();
        Voorwerp v = null;
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            v = (Voorwerp)session.load(Voorwerp.class,id);
            session.delete(v);
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

