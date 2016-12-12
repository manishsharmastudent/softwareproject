package view;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.imageio.ImageIO;
import javax.swing.border.Border;

/**
 * Created by User on 01/11/2016.
 */





public class TypeKaartView extends StandardView {

    private JButton doorgaanButton = new JButton("Doorgaan");
    private JButton doorgaanTweedeButton = new JButton("Doorgaan");

    private JPanel doorgaanPanel = new JPanel();
    private JPanel mainInteractiePanel = new JPanel();
    private JPanel prijsPanel = new JPanel();
    private  JScrollPane scrollPane = new JScrollPane(mainInteractiePanel,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);


    public TypeKaartView(String titel){
        super(titel);
    }


    public void showTicketten(){
        this.showWindow();
        int aantalTickets = 15;
        interactiePanel.setLayout(new BoxLayout(interactiePanel, BoxLayout.PAGE_AXIS));
        mainInteractiePanel.setLayout(new BoxLayout(mainInteractiePanel, BoxLayout.PAGE_AXIS));
        doorgaanPanel.setLayout(new BoxLayout(doorgaanPanel, BoxLayout.PAGE_AXIS));



        doorgaanButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        doorgaanTweedeButton.setAlignmentX(Component.CENTER_ALIGNMENT);






        prijsPanel.setPreferredSize(new Dimension(getWindow().getWidth(), getWindow().getHeight()- mainInteractiePanel.getHeight() - welkomPanel.getHeight() - mainNavPanel.getHeight() - 335));
        prijsPanel.setMaximumSize(prijsPanel.getPreferredSize());
        prijsPanel.setMinimumSize(prijsPanel.getPreferredSize());



        scrollPane.setPreferredSize(new Dimension(710, 200));
        scrollPane.setMaximumSize(scrollPane.getPreferredSize());
        scrollPane.setMinimumSize(scrollPane.getPreferredSize());






        doorgaanPanel.add(prijsPanel);
        doorgaanPanel.add(doorgaanTweedeButton);


        for (int i =0; i < aantalTickets; i++){
            JPanel ticketPanel = new JPanel(new GridLayout(0,9));


            ticketPanel.setPreferredSize(new Dimension((mainPanel.getWidth() - 100), 50));
            ticketPanel.setMaximumSize(ticketPanel.getPreferredSize());
            ticketPanel.setMinimumSize(ticketPanel.getPreferredSize());

            JCheckBox checkTicketBox = new JCheckBox();
            JLabel stationLabel = new JLabel("Staion");
            JLabel aankomstStationLabel = new JLabel("Station");
            JLabel arrowLabel = new JLabel();
            String path = "/resources/images/arrow.png";
            java.net.URL imgURL = getClass().getResource(path);
            JLabel datunLabel = new JLabel("datum");
            JLabel duurLabel = new JLabel("duur");
            JLabel typeTreinLabel = new JLabel("(ICn,P,..)");
            JLabel overstapLabel = new JLabel("wissels: " + i);


            ticketPanel.setBorder(border);
            ticketPanel.add(checkTicketBox);






            if (imgURL != null) {
                ImageIcon icon = new ImageIcon(this.getClass().getResource(path), "Arrow");



//
                arrowLabel.setIcon(icon);//knjj

                ticketPanel.add(arrowLabel);

            } else {
                System.err.println("Couldnn't find file: " + path);
            }


            ticketPanel.add(stationLabel);
            ticketPanel.add(aankomstStationLabel);
            ticketPanel.add(datunLabel);
            ticketPanel.add(duurLabel);
            ticketPanel.add(typeTreinLabel);
            ticketPanel.add(overstapLabel);




            mainInteractiePanel.add(ticketPanel);

        }


        interactiePanel.setBorder(border);



        interactiePanel.add(scrollPane);

        interactiePanel.add(doorgaanButton);
        doorgaanPanel.setBorder(border);

        interactiePanel.add(doorgaanPanel);






        addPath("Tickets en abonnementen");
        addPath("Verkoop Ticket");

        showPath();

        getWindow().setResizable(false);
        showWindow();

    }




    public static void main(String[] args) {

        TypeKaartView t = new TypeKaartView("iets");

        t.showTicketten();
    }

}