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
    private JButton reservButton = new JButton("Reservaties");
    private JButton verlengAboButton = new JButton("Abonnement verlengen/aanpassen");
    private JPanel voorwerpPanel = new JPanel();
    private JButton vvvasButton = new JButton("Verloren voorwerpen zoeken");
    private JButton rvvButton = new JButton("Registreer verloren voorwerp");
    private JButton vvvButton = new JButton("Verwijder verloren voorwerp");
    private JLabel verlorenVoorLabel = new JLabel("Verloren voorwerpen",  SwingConstants.CENTER);

    private JPanel infoPanel = new JPanel();
    private GridBagConstraints c = new GridBagConstraints();


    private JButton treinInfo = new JButton("Treininformatie opvragen");
    private JButton routeInfo = new JButton("Stationsinformatie opvragen");
    private JButton stationsInfo = new JButton("Route-informatie opvragen");
    private JLabel infoLabel = new JLabel("Informatie",  SwingConstants.CENTER);

    private JPanel klantPanel = new JPanel();
    private JLabel klantLabel = new JLabel("Klantenadministratie",  SwingConstants.CENTER);
    private JButton klantOpzoeken = new JButton("Opzoeken klant");
    private JButton klantToevoegen = new JButton("Klant Toevoegen");
    private JButton klantVerwijderen = new JButton("Klant verwijderen");

    public HomeView(String titel) {
        super(titel);
    }
    String text = "";

    public JButton getShowVerlorenVoorwerpenButton(){
        return this.vvvasButton;
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

    public JFrame getView() { return (JFrame) SwingUtilities.getWindowAncestor(this.getWindow());}
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
        if (path.size() == 0){
            addPath("Home");
        }


        showWindow();



        ticketPanel.setLayout(new GridLayout(5,1));
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

        ticketPanel.add(verlengAboButton);

        ticketPanel.add(verkoopTicketButton);

        infoLabel.setBorder(border);
        infoLabel.setOpaque(true);
        infoLabel.setBackground(Color.black);
        infoLabel.setForeground(Color.white);
        infoPanel.add(infoLabel);
        infoPanel.add(treinInfo);
        infoPanel.add(stationsInfo);
        infoPanel.add(routeInfo);

        verlorenVoorLabel.setBorder(border);
        verlorenVoorLabel.setOpaque(true);
        verlorenVoorLabel.setBackground(Color.black);
        verlorenVoorLabel.setForeground(Color.white);
        voorwerpPanel.add(verlorenVoorLabel);
        voorwerpPanel.add(vvvasButton);
        voorwerpPanel.add(rvvButton);
        voorwerpPanel.add(vvvButton);

        klantLabel.setBorder(border);
        klantLabel.setOpaque(true);
        klantLabel.setBackground(Color.black);
        klantLabel.setForeground(Color.white);
        klantPanel.add(klantLabel);
        klantPanel.add(klantOpzoeken);
        klantPanel.add(klantToevoegen);
        klantPanel.add(klantVerwijderen);
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
