package view;

import com.fasterxml.classmate.types.TypePlaceHolder;
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
    private JTextField loginNaamText = new JTextField();
    private JPasswordField loginWachtwoordText = new JPasswordField();
    private JPasswordField loginWachtwoordTextRepeat = new JPasswordField();
    private JComboBox rolComboBox = new JComboBox();
    private JButton aanmelden = new JButton("Aanmelden");
    private JButton vergeetPaswoord = new JButton("Passwoord vergeten");
    private JButton loginAanmakenButton = new JButton("Aanmaken");
    private GridBagConstraints c = new GridBagConstraints();

    public LoginView(String titel){
        super(titel);
        panelGegevens.setLayout(new GridLayout(3, 3));
    }

    public JComboBox getRolComboBox(){return rolComboBox; }
    public JTextField getLoginNaamText(){
        return this.loginNaamText;
    }
    public JPasswordField getLoginWachtwoordText(){
        return this.loginWachtwoordText;
    }
    public JPasswordField getLoginWachtwoordTextRepeat(){return this.loginWachtwoordTextRepeat; }
    public int getRolIndex(){return rolComboBox.getSelectedIndex(); }
    public JButton getAanmeldButton(){
        return this.aanmelden;
    }

    public JButton getVergeetPaswoordButton(){
        return this.vergeetPaswoord;
    }

    public JButton getLoginAanmakenButton(){return this.loginAanmakenButton; }

    public void showLoginScreen() {


        panelGegevens.setBorder(null);
        loginNaamText.setColumns(6);
        loginWachtwoordText.setColumns(6);
        panelGegevens.add(loginNaam);
        loginNaamText.setMinimumSize(loginNaamText.getPreferredSize());
        panelGegevens.add(loginNaamText);
        panelGegevens.add(loginWachtwoord);
        panelGegevens.add(loginWachtwoordText);
        panelGegevens.add(aanmelden);
        //panelGegevens.add(vergeetPaswoord);
        interactiePanel.add(panelGegevens);

        window.pack();
        this.showWindow();
    }
    public void showAddLogin(){
        interactiePanel.removeAll();
        interactiePanel.updateUI();
        panelGegevens.removeAll();
        panelGegevens.updateUI();

        panelGegevens.setLayout(new GridBagLayout());
        c.insets = new Insets(10, 20 , 1 ,0);

        initTimeAndDate();
        initWelkomBoard();
        initNavTree();
        initMenuBar();
        c.weightx =1;
        c.weighty =1;
        loginNaamText.setPreferredSize(new Dimension(110,20));
        loginNaamText.setMinimumSize(loginNaamText.getPreferredSize());
        loginNaamText.setMaximumSize(loginNaamText.getPreferredSize());
        getLoginWachtwoordTextRepeat().setPreferredSize(new Dimension(110,20));
        getLoginWachtwoordTextRepeat().setMinimumSize(getLoginWachtwoordTextRepeat().getPreferredSize());
        loginWachtwoordTextRepeat.setMaximumSize(loginWachtwoordTextRepeat.getPreferredSize());
        c.fill = GridBagConstraints.HORIZONTAL;

        c.gridy = 0;
        c.gridx = 0;
        panelGegevens.add(loginNaam, c);
        c.gridx = 1;
        panelGegevens.add(loginNaamText, c);
        c.gridy = 1;
        c.gridx = 0;
        panelGegevens.add(loginWachtwoord, c);
        c.gridx = 1;
        panelGegevens.add(loginWachtwoordText, c);
        c.gridx = 2;
        panelGegevens.add(loginWachtwoordTextRepeat, c);
        c.gridy = 2;
        c.gridx = 0;
        panelGegevens.add(new JLabel("Rol"), c);
        c.gridx = 1;
        panelGegevens.add(rolComboBox, c);
        c.gridy = 3;
        c.gridx = 0;
        panelGegevens.add(loginAanmakenButton, c);


        interactiePanel.add(panelGegevens);

        path.add("Login Toevoegen");
        showWindow();
    }
    public String showForgetPassword(){
        return JOptionPane.showInputDialog("Geef hieronder het email adres van je account in:");
    }
    public void showFailedLogin(){
        JOptionPane.showMessageDialog(this.getWindow(), "Passwoord verkeerd");
    }
    public void showAddLoginSucceed(){JOptionPane.showMessageDialog(null, "Login is toegevoegd!");}
    public void showAddLoginFailed(){JOptionPane.showMessageDialog(null, "Er is iets foutgelopen bij het toevoegen");}
}