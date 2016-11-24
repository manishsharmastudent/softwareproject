package controller;

import model.Voorwerp;
import view.HomeView;
import view.LoginView;
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

    protected Timer logOutTimer;
    protected MouseMotionListener l;

    public MainController(){
        home = new HomeView("HomeScreen");
    }
    protected void showHomeScreen(){
        home.showHomeScreen();
        koopTicket();
        //voegStationToe();
        toevoegenKlant();
        voegAbonnementToe();
        voegVoorwerpToe();
        zoekRoute();
        //initLogOutTimer();
        //initMouseMotionListener();
        //home.getWindow().addMouseMotionListener(l);
        //logOutTimer.restart();
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
//                logOutTimer.start();
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
    public void zoekRoute(){
        home.getTreinInfo().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                home.getWindow().setVisible(false);
                home.getWindow().dispose();
                new RouteController().showZoekRoute();
            }
        });
    }
    public void initLogOutTimer(){
        logOutTimer = new javax.swing.Timer(10000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "U wordt uitgelogd!");
                home.getWindow().setVisible(false);
                home.getWindow().dispose();
                new LoginView("Login").showLoginScreen();
            }
        });
        }
    public void initMouseMotionListener(){
        l = new MouseMotionListener() {
            public void mouseDragged(MouseEvent e) {
            }
            public void mouseMoved(MouseEvent e) {
                logOutTimer.restart();
            }
        };
    }

}
