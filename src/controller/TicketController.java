package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import hibernate.ManageStation;
import hibernate.ManageTicket;
import hibernate.ManageTypeKaart;
import model.*;
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

        ticketView.getKlasseCombobox().addItem("Eerste klasse");
        ticketView.getKlasseCombobox().addItem("Tweede klasse");
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
                    DateFormat format = new SimpleDateFormat("yyyy-mm-dd");
                    try {
                        Date date = format.parse(datum);
                        ticketModel.setBeginDatum(date);
                    } catch (ParseException exc) {
                        ticketModel.setBeginDatum(Calendar.getInstance().getTime());
                    }

                    ticketModel.setBeginDatum(ticketView.getBeginDatum());
                    ticketModel.setEindDatum(ticketView.getBeginDatum());
                    ticketModel.setTypeKaart(typeKaart);
                    ticketModel.setAantalPersonen(ticketView.getAantalPersonen());
                    if (ticketView.getKlasse().toString() == "Eerste klasse") {
                        ticketModel.setKlasse(1);
                    } else {
                        ticketModel.setKlasse(2);
                    }
                    //calculatePrice();
                    if (ticketManage.addTicket(ticketModel) > 0) {
                        ticketView.addSucceed();
                    } else {
                        ticketView.noTicketAdded();
                    }
                }
            }
        });
    }
    public double calculatePrice() {
                Korting korting = ticketModel.getTypeKaart().getKorting();
                List<Traject> trj = null;
                try{
                    System.out.println(ticketModel.getVertrekStation().getNaam());
                    trj = ParseController.getTraject(ticketModel.getVertrekStation().getNaam(), ticketModel.getBestemmingStation().getNaam());
                } catch(Exception exc){
                }
                if (ticketModel.getKlasse() == 1) {
                    return ((trj.get(0).getAantalKilometers() - (10 * korting.getProcent())) + 6) * ticketView.getAantalPersonen();
                }
                return (trj.get(0).getAantalKilometers() - (10 * korting.getProcent())) * ticketView.getAantalPersonen();
            }
}