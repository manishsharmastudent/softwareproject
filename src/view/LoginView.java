package view;

import controller.LoginController;
import model.Login;

import javax.swing.JOptionPane;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Rik Van Belle on 01/11/2016.
 */
public class LoginView extends StandardView {
    private final Login login = new Login();
    private JPanel panelGegevens = new JPanel();
    private JLabel loginNaam = new JLabel("Naam: ");
    private JLabel loginWachtwoord = new JLabel("Wachtwoord: ");
    private JTextField loginNaamText = new JTextField("Rik");
    private JPasswordField loginWachtwoordText = new JPasswordField("Password");
    private JButton aanmelden = new JButton("Aanmelden");
    private JButton vergeetPaswoord = new JButton("Passwoord vergeten");
    public LoginView(String titel){
        super(titel);
        panelGegevens.setLayout(new GridLayout(3, 3));
    }

    public Login getLogin(){
        return this.login;
    }

    public JTextField getLoginNaamText(){
        return this.loginNaamText;
    }

    public JPasswordField getLoginWachtwoordText(){
        return this.loginWachtwoordText;
    }

    public JButton getAanmeldButton(){
        return this.aanmelden;
    }

    public JButton getVergeetPaswoordButton(){
        return this.vergeetPaswoord;
    }

    public void showLoginScreen() {
        loginNaamText.setColumns(6);
        loginWachtwoordText.setColumns(6);
        panelGegevens.add(loginNaam);
        panelGegevens.add(loginNaamText);
        panelGegevens.add(loginWachtwoord);
        panelGegevens.add(loginWachtwoordText);
        panelGegevens.add(aanmelden);
        panelGegevens.add(vergeetPaswoord);
        mainPanel.add(panelGegevens);

        window.pack();
        this.showWindow();
    }
    public String showForgetPassword(){
        return JOptionPane.showInputDialog("Geef hieronder het email adres van je account in:");
    }
    public void showLogins(Login[] logins){

    }
    public void showFailedLogin(){
        JOptionPane.showMessageDialog(this.getWindow(), "Passwoord verkeerd");
    }
}
