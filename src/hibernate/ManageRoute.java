package hibernate;
import java.util.ArrayList;
import model.Route;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Iterator;
import java.util.List;

/**
 * Created by thibaut on 31/10/2016.
 */
public class ManageRoute {
    public Integer addRoute(Route r) {

        SessionFactory factory = SessionFactorySingleton.getInstance().getSessionFactory();
        Session session = factory.openSession();
        Transaction tx = null;
        Integer routeId = null;
        try {
            tx = session.beginTransaction();
            routeId = (Integer)session.save(r);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return routeId;
    }


    public List<Route> listRoute( ){
        SessionFactory factory = SessionFactorySingleton.getInstance().getSessionFactory();

        Session session = factory.openSession();
        Transaction tx = null;
        List<Route> routes = new ArrayList<Route>();
        try{
            tx = session.beginTransaction();
            routes = session.createQuery("FROM Route").list();

            tx.commit();

        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return routes;
    }


    public void updateRouteId(Route a, int integer ){
        SessionFactory factory = SessionFactorySingleton.getInstance().getSessionFactory();
        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            Route route =(Route) session.get(Route.class, integer);
            route.setRouteId(integer);
            session.update(route);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }


}

