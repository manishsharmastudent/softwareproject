import java.util.List;
import java.util.Date;
import java.util.Iterator;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ManageLogin {
    private static SessionFactory factory;
    public static void main(String[] args) {
        try{
            factory = new Configuration().configure().buildSessionFactory();
        }catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
       ManageLogin ML = new ManageLogin();
        Login l = new Login("Tweede", "password", 1, new Date(), true, 1 );
     // int id=  ML.addLogin(l);
    ML.listLogins();
      //  System.out.println("id = " + id);
      /* Add few Login records in database
        Integer empID1 = ME.addLogin("Zara", "Ali", 1000);
        Integer empID2 = ME.addLogin("Daisy", "Das", 5000);
        Integer empID3 = ME.addLogin("John", "Paul", 10000); */

      /* List down all the Logins */
    //    ME.listLogins();

      /* Update Login's records */
      //  ME.updateLogin(empID1, 5000);

      /* Delete an Login from the database */
     //   ME.deleteLogin(empID2);

      /* List down new list of the Logins */
     //   ME.listLogins();


    }
    /* Method to CREATE an Login in the database */
    public Integer addLogin(Login l){
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
    /* Method to UPDATE salary for an Login */
  /*  public void updateLogin(Integer LoginID, int salary ){
        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            Login Login =
                    (Login)session.get(Login.class, LoginID);
            Login.setSalary( salary );
            session.update(Login);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

    */
    /* Method to DELETE an Login from the records */

   /*
    public void deleteLogin(Integer LoginID){
        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            Login Login =
                    (Login)session.get(Login.class, LoginID);
            session.delete(Login);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }
    */



}