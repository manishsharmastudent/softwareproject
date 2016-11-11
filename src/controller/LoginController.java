package controller;

import java.util.Date;

import hibernate.ManageLogin;
import model.Login;
import model.Rol;
import view.LoginView;
//import view.LoginView;
/**
 * Created by Rik Van Belle on 01/11/2016.
 */
public class LoginController {
    private Login loginModel;
    private LoginView loginView;
    private ManageLogin loginManage;
    private MainController mainController = new MainController();

    public LoginController(){
        loginModel = new Login();
        loginManage = new ManageLogin();
        loginView = new LoginView("Login", false);
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
        loginView.showLoginScreen(this);
    }
    public void controleerLogin(Login login){
        if (loginManage.checkLogin(login.getLoginNaam(), login.getLoginWachtwoord()) == true){
            loginView.getWindow().setVisible(false);
            loginView.getWindow().dispose();
            mainController.showHomeScreen();
        }
        else {showFailedLogin();}
    }
    public void showFailedLogin(){
        loginView.showFailedLogin();
    }
}
