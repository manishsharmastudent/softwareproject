package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import hibernate.ManageAbonnement;
import hibernate.ManageKlant;
import hibernate.ManageKorting;
import hibernate.ManageRoute;
import model.Abonnement;
import model.Korting;
import model.Route;
import model.Klant;
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
                System.out.println(abonnementView.getRijksregisterNummerText());
                abonnementView.showGevondenAbonnementen(abonnement);
                aanpassenAbonnement();
            }
        });
    }
    public void zoekAbonnementWithAbonnementId(){
           abonnementView.getZoekAbonnementByAboIdButton().addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {
                   abonnementView.getGevondenAbonnementPanel().removeAll();
                   abonnementView.getGevondenAbonnementPanel().updateUI();
                   Abonnement abo = abonnementManage.getAbonnementById(Integer.parseInt(abonnementView.getAbonnementNummerText()));
                   abonnementView.showGevondenAbonnementen(abo);
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
                Route route = null;
                Klant klant = null;
                Abonnement abonnement = null;

                    List<Korting> kortingen = new ManageKorting().listKorting();
                    korting = new ManageKorting().getKortingByid(kortingen.get(abonnementView.getKortingComboBox().getSelectedIndex()).getKortingId());

                    List<Route> routes = new ManageRoute().listRoute();
                    route = new ManageRoute().getRouteById(routes.get(abonnementView.getRouteComboBox().getSelectedIndex()).getRouteId());

                    List<Klant> klanten = new ManageKlant().listKlanten();
                    klant = new ManageKlant().getKlantByRijksregister(klanten.get(abonnementView.getKlantComboBox().getSelectedIndex()).getRijksregisterNummer());

                    abonnementModel = new Abonnement(0, korting, abonnementView.getBegindatum(), abonnementView.getEinddatum(), route, klant, 12.5f, true);
                    abonnement = abonnementManage.getAbonnementByKlantId(klant.getRijksregisterNummer());

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
                showChangeAbonnement(abonnementView.getAbonnement());
            }
        });
    }
    public void updatenAbonnement(){
        abonnementView.getUpdateButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    Abonnement abonnement = new Abonnement(abonnementView.getAboId(), new ManageKorting().getKortingByid(abonnementView.getKorting()), abonnementView.getBegindatum(), abonnementView.getEinddatum(),new ManageRoute().getRouteById(abonnementView.getRoute()), new ManageKlant().getKlantByRijksregister(abonnementView.getKlant()), 0.0f,  abonnementView.getAfsluiten());
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
    private void initComboBoxes(){
        AutoCompleteDecorator.decorate(abonnementView.getKlantComboBox());
        AutoCompleteDecorator.decorate(abonnementView.getKortingComboBox());
        AutoCompleteDecorator.decorate(abonnementView.getRouteComboBox());

        ManageRoute manageRoute = new ManageRoute();
        final List<Route> routes = manageRoute.listRoute();
        for (int i = 0; i < routes.size();i++){
            String route = routes.get(i).getRouteId() + ". " + routes.get(i).getRouteVertrek().getNaam() + " - " + routes.get(i).getRouteBestemming().getNaam();
            abonnementView.getRouteComboBox().addItem(route);
        }
        List<Korting> kortingen = new ManageKorting().listKorting();
        for (int i = 0; i < kortingen.size();i++){
            String korting = kortingen.get(i).getKortingId() + "." + kortingen.get(i).getOmschrijving();
            abonnementView.getKortingComboBox().addItem(korting);
        }

        final List<Klant> klanten = new ManageKlant().listKlanten();
        for (int i = 0; i < klanten.size();i++){
            String klant = klanten.get(i).getRijksregisterNummer() + klanten.get(i).getVoornaam() + " " + klanten.get(i).getAchternaam();
            abonnementView.getKlantComboBox().addItem(klant);
        }
    }
    public void terugButton(){
        abonnementView.getTerugButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                backToHomeScreen();
            }
        });
    }
    private void backToHomeScreen() {
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
