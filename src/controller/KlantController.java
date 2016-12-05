package controller;

import hibernate.ManageKlant;
import jdk.nashorn.internal.scripts.JO;
import model.Klant;
import view.KlantView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Created by Rik Van Belle on 01/11/2016.
 */
public class KlantController {
    private Klant klantModel = new Klant();
    private KlantView klantView = new KlantView("Klant");
    private ManageKlant manageKlant = new ManageKlant();

    public KlantController(){
    }

    public KlantController(Klant klant, KlantView klantView, ManageKlant MK){
        this.klantModel = klant;
        this.klantView = klantView;
        this.manageKlant = MK;
    }
    public String getRijksregister(){
        return klantModel.getRijksregisterNummer();
    }
    public String getVoornaam(){
        return klantModel.getVoornaam();
    }
    public String getAchternaam(){
        return klantModel.getAchternaam();
    }
    public String getAdres(){
        return klantModel.getAdres();
    }
    public int getPostcode(){
        return klantModel.getPostcode();
    }
    public String getStad(){
        return klantModel.getStad();
    }
    public boolean setVoornaam(String voornaam){
        return klantModel.setVoornaam(voornaam);
    }
    public boolean setAchternaam(String achternaam){
        return klantModel.setAchternaam(achternaam);
    }
    public boolean setAdres(String adres){
        return klantModel.setAdres(adres);
    }
    public boolean setPostcode(int postcode){
        return klantModel.setPostcode(postcode);
    }
    public boolean setStad(String stad){
        return klantModel.setStad(stad);
    }

    public void getKlantByName(String name){
        /*List kl = MK.getKlantByName(name);
        for (int i = 0; i < kl.size();i++){
            klantView.showKlant((Klant)kl.get(i));
        }*/
    }
    public void searchKlantByRijksregister(){
        klantView.getSearchButtonRijksregisterNummer().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Klant klant = manageKlant.getKlantByRijksregister(klantView.getRijksregisterNummer());
                //klantView.showKlanten(klant);
            }
        });
    }
    public void searchKlantBySurname(){
        klantView.getSearchButtonSurname().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Klant> klanten = manageKlant.getKlantBySurname(klantView.getVoornaam());
                klantView.showKlanten(klanten);
            }
        });
    }
    public void searchKlantByLastname(){
        klantView.getSearchButtonLastname().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Klant> klanten = manageKlant.getKlantByLastname(klantView.getAchternaam());
                klantView.showKlanten(klanten);
            }
        });
    }

    public void showToevoegenKlant(){
        klantView.showKlantToevoegen();
        //Listeners
        klantToevoegen();
        terugButton();
    }
    public void showZoekKlanten(){
        klantView.showKlantZoeken();
        searchKlantByLastname();
        searchKlantByRijksregister();
        searchKlantBySurname();
        terugButton();
    }
    public void klantToevoegen(){
        klantView.getKlantToevoegenButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                klantModel = new Klant(klantView.getRijksregisterNummer(), klantView.getVoornaam(), klantView.getAchternaam(), klantView.getAdres(), klantView.getPostcode(), klantView.getStad(), true);
                try {
                    manageKlant.addKlant(klantModel);
                    backToHomeScreen();
                } catch (Exception ex){
                    ex.getStackTrace();
                    JOptionPane.showMessageDialog(null, ex.getMessage() + "\n Probeer later opnieuw!");
                    backToHomeScreen();
                }
            }
        });
    }

    public void showToevoegenKlant(){
        klantView.showKlantToevoegen();
        //Listeners
        klantToevoegen();
        terugButton();
    }

    public void klantToevoegen(){
        klantView.getKlantToevoegenButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                klantModel = new Klant(klantView.getRijksregisterNummer(), klantView.getVoornaam(), klantView.getAchternaam(), klantView.getAdres(), klantView.getPostcode(), klantView.getStad(), true);
                try {
                    manageKlant.addKlant(klantModel);
                    backToHomeScreen();
                } catch (Exception ex){
                    ex.getStackTrace();
                    JOptionPane.showMessageDialog(null, ex.getMessage() + "\n Probeer later opnieuw!");
                    backToHomeScreen();
                }
            }
        });
    }

    public void showKlant(){
        klantView.showKlant(klantModel);
    }
    public void terugButton(){
        klantView.getTerugButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                backToHomeScreen();
            }
        });
    }
    public void backToHomeScreen() {
        klantView.getWindow().setVisible(false);
        klantView.getWindow().dispose();
        klantView.deleteLastInPath();
        new MainController().showHomeScreen();
    }
}
