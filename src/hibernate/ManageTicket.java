package hibernate;


import model.Station;
import model.Ticket;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
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

    public List<Ticket> listTicket( ){
        SessionFactory factory = SessionFactorySingleton.getInstance().getSessionFactory();

        Session session = factory.openSession();
        Transaction tx = null;
        List<Ticket> tickets = new ArrayList<Ticket>();
        try{
            tx = session.beginTransaction();
            tickets = session.createQuery("FROM Ticket").list();

            tx.commit();

        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return tickets;
    }
}
