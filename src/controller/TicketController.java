package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import hibernate.ManageStation;
import hibernate.ManageTicket;
import hibernate.ManageTypeKaart;
import model.*;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import view.TicketView;
public class TicketController {
    private Ticket ticketModel;
    private TicketView ticketView;
    private ManageTicket ticketManage;

    private ArrayList<Integer> stationIds = new ArrayList<>();
    private ArrayList<Integer> typeKaartIds = new ArrayList<>();

    public TicketController() {
        ticketModel = new Ticket();
        ticketManage = new ManageTicket();
        ticketView = new TicketView("Ticket");
    }
    public void disableOptionsOnType() {
        ticketView.getTypeKaartenComboBox().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                switch (ticketView.getTypeKaartenComboBox().getSelectedIndex()) {
                    case 0:
                        ticketView.getVertrekStationComboBox().setEnabled(true);
                        ticketView.getBestemmingsStationComboBox().setEnabled(true);
                        ticketView.getKlasseCombobox().setEnabled(true);
                        ticketView.getSpinnerAantalPersonen().setEnabled(true);
                        break;
                    case 1:
                        ticketView.getVertrekStationComboBox().setEnabled(false);
                        ticketView.getBestemmingsStationComboBox().setEnabled(false);
                        ticketView.getKlasseCombobox().setEnabled(false);
                        ticketView.getSpinnerAantalPersonen().setEnabled(false);
                        break;
                    case 2:
                        ticketView.getVertrekStationComboBox().setEnabled(true);
                        ticketView.getBestemmingsStationComboBox().setEnabled(true);
                        ticketView.getKlasseCombobox().setEnabled(true);
                        ticketView.getSpinnerAantalPersonen().setEnabled(true);
                        break;
                    case 4:
                        ticketView.getVertrekStationComboBox().setEnabled(false);
                        ticketView.getBestemmingsStationComboBox().setEnabled(false);
                        ticketView.getKlasseCombobox().setEnabled(false);
                        ticketView.getSpinnerAantalPersonen().setEnabled(false);
                        break;
                }
            }
        });
    }
    public void showVoegTicketToe() {
        ticketView.showVoegTicketToe();
        //Initialization
        initComboBoxes();
        //add Listeners
        voegTicketToe();
        terugButton();
    }
    public void terugButton() {
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
    private void initComboBoxes() {
        AutoCompleteDecorator.decorate(ticketView.getTypeKaartenComboBox());
        AutoCompleteDecorator.decorate(ticketView.getBestemmingsStationComboBox());
        AutoCompleteDecorator.decorate(ticketView.getVertrekStationComboBox());

        List<Station> stations = new ManageStation().listStations();
        ManageStation ms = new ManageStation();

        ManageTypeKaart mTK = new ManageTypeKaart();
        final List<TypeKaart> typeKaarten = mTK.listTypeKaarten();

        ticketView.getTypeKaartenComboBox().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ticketView.setTypeKaartOmschrijving(typeKaarten.get(ticketView.getTypeKaartIndex()).getOmschrijving());
            }
        });

        for (int i = 0; i < typeKaarten.size(); i++) {
            typeKaartIds.add(typeKaarten.get(i).getId());
            ticketView.getTypeKaartenComboBox().addItem(typeKaarten.get(i).getNaam());
        }

        for (int i = 0; i < stations.size(); i++) {
            stationIds.add(stations.get(i).getStationId());
            ticketView.getVertrekStationComboBox().addItem(stations.get(i).getNaam());
            ticketView.getBestemmingsStationComboBox().addItem(stations.get(i).getNaam());
        }

        ticketView.getKlasseCombobox().addItem("Tweede klasse");
        ticketView.getKlasseCombobox().addItem("Eerste klasse");

        disableOptionsOnType();
    }
    private void voegTicketToe() {
        ticketView.getZoekButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Station vertrekStation = new ManageStation().getStationById(stationIds.get(ticketView.getVertrekStationIndex()));
                Station bestemmingStation = new ManageStation().getStationById(stationIds.get(ticketView.getBestemmingsStationIndex()));

                if (vertrekStation == bestemmingStation) {
                    ticketView.stationsAreTheSame();
                } else {

                    TypeKaart typeKaart = new ManageTypeKaart().getTypeKaartById(typeKaartIds.get(ticketView.getTypeKaartIndex()));

                    ticketModel.setTicketId(0);


                    ticketModel.setVertrekStation(vertrekStation);
                    ticketModel.setBestemmingStation(bestemmingStation);
                    String datum = ticketView.getDatePicker().getJFormattedTextField().getText();

                    LocalDate date = LocalDate.parse(datum);
                    System.out.println(date);
                    ticketModel.setBeginDatum(ticketView.getBeginDatum());
                    ticketModel.setEindDatum(ticketView.getBeginDatum());
                    ticketModel.setTypeKaart(typeKaart);
                    ticketModel.setAantalPersonen(ticketView.getAantalPersonen());
                    if (ticketView.getKlasse().toString() == "Eerste klasse") {
                        ticketModel.setKlasse(1);
                    } else {
                        ticketModel.setKlasse(2);
                    }
                    calculatePrice();
                    if (ticketManage.addTicket(ticketModel) > 0) {
                        ticketView.addSucceed();
                        backToHomeScreen();
                    } else {
                        ticketView.noTicketAdded();
                    }
                }
            }
        });
    }
    public void calculatePrice() {
        Korting korting = ticketModel.getTypeKaart().getKorting();
        List<Traject> trj = null;

        double percentage = korting.getProcent();
        int aantalPersonen= ticketView.getAantalPersonen();
        double prijs = 0.0;

        try{
            trj = ParseController.getTraject(ticketModel.getVertrekStation().getNaam(), ticketModel.getBestemmingStation().getNaam());
        } catch(Exception exc){exc.getStackTrace();}
        double aantalKilometers = trj.get(0).getAantalKilometers();
        if(aantalKilometers > 45){aantalKilometers = 45;}
        if (ticketModel.getKlasse() == 1) {
             if(percentage != 0){
                 prijs = (((aantalKilometers / 2) * percentage) + 6) * aantalPersonen;
             }
             else {
                 prijs =((aantalKilometers / 2) + 6) * aantalPersonen;
             }
        }
        else {
            if(percentage != 0){
                prijs = ((aantalKilometers / 2) * percentage) * aantalPersonen;
            }
            else {
                prijs = (aantalKilometers / 2) * aantalPersonen;
            }
        }
        prijs = Math.floor(prijs);
        if(ticketModel.getTypeKaart().getId() == 15){
            ticketModel.setPrijs((float)prijs*2);
        }
        else {ticketModel.setPrijs((float)prijs);}
    }
}