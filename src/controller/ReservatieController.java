package controller;

import hibernate.ManageReservatie;
import hibernate.ManageStation;
import hibernate.ManageTicket;
import hibernate.ManageTypeKaart;
import model.*;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import view.ReservatieView;
import view.TicketView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Rik Van Belle on 02/01/2017.
 */
public class ReservatieController {
    private Reservatie reservatieModel;
    private ReservatieView view;
    private ManageReservatie reservatieManage;

    private ArrayList<Integer> stationIds = new ArrayList<>();

    public ReservatieController() {
        reservatieModel = new Reservatie();
        reservatieManage = new ManageReservatie();
        view = new ReservatieView("Reservatie");
    }
    public void showVoegReservatieToe() {
        view.showReservatieToevoegen();
        //Initialization
        initComboBoxes();
        //add Listeners
        voegReservatieToe();
        terugButton();
    }

    public void showZoekReservatie(){
        view.showReservatieZoeken();
        //Initalization
        initComboBoxes();
        //add Listeners
        zoekReservatieByReservatieNr();
        zoekReservatieByVertrekStation();
        zoekReservatieByBestemmingStation();
    }
    public void terugButton() {
        view.getTerugButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                backToHomeScreen();
            }
        });
    }
    public void backToHomeScreen() {
        view.getWindow().setVisible(false);
        view.getWindow().dispose();
        view.deleteLastInPath();
        new MainController().showHomeScreen();
    }
    private void initComboBoxes() {
        AutoCompleteDecorator.decorate(view.getBestemmingStationCombobox());
        AutoCompleteDecorator.decorate(view.getVertrekStationCombobox());

        List<Station> stations = new ManageStation().listStations();
        ManageStation ms = new ManageStation();


        for (int i = 0; i < stations.size(); i++) {
            stationIds.add(stations.get(i).getStationId());
            view.getVertrekStationCombobox().addItem(stations.get(i).getNaam());
            view.getBestemmingStationCombobox().addItem(stations.get(i).getNaam());
        }
    }
    private void voegReservatieToe() {
        view.getReservatieToevoegenButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Station vertrekStation = new ManageStation().getStationById(stationIds.get(view.getVertrekStationIndex()));
                Station bestemmingStation = new ManageStation().getStationById(stationIds.get(view.getBestemmingsStationIndex()));

                if (vertrekStation == bestemmingStation) {
                    view.stationsAreTheSame();
                } else {

                    reservatieModel.setReservatienr(0);
                    reservatieModel.setAantalPersonen(view.getAantalPersonen());

                    reservatieModel.setVertrekStation(vertrekStation);
                    reservatieModel.setAankomstStation(bestemmingStation);
                    String datum = view.getDatePicker().getJFormattedTextField().getText();

                    DateFormat format = new SimpleDateFormat("yyyy-mm-dd");
                    try {
                        Date date = format.parse(datum);
                        reservatieModel.setReservatieDatum(date);
                    } catch (ParseException pExc){}
                    reservatieModel.setGroepsnaam(view.getGroepsnaam());
                    reservatieModel.setActive(true);
                    if (reservatieManage.addReservatie(reservatieModel) > 0) {
                        view.reservatieInsertSucceed();
                        backToHomeScreen();
                    } else {
                        view.reservatieInsertFailed();
                    }
                }
            }
        });
    }
    private void zoekReservatieByReservatieNr(){
        view.getSearchButtonReservatieNr().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int reservatienr = view.getReservatieNr();
                reservatieModel = reservatieManage.getReservatieById(reservatienr);
                view.showUpdateReservatie(reservatieModel);
            }
        });
    }
    private void zoekReservatieByVertrekStation(){
        view.getSearchButtonVertrekStation().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Station vertrekStation = new ManageStation().getStationById(stationIds.get(view.getVertrekStationIndex()));
                List<Reservatie> reservatieList = new ArrayList<>();
                reservatieList = reservatieManage.getReservatieByVertrekStation(vertrekStation);
                view.showReservaties(reservatieList);
                aanpassenReservatie();
            }
        });

    }
    private void zoekReservatieByBestemmingStation(){
        view.getSearchButtonBestemmingStation().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Station bestemmingStation = new ManageStation().getStationById(stationIds.get(view.getBestemmingsStationIndex()));
                List<Reservatie> reservatieList = new ArrayList<>();
                reservatieList = reservatieManage.getReservatieByAankomstStation(bestemmingStation);
                view.showReservaties(reservatieList);
            }
        });

    }
    private void aanpassenReservatie(){
        view.getAanpassenReservatie().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = view.getSelectedRow();
                reservatieModel = reservatieManage.getReservatieById(id);
                view.showUpdateReservatie(reservatieModel);
                updatenReservatie();
            }
        });
    }
    private void updatenReservatie() {
        view.getReservatieUpdateButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Station vertrekStation = new ManageStation().getStationById(stationIds.get(view.getVertrekStationIndex()));
                Station bestemmingStation = new ManageStation().getStationById(stationIds.get(view.getBestemmingsStationIndex()));

                if (vertrekStation == bestemmingStation) {
                    view.stationsAreTheSame();
                } else {

                    reservatieModel.setReservatienr(0);


                    reservatieModel.setVertrekStation(vertrekStation);
                    reservatieModel.setAankomstStation(bestemmingStation);
                    String datum = view.getDatePicker().getJFormattedTextField().getText();

                    DateFormat format = new SimpleDateFormat("yyyy-mm-dd");
                    try {
                        Date date = format.parse(datum);
                        reservatieModel.setReservatieDatum(date);
                    } catch (ParseException pExc) {
                    }
                    reservatieModel.setGroepsnaam(view.getGroepsnaam());
                    reservatieModel.setActive(true);
                    reservatieManage.updateReservatie(reservatieModel);
                }
            }
        });
    }
}
