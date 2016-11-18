package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;
import javax.swing.*;

import hibernate.ManageStation;
import hibernate.ManageTicket;
import hibernate.ManageTypeKaart;
import model.Route;
import model.Station;
import model.Ticket;
import model.TypeKaart;
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

    public void showVoegTicketToe(){
        ticketView.showVoegTicketToe();
        //Initialization
        initComboBoxes();
        //add Listeners
        voegTicketToe();
        terugButton();
    }
    /*private Ticket[][] getTickets(){
        // --Rik-- Tickets ophalen en omzetten naar 2D array voor tabel
        List<Ticket> ticketsList = ticketManage.listTicket();
        Ticket[][] tickets = new Ticket[ticketsList.size()][];
        for (int i = 0; i < tickets.length/2;i++){
            tickets[i] = ticketsList.toArray(new Ticket[ticketsList.size()]);
        }
        return tickets;
    }
    public void showAllTickets(){
        ticketView.showTickets(getTickets());
    }*/
    private void initComboBoxes(){
        ManageStation ms = new ManageStation();
        List<Station> stations = ms.listStations();

        ManageTypeKaart mTK = new ManageTypeKaart();
        final List<TypeKaart> typeKaarten = mTK.listTypeKaarten();

        ticketView.getTypeKaartenComboBox().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ticketView.setTypeKaartOmschrijving(typeKaarten.get(ticketView.getTypeKaartIndex()).getOmschrijving());
            }
        });

        for (int i = 0; i < typeKaarten.size();i++){
            System.out.print(typeKaarten.get(i).getNaam());
            ticketView.getTypeKaartenComboBox().addItem(typeKaarten.get(i).getNaam());
        }

        for(int i = 0; i < stations.size();i++){
            ticketView.getVertrekStationComboBox().addItem(stations.get(i).getNaam());
            ticketView.getBestemmingsStationComboBox().addItem(stations.get(i).getNaam());
        }

        ticketView.getKlasseCombobox().addItem("Eerste klasse");
        ticketView.getKlasseCombobox().addItem("Tweede klasse");
    }
    private void voegTicketToe(){
        ticketView.getZoekButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Station stationVertrek = new Station(0,"Station " + ticketView.getBestemmingsStation(),ticketView.getBestemmingsStation(), true);
                Station stationAankomst = new Station(0,"Station" + ticketView.getVertrekStation(),ticketView.getVertrekStation(), true);
                Route route = new Route(1,stationVertrek,stationAankomst, true);

                ManageTypeKaart mTK = new ManageTypeKaart();
                List<TypeKaart> typeKaarten = mTK.listTypeKaarten();

                ticketModel.setTicketId(0);
                ticketModel.setRoute(route);
                ticketModel.setBeginDatum(new Date());
                ticketModel.setEindDatum(new Date());
                ticketModel.setTypeKaart(typeKaarten.get(ticketView.getTypeKaartIndex()));
                ticketModel.setAantalPersonen(ticketView.getAantalPersonen());
                ticketModel.setPrijs(12.5f);
                if (ticketView.getKlasse().toString() == "Eerste klasse"){ticketModel.setKlasse(1);}
                else {ticketModel.setKlasse(2);}

                if (ticketManage.addTicket(ticketModel) > 0){
                    JOptionPane.showMessageDialog(ticketView.getWindow(), "Ticket toevgevoegd!");
                };
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
}

