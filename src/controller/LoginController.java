package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import hibernate.ManageLogin;
import hibernate.ManageStation;
import hibernate.SessionFactorySingleton;
import model.Login;
import model.Rol;

import view.LoginView;
import view.OptionLoginView;
import view.StandardView;

/**
 * Created by Rik Van Belle on 01/11/2016.
 */
public class LoginController {
    private Login loginModel;
    private LoginView loginView;
    private ManageLogin loginManage;

    private List<Integer> rolIds = new ArrayList<>();

    public LoginController(){
        loginModel = new Login();
        loginManage = new ManageLogin();
        loginView = new LoginView("Login");
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
                    List<Login>logins = loginManage.getLoginByName(loginView.getLoginNaamText().getText());
                    if(logins != null){
                        if(logins.get(0).getRol().getRolId() == 1 && new OptionLoginView().showOptionPaneLogin() == true){
                                new MainController().showAdminScreen();
                        }
                        else {
                            new MainController().showHomeScreen();
                        }
                    } else {
                        new MainController().showHomeScreen();
                    }
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
    public void showAddLogin(){
        loginView.showAddLogin();
        initComboBox();
        addLogin();
    }
    public void addLogin(){
        loginView.getLoginAanmakenButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginModel.setLoginNaam(loginView.getLoginNaamText().getText());
                System.out.println(loginView.getLoginWachtwoordText().getText());
                System.out.println(loginView.getLoginWachtwoordTextRepeat().getText());
                //if(loginView.getLoginWachtwoordText().getText() == loginView.getLoginWachtwoordTextRepeat().getText()){
                loginModel.setLoginWachtwoord(loginView.getLoginWachtwoordText().getText());
                //}
                loginModel.setRol(loginManage.getRolById(rolIds.get(loginView.getRolIndex())));
                loginModel.setActive(true);
                loginModel.setLastChanged(Calendar.getInstance().getTime());
                loginModel.setStation(new ManageStation().getStationById(1));
                if(loginManage.addLogin(loginModel) > 0){
                    loginView.showAddLoginSucceed();
                }else {
                    loginView.showAddLoginFailed();
                }
            }
        });
    }
    public void initComboBox(){
        List<Rol> rollen = loginManage.listRols();
        for(int i = 0; i < rollen.size();i++){
            rolIds.add(rollen.get(i).getRolId());
            loginView.getRolComboBox().addItem(rollen.get(i).getRolBeschrijving());
        }
    }
}