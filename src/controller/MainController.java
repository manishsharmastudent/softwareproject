package controller;

import view.HomeView;
import view.TicketView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Rik Van Belle on 11/11/2016.
 */
public class MainController {
    HomeView home;
    TicketController ticketController;

    public MainController(){
        home = new HomeView("HomeScreen");
        ticketController = new TicketController();
    }

    public void showHomeScreen(){
        home.showVoegTicketToe();
        koopTicket();
    }

    public void koopTicket(){
        home.getButtonVoegTicketToe().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                home.getWindow().setVisible(false);
                home.getWindow().dispose();
                ticketController.showVoegTicketToe();
            }
        });
    }

}
