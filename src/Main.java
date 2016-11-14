import controller.*;
import hibernate.*;
import view.*;
import model.*;

import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Manish on 10/10/2016.
 */
public class Main {

    public static void main(String[] args) {
        SessionFactory factory = SessionFactorySingleton.getInstance().getSessionFactory();
        ManageKlant mK = new ManageKlant();
        Klant k1 = new Klant("123-123", "Rik", "Van Belle", "Vrijheidstraat 25", 9400, "Ninove", true);
        KlantView KView = new KlantView("Klant", true);
        KlantController KC = new KlantController(k1, KView, mK);


        ManageVoorwerp MV = new ManageVoorwerp();
        Station stationVertrek = new Station(1,"Brussel-Zuid","Brussel", true);
        Station stationAankomst = new Station(1,"Vilvoorde","Vilvoorde", true);
        Route route = new Route(1,stationVertrek,stationAankomst, true);
    //  Voorwerp v = new Voorwerp(1,1345, stationAankomst,route,"Kous", "Geel",k1,true);
        Voorwerp v1 = new Voorwerp(2,1,"Groen","elektronica","GSM", route, stationAankomst,k1,true);
        VoorwerpView voorwerpView = new VoorwerpView("Voorwerp", false);
        VoorwerpController voorwerpController = new VoorwerpController(v1, voorwerpView);
        voorwerpController.showVoorwerpen();

        Login l = new Login(1, "Rik", "Pass", new Rol(), new Date(), true, stationVertrek);
        ManageLogin mL = new ManageLogin();
        LoginView lView = new LoginView("Login", false);
        LoginController lC = new LoginController(l, lView, mL);
        lC.showLoginScreen();
    }

}