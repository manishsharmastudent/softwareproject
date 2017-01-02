package hibernate;

import model.Abonnement;
import model.Klant;
import model.Login;
import model.Route;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Manish on 30/10/2016.
 */
public class ManageAbonnement {

    /* Method to CREATE an Abonnement in the database */
    public Integer addAbonnement(Abonnement a){

        SessionFactory factory = SessionFactorySingleton.getInstance().getSessionFactory();
        Session session = factory.openSession();
        Transaction tx = null;
        Integer abonnementId = null;
        try{
            tx = session.beginTransaction();

           abonnementId = (Integer)session.save(a);

              //  session.save(a);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return abonnementId;
    }

    public List<Abonnement> listAbonnementen( ){
        SessionFactory factory = SessionFactorySingleton.getInstance().getSessionFactory();

        Session session = factory.openSession();
        Transaction tx = null;
        List<Abonnement> abonnementen = new ArrayList<Abonnement>();
        try{
            tx = session.beginTransaction();
             abonnementen = session.createQuery("FROM Abonnement where active = true").list();
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return abonnementen;
    }

    public void updateAbonnement(Abonnement abonnement ){
        SessionFactory factory = SessionFactorySingleton.getInstance().getSessionFactory();
        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            session.update(abonnement);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

    public boolean deleteAbonnementById(int id){
        SessionFactory factory = SessionFactorySingleton.getInstance().getSessionFactory();
        Session session = factory.openSession();
        Abonnement a = null;
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            a = session.load(Abonnement.class,id);
            session.delete(a);
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

    public Abonnement getAbonnementById(int id){
        SessionFactory factory = SessionFactorySingleton.getInstance().getSessionFactory();
        Session session = factory.openSession();
        Abonnement a = null;
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            a = session.get(Abonnement.class, id);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
            return a;
        }
    }
    public List<Abonnement> getAbonnementByKlantId(Klant klant){
        SessionFactory factory = SessionFactorySingleton.getInstance().getSessionFactory();

        Session session = factory.openSession();
        Transaction tx = null;
        List<Abonnement> abonnement = new ArrayList<>();
        Query query= null;
        try{
            tx = session.beginTransaction();
            String hql = "FROM Abonnement WHERE klant = :klant AND active = true";
            query = session.createQuery(hql);
            query.setParameter("klant", klant);
            abonnement = query.list();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return abonnement;
    }
}
