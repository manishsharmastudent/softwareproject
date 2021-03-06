package view;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Rik Van Belle on 11/11/2016.
 */
public class HomeView extends StandardView {
    private JPanel ticketPanel = new JPanel();
    private JLabel ticketLabel = new JLabel("Tickets & Abonnementen", SwingConstants.CENTER);
    private JButton verkoopTicketButton = new JButton("Verkoop Ticket");
    private JButton verkoopAboButton = new JButton("Abonnement aanmaken");
    private JButton reservButton = new JButton("Reservatie toevoegen");
    private JButton reservAanpasButton = new JButton("Reservaties aanpassen/verwijderen/opzoeken");
    private JButton verlengAboButton = new JButton("Abonnement verlengen/aanpassen");
    private JPanel voorwerpPanel = new JPanel();
    private JButton vvvasButton = new JButton("Verloren voorwerpen zoeken/aanpassen/verwijderen");
    private JButton rvvButton = new JButton("Registreer verloren voorwerp");
    private JLabel verlorenVoorLabel = new JLabel("Verloren voorwerpen",  SwingConstants.CENTER);

    private JPanel infoPanel = new JPanel();
    private GridBagConstraints c = new GridBagConstraints();

    private JButton routeInfo = new JButton("Routeinformatie opvragen");
    private JButton stationsInfo = new JButton("Stationsinformatie opvragen");
    private JLabel infoLabel = new JLabel("Informatie",  SwingConstants.CENTER);

    private JPanel klantPanel = new JPanel();
    private JLabel klantLabel = new JLabel("Klantenadministratie",  SwingConstants.CENTER);
    private JButton klantOpzoeken = new JButton("Klant zoeken/aanpassen/verwijderen");
    private JButton klantToevoegen = new JButton("Klant Toevoegen");

    public HomeView(String titel) {
        super(titel);
    }

    public JButton getShowVerlorenVoorwerpenButton(){
        return this.vvvasButton;
    }

    public JButton getButtonVoegTicketToe() {
        return this.verkoopTicketButton;
    }

    public JButton getStationsInfo(){return this.stationsInfo;}

    public JButton getRouteInfo(){return this.routeInfo;}

    public JButton getVerkoopAboButton() {
        return this.verkoopAboButton;
    }

    public JButton getKlantToevoegenButton() {
        return this.klantToevoegen;
    }

    public JButton getRvvButton() {
        return this.rvvButton;
    }

    public JFrame getView() { return (JFrame) SwingUtilities.getWindowAncestor(this.getWindow());}

    public JButton getVerlengAboButton() {
        return this.verlengAboButton;
    }

    public JButton getKlantOpzoeken() {
        return this.klantOpzoeken;
    }

    public JButton getReservatieButton(){return this.reservButton; }

    public JButton getReservatieAanpasButton(){return this.reservAanpasButton;}

    public void showHomeScreen() {
        if (path.size() == 0){
            deleteLastInPath();
            deleteLastInPath();
            deleteLastInPath();
            addPath("Home");
        } else {

            deleteLastInPath();
            deleteLastInPath();
            deleteLastInPath();
            addPath("Home");
        }
        showWindow();



        ticketPanel.setLayout(new GridLayout(6,1));
        infoPanel.setLayout(new GridLayout(5,1));
        voorwerpPanel.setLayout(new GridLayout(5,1));
        klantPanel.setLayout(new GridLayout(5,1));


        ticketLabel.setBorder(border);
        ticketLabel.setOpaque(true);
        ticketLabel.setBackground(Color.black);
        ticketLabel.setForeground(Color.white);
        ticketPanel.add(ticketLabel);

        ticketPanel.add(verkoopTicketButton);

        ticketPanel.add(verkoopAboButton);

        ticketPanel.add(reservButton);

        ticketPanel.add(reservAanpasButton);

        ticketPanel.add(verlengAboButton);

        ticketPanel.add(verkoopTicketButton);

        infoLabel.setBorder(border);
        infoLabel.setOpaque(true);
        infoLabel.setBackground(Color.black);
        infoLabel.setForeground(Color.white);
        infoPanel.add(infoLabel);
        infoPanel.add(stationsInfo);
        infoPanel.add(routeInfo);

        verlorenVoorLabel.setBorder(border);
        verlorenVoorLabel.setOpaque(true);
        verlorenVoorLabel.setBackground(Color.black);
        verlorenVoorLabel.setForeground(Color.white);
        voorwerpPanel.add(verlorenVoorLabel);
        voorwerpPanel.add(vvvasButton);
        voorwerpPanel.add(rvvButton);

        klantLabel.setBorder(border);
        klantLabel.setOpaque(true);
        klantLabel.setBackground(Color.black);
        klantLabel.setForeground(Color.white);
        klantPanel.add(klantLabel);
        klantPanel.add(klantOpzoeken);
        klantPanel.add(klantToevoegen);
        interactiePanel.setLayout(new GridBagLayout());

        c.gridx = 0;
        c.gridy = 3;

        c.insets = (new Insets(5,10,0,10));
        c.fill = 2;

        interactiePanel.add(ticketPanel,c);
        c.gridy = 2;
        interactiePanel.add(voorwerpPanel,c );
        c.gridy = 1;
        interactiePanel.add(infoPanel,c);
        c.gridy = 0;
        interactiePanel.add(klantPanel, c);
    }
}
