package view;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;

/**
 * Created by User on 14/11/2016.
 */
public class StandardGuiView {

    /**
     * Created by User on 31/10/2016.
     */

        private JFrame frame = new JFrame();

        private JLabel tijdLabel = new JLabel("Tijd");
        private JLabel datumLabel = new JLabel("Datum");
        private JLabel welkomLabel = new JLabel("Welkom");
        private JPanel welkomPanel = new JPanel();
        private JPanel panel = new JPanel();
        private JPanel interactiePanel = new JPanel(new SpringLayout());
        private JButton terugButton = new JButton("Terug");

        private JPanel mainPanel = new JPanel();
        private JPanel navigationPanel = new JPanel();
        private FlowLayout navigationPanelLayout = new FlowLayout(FlowLayout.LEFT);
        private JPanel mainNavPanel = new JPanel();

        private Border border = BorderFactory.createLineBorder(Color.BLACK, 2);

        public StandardGuiView(){

            setGui();
        }


       protected void setInteractiePanel(){};


        private void setGui() {

            frame.setSize(800, 700);


            frame.setLocationRelativeTo(null);

            frame.setVisible(true);


            mainNavPanel.setLayout(new BorderLayout());
            mainNavPanel.add(navigationPanel, BorderLayout.WEST);
            mainNavPanel.add(terugButton, BorderLayout.EAST);


            welkomPanel.setLayout(new GridLayout(1, 3));


            welkomLabel.setHorizontalAlignment(JLabel.CENTER);
            datumLabel.setHorizontalAlignment(JLabel.CENTER);
            tijdLabel.setHorizontalAlignment(JLabel.CENTER);


            welkomPanel.add(welkomLabel);
            welkomPanel.add(tijdLabel);
            welkomPanel.add(datumLabel);


            welkomPanel.setPreferredSize(new Dimension(800, 50));
            welkomPanel.setMaximumSize(welkomPanel.getPreferredSize());

            welkomPanel.setBorder(border);


            interactiePanel.setLayout(null);




            interactiePanel.setBorder(border);


            mainNavPanel.setBorder(border);


            panel.setLayout(new BorderLayout(80, 30));

            mainPanel.setLayout(new BorderLayout(0, 0));


            mainPanel.add(mainNavPanel, BorderLayout.NORTH);
            mainPanel.add(interactiePanel, BorderLayout.CENTER);


            panel.add(welkomPanel, BorderLayout.NORTH);
            panel.add(mainPanel, BorderLayout.CENTER);


            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


            Global.aantalTrees = 0;

            Global.aantalTrees++;
            System.out.println(Global.aantalTrees);
            Global.currentPathName = "Home";
            System.out.println(Global.firstPathName);
            Global.aantalTrees++;
            System.out.println(Global.aantalTrees);

            Global.secondPathName = "Tickets en Abonnementen";
            Global.currentPathName = "Verkoop Ticket";
            Global.aantalTrees++;
            Global.thirdPathName = Global.currentPathName;


            navigationPanel.setLayout(navigationPanelLayout);


            for (int i = 0; i < Global.aantalTrees; i++) {
                JLabel treeText = new JLabel("");

                JPanel treePanel = new JPanel();
                treePanel.setLayout(new BorderLayout());

                treeText.setHorizontalAlignment(JLabel.CENTER);
                treeText.setVerticalAlignment(JLabel.CENTER);


                switch (i) {
                    case 0:
                        treeText.setText(Global.firstPathName);
                        System.out.println(0);


                        break;
                    case 1:
                        treeText.setText(Global.secondPathName);
                        break;
                    case 2:
                        treeText.setText(Global.thirdPathName);
                        break;
                    default:
                        treeText.setText("Error_treestructure_naming");
                        break;
                }


                treePanel.setPreferredSize(new Dimension(Global.widthNavPanel, Global.heightNavPanel));
                treePanel.setBorder(border);
                treePanel.add(treeText, BorderLayout.CENTER);

                navigationPanel.add(treePanel);


            }


            frame.add(panel);
            frame.setResizable(false);
        }


        public static void main(String[] args) {
            StandardGuiView t = new StandardGuiView();

        }


    }


