import controller.*;
import hibernate.ManageKlant;
import hibernate.ManageVoorwerp;
import view.*;
import model.*;

import hibernate.SessionFactorySingleton;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Manish on 10/10/2016.
 */
public class Main {

    public static void main(String[] args) {
        SessionFactory factory = SessionFactorySingleton.getInstance().getSessionFactory();
        /*Klant k1 = new Klant("123-123", "Rik", "Van Belle", "Vrijheidstraat 25", 9400, "Ninove", true);
        KlantView KView = new KlantView("Klant", true);
        KlantController KC = new KlantController(k1, KView, mK);
        KC.showKlant();*/


        //ManageVoorwerp MV = new ManageVoorwerp();
        //Trein trein = new Trein(1,"IC 4456");

        //Station stationVertrek = new Station(1,"Brussel-Zuid","Brussel");
        //Station stationAankomst = new Station(1,"Vilvoorde","Vilvoorde");
        //Route route = new Route(1,stationVertrek,stationAankomst);
    //    Voorwerp v = new Voorwerp(1,1345, stationAankomst,route,"Kous", "Geel",k1,true);
        //Voorwerp v1 = new Voorwerp(2,1,"Groen","elektronica","GSM", route, stationAankomst,k1,true);

        //MV.addVoorwerp(v1);
       /*List<Voorwerp> voorwerpen = MV.listVoorwerp();
        //System.out.println("Station id: " + st.getStationId());

        System.out.println("Voorwerp id: " + voorwerpen);



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