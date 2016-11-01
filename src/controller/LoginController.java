package controller;

import java.util.Date;

import model.Login;
import model.Rol;
//import view.LoginView;
/**
 * Created by Rik Van Belle on 01/11/2016.
 */
public class LoginController {
    private Login loginModel;
    //private LoginView loginView;

    private String getLoginNaam(){
        return loginModel.getLoginNaam();
    }
    private Rol getRol(){
        return loginModel.getRol();
    }
    private Date getLastChanged(){
        return loginModel.getLastChanged();
    }
    private boolean changePassword(String pass){
        return true;
    }
    private boolean setPassword(String pass){
        return true;
    }
    private boolean setRol(Rol rol){
        loginModel.setRol(rol);
        return true;
    }
}
