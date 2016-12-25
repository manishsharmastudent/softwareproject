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
    HomeView home = new HomeView("Homescreen");

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
        zoekKlanten();
        zoekRoute();
        verlengAbonnement();
        showSearchVoorwerpen();
        showSearchLiveBoard();
        //initLogOutTimer();
        //initMouseMotionListener();
        //home.getWindow().addMouseMotionListener(l);
        //logOutTimer.restart();
    }
    public void toevoegenKlant(){
        home.getKlantToevoegenButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                closeHomeWindow();
                new KlantController().showToevoegenKlant();
            }
        });
    }
    public void koopTicket(){
        home.getButtonVoegTicketToe().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                closeHomeWindow();
                new TicketController().showVoegTicketToe();
            }
        });
    }
    public void voegAbonnementToe(){
        home.getVerkoopAboButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                closeHomeWindow();
                new AbonnementController().showToevoegenAbonnement();
            }
        });
    }
    public void verlengAbonnement(){
        home.getVerlengAboButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               closeHomeWindow();
                new AbonnementController().showZoekAbonnement();
            }
        });
    }
    public void voegStationToe(){
        home.getVerkoopAboButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                closeHomeWindow();
                //stationController.showToevoegenStation();
            }
        });
    }
    public void showSearchVoorwerpen(){
        home.getShowVerlorenVoorwerpenButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                closeHomeWindow();
                new VoorwerpController().showZoekVoorwerp();
            }
        });
    }
    public void voegVoorwerpToe(){
        home.getRvvButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                closeHomeWindow();
                new VoorwerpController().showVoorwerpToevoegen();
            }
        });
    }
    public void zoekRoute(){
        home.getTreinInfo().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                closeHomeWindow();
                new RouteController().showZoekRoute();
            }
        });
    }
    public void showSearchLiveBoard(){
        home.getStationsInfo().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                closeHomeWindow();
                new StationController().showSearchLiveboard();
            }
        });
    }
    public void zoekKlanten(){
        home.getKlantOpzoeken().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                closeHomeWindow();
                new KlantController().showZoekKlanten();
            }
        });
    }
    public void initLogOutTimer(){
        logOutTimer = new javax.swing.Timer(10000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "U wordt uitgelogd!");
                closeHomeWindow();
                new LoginView("Login").showLoginScreen();
            }
        });
        }
    private void closeHomeWindow(){
        home.getWindow().setVisible(false);
        home.getWindow().dispose();
    }
}
