package Listeners;

import model.Login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import hibernate.*;

/**
 * Created by Rik Van Belle on 08/11/2016.
 */
public class AanmeldListener implements ActionListener {
    ManageLogin mL = new ManageLogin();
    Login login = new Login();

    public AanmeldListener(String loginNaam, String loginWachtwoord) {
        this.login.setLoginNaam(loginNaam);
        this.login.setLoginWachtwoord(loginWachtwoord);
    }
    public void actionPerformed(ActionEvent e){
        System.out.println(mL.checkLogin(login.getLoginNaam(), login.getLoginWachtwoord()));
        System.out.println("Geklikt");
    }
}
