package controller;

import hibernate.ManageStation;
import model.Route;
import model.Station;
import model.Traject;
import view.RouteView;
import view.TicketView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Created by Rik Van Belle on 24/11/2016.
 */
public class RouteController {
    RouteView view;
    TicketView ticketView;
    Route routeModel;
    List<Traject> trajecten = null;

    public RouteController(){
        view = new RouteView("Route opzoeken");
    }
    public void showZoekRoute(){
        view.showRoute();
        initComboBoxes();
        zoekRouteInAPI();
        terugButton();
    }
    public void zoekRouteInAPI(){
        view.getRouteButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchRoutes(view.getVertrekStation(), view.getBestemmingStation());
                terugButton();
            }
        });
    }
    public void searchRoutes(String vertrek, String bestemming){

        try {
            trajecten = new ParseController().getTraject(vertrek, bestemming);
        } catch (Exception e){
            e.getStackTrace();
            JOptionPane.showMessageDialog(ticketView.getWindow(), "Geen geldige route gevonden!");
        }
        if(trajecten == null){
            view.showError();
        }
        else {
            view.showSearchedRoutes(trajecten);
            showMoreInfo();
            terugButton();
        }
    }
    public void showMoreInfo(){
        view.getMoreInfoButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Geselecteerde rij: " + view.getSelectedRow());
                view.showDetailedRoute(trajecten.get(view.getSelectedRow()));
            }
        });
    }
    public void initComboBoxes(){
        List<Station> stations = new ManageStation().listStations();
        for (int i = 0; i < stations.size();i++){
            view.getVertrekStationBox().addItem(stations.get(i).getNaam());
            view.getBestemmingStationBox().addItem(stations.get(i).getNaam());
        }
    }
    public void terugButton(){
        view.getTerugButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                backToHomeScreen();
            }
        });
    }
    public void backToHomeScreen() {
        view.getWindow().setVisible(false);
        view.getWindow().dispose();
        view.deleteLastInPath();
        new MainController().showHomeScreen();
    }
}

