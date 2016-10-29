import hibernate.ManageLogin;
import hibernate.SessionFactorySingleton;
import model.Login;
import org.hibernate.SessionFactory;

import java.util.Date;

/**
 * Created by Manish on 10/10/2016.
 */
public class Main {

    public static void main(String[] args) {
        SessionFactory factory = SessionFactorySingleton.getInstance().getSessionFactory();

        ManageLogin ML = new ManageLogin();
        Login l = new Login("Rik", "password", 1, new Date(), true, 1 );
        System.out.println(ML.checkLogin(l.getLoginNaam(), l.getLoginWachtwoord()));
        //   int id=  ML.addLogin(l);
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

}