package view;

import model.Login;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Created by User on 31/10/2016.
 */
public class LoginView implements ActionListener {

    private JFrame j = new JFrame("Login");
    private JButton button = new JButton("Login");
    private JTextField textLogin = new JTextField();
    private JPasswordField textPass = new JPasswordField();
    private JLabel user = new JLabel("Username: ");
    private JLabel pass = new JLabel("Password: ");
    private JPanel panel = new JPanel();

    public void actionPerformed(ActionEvent e) {

    }

    public LoginView(){
        loginGUI();
        button.addActionListener(this);

    }

    private void loginGUI(){

        panel.setLayout(null);


        j.setSize(800,700);
        j.setLocationRelativeTo(null);
        button.setBounds(300, 480, 180, 25);
        textLogin.setBounds(420,180,180,25);
        textPass.setBounds(420,280,180,25);
        user.setBounds(140,180,180,25);
        pass.setBounds(140,280,180,25);



        panel.add(button);
        panel.add(textLogin);
        panel.add(textPass);
        panel.add(user);
        panel.add(pass);
        j.add(panel);


        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.setVisible(true);
    }


    public static void main(String[] args) {
        LoginView loginView = new LoginView();

    }







}
