package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;
import javax.swing.*;
import javax.swing.plaf.synth.SynthTextAreaUI;

import hibernate.ManageStation;
import hibernate.ManageTicket;
import hibernate.ManageTypeKaart;
import model.*;
import view.TicketView;
//import view.LoginView;
/**
 * Created by Rik Van Belle on 01/11/2016.
 */
public class TicketController {
    private Ticket ticketModel;
    private TicketView ticketView;
    private ManageTicket ticketManage;

    public TicketController(){
        ticketModel = new Ticket();
        ticketManage = new ManageTicket();
        ticketView = new TicketView("Ticket");
    }
    public TicketController(Ticket model, TicketView view, ManageTicket manage){
        this.ticketModel = model;
        this.ticketView = view;
        this.ticketManage = manage;
    }

    public TicketView getTicketView(){
        return this.ticketView;
    }

    public void disableOptionsOnType(){
        ticketView.getTypeKaartenComboBox().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                switch (ticketView.getTypeKaartenComboBox().getSelectedIndex()){
                    case 0: ticketView.getVertrekStationComboBox().setEnabled(true);
                            ticketView.getBestemmingsStationComboBox().setEnabled(true);
                            ticketView.getKlasseCombobox().setEnabled(true);
                            ticketView.getSpinnerAantalPersonen().setEnabled(true);
                        break;
                    case 1: ticketView.getVertrekStationComboBox().setEnabled(false);
                            ticketView.getBestemmingsStationComboBox().setEnabled(false);
                            ticketView.getKlasseCombobox().setEnabled(false);
                            ticketView.getSpinnerAantalPersonen().setEnabled(false);
                        break;
                    case 2: ticketView.getVertrekStationComboBox().setEnabled(true);
                            ticketView.getBestemmingsStationComboBox().setEnabled(true);
                            ticketView.getKlasseCombobox().setEnabled(true);
                            ticketView.getSpinnerAantalPersonen().setEnabled(true);
                        break;
                    case 4: ticketView.getVertrekStationComboBox().setEnabled(false);
                            ticketView.getBestemmingsStationComboBox().setEnabled(false);
                            ticketView.getKlasseCombobox().setEnabled(false);
                            ticketView.getSpinnerAantalPersonen().setEnabled(false);
                        break;
                }
            }
        });
    }
    public void showVoegTicketToe(){
        ticketView.showVoegTicketToe();
        //Initialization
        initComboBoxes();
        //add Listeners
        voegTicketToe();
        terugButton();
    }
    private void initComboBoxes(){
        List<StationCsv> stations = new ManageStation().getAllStationsBoxes();

        ManageTypeKaart mTK = new ManageTypeKaart();
        final List<TypeKaart> typeKaarten = mTK.listTypeKaarten();

        ticketView.getTypeKaartenComboBox().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ticketView.setTypeKaartOmschrijving(typeKaarten.get(ticketView.getTypeKaartIndex()).getOmschrijving());
            }
        });

        for (int i = 0; i < typeKaarten.size();i++){
            ticketView.getTypeKaartenComboBox().addItem(typeKaarten.get(i).getNaam());
        }

        for(int i = 0; i < stations.size();i++){
            ticketView.getVertrekStationComboBox().addItem(stations.get(i).getNaam());
            ticketView.getBestemmingsStationComboBox().addItem(stations.get(i).getNaam());
        }

        ticketView.getKlasseCombobox().addItem("Eerste klasse");
        ticketView.getKlasseCombobox().addItem("Tweede klasse");
        disableOptionsOnType();
    }
    private void voegTicketToe(){
        ticketView.getZoekButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                List<Traject> trajecten = null;
                ParseController pC = new ParseController();
                try {
                   trajecten = pC.getTraject(ticketView.getVertrekStation(), ticketView.getBestemmingsStation());
                    for(int i = 0; i < trajecten.size();i++){
                        System.out.println(trajecten.get(i).toString());
                    }
                    double prijs = trajecten.get(1).getAantalKilometers() * 0.50;
                    NumberFormat formatter = new DecimalFormat("##.##");
                    JOptionPane.showMessageDialog(ticketView.getWindow(), "Prijs ticket: €" +  formatter.format(prijs)
                    + "\nAfstand route= " + trajecten.get(1).getAantalKilometers() + "km");

                } catch (Exception exc){
                    JOptionPane.showMessageDialog(ticketView.getWindow(), "Geen geldige route gevonden!!!! godverdomme zoekt ne keer een deftige route");
                    exc.getStackTrace();
                }

/*
                    if (trajecten.equals(null)){
                        JOptionPane.showMessageDialog(ticketView.getWindow(), "Geen geldige route gevonden!!!! godverdomme zoekt ne keer een deftige route");
                    }else {
                        for (int i = 0; i < trajecten.size(); i++){
                            System.out.println(trajecten.get(i).toString());
                        }
                    }*/
                /*
                Route route = new Route(1,stationVertrek,stationAankomst, true);

                ManageTypeKaart mTK = new ManageTypeKaart();
                List<TypeKaart> typeKaarten = mTK.listTypeKaarten();

                ticketModel.setTicketId(0);
                ticketModel.setRoute(route);
                ticketModel.setBeginDatum(new Date());
                ticketModel.setEindDatum(new Date());
                ticketModel.setTypeKaart(typeKaarten.get(ticketView.getTypeKaartIndex()));
                ticketModel.setAantalPersonen(ticketView.getAantalPersonen());
                if (ticketView.getKlasse().toString() == "Eerste klasse"){
                    ticketModel.setKlasse(1);
                }
                else {ticketModel.setKlasse(2);}
                if (ticketView.showPrice(calculatePrice(typeKaarten.get(ticketView.getTypeKaartIndex()), ticketModel.getKlasse())) == 1){
                    if (ticketManage.addTicket(ticketModel) > 0){
                        JOptionPane.showMessageDialog(ticketView.getWindow(), "Ticket toevgevoegd!");
                    }
                    else {
                        ticketView.noTicketAdded();
                    }
                }*/
            }
        });
    }
    public void terugButton(){
        ticketView.getTerugButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            backToHomeScreen();
            }
        });
    }
    public void backToHomeScreen() {
        ticketView.getWindow().setVisible(false);
        ticketView.getWindow().dispose();
        ticketView.deleteLastInPath();
        new MainController().showHomeScreen();
    }
    public double calculatePrice(TypeKaart typeKaart, int klasse){
        Korting korting = null;

        switch (typeKaart.getId()){
            case 1: korting = typeKaart.getKorting();
                break;
            case 2: return 6;
            case 3: return 0;
            case 4: return 50;
        }
        if (klasse == 1){
            return ((10 - (10 * korting.getProcent())) + 6) * ticketView.getAantalPersonen();
        }
        return (10 - (10 * korting.getProcent())) * ticketView.getAantalPersonen();
    }
}

