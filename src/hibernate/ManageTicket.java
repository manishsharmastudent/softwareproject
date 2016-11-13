package hibernate;


import model.Station;
import model.Ticket;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Iterator;
import java.util.List;

/**
 * Created by Manish on 06/11/2016.
 */
public class ManageTicket {

    /* Method to CREATE an Ticket in the database */
    public Integer addTicket(Ticket tk){

        SessionFactory factory = SessionFactorySingleton.getInstance().getSessionFactory();
        Session session = factory.openSession();
        Transaction tx = null;
        Integer ticketId = null;
        try{
            tx = session.beginTransaction();

            ticketId = (Integer)session.save(tk);

            //  session.save(st);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return ticketId;
    }


    public void listStations( ){
        SessionFactory factory = SessionFactorySingleton.getInstance().getSessionFactory();

        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            List tickets = session.createQuery("FROM Ticket ").list();
            for (Iterator iterator =
                 tickets.iterator(); iterator.hasNext();){
                Station st = (Station) iterator.next();
                System.out.println("Ticket id: " + st.getStationId());

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
