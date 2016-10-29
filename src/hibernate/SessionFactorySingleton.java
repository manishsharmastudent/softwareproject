package hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * SessionFactorySingleton
 */

public class SessionFactorySingleton {

    private static SessionFactorySingleton instance = null;
    private static SessionFactory sessionFactory;

    private SessionFactorySingleton(){
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactorySingleton getInstance(){
        if(instance == null){
            instance  = new SessionFactorySingleton();
        }
        return instance;
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

}