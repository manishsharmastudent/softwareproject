package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import hibernate.*;
import model.*;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import view.AbonnementView;

import javax.swing.*;

/**
 * Created by Robbe on 06/11/2016.
 */
public class AbonnementController {
    private Abonnement abonnementModel;
    private AbonnementView abonnementView;
    private ManageAbonnement abonnementManage;

    private ArrayList<Integer> stationIds = new ArrayList<>();
    private ArrayList<Integer> kortingIds = new ArrayList<>();
    private ArrayList<String> rijkregisterNummers = new ArrayList<>();

    public AbonnementController(){
        abonnementModel = new Abonnement();
        abonnementView = new AbonnementView("Abonnement");
        abonnementManage = new ManageAbonnement();
    }

    public AbonnementController(Abonnement abonnement, AbonnementView abonnementView){
        this.abonnementModel = abonnement;
        this.abonnementView = abonnementView;
    }


    public int getAbonnementId(){ return abonnementModel.getAbonnementId(); }
    public Korting getKorting(){ return abonnementModel.getKorting(); }
    public Date getBeginDatum(){ return abonnementModel.getBeginDatum(); }
    public Date getVervalDatum(){ return abonnementModel.getVervalDatum(); }
    public Route getRoute(){ return abonnementModel.getRoute(); }
    public Klant getKlant(){ return abonnementModel.getKlant(); }
    public Float getPrijs(){ return abonnementModel.getPrijs(); }
    public Boolean isActive(){ return abonnementModel.isActive(); }

    public void setAbonnementId(int abonnementId){ abonnementModel.setAbonnementId(abonnementId); }
    public void setKorting(Korting korting){ abonnementModel.setKorting(korting); }
    public void setBeginDatum(Date beginDatum){ abonnementModel.setBeginDatum(beginDatum); }
    public void setVervalDatum(Date vervalDatum){ abonnementModel.setVervalDatum(vervalDatum); }
    public void setRoute(Route route){ abonnementModel.setRoute(route); }
    public void setKlant(Klant klant){ abonnementModel.setKlant(klant); }
    public void setPrijs(Float prijs){ abonnementModel.setPrijs(prijs); }
    public void setActive(Boolean active){ abonnementModel.setActive(active); }

