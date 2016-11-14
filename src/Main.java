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
        /*ManageKlant mK = new ManageKlant();
        Klant k1 = new Klant("123-123", "Rik", "Van Belle", "Vrijheidstraat 25", 9400, "Ninove", true);
        KlantView KView = new KlantView("Klant");
        KlantController KC = new KlantController(k1, KView, mK);


        ManageVoorwerp MV = new ManageVoorwerp();
        Station stationVertrek = new Station(1,"Brussel-Zuid","Brussel", true);
        Station stationAankomst = new Station(1,"Vilvoorde","Vilvoorde", true);
        Route route = new Route(1,stationVertrek,stationAankomst, true);
    //  Voorwerp v = new Voorwerp(1,1345, stationAankomst,route,"Kous", "Geel",k1,true);
        Voorwerp v1 = new Voorwerp(2,1,"Groen","elektronica","GSM", route, stationAankomst,k1,true);
        VoorwerpView voorwerpView = new VoorwerpView("Voorwerp");
        VoorwerpController voorwerpController = new VoorwerpController(v1, voorwerpView);
        voorwerpController.showVoorwerpen();*/

        LoginController lC = new LoginController();
        lC.showLoginScreen();
    }

}