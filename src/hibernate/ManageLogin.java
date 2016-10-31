package hibernate;

import java.util.List;
import java.util.Iterator;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import model.Login;
import org.hibernate.query.Query;

public class ManageLogin {



    /* Method to CREATE an Login in the database */
    public Integer addLogin(Login l){

        SessionFactory factory = SessionFactorySingleton.getInstance().getSessionFactory();
        Session session = factory.openSession();
        Transaction tx = null;
        Integer LoginID = null;
        try{
            tx = session.beginTransaction();

            LoginID = (Integer) session.save(l);

            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return LoginID;
    }
    /* Method to  READ all the Logins */
    public void listLogins( ){
        SessionFactory factory = SessionFactorySingleton.getInstance().getSessionFactory();

        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            List Logins = session.createQuery("FROM Login").list();
            for (Iterator iterator =
                 Logins.iterator(); iterator.hasNext();){
                Login Login = (Login) iterator.next();
                System.out.print("First Name: " + Login.getLoginNaam());

            }
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

    /* Look if the login is right */
    public boolean checkLogin(String loginNaam, String loginWachtwoord){
        SessionFactory factory = SessionFactorySingleton.getInstance().getSessionFactory();
        List logins = null;
        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            String hql = "FROM Login WHERE loginNaam = :loginNaam AND loginWachtwoord = :loginWachtwoord";
            Query query = session.createQuery(hql);
            query.setParameter("loginNaam", loginNaam);
            query.setParameter("loginWachtwoord", loginWachtwoord);
            logins = query.list();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        if (logins.isEmpty()){
            return false;
        }
        else {
            return true;
        }
    }


    /* Method to UPDATE wachtwoord for login */
    public void updateWachtwoord(Integer loginId, String loginWachtwoord ){
        SessionFactory factory = SessionFactorySingleton.getInstance().getSessionFactory();
        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            Login login =
                    (Login)session.get(Login.class, loginId);
            login.setLoginWachtwoord( loginWachtwoord );
            session.update(login);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }
}