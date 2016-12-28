package controller;

import hibernate.ManageKlant;
import hibernate.ManageStation;
import hibernate.ManageVoorwerp;
import model.*;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import view.VoorwerpView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Robbe on 06/11/2016.
 */
public class VoorwerpController {
    private Voorwerp voorwerpModel;
    private VoorwerpView voorwerpView;
    private ManageVoorwerp voorwerpManage;

    private ArrayList<Integer> stationIds = new ArrayList<>();
    private ArrayList<String> rijkregisterNummers = new ArrayList<>();

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

    public void setVoorwerpId(int voorwerpid){ voorwerpModel.setVoorwerpId(voorwerpid); }
    public void setKleur(String kleur){ voorwerpModel.setKleur(kleur); }
    public void setType(String type){ voorwerpModel.setType(type); }
    public void toevoegenVoorwerp(){
        voorwerpView.getToevoegenVoorwerpButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Klant klant = new ManageKlant().getKlantByRijksregister(rijkregisterNummers.get(voorwerpView.getKlantIndex()));
                Station vertrekStation = new ManageStation().getStationById(stationIds.get(voorwerpView.getVertrekStationIndex()));
                Station bestemmingStation = new ManageStation().getStationById(stationIds.get(voorwerpView.getBestemmingStationIndex()));

                voorwerpModel = new Voorwerp(0, voorwerpView.getTrein(), voorwerpView.getKleur(), voorwerpView.getType(), voorwerpView.getVoorwerp(), vertrekStation, bestemmingStation, klant, true);
                try {
                    voorwerpManage.addVoorwerp(voorwerpModel);
                    voorwerpView.addVoorwerpSucceed(voorwerpModel.getVoorwerp());
                } catch(Exception exc){
                    voorwerpView.addVoorwerpFailed();
                }

            }
        });
    }
    public void showZoekVoorwerp(){
        voorwerpView.showVoorwerpenZoeken();
        initComboBox();
        zoekVoorwerpOpNaam();
        terugButton();
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
    public void showVoorwerpen(List<Voorwerp>voorwerpen){
        if(voorwerpen.size() == 0){
            showGeenVoorwerpenGevonden();
        }
        else {
            voorwerpView.getVoorwerpenPanel().removeAll();
            voorwerpView.getVoorwerpenPanel().updateUI();
            voorwerpView.showVoorwerpen(voorwerpen);
            verwijderAfgehaaldVoorwerp();
            terugButton();
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

                        Voorwerp voorwerp = voorwerpManage.getVoorwerpById(id);
                        voorwerp.setActive(false);
                        voorwerpManage.updateVoorwerp(voorwerp);
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
        AutoCompleteDecorator.decorate(voorwerpView.getKleurComboBox());
        AutoCompleteDecorator.decorate(voorwerpView.getVertrekStationComboBox());
        AutoCompleteDecorator.decorate(voorwerpView.getBestemmingStationComboBox());
        AutoCompleteDecorator.decorate(voorwerpView.getTypeComboBox());

        voorwerpView.getKlantComboBox().addItem("N/A");
        String[]typeVoorwerpen = {"N/A", "Smartphone", "GSM", "Paraplu", "Laptop", "Handtas", "Portomonnee"};
        for (int i = 0; i < typeVoorwerpen.length;i++){
            voorwerpView.getTypeComboBox().addItem(typeVoorwerpen[i]);
        }

        List<Klant> klanten = new ManageKlant().listKlanten();
        for (int i = 0; i < klanten.size();i++){
            rijkregisterNummers.add(klanten.get(i).getRijksregisterNummer());
            String klant = klanten.get(i).getVoornaam() + " " + klanten.get(i).getAchternaam();
            voorwerpView.getKlantComboBox().addItem(klant);
        }

        String[] kleuren = {"Rood", "Geel", "Zwart", "Wit", "Onbekend"};
        for (int i = 0; i < kleuren.length;i++){
            voorwerpView.getKleurComboBox().addItem(kleuren[i]);
        }

        List<Station> stations = new ManageStation().listStations();
        for (int i = 0; i < stations.size();i++){
            stationIds.add(stations.get(i).getStationId());
            voorwerpView.getVertrekStationComboBox().addItem(stations.get(i).getNaam());
            voorwerpView.getBestemmingStationComboBox().addItem(stations.get(i).getNaam());
        }
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
