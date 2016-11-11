package view;

import model.Ticket;

/**
 * Created by Rik Van Belle on 01/11/2016.
 */
public class TicketView extends StandardView {
    public TicketView(String titel, boolean haveButton){
        super(titel, haveButton);
        getStandardButton().setText("Ticket View");
    }
    public void showTicket(Ticket ticket){

    }
}
