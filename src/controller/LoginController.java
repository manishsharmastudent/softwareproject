package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import hibernate.ManageLogin;
import model.Login;
import model.Rol;

import view.LoginView;
import view.StandardView;

/**
 * Created by Rik Van Belle on 01/11/2016.
 */
public class LoginController {
    private Login loginModel;
    private LoginView loginView;
    private ManageLogin loginManage;

    public LoginController(){
        loginModel = new Login();
        loginManage = new ManageLogin();
        loginView = new LoginView("Login");
    }
    public LoginController(Login login, LoginView view, ManageLogin manage){
        this.loginModel = login;
        this.loginView = view;
        this.loginManage = manage;
    }

    public String getLoginNaam(){
        return loginModel.getLoginNaam();
    }
    public Rol getRol(){
        return loginModel.getRol();
    }
    public Date getLastChanged(){
        return loginModel.getLastChanged();
    }
    public boolean changePassword(String pass){
        return true;
    }
    public boolean setPassword(String pass){
        return true;
    }
    public boolean setRol(Rol rol){
        loginModel.setRol(rol);
        return true;
    }

    public void showLoginScreen(){
        loginView.showLoginScreen();
        //add Listeners
        controleerLogin();
        vergeetPasswoord();
    }
    public void controleerLogin(){
        loginView.getAanmeldButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (loginManage.checkLogin(loginView.getLoginNaamText().getText(), loginView.getLoginWachtwoordText().getText()) == true){
                    loginView.getWindow().setVisible(false);
                    loginView.getWindow().dispose();
                    new MainController().showHomeScreen();
                }
                else
                {
                    loginView.showFailedLogin();
                }
            }
        });
    }
    public void vergeetPasswoord(){
        loginView.getVergeetPaswoordButton().addActionListener(new ActionListener() {
            String email;
            public void actionPerformed(ActionEvent e) {
                email = loginView.showForgetPassword();
                System.out.println(email);

            }
        });
    }
}

