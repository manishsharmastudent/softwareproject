package hibernate;

import model.Abonnement;
import model.Login;
import model.Route;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

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
             abonnementen = session.createQuery("FROM Abonnement").list();
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


    public void updateRoute(Integer abonnementId, Route route ){
        SessionFactory factory = SessionFactorySingleton.getInstance().getSessionFactory();
        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            Abonnement abonnement =
                    (Abonnement) session.get(Abonnement.class, abonnementId);
            abonnement.setRoute( route );
            session.update(abonnement);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }


}
