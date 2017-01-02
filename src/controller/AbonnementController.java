package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import hibernate.*;
import model.*;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import view.AbonnementView;

import javax.swing.*;

/**
 * Created by Robbe on 06/11/2016.
 */
public class AbonnementController extends MainController {
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
                Klant klant = new ManageKlant().getKlantByRijksregister(abonnementView.getRijksregisterNummerText());
                List<Abonnement> abonnements = abonnementManage.getAbonnementByKlantId(klant);
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
                       if(abo != null){abonnements.add(abo);}
                   } catch (Exception exc){
                       abonnements = abonnementManage.listAbonnementen();
                   }
                    if(abonnements.size() == 0){
                       abonnements = abonnementManage.listAbonnementen();
                    }
                   abonnementView.showGevondenAbonnementen(abonnements);
                   aanpassenAbonnement();
               }
           });
       }
    public void calculatePrice(Korting korting){
        long diff = abonnementModel.getBeginDatum().getTime() - abonnementModel.getBeginDatum().getTime();
        long aantalDagen = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);

        List<Traject> trj = null;

        double percentage = korting.getProcent();
        double prijs = aantalDagen / 3;

        try{
            trj = ParseController.getTraject(abonnementModel.getVertrekStation().getNaam(), abonnementModel.getBestemmingStation().getNaam());
        } catch(Exception exc){}
        double aantalKilometers = trj.get(0).getAantalKilometers();
        if(aantalKilometers > 45){aantalKilometers = 45;}
            if(percentage != 0){
                prijs += aantalKilometers * percentage;
            }
            else {
                prijs += aantalKilometers;
            }
        prijs = Math.floor(prijs);
        abonnementModel.setPrijs((float)prijs);
    }
    public void toevoegenAbonnement(){
        abonnementView.getToevoegenAbonnementButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Korting korting = new ManageKorting().getKortingByid(kortingIds.get(abonnementView.getKortingIndex()));
                Station vertrekStation = new ManageStation().getStationById(stationIds.get(abonnementView.getVertrekStationIndex()));
                Station bestemmingStation = new ManageStation().getStationById(stationIds.get(abonnementView.getBestemmingStationIndex()));
                Klant klant = new ManageKlant().getKlantByRijksregister(rijkregisterNummers.get(abonnementView.getKlantIndex()));

                abonnementModel = new Abonnement(0, korting, abonnementView.getBegindatum(), abonnementView.getEinddatum(), vertrekStation, bestemmingStation, klant, 12.5f, true);
                calculatePrice(korting);
                    if(abonnementView.showPrice(abonnementModel.getPrijs()) == 1){
                        abonnementManage.addAbonnement(abonnementModel);
                        abonnementView.showSuccesfullAdd(abonnementModel.getKlant());
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
                Abonnement abonnement = new Abonnement(abonnementView.getAboId(), new ManageKorting().getKortingByid(kortingIds.get(abonnementView.getKortingIndex())), abonnementView.getBegindatum(), abonnementView.getEinddatum(),new ManageStation().getStationById(stationIds.get(abonnementView.getVertrekStationIndex())), new ManageStation().getStationById(stationIds.get(abonnementView.getBestemmingStationIndex())), new ManageKlant().getKlantByRijksregister(rijkregisterNummers.get(abonnementView.getKlantIndex())), 0.0f,  abonnementView.isActive());
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
