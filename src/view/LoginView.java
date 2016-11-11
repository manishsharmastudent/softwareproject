package view;

import Listeners.AanmeldListener;
import controller.LoginController;
import model.Login;

import javax.swing.JOptionPane;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Rik Van Belle on 01/11/2016.
 */
public class LoginView extends StandardView {
    final Login login = new Login();

    JPanel panelGegevens = new JPanel();
    JPanel panelButtons = new JPanel();
    JLabel loginNaam = new JLabel("Naam: ");
    JLabel loginWachtwoord = new JLabel("Wachtwoord: ");
    final JTextField loginNaamText = new JTextField();
    final JTextField loginWachtwoordText = new JTextField();

    public LoginView(String titel, boolean haveButton){
        super(titel, haveButton);
        panelGegevens.setLayout(new GridLayout(2, 2));
        panelButtons.setLayout(new GridLayout(2, 1));
        getStandardButton().setText("Aanmelden");
    }

    public Login getLogin(){
        return this.login;
    }

    public void showLoginScreen(final LoginController loginController) {
        JButton aanmelden = new JButton("Aanmelden");
        aanmelden.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                login.setLoginNaam(loginNaamText.getText());
                login.setLoginWachtwoord(loginWachtwoordText.getText());
                System.out.println(login.getLoginNaam());
                loginController.controleerLogin(login);
            }
        });
        loginNaamText.setColumns(4);
        loginWachtwoordText.setColumns(4);
        panelGegevens.add(loginNaam);
        panelGegevens.add(loginNaamText);
        panelGegevens.add(loginWachtwoord);
        panelGegevens.add(loginWachtwoordText);
        panelButtons.add(aanmelden);

        getMainPanel().add(panelGegevens);
        getMainPanel().add(panelButtons);
        getMainPanel().setLayout(new GridLayout(2, 1));
        getWindow().add(getMainPanel());

        this.showWindow();
    }
    public void showForgetPassword(){

    }
    public void showLogins(Login[] logins){

    }
    public void showFailedLogin(){
        JOptionPane.showMessageDialog(this.getWindow(), "Passwoord verkeerd");
    }
}
