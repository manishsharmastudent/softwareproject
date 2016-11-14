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
    /*    SessionFactory factory = SessionFactorySingleton.getInstance().getSessionFactory();
        ManageKlant mK = new ManageKlant();
        Klant k1 = new Klant("123-123", "Rik", "Van Belle", "Vrijheidstraat 25", 9400, "Ninove", true);
        KlantView KView = new KlantView("Klant", true);
        KlantController KC = new KlantController(k1, KView, mK);


        ManageVoorwerp MV = new ManageVoorwerp();
        Station stationVertrek = new Station(1,"Brussel-Zuid","Brussel", true);
        Station stationAankomst = new Station(1,"Vilvoorde","Vilvoorde", true);
        Route route = new Route(1,stationVertrek,stationAankomst, true);
    //    Voorwerp v = new Voorwerp(1,1345, stationAankomst,route,"Kous", "Geel",k1,true);
        Voorwerp v1 = new Voorwerp(2,1,"Groen","elektronica","GSM", route, stationAankomst,k1,true);

        Login l = new Login(1, "Rik", "Pass", new Rol(), new Date(), true, stationVertrek);
        ManageLogin mL = new ManageLogin();
        LoginView lView = new LoginView("Login", false);
        LoginController lC = new LoginController(l, lView, mL);
        lC.showLoginScreen();




    //Rik zijn main code
    */

        /* Typekaart, ticket en Route  list getest
        System.out.print("manish");
        ManageTypeKaart tk = new ManageTypeKaart();
        List<TypeKaart> types = tk.listTypeKaarten();

        for (TypeKaart t:types
             ) {

            System.out.print(t.getNaam());
        }


        ManageTicket mt = new ManageTicket();
        List<Ticket> tickets = mt.listTicket();
        for (Ticket t:tickets
             ) {
            System.out.print(t.getTicketId());

        }


        Station stationVertrek = new Station(1,"Brussel-Zuid","Brussel", true);
        Station stationAankomst = new Station(1,"Vilvoorde","Vilvoorde", true);
        Route route = new Route(1,stationVertrek,stationAankomst, true);
        ManageTypeKaart tk = new ManageTypeKaart();
        List<TypeKaart> types = tk.listTypeKaarten();
        TypeKaart typekaart = types.get(0);

        Ticket t = new Ticket(1,route,new Date(), new Date(),typekaart,1,5,1);
        ManageTicket mt = new ManageTicket();
       int id = mt.addTicket(t);
        System.out.print(id);
        Station stationVertrek = new Station(1,"Brussel-Zuid","Brussel", true);
        Station stationAankomst = new Station(1,"Vilvoorde","Vilvoorde", true);
        Route route = new Route(1,stationVertrek,stationAankomst, true);

        ManageRoute rt = new ManageRoute();
      int i =  rt.addRoute(route);
        System.out.print(i);
        ManageAbonnement ma = new ManageAbonnement();
        List<Abonnement> abo= ma.getAbonnementByLastName("achter");

        for (Abonnement a:abo
             ) {
            System.out.println(a.getAbonnementId());

        }
        */

        Station stationVertrek = new Station(1,"Brussel-Zuid","Brussel", true);
        Station stationAankomst = new Station(1,"Vilvoorde","Vilvoorde", true);
        Route route = new Route(1,stationVertrek,stationAankomst, true);
        ManageTypeKaart tk = new ManageTypeKaart();
     //   List<TypeKaart> types = tk.listTypeKaarten();
        TypeKaart typekaart = tk.getTypeKaartById(1);

        Ticket t = new Ticket(1,route,new Date(), new Date(),typekaart,1,5,1);

        ManageTicket mt = new ManageTicket();

        int i = mt.addTicket(t);
        System.out.print(i);

    }




}