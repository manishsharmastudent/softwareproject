package controller;

import hibernate.ManageKlant;
import hibernate.ManageRoute;
import hibernate.ManageStation;
import hibernate.ManageVoorwerp;
import model.*;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import view.VoorwerpView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Robbe on 06/11/2016.
 */
public class VoorwerpController {
    private Voorwerp voorwerpModel;
    private VoorwerpView voorwerpView;
    private ManageVoorwerp voorwerpManage;

    public VoorwerpController(){
        voorwerpView = new VoorwerpView("Voorwerp");
        voorwerpManage = new ManageVoorwerp();
    }

    public VoorwerpController(Voorwerp voorwerp, VoorwerpView voorwerpView){
        this.voorwerpModel = voorwerp;
        this.voorwerpView = voorwerpView;
        this.voorwerpManage = new ManageVoorwerp();
    }


    public int getVoorwerpId(){ return voorwerpModel.getVoorwerpId(); }
    public String getKleur(){ return voorwerpModel.getKleur(); }
    public String getType(){ return voorwerpModel.getType(); }
    public Route getRoute(){ return voorwerpModel.getRoute(); }
    public Station getStation(){ return voorwerpModel.getStation(); }

    public void setVoorwerpId(int voorwerpid){ voorwerpModel.setVoorwerpId(voorwerpid); }
    public void setKleur(String kleur){ voorwerpModel.setKleur(kleur); }
    public void setType(String type){ voorwerpModel.setType(type); }
    public void setRoute(Route route){ voorwerpModel.setRoute(route); }
    public void setStation(Station station){ voorwerpModel.setStation(station); }
    public void toevoegenVoorwerp(){
        voorwerpView.getToevoegenVoorwerpButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Route route = null;
                Klant klant = null;
                Station station = null;

                //Route
                try{
                    List<Route> routes = new ManageRoute().listRoute();
                    route = new ManageRoute().getRouteById(routes.get(voorwerpView.getKlantComboBox().getSelectedIndex()).getRouteId());
                } catch(Exception exc){
                    JOptionPane.showMessageDialog(null, exc.getMessage() + "\nRoute is niet gevonden");
                }

                //Klant
                try {
                    List<Klant> klanten = new ManageKlant().listKlanten();
                    klant = new ManageKlant().getKlantByRijksregister(klanten.get(voorwerpView.getKlantComboBox().getSelectedIndex()).getRijksregisterNummer());
                } catch (Exception exc){
                    JOptionPane.showMessageDialog(null, exc.getMessage() + "\nKlant is niet gevonden");
                }

                //Station
                try {
                    List<Station> stations = new ManageStation().listStations();
                    station = new ManageStation().getStationById(stations.get(voorwerpView.getKlantComboBox().getSelectedIndex()).getStationId());
                } catch (Exception exc){
                    JOptionPane.showMessageDialog(null, exc.getMessage() + "\nStation is niet gevonden");
                }

                voorwerpModel = new Voorwerp(0, voorwerpView.getTrein(), voorwerpView.getKleur(), voorwerpView.getType(), voorwerpView.getVoorwerp(), route, station, klant, true);
                voorwerpManage.addVoorwerp(voorwerpModel);
            }
        });
    }
    public void showZoekVoorwerp(){
        voorwerpView.showVoorwerpenZoeken();
        initComboBox();
        zoekVoorwerpOpNaam();
        terugButton();
    }
    public void showAllVoorwerpen(){
        voorwerpView.showVoorwerpen(voorwerpManage.listVoorwerp());
    }
    public void zoekVoorwerpOpNaam(){
        voorwerpView.getZoekButtonNaam().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Voorwerp>voorwerpen = voorwerpManage.getVoorwerpenByNaam(voorwerpView.getVoorwerp());
                showVoorwerpen(voorwerpen);
                terugButton();
            }
        });
    }
    public void showVoorwerp(Voorwerp voorwerp){ voorwerpView.showVoorwerp(voorwerp);}
    public void showVoorwerpen(List<Voorwerp>voorwerpen){
        if(voorwerpen.size() == 0){
            showGeenVoorwerpenGevonden();
        }
        else {
            voorwerpView.getVoorwerpenPanel().removeAll();
            voorwerpView.getVoorwerpenPanel().updateUI();
            voorwerpView.showVoorwerpen(voorwerpen);
            verwijderAfgehaaldVoorwerp();
        }

    }
    public void showVoorwerpToevoegen(){
        voorwerpView.showVoorwerpenToevoegen();
        initComboBox();
        toevoegenVoorwerp();
        terugButton();
    }
    public void verwijderAfgehaaldVoorwerp(){
        voorwerpView.getVoorwerpAfgehaald().addActionListener(new ActionListener() {
            int id = -1;
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    id = voorwerpView.getSelectedRow();
                    if(id != -1) {
                        voorwerpManage.deleteVoorwerpById(id);
                        voorwerpView.showSucceed(id);
                    }
                } catch (Exception exc){
                    voorwerpView.showError(id);
                }

            }
        });
    }
    public void showGeenVoorwerpenGevonden(){
        voorwerpView.geenVoorwerpenGevonden();
    }
    public void initComboBox(){
        AutoCompleteDecorator.decorate(voorwerpView.getKlantComboBox());
        AutoCompleteDecorator.decorate(voorwerpView.getRouteComboBox());
        AutoCompleteDecorator.decorate(voorwerpView.getKleurComboBox());
        AutoCompleteDecorator.decorate(voorwerpView.getStationComboBox());
        AutoCompleteDecorator.decorate(voorwerpView.getTypeComboBox());

        voorwerpView.getRouteComboBox().addItem("N/A");
        voorwerpView.getKlantComboBox().addItem("N/A");
        ManageRoute manageRoute = new ManageRoute();
        final List<Route> routes = manageRoute.listRoute();

        for (int i = 0; i < routes.size();i++){
            String route = routes.get(i).getRouteVertrek().getNaam() + " - " + routes.get(i).getRouteBestemming().getNaam();
        voorwerpView.getRouteComboBox().addItem(route);
    }

        String[]typeVoorwerpen = {"N/A", "Smartphone", "GSM", "Paraplu", "Laptop", "Handtas", "Portomonnee"};
        for (int i = 0; i < typeVoorwerpen.length;i++){
            voorwerpView.getTypeComboBox().addItem(typeVoorwerpen[i]);
        }

        List<Klant> klanten = new ManageKlant().listKlanten();
        for (int i = 0; i < klanten.size();i++){
            String klant = klanten.get(i).getVoornaam() + " " + klanten.get(i).getAchternaam();
            voorwerpView.getKlantComboBox().addItem(klant);
        }

        String[] kleuren = {"Rood", "Geel", "Zwart", "Wit", "Onbekend"};
        for (int i = 0; i < kleuren.length;i++){
            voorwerpView.getKleurComboBox().addItem(kleuren[i]);
        }

        /*List<Station> stations = new ManageStation().listStations();
        for (int i = 0; i < stations.size();i++){
            voorwerpView.getStationComboBox().addItem(stations.get(i).getStad());
        }*/
    }
    public void terugButton(){
        voorwerpView.getTerugButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                backToHomeScreen();
            }
        });
    }
    public void backToHomeScreen() {
        voorwerpView.getWindow().setVisible(false);
        voorwerpView.getWindow().dispose();
        voorwerpView.deleteLastInPath();
        new MainController().showHomeScreen();
    }
}
