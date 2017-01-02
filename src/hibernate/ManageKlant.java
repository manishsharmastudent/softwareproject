package hibernate;

import model.Klant;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
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
    public List<Klant> listKlanten( ){
        SessionFactory factory = SessionFactorySingleton.getInstance().getSessionFactory();
        List<Klant> klanten = new ArrayList<Klant>();

        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            klanten = session.createQuery("FROM Klant where active = true").list();

            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
            return klanten;
        }
    }
    public Klant getKlantByRijksregister(String rijksregisterNummer){
        SessionFactory factory = SessionFactorySingleton.getInstance().getSessionFactory();
        Session session = factory.openSession();
        Klant klant = null;
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            klant = (Klant) session.createQuery("FROM Klant WHERE rijksregisterNummer = :rrn and active = true").setParameter("rrn", rijksregisterNummer).uniqueResult();
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return klant;
    }
    public void updateKlant(Klant k){
        SessionFactory factory = SessionFactorySingleton.getInstance().getSessionFactory();
        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            session.update(k);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }
    public boolean deleteKlantByRijksregister(String rijksregister){
        SessionFactory factory = SessionFactorySingleton.getInstance().getSessionFactory();
        Session session = factory.openSession();
        Klant k = null;
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            k = session.load(Klant.class,rijksregister);
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
    public List<Klant> getKlantByLastname(String lastname){
        SessionFactory factory = SessionFactorySingleton.getInstance().getSessionFactory();
        Session session = factory.openSession();
        List<Klant> klanten = null;
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            String hql = "FROM Klant WHERE achternaam LIKE :achternaam AND active = true";
            Query query = session.createQuery(hql);
            query.setParameter("achternaam", "%" + lastname + "%");
            klanten = query.list();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return klanten;
    }
    public List<Klant> getKlantBySurname(String surname){
        SessionFactory factory = SessionFactorySingleton.getInstance().getSessionFactory();
        Session session = factory.openSession();
        List<Klant> klanten = null;
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            String hql = "FROM Klant WHERE voornaam LIKE :voornaam AND active = true";
            Query query = session.createQuery(hql);
            query.setParameter("voornaam", "%" + surname + "%");
            klanten = query.list();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return klanten;
    }
    public List<Klant> getKlantByPostcode(int postcode){
        SessionFactory factory = SessionFactorySingleton.getInstance().getSessionFactory();
        Session session = factory.openSession();
        List<Klant> klanten = null;
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            String hql = "FROM Klant WHERE postcode = :postcode AND active = true";
            Query query = session.createQuery(hql);
            query.setParameter("postcode", postcode);
            klanten = query.list();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return klanten;
    }
}
