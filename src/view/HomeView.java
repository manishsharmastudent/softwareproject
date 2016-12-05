package view;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Rik Van Belle on 11/11/2016.
 */
public class HomeView extends StandardView {
    private JPanel ticketPanel = new JPanel();
    private JLabel ticketLabel = new JLabel("Tickets & Abonnementen");
    private JButton verkoopTicketButton = new JButton("Verkoop Ticket");
    private JButton verkoopAboButton = new JButton("Abonnement aanmaken");
    private JButton reservButton = new JButton("Reservaties");
    private JButton verlengAboButton = new JButton("Verleng Abonnement");
    private JButton aboAanpas = new JButton("Abonnement Aanpassen");
    private JPanel voorwerpPanel = new JPanel();
    private JButton vvvdsButton = new JButton("Verloren voorwerpen voor <dit station>");
    private JButton vvvasButton = new JButton("Verloren voorwerpen voor ander station");
    private JButton rvvButton = new JButton("Registreer verloren voorwerp");
    private JButton vvvButton = new JButton("Verwijder verloren voorwerp");
    private JLabel verlorenVoorLabel = new JLabel("Verloren voorwerpen");

    private JPanel infoPanel = new JPanel();
    private JButton treinInfo = new JButton("Treininformatie opvragen");
    private JButton routeInfo = new JButton("Stationsinformatie opvragen");
    private JButton stationsInfo = new JButton("Route-informatie opvragen");
    private JLabel infoLabel = new JLabel("Informatie");

    private JPanel klantPanel = new JPanel();
    private JLabel klantLabel = new JLabel("Klantenadministratie");
    private JButton klantOpzoeken = new JButton("Opzoeken klant");
    private JButton klantToevoegen = new JButton("Klant Toevoegen");
    private JButton klantVerwijderen = new JButton("Klant verwijderen");

    public HomeView(String titel) {
        super(titel);
    }

    public JButton getButtonVoegTicketToe() {
        return this.verkoopTicketButton;
    }

    public JButton getVerkoopAboButton() {
        return this.verkoopAboButton;
    }

    public JButton getKlantToevoegenButton() {
        return this.klantToevoegen;
    }

    public JButton getRvvButton() {
        return this.rvvButton;
    }

    public JButton getTreinInfo() {
        return this.treinInfo;
    }

    public JButton getVerlengAboButton() {
        return this.verlengAboButton;
    }

    public JButton getKlantOpzoeken() {
        return this.klantOpzoeken;
    }

    public void showHomeScreen() {
        ticketPanel.setLayout(new GridLayout(8,1));
        infoPanel.setLayout(new GridLayout(5,1));
        voorwerpPanel.setLayout(new GridLayout(5,1));
        klantPanel.setLayout(new GridLayout(4,1));

        ticketLabel.setBorder(border);
        ticketPanel.add(ticketLabel);
        ticketPanel.add(verkoopTicketButton);
        ticketPanel.add(verkoopAboButton);
        ticketPanel.add(reservButton);
        ticketPanel.add(verlengAboButton);
        ticketPanel.add(aboAanpas);
        ticketPanel.add(verkoopTicketButton);

        infoLabel.setBorder(border);
        infoPanel.add(infoLabel);
        infoPanel.add(treinInfo);
        infoPanel.add(stationsInfo);
        infoPanel.add(routeInfo);

        verlorenVoorLabel.setBorder(border);
        voorwerpPanel.add(verlorenVoorLabel);
        voorwerpPanel.add(vvvdsButton);
        voorwerpPanel.add(vvvasButton);
        voorwerpPanel.add(rvvButton);
        voorwerpPanel.add(vvvButton);

        klantLabel.setBorder(border);
        klantPanel.add(klantLabel);
        klantPanel.add(klantOpzoeken);
        klantPanel.add(klantToevoegen);
        klantPanel.add(klantVerwijderen);

        mainPanel.add(ticketPanel);
        mainPanel.add(voorwerpPanel);
        mainPanel.add(infoPanel);
        mainPanel.add(klantPanel);

        if (path.size() == 0){
            addPath("Home");
        }
        showWindow();
    }
}
