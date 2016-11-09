import controller.*;
import hibernate.ManageKlant;
import view.*;
import model.*;

import hibernate.SessionFactorySingleton;
import org.hibernate.SessionFactory;

/**
 * Created by Manish on 10/10/2016.
 */
public class Main {

    public static void main(String[] args) {
        SessionFactory factory = SessionFactorySingleton.getInstance().getSessionFactory();
        Klant k1 = new Klant("123-123", "Rik", "Van Belle", "Vrijheidstraat 25", 9400, "Ninove", true);
        /*KlantView KView = new KlantView("Klant", true);
        KlantController KC = new KlantController(k1, KView);
        KC.showKlant();*/
        ManageKlant MK = new ManageKlant();
        System.out.println(MK.getKlant("123-123").getAchternaam());



        //ManageStation MS = new ManageStation();
        //ManageRoute MR = new ManageRoute();
        //ManageAbonnement MA = new ManageAbonnement();
        //Korting k = new Korting(1,0,new Date(),"test korting", true);
        //Station s = new Station(1,"test","leuven");
        //Route r = new Route(1,s,s);
        //Route ro = new Route(2,s,s);
        //Klant klant = new Klant("95103150548","Manish","Sharma","tiensevest 14",3000,"Leuven",true);
        //Abonnement a = new Abonnement(0,k, new Date(), new Date(),r, klant, Float.valueOf(55),true);
      //  int id = MA.addAbonnement(a);
        //MA.listAbonnementen();
        //MA.updateRoute(4,r);
        //MR.addRoute(r);
        //MR.listRoutes();
        //MS.addStation(s);
        //MS.listStations();
       // Login l = new Login(0,"Test","testwachtwoord", new Rol(true,1,"test door manish"), new Date(), true, new Station(1,"test","leuven"));

        //ManageLogin ML = new ManageLogin();

        //System.out.println(ML.checkLogin(l.getLoginNaam(), l.getLoginWachtwoord()));
        //  int id=  ML.addLogin(l);


     //   ML.updateWachtwoord(1,"Changed!"); // Werkt!

       // ML.listLogins();
      //   System.out.println("id = " + id);
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

}