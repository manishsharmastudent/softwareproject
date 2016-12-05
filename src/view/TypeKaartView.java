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
    private JTextField prijsText = new JTextField("€0,00");
    private JLabel prijsLabel = new JLabel("Prijs: ");
    private JPanel doorgaanPanel = new JPanel();
    private JPanel mainInteractiePanel = new JPanel();
    private JPanel prijsPanel = new JPanel();
    private  JScrollPane scrollPane = new JScrollPane(mainInteractiePanel,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);


    public TypeKaartView(String titel){
        super(titel);
    }


    public void showTicketten(){
        int aantalTickets = 15;
        mainInteractiePanel.setLayout(new BoxLayout(mainInteractiePanel, BoxLayout.PAGE_AXIS));
        doorgaanPanel.setLayout(new BoxLayout(doorgaanPanel, BoxLayout.PAGE_AXIS));
        prijsPanel.setLayout(null);


        doorgaanButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        doorgaanTweedeButton.setAlignmentX(Component.CENTER_ALIGNMENT);


        mainInteractiePanel.setBackground(Color.CYAN);




        prijsPanel.setPreferredSize(new Dimension(getWindow().getWidth(), getWindow().getHeight()- mainInteractiePanel.getHeight() - welkomPanel.getHeight() - mainNavPanel.getHeight() - 335));
        prijsPanel.setMaximumSize(prijsPanel.getPreferredSize());
        prijsPanel.setMinimumSize(prijsPanel.getPreferredSize());



        scrollPane.setPreferredSize(new Dimension(710, 200));
        scrollPane.setMaximumSize(scrollPane.getPreferredSize());
        scrollPane.setMinimumSize(scrollPane.getPreferredSize());


        prijsLabel.setBounds(290,110,100,50);
        prijsText.setBounds(330,120,150,30);

        prijsPanel.add(prijsLabel);
        prijsPanel.add(prijsText);



        doorgaanPanel.add(prijsPanel);
        doorgaanPanel.add(doorgaanTweedeButton);

        doorgaanPanel.setBackground(Color.red);

        for (int i =0; i < aantalTickets; i++){
            JPanel ticketPanel = new JPanel(new GridLayout(0,9));



            ticketPanel.setPreferredSize(new Dimension((mainPanel.getWidth() - 100), 50));
            ticketPanel.setMaximumSize(ticketPanel.getPreferredSize());
            ticketPanel.setMinimumSize(ticketPanel.getPreferredSize());

            JCheckBox checkTicketBox = new JCheckBox();
            JLabel stationLabel = new JLabel("Station");
            JLabel aankomstStationLabel = new JLabel("Station");
            JLabel arrowLabel = new JLabel();
            String path = "/resources/images/arrow.png";
            java.net.URL imgURL = getClass().getResource(path);
            JLabel datunLabel = new JLabel("datun");
            JLabel duurLabel = new JLabel("duur");
            JLabel typeTreinLabel = new JLabel("(IC,P,..)");
            JLabel overstapLabel = new JLabel("wissels: " + i);


            ticketPanel.setBorder(border);
            ticketPanel.add(checkTicketBox);






            if (imgURL != null) {
                ImageIcon icon = new ImageIcon(this.getClass().getResource(path), "Arrow");




                arrowLabel.setIcon(icon);

                ticketPanel.add(arrowLabel);

            } else {
                System.err.println("Couldn't find file: " + path);
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
        mainInteractiePanel.add(doorgaanButton);


        interactiePanel.add(doorgaanPanel);

        doorgaanPanel.setBorder(border);





        addPath("Tickets en abonnementen");
        addPath("Verkoop Ticket");

        showPath();

        getWindow().setResizable(false);
        showWindow();

    }




    public static void main(String[] args) {

        TypeKaartView t = new TypeKaartView("iets");
        t.initMenuBar();
        t.initNavTree();
        t.showWindow();
        t.showPath();
        t.showTicketten();
    }

}