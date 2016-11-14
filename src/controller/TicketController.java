package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

import hibernate.ManageTicket;
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
        //add Listeners
        voegTicketToe();
    }
    private void voegTicketToe(){
        ticketView.getZoekButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int klasse = 2;
                ticketView.getBestemmingsStation();
                ticketView.getVertrekStation();
                if (ticketView.getKlasse().toString() == "Eerste klasse"){
                    klasse = 1;
                }
            }
        });
    }
}