    public void showToevoegenAbonnement(){
        abonnementView.showToevoegenAbonnement();
        initComboBoxes();
        toevoegenAbonnement();
        terugButton();
        checkIfEndDateIsAfterStartDate();
    }
    public void showZoekAbonnement(){
        abonnementView.showZoekAbonnement();
        zoekAbonnementWithKlantId();
        zoekAbonnementWithAbonnementId();
        terugButton();
    }
    public void zoekAbonnementWithKlantId(){
        abonnementView.getZoekAbonnementByKlantIdButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abonnementView.getGevondenAbonnementPanel().removeAll();
                abonnementView.getGevondenAbonnementPanel().updateUI();
                Abonnement abonnement = abonnementManage.getAbonnementByKlantId(abonnementView.getRijksregisterNummerText());
                List<Abonnement> abonnements = new ArrayList<Abonnement>();
                abonnements.add(abonnement);
                if(abonnements.get(0) == null){
                    abonnementView.showAbonnementNotFound();
                }
                else {
                    abonnementView.showGevondenAbonnementen(abonnements);
                    aanpassenAbonnement();
                }
            }
        });
    }
    public void zoekAbonnementWithAbonnementId(){
           abonnementView.getZoekAbonnementByAboIdButton().addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {
                   abonnementView.getGevondenAbonnementPanel().removeAll();
                   abonnementView.getGevondenAbonnementPanel().updateUI();
                   List<Abonnement> abonnements = new ArrayList<Abonnement>();
                   try {
                       Abonnement abo = abonnementManage.getAbonnementById(Integer.parseInt(abonnementView.getAbonnementNummerText()));
                       abonnements.add(abo);
                   } catch (Exception exc){
                       abonnements = abonnementManage.listAbonnementen();
                   }


                   abonnementView.showGevondenAbonnementen(abonnements);
                   aanpassenAbonnement();
               }
           });
       }
    public double calculatePrice(Korting korting){
        double price = 120;
        double procent = korting.getProcent();
        double kortingsPrijs = price * procent;
        price = price - kortingsPrijs;

        return price;
    }
    public void toevoegenAbonnement(){
        abonnementView.getToevoegenAbonnementButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Korting korting = null;
                Station vertrekStation = null;
                Station bestemmingStation = null;
                Klant klant = null;
                Abonnement abonnement = null;
                    korting = new ManageKorting().getKortingByid(kortingIds.get(abonnementView.getKortingIndex()));
                    vertrekStation = new ManageStation().getStationById(stationIds.get(abonnementView.getVertrekStationIndex()));
                    bestemmingStation = new ManageStation().getStationById(stationIds.get(abonnementView.getBestemmingStationIndex()));
                    klant = new ManageKlant().getKlantByRijksregister(rijkregisterNummers.get(abonnementView.getKlantIndex()));

                    abonnementModel = new Abonnement(0, korting, abonnementView.getBegindatum(), abonnementView.getEinddatum(), vertrekStation, bestemmingStation, klant, 12.5f, true);

                    if (abonnement == null) {
                        if(abonnementView.showPrice(calculatePrice(korting)) == 1){
                            abonnementManage.addAbonnement(abonnementModel);
                            abonnementView.showSuccesfullAdd(abonnementModel.getKlant());
                        }
                    }
                    else {
                            abonnementView.alreadyAbonnement(abonnement.getAbonnementId());
                    }
                backToHomeScreen();
            }
        });
    }
    public void aanpassenAbonnement(){
        abonnementView.getAanpasButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abonnementView.getAbonnementPanel().removeAll();
                abonnementView.getAbonnementPanel().updateUI();
                abonnementView.getGevondenAbonnementPanel().removeAll();
                abonnementView.getGevondenAbonnementPanel().updateUI();
                Abonnement abo = abonnementManage.getAbonnementById(abonnementView.getSelectedRow());
                showChangeAbonnement(abo);
            }
        });
    }
    public void updatenAbonnement(){
        abonnementView.getUpdateButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Abonnement abonnement = new Abonnement(abonnementView.getAboId(), new ManageKorting().getKortingByid(kortingIds.get(abonnementView.getKortingIndex())), new Date(), new Date(),new ManageStation().getStationById(stationIds.get(abonnementView.getVertrekStationIndex())), new ManageStation().getStationById(stationIds.get(abonnementView.getBestemmingStationIndex())), new ManageKlant().getKlantByRijksregister(rijkregisterNummers.get(abonnementView.getKlantIndex())), 0.0f,  abonnementView.isActive());
                abonnementManage.updateAbonnement(abonnement);
            }
        });
    }
    public void showChangeAbonnement(Abonnement abonnement){
        abonnementView.getWindow().setVisible(false);
        abonnementView.getWindow().dispose();
        abonnementView.showAanpassenAbonnement(abonnement);
        updatenAbonnement();
        initComboBoxes();
    }
    private void initComboBoxes() {
        AutoCompleteDecorator.decorate(abonnementView.getKlantComboBox());
        AutoCompleteDecorator.decorate(abonnementView.getKortingComboBox());
        AutoCompleteDecorator.decorate(abonnementView.getVertrekComboBox());
        AutoCompleteDecorator.decorate(abonnementView.getBestemmingComboBox());

        ManageStation manageStation = new ManageStation();
        final List<Station> stations = manageStation.listStations();
        for (int i = 0; i < stations.size(); i++) {
            stationIds.add(stations.get(i).getStationId());
            abonnementView.getVertrekComboBox().addItem(stations.get(i).getNaam());
            abonnementView.getBestemmingComboBox().addItem(stations.get(i).getNaam());
        }
        List<Korting> kortingen = new ManageKorting().listKorting();
        for (int i = 0; i < kortingen.size(); i++) {
            kortingIds.add(kortingen.get(i).getKortingId());
            abonnementView.getKortingComboBox().addItem(kortingen.get(i).getOmschrijving());
        }

        final List<Klant> klanten = new ManageKlant().listKlanten();
        for (int i = 0; i < klanten.size(); i++) {
            rijkregisterNummers.add(klanten.get(i).getRijksregisterNummer());
            String klant = klanten.get(i).getVoornaam() + " " + klanten.get(i).getAchternaam();
            abonnementView.getKlantComboBox().addItem(klant);
        }
    }
    public void terugButton() {
        abonnementView.getTerugButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                backToHomeScreen();
            }
        });
    }
    public void backToHomeScreen() {
        abonnementView.getWindow().setVisible(false);
        abonnementView.getWindow().dispose();
        abonnementView.deleteLastInPath();
        new MainController().showHomeScreen();
    }
    public void checkIfEndDateIsAfterStartDate(){
        abonnementView.getDatePickerEindDatum().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(abonnementView.getEinddatum().compareTo(abonnementView.getBegindatum()) < 0){
                    abonnementView.showErrorDate();
                }
            }
        });
    }
}
