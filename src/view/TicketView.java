package view;
import javax.swing.*;
import javax.swing.border.Border;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;
import org.jdesktop.swingx.autocomplete.*;

import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Properties;
import java.util.Calendar;




/**
 * Created by User on 31/10/2016.
 */
public class TicketView extends StandardGuiView{/*
    private JFrame frame = new JFrame();

    private JLabel tijdLabel = new JLabel("Tijd");
    private JLabel datumLabel = new JLabel("Datum");
    private JLabel welkomLabel = new JLabel("Welkom");
    private JPanel welkomPanel = new JPanel();
    private JPanel panel = new JPanel();
    private JPanel interactiePanel = new JPanel(new SpringLayout());
    private JLabel vertrekLabel = new JLabel("Vertrekpunt");
    private JLabel aankomstLabel = new JLabel("Aankomst");
    private JLabel datumticketLabel = new JLabel("Datum");
    private JLabel aantalLabel = new JLabel("Aantal");
    private JLabel klasseLabel = new JLabel("Klasse");
    private JButton terugButton = new JButton("Terug");
    private JButton zoekButton = new JButton("Zoek");
    private AutoCompleteDecorator decorator;
    private JComboBox stationCombobox;
    private JComboBox stationTweeCombobox;
    private JComboBox klasseCombobox;
    private Properties p = new Properties();
    private Integer value = new Integer(1);
    private Integer min = new Integer(1);
    private Integer max = new Integer(100);
    private Integer step = new Integer(1);
    private SpinnerNumberModel modelSp = new SpinnerNumberModel(value, min, max, step);
    private int fifty = modelSp.getNumber().intValue();
    private JSpinner spinner1 = new JSpinner(modelSp);
    private JPanel mainPanel = new JPanel();
    private JPanel navigationPanel = new JPanel();
    private FlowLayout navigationPanelLayout = new FlowLayout(FlowLayout.LEFT);
    private JPanel mainNavPanel = new JPanel();




    private UtilDateModel model = new UtilDateModel();
    private JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
    private JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new JFormattedTextField.AbstractFormatter() {

        private String datePattern = "yyyy-MM-dd";
        private SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);

        @Override
        public Object stringToValue(String text) throws ParseException {
            return dateFormatter.parseObject(text);        }

        @Override
        public String valueToString(Object value) throws ParseException {
            if (value != null) {
                Calendar cal = (Calendar) value;
                return dateFormatter.format(cal.getTime());
            }

            return "";
        }
    });
    private Border border = BorderFactory.createLineBorder(Color.BLACK, 2);

    public TicketView(){

        setGui();
    }


    private void setGui(){
        stationCombobox = new JComboBox(new Object[]{"","test", "aardappeltest"});
        stationTweeCombobox = new JComboBox(new Object[]{"","test", "aardappeltest"});
        klasseCombobox = new JComboBox(new Object[]{"","Eerste klasse", "Tweede klasse"});



        AutoCompleteDecorator.decorate(stationCombobox);
        AutoCompleteDecorator.decorate(stationTweeCombobox);

        frame.setSize(800,700);


        frame.setLocationRelativeTo(null);

        frame.setVisible(true);






        mainNavPanel.setLayout(new BorderLayout());
        mainNavPanel.add(navigationPanel, BorderLayout.WEST);
        mainNavPanel.add(terugButton, BorderLayout.EAST);



        welkomPanel.setLayout(new GridLayout(1,3));


        welkomLabel.setHorizontalAlignment(JLabel.CENTER);
        datumLabel.setHorizontalAlignment(JLabel.CENTER);
        tijdLabel.setHorizontalAlignment(JLabel.CENTER);


        welkomPanel.add(welkomLabel);
        welkomPanel.add(tijdLabel);
        welkomPanel.add(datumLabel);



        welkomPanel.setPreferredSize(new Dimension(800,50));
        welkomPanel.setMaximumSize(welkomPanel.getPreferredSize());

        welkomPanel.setBorder(border);



        interactiePanel.setLayout(null);
        vertrekLabel.setBounds(30, 180, 180, 25);
        stationCombobox.setBounds(200, 180, 180, 25);
        aankomstLabel.setBounds(30, 220, 180, 25);
        stationTweeCombobox.setBounds(200, 220, 180, 25);
        datePicker.setBounds(200, 260, 180, 25);
        datumticketLabel.setBounds(30, 260, 180, 25);
        aantalLabel.setBounds(30, 300, 180, 25);
        klasseLabel.setBounds(30, 340, 180, 25);
        klasseCombobox.setBounds(200, 340, 180, 25);
        spinner1.setBounds(200, 300, 180, 25);
        zoekButton.setBounds(330, 400, 180, 25);
        terugButton.setBounds(600, 20, 90, 40);

        interactiePanel.add(stationTweeCombobox);
        interactiePanel.add(vertrekLabel);
        interactiePanel.add(stationCombobox);
        interactiePanel.add(aankomstLabel);
        interactiePanel.add(datumticketLabel);
        interactiePanel.add(datePicker);
        interactiePanel.add(aantalLabel);
        interactiePanel.add(datePicker);
        interactiePanel.add(klasseLabel);
        interactiePanel.add(klasseCombobox);
        interactiePanel.add(spinner1);
        interactiePanel.add(zoekButton);
        interactiePanel.setBorder(border);



        mainNavPanel.setBorder(border);




        panel.setLayout(new BorderLayout(80,30));

        mainPanel.setLayout(new BorderLayout(0,0));











        mainPanel.add(mainNavPanel, BorderLayout.NORTH);
        mainPanel.add(interactiePanel, BorderLayout.CENTER);



        panel.add(welkomPanel, BorderLayout.NORTH);
        panel.add(mainPanel, BorderLayout.CENTER);




        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);





        Global.aantalTrees=0;

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


        for (int i = 0; i < Global.aantalTrees; i++){
            JLabel treeText = new JLabel("");

            JPanel treePanel = new JPanel();
            treePanel.setLayout(new BorderLayout());

            treeText.setHorizontalAlignment(JLabel.CENTER);
            treeText.setVerticalAlignment(JLabel.CENTER);


            switch (i){
                case 0: treeText.setText(Global.firstPathName);
                    System.out.println(0);


                    break;
                case 1: treeText.setText(Global.secondPathName);
                    break;
                case 2: treeText.setText(Global.thirdPathName);
                    break;
                default: treeText.setText("Error_treestructure_naming");
                    break;
            }




            treePanel.setPreferredSize(new Dimension(Global.widthNavPanel, Global.heightNavPanel));
            treePanel.setBorder(border);
            treePanel.add(treeText, BorderLayout.CENTER);

            navigationPanel.add(treePanel);


        }








        frame.add(panel);
        frame.setResizable(false);

    }*/

    public static void main(String[] args) {
        TicketView t = new TicketView();

    }


}
