package controller;

import model.Voorwerp;
import view.HomeView;
import view.LoginView;
import view.StandardView;
import view.TicketView;

import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.*;
import javax.swing.event.MouseInputAdapter;

/**
 * Created by Rik Van Belle on 11/11/2016.
 */
public class MainController {
    HomeView home;

    private Timer logOutTimer;
    protected static MouseMotionListener l;

    public MainController(){
        home = new HomeView("HomeScreen");
    }
    protected void showHomeScreen(){
        home.showHomeScreen();
        koopTicket();
        //voegStationToe();
        voegAbonnementToe();
        voegVoorwerpToe();
        initLogOutTimer(home);
        logOutTimer.start();
    }
    public void toevoegenKlant(){
        home.getKlantToevoegenButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                home.getWindow().setVisible(false);
                home.getWindow().dispose();
                new KlantController().showToevoegenKlant();
            }
        });
    }
    public void koopTicket(){
        home.getButtonVoegTicketToe().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                home.getWindow().setVisible(false);
                home.getWindow().dispose();
                logOutTimer.restart();
                new TicketController().showVoegTicketToe();
            }
        });
    }
    public void voegAbonnementToe(){
        home.getVerkoopAboButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                home.getWindow().setVisible(false);
                home.getWindow().dispose();
                new AbonnementController().showToevoegenAbonnement();
            }
        });
    }
    public void voegStationToe(){
        home.getVerkoopAboButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                home.getWindow().setVisible(false);
                home.getWindow().dispose();
                //stationController.showToevoegenStation();
            }
        });
    }
    public void voegVoorwerpToe(){
        home.getRvvButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                home.getWindow().setVisible(false);
                home.getWindow().dispose();
                new VoorwerpController().showVoorwerpToevoegen();
            }
        });
    }
    protected void initLogOutTimer(final StandardView view){
        logOutTimer = new javax.swing.Timer(10000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "U wordt uitgelogd!");
                view.getWindow().setVisible(false);
                view.getWindow().dispose();
                logOutTimer.stop();
                new LoginView("Login").showLoginScreen();
            }
        });
        addLogOutListener(view);
        }
    private void initMouseMotionListener(){
        l = new MouseMotionListener() {
            public void mouseDragged(MouseEvent e) {
            }
            public void mouseMoved(MouseEvent e) {
                logOutTimer.restart();
                System.out.println("Bewogen");
            }
        };
    }
    private void addLogOutListener(StandardView view){
        view.getWindow().addMouseMotionListener(l);
        logOutTimer.restart();
        initMouseMotionListener();
    }
}
