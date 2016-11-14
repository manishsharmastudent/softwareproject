package hibernate;

import model.Abonnement;
import model.Klant;
import model.Login;
import model.Route;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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
           /* for (Iterator iterator =
                 abonnementen.iterator(); iterator.hasNext();){
                Abonnement a = (Abonnement) iterator.next();
                System.out.println("abonnement id: " + a.getAbonnementId());

            }*/
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
            a = (Abonnement)session.load(Abonnement.class,id);
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
            a =  (Abonnement) session.get(Abonnement.class, id);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
            return a;
        }
    }

    public List<Abonnement> getAbonnementByRoute(Route r){
        SessionFactory factory = SessionFactorySingleton.getInstance().getSessionFactory();

        Session session = factory.openSession();
        Transaction tx = null;
        List<Abonnement> abonnementen = new ArrayList<Abonnement>();
        try{
            tx = session.beginTransaction();
            String hql = "FROM Abonnement WHERE route = :route AND active = true";
            Query query = session.createQuery(hql);
            query.setParameter("route", r);

            abonnementen = query.list();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return abonnementen;

    }

    public List<Abonnement> getAbonnementByKlantId(int id){
        SessionFactory factory = SessionFactorySingleton.getInstance().getSessionFactory();

        Session session = factory.openSession();
        Transaction tx = null;
        List<Abonnement> abonnementen = new ArrayList<Abonnement>();
        try{
            tx = session.beginTransaction();
            String hql = "FROM Abonnement WHERE klant= :klant AND active = true";
            Query query = session.createQuery(hql);
            query.setParameter("klant", id);

            abonnementen = query.list();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return abonnementen;

    }

    /*
    public List<Abonnement> getAbonnementByLastName(String lastname){
        SessionFactory factory = SessionFactorySingleton.getInstance().getSessionFactory();

        Session session = factory.openSession();
        Transaction tx = null;
        List<Abonnement> abonnementen = new ArrayList<Abonnement>();
        try{
            tx = session.beginTransaction();
         //  List<Klant> klanten = mk.getKlantByLastname(lastname);
            String hql = "from Abonnement where active = true";
            Query query = session.createQuery(hql);
           List<Abonnement> temp = query.list();
            for (Abonnement a: temp
                 ) {
                for (Klant k: klanten
                     ) {
                    if (a.getKlant() == k){
                        abonnementen.add(a);
                    }

                }
            }

        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return abonnementen;

    }
    */

}
