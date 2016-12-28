package controller;

import com.google.maps.*;
import com.google.maps.model.DistanceMatrix;
import com.google.maps.model.TransitMode;
import com.google.maps.model.TravelMode;
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

    GeoApiContext q;

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
        List<Traject> trajecten = null;

        try {
            trajecten = new ParseController().getTraject(vertrek, bestemming);
        } catch (Exception e){
            e.getStackTrace();
            JOptionPane.showMessageDialog(ticketView.getWindow(), "Geen geldige route gevondenen");
        }
        if(trajecten == null){
            view.showError();
        }
        else {
            view.showSearchedRoutes(trajecten);
            terugButton();
        }
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

