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
        LoginController loginController = new LoginController();
        loginController.showLoginScreen();
    }
}