package view;

import Listeners.AanmeldListener;
import model.Login;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Rik Van Belle on 01/11/2016.
 */
public class LoginView extends StandardView {
    Login login = new Login();
    public LoginView(String titel, boolean haveButton){
        super(titel, haveButton);
        standardButton.setText("Aanmelden");
    }

    public Login getLogin(){
        return this.login;
    }

    public void showLoginScreen() {
        JLabel loginNaam = new JLabel("Naam: ");
        JLabel loginWachtwoord = new JLabel("Wachtwoord: ");
        JTextField loginNaamText = new JTextField();
        JTextField loginWachtwoordText = new JTextField();
        JButton aanmelden = new JButton("Aanmelden");
        aanmelden.addActionListener(new AanmeldListener(loginNaamText.getText(), loginWachtwoordText.getText()));
        loginNaamText.setColumns(4);
        loginWachtwoordText.setColumns(4);
        content.add(aanmelden);
        content.add(loginNaam);
        content.add(loginNaamText);
        content.add(loginWachtwoord);
        content.add(loginWachtwoordText);
        content.setVisible(true);
        window.setVisible(true);
    }
    public void showForgetPassword(){

    }
    public void showLogins(Login[] logins){

    }
}
