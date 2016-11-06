package view;

import model.Login;

import javax.swing.*;

/**
 * Created by Rik Van Belle on 01/11/2016.
 */
public class LoginView extends StandardView {
    public LoginView(String titel, boolean haveButton){
        super(titel, haveButton);
        standardButton.setText("Login");
    }
    public void showLoginScreen() {

    }
    public void showForgetPassword(){

    }
    public void showLogins(Login[] logins){

    }
}
