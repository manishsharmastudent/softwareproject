package controller;

import model.Voorwerp;
import view.HomeView;
import view.TicketView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Rik Van Belle on 11/11/2016.
 */
public class MainController {
    HomeView home;
    TicketController ticketController;
    StationController stationController;
    KlantController klantController;
    VoorwerpController voorwerpController;
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
}
