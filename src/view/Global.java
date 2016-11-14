package view;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**
 * Created by User on 13/11/2016.
 */
public class Global {
    static String firstPathName = "Home";
    static String secondPathName;
    static String thirdPathName;
    static String currentPathName;
    static int aantalTrees = 0;
    static int heightNavPanel = 30;
    static int widthNavPanel = 170;

    /**
     * Created by User on 31/10/2016.
     */
    public class StandardView {
        private JFrame frame = new JFrame();
        private JPanel panel = new JPanel();
        private JLabel welcomeLabel = new JLabel("Welkom ");
        private JLabel tijdLabel = new JLabel("tijd");
        private JLabel datumLabel = new JLabel("datum");
        private JPanel welkomPanel = new JPanel();
        private JPanel ticketPanel = new JPanel();
        private JPanel voorwerpPanel = new JPanel();
        private JPanel infoPanel = new JPanel();
        private JLabel ticketLabel = new JLabel("Tickets & Abonnementen");
        private JButton verkoopTicketButton = new JButton("Verkoop Ticket");
        private JButton verkoopAboButton = new JButton("Verkoop Abonnement");
        private JButton reservButton = new JButton("Reservaties");
        private JButton verlengAboButton = new JButton("Verleng Abonnement");
        private JButton aboAanpas = new JButton("Abonnement Aanpassen");
        private Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
        private JButton treinInfo = new JButton("Treininformatie opvragen");
        private JButton routeInfo = new JButton("Stationsinformatie opvragen");
        private JButton stationsInfo = new JButton("Route-informatie opvragen");
        private JLabel infoLabel = new JLabel("Informatie");
        private JButton vvvdsButton = new JButton("Verloren voorwerpen voor <dit station>");
        private JButton vvvasButton = new JButton("Verloren voorwerpen voor ander station");
        private JButton rvvButton = new JButton("Registreer verloren voorwerp");
        private JButton vvvButton = new JButton("Verwijder verloren voorwerp");
        private JLabel verlorenVoorLabel = new JLabel("Verloren voorwerpen");




        public StandardView(){

            setGui();

        }

        private void setGui(){
            frame.setTitle("Menu");
            frame.setSize(800,700);


            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(panel);



            welkomPanel.setLayout(new BoxLayout(welkomPanel, BoxLayout.LINE_AXIS));
            welkomPanel.setPreferredSize(new Dimension(800,50));
            welkomPanel.setMaximumSize(welkomPanel.getPreferredSize());
            welkomPanel.add(welcomeLabel);
            welkomPanel.add(tijdLabel);
            welkomPanel.add(datumLabel);
            welkomPanel.setBorder(border);

            ticketPanel.setLayout(new BoxLayout(ticketPanel, BoxLayout.PAGE_AXIS));
            ticketPanel.setPreferredSize(new Dimension(250,100));
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




            panel.setLayout(new BorderLayout(25,50));







            panel.add(welkomPanel, BorderLayout.NORTH);

            panel.add(ticketPanel, BorderLayout.WEST);
            panel.add(infoPanel, BorderLayout.CENTER);
            panel.add(voorwerpPanel, BorderLayout.EAST);

            frame.setLocationRelativeTo( null );
            frame.setVisible(true);

            Global.aantalTrees++;
            Global.currentPathName = "Home";


        }




    }


}


