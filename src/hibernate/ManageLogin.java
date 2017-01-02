package hibernate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Iterator;

import model.PasswordAuthentication;
import model.Rol;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import model.Login;
import org.hibernate.query.Query;

public class ManageLogin {



    /* Method to CREATE an Login in the database */
    public Integer addLogin(Login l){
        PasswordAuthentication p = new PasswordAuthentication();
        l.setLoginWachtwoord(p.hash(l.getLoginWachtwoord()));
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
    public List<Login> listLogins( ){
        SessionFactory factory = SessionFactorySingleton.getInstance().getSessionFactory();
        List<Login> logins = new ArrayList<Login>();
        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            logins = session.createQuery("FROM Login where active = true").list();

            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
            return logins;
        }
    }

    /* Look if the login is right */
    public boolean checkLogin(String loginNaam, String loginWachtwoord){
        PasswordAuthentication p = new PasswordAuthentication();

        SessionFactory factory = SessionFactorySingleton.getInstance().getSessionFactory();
        List<Login> logins = null;
        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            String hql = "FROM Login WHERE loginNaam = :loginNaam";
            Query query = session.createQuery(hql);
            query.setParameter("loginNaam", loginNaam);
            // query.setParameter("loginWachtwoord", loginWachtwoord);
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
            if(p.authenticate(loginWachtwoord,logins.get(0).getLoginWachtwoord()))
                return true;
            else{
                return false;
            }
        }
    }

    public List<Login> getLoginByName(String loginNaam){
        SessionFactory factory = SessionFactorySingleton.getInstance().getSessionFactory();
        List<Login> logins = null;
        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            String hql = "FROM Login WHERE loginNaam = :loginNaam";
            Query query = session.createQuery(hql);
            query.setParameter("loginNaam", loginNaam);
            logins = query.list();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        if(logins.size() == 1){
            return logins;
        }
        else {return null;}
    }

    /* Method to UPDATE login */
    public void updateLogin(Login login){
        SessionFactory factory = SessionFactorySingleton.getInstance().getSessionFactory();
        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            session.update(login);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }


    //Werkt, getest door Manish
    public Login getLoginById(int id){
        SessionFactory factory = SessionFactorySingleton.getInstance().getSessionFactory();
        Session session = factory.openSession();
        Login l = null;
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            l =  (Login) session.get(Login.class, id);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
            return l;
        }
    }

    public boolean deleteLoginById(int id){
        SessionFactory factory = SessionFactorySingleton.getInstance().getSessionFactory();
        Session session = factory.openSession();
        Login l = null;
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            l = (Login)session.load(Login.class,id);
            session.delete(l);
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
    public List<Rol> listRols(){
        SessionFactory factory = SessionFactorySingleton.getInstance().getSessionFactory();
        List<Rol> rols = new ArrayList<Rol>();
        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            rols = session.createQuery("FROM Rol where active = true").list();

            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
            return rols;
        }
    }
    public Rol getRolById(int id){
        SessionFactory factory = SessionFactorySingleton.getInstance().getSessionFactory();
        Session session = factory.openSession();
        Rol rol = null;
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            rol =  (Rol) session.get(Rol.class, id);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
            return rol;
        }
    }
}