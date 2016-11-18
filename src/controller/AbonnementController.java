package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

    public void showAbonnement(Abonnement abonnement){ abonnementView.showAbonnement(abonnement);}
    public void showToevoegenAbonnement(){
        abonnementView.showToevoegenAbonnement();
        initComboBoxes();
        toevoegenAbonnement();
        terugButton();
    }
    public void toevoegenAbonnement(){
        abonnementView.getToevoegenAbonnementButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Korting korting = null;
                Route route = null;
                Klant klant = null;

                //Korting
                try {
                    List<Korting> kortingen = new ManageKorting().listKorting();
                    korting = new ManageKorting().getKortingByid(kortingen.get(abonnementView.getKlantComboBox().getSelectedIndex()).getKortingId());
                } catch (Exception exc){
                    JOptionPane.showMessageDialog(null, exc.getMessage() + "\nRoute is niet gevonden");
                }

                //Route
                try{
                    List<Route> routes = new ManageRoute().listRoute();
                    route = new ManageRoute().getRouteById(routes.get(abonnementView.getKlantComboBox().getSelectedIndex()).getRouteId());
                } catch(Exception exc){
                    JOptionPane.showMessageDialog(null, exc.getMessage() + "\nRoute is niet gevonden");
                }

                //Klant
                try {
                    List<Klant> klanten = new ManageKlant().listKlanten();
                    klant = new ManageKlant().getKlantByRijksregister(klanten.get(abonnementView.getKlantComboBox().getSelectedIndex()).getRijksregisterNummer());
                } catch (Exception exc){
                    JOptionPane.showMessageDialog(null, exc.getMessage() + "\nKlant is niet gevonden");
                }
                try {
                    abonnementModel = new Abonnement(0, korting, abonnementView.getBegindatum(), abonnementView.getEinddatum(), route, klant, 12.5f, true);
                    abonnementManage.addAbonnement(abonnementModel);
                } catch (Exception exc){
                    JOptionPane.showMessageDialog(null, exc.getMessage() + "\n Abonnement is niet toegevoegd");
                }
            }
        });
    }
    private void initComboBoxes(){
        ManageRoute manageRoute = new ManageRoute();
        final List<Route> routes = manageRoute.listRoute();
        for (int i = 0; i < routes.size();i++){
            String route = routes.get(i).getRouteVertrek().getNaam() + " - " + routes.get(i).getRouteBestemming().getNaam();
            abonnementView.getRouteComboBox().addItem(route);
        }
        List<Korting> kortingen = new ManageKorting().listKorting();
        for (int i = 0; i < kortingen.size();i++){
            String korting = kortingen.get(i).getOmschrijving();
            abonnementView.getKortingComboBox().addItem(korting);
        }

        final List<Klant> klanten = new ManageKlant().listKlanten();
        for (int i = 0; i < klanten.size();i++){
            String klant = klanten.get(i).getVoornaam() + " " + klanten.get(i).getAchternaam();
            abonnementView.getKlantComboBox().addItem(klant);
        }

        abonnementView.getKlantComboBox().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Klant klant = new Klant();
                String nummer = klanten.get(abonnementView.getKlantComboBox().getSelectedIndex()).getRijksregisterNummer();
                System.out.println(klant.getRijksregisterNummer());
            }
        });

    }
    public void terugButton(){
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
}
