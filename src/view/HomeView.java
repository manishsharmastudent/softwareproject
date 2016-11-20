package view;

import hibernate.ManageVoorwerp;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by Rik Van Belle on 11/11/2016.
 */
public class HomeView extends StandardView {
    private JPanel ticketPanel = new JPanel();
    private JPanel voorwerpPanel = new JPanel();
    private JPanel infoPanel = new JPanel();
    private JLabel ticketLabel = new JLabel("Tickets & Abonnementen");
    private JButton verkoopTicketButton = new JButton("Verkoop Ticket");
    private JButton verkoopAboButton = new JButton("Verkoop Abonnement");
    private JButton reservButton = new JButton("Reservaties");
    private JButton verlengAboButton = new JButton("Verleng Abonnement");
    private JButton aboAanpas = new JButton("Abonnement Aanpassen");
    private JButton treinInfo = new JButton("Treininformatie opvragen");
    private JButton routeInfo = new JButton("Stationsinformatie opvragen");
    private JButton stationsInfo = new JButton("Route-informatie opvragen");
    private JLabel infoLabel = new JLabel("Informatie");
    private JButton vvvdsButton = new JButton("Verloren voorwerpen voor <dit station>");
    private JButton vvvasButton = new JButton("Verloren voorwerpen voor ander station");
    private JButton rvvButton = new JButton("Registreer verloren voorwerp");
    private JButton vvvButton = new JButton("Verwijder verloren voorwerp");
    private JLabel verlorenVoorLabel = new JLabel("Verloren voorwerpen");

    public HomeView(String titel){
        super(titel);
    }

    public JButton getButtonVoegTicketToe(){
        return this.verkoopTicketButton;
    }

    public void showVoegTicketToe() {

        ticketPanel.setLayout(new BoxLayout(ticketPanel, BoxLayout.PAGE_AXIS));
        ticketPanel.setPreferredSize(new Dimension(250, 100));
        ticketPanel.setMaximumSize(ticketPanel.getPreferredSize());
        ticketPanel.setMinimumSize(ticketPanel.getPreferredSize());
        ticketLabel.setBorder(border);
        ticketLabel.setMaximumSize(new Dimension(Integer.MAX_VALUE, ticketLabel.getMinimumSize().height));
        ticketPanel.add(ticketLabel);
        verkoopTicketButton.setMaximumSize(new Dimension(Integer.MAX_VALUE, ticketLabel.getMinimumSize().height));
        ticketPanel.add(verkoopTicketButton);
        verkoopAboButton.setMaximumSize(new Dimension(Integer.MAX_VALUE, ticketLabel.getMinimumSize().height));
        ticketPanel.add(verkoopAboButton);
        reservButton.setMaximumSize(new Dimension(Integer.MAX_VALUE, ticketLabel.getMinimumSize().height));
        ticketPanel.add(reservButton);
        verlengAboButton.setMaximumSize(new Dimension(Integer.MAX_VALUE, ticketLabel.getMinimumSize().height));
        ticketPanel.add(verlengAboButton);
        aboAanpas.setMaximumSize(new Dimension(Integer.MAX_VALUE, ticketLabel.getMinimumSize().height));
        ticketPanel.add(aboAanpas);

        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.PAGE_AXIS));
        infoPanel.setMaximumSize(new Dimension(250, 101));
        infoLabel.setBorder(border);
        infoLabel.setMaximumSize(new Dimension(250, infoLabel.getMinimumSize().height));
        infoPanel.add(infoLabel);
        treinInfo.setMaximumSize(new Dimension(250, 34));
        infoPanel.add(treinInfo);
        stationsInfo.setMaximumSize(new Dimension(250, 34));
        infoPanel.add(stationsInfo);
        routeInfo.setMaximumSize(new Dimension(250, 33));
        infoPanel.add(routeInfo);


        voorwerpPanel.setLayout(new BoxLayout(voorwerpPanel, BoxLayout.PAGE_AXIS));
        infoPanel.setMaximumSize(new Dimension(250, 101));
        verlorenVoorLabel.setBorder(border);
        verlorenVoorLabel.setMaximumSize(new Dimension(250, verlorenVoorLabel.getMinimumSize().height));
        voorwerpPanel.add(verlorenVoorLabel);
        vvvdsButton.setMaximumSize(new Dimension(250, 25));
        vvvdsButton.setFont(new Font("Arial", Font.BOLD, 10));
        voorwerpPanel.add(vvvdsButton);
        vvvasButton.setMaximumSize(new Dimension(250, 26));
        vvvasButton.setFont(new Font("Arial", Font.BOLD, 10));
        voorwerpPanel.add(vvvasButton);
        rvvButton.setMaximumSize(new Dimension(250, 25));
        voorwerpPanel.add(rvvButton);
        vvvButton.setMaximumSize(new Dimension(250, 25));
        voorwerpPanel.add(vvvButton);

        getMainPanel().add(ticketPanel, BorderLayout.WEST);
        getMainPanel().add(infoPanel, BorderLayout.CENTER);
        getMainPanel().add(voorwerpPanel, BorderLayout.EAST);

        panel.add(interactiePanel, BorderLayout.CENTER);

        getMainPanel().add(panel, BorderLayout.CENTER);

        if (path.size() == 0){
            addPath("Home");
        }

        showPath();
        showWindow();
    }
}
