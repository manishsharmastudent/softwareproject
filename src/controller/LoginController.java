package controller;

import view.LoginView;
import model.Login;


/**
 * Created by User on 06/11/2016.
 */
public class LoginController
{

    Login loginmodel = new Login();
    LoginView loginview = new LoginView();

    public LoginController(Login loginm, LoginView view){
        this.loginmodel = loginm;
        this.loginview = view;
    }


}
