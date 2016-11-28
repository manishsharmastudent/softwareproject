package controller;

import hibernate.ManageStation;
import model.Route;
import model.StationCsv;
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

    public RouteController(){
        view = new RouteView("Route opzoeken");
    }
    public void showZoekRoute(){
        view.showRoute();
        initComboBoxes();
        zoekRouteInAPI();
    }
    public void zoekRouteInAPI(){
        view.getRouteButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.getWindow().dispose();
                view.getWindow().setVisible(false);
                searchRoutes(view.getVertrekStation(), view.getBestemmingStation());
            }
        });
    }
    public void searchRoutes(String vertrek, String bestemming){
        List<Traject> trajecten = null;

        try {
            trajecten = new ParseController().getTraject(vertrek, bestemming);
        } catch (Exception e){
            e.getStackTrace();
            JOptionPane.showMessageDialog(ticketView.getWindow(), "Geen geldige route gevonden!!!! godverdomme zoekt ne keer een deftige route");

        }
        view = new RouteView("Route");
        if(trajecten == null){
            view.showError();
        }
        else {
            view.showSearchedRoutes(trajecten);

        }
    }
    public void initComboBoxes(){
        List<StationCsv> stations = new ManageStation().getAllStationsBoxes();
        for (int i = 0; i < stations.size();i++){
            view.getVertrekStationBox().addItem(stations.get(i).getNaam());
            view.getBestemmingStationBox().addItem(stations.get(i).getNaam());
        }
    }
}

