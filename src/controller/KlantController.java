package controller;

import hibernate.ManageKlant;
import jdk.nashorn.internal.scripts.JO;
import model.Klant;
import view.KlantView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
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
    public void setVoornaam(String voornaam){
        klantModel.setVoornaam(voornaam);
    }
    public void setAchternaam(String achternaam){
        klantModel.setAchternaam(achternaam);
    }
    public void setAdres(String adres){
        klantModel.setAdres(adres);
    }
    public void setPostcode(int postcode){
        klantModel.setPostcode(postcode);
    }
    public void setStad(String stad){
        klantModel.setStad(stad);
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
                List<Klant> klanten = new ArrayList<Klant>();
                klanten.add(klant);
                if(klanten.get(0) == null){klantView.klantNotFound();}
                else {
                    klantView.showKlanten(klanten);
                    showKlantAanpassen();
                    klantAanpassen();
                }
            }
        });
    }
    public void searchKlantBySurname(){
        klantView.getSearchButtonSurname().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Klant> klanten = manageKlant.getKlantBySurname(klantView.getVoornaam());
                if(klanten.size() == 0){klantView.klantNotFound();}
                else {
                    klantView.showKlanten(klanten);
                    showKlantAanpassen();
                    klantAanpassen();
                }
            }
        });
    }
    public void searchKlantByLastname(){
        klantView.getSearchButtonLastname().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Klant> klanten = manageKlant.getKlantByLastname(klantView.getAchternaam());
                if(klanten.size() == 0){klantView.klantNotFound();}
                else {
                    klantView.showKlanten(klanten);
                    showKlantAanpassen();
                    klantAanpassen();
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
                    klantView.klantInsertSucceed();
                    backToHomeScreen();
                } catch (Exception ex){
                    ex.getStackTrace();
                    JOptionPane.showMessageDialog(null, ex.getMessage() + "\n Probeer later opnieuw!");
                    backToHomeScreen();
                }
            }
        });
    }
    public void klantAanpassen(){
        klantView.getKlantUpdateButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                klantModel = new Klant(klantView.getRijksregisterNummer(), klantView.getVoornaam(), klantView.getAchternaam(), klantView.getAdres(), klantView.getPostcode(), klantView.getStad(), klantView.isActive());
                try {
                    manageKlant.updateKlant(klantModel);
                    klantView.klantUpdateSucceed();
                }catch (Exception exc){
                    klantView.klantUpdateFailure();
                }

            }
        });
    }
    public void showKlantAanpassen(){
        klantView.getAanpassenKlant().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                klantView.showUpdateKlant(manageKlant.getKlantByRijksregister(klantView.getSelectedRow()));
            }
        });
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
