package controller;

import com.google.maps.model.DistanceMatrix;
import hibernate.ManageStation;
import model.Station;
import model.Traject;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import view.RouteView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Created by Rik Van Belle on 24/11/2016.
 */
public class RouteController {
    RouteView view;


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
            }
        });
    }
    public void searchRoutes(String vertrek, String bestemming){
        List<Traject> trajecten = null;

        try {
            trajecten = new ParseController().getTraject(vertrek, bestemming);
        } catch (Exception e){
            view.showGeenGeldigeRoute();
        }
            if(trajecten == null){view.showGeenGeldigeRoute();}
            else {view.showSearchedRoutes(trajecten);}

    }
    public void initComboBoxes(){
        AutoCompleteDecorator.decorate(view.getVertrekStationBox());
        AutoCompleteDecorator.decorate(view.getBestemmingStationBox());

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

