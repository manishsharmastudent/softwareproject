package view;

import model.Ticket;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import javax.swing.*;
import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Rik Van Belle on 01/11/2016.
 */
public class TicketView extends StandardView {
    private JLabel vertrekLabel = new JLabel("Vertrekpunt");
    private JLabel kaartLabel = new JLabel("Kaart");
    private JLabel aankomstLabel = new JLabel("Aankomst");
    private JLabel datumticketLabel = new JLabel("Datum");
    private JLabel aantalLabel = new JLabel("Aantal");
    private JLabel klasseLabel = new JLabel("Klasse");
    private JLabel typeKaartOmschrijving = new JLabel();
    private JButton zoekButton = new JButton("Zoek");
    private JComboBox stationCombobox = new JComboBox();
    private JComboBox stationTweeCombobox = new JComboBox();
    private JComboBox klasseCombobox = new JComboBox();
    private JComboBox typeKaartenComboBox = new JComboBox();
    private Properties p = new Properties();
    private Integer value = new Integer(1);
    private Integer min = new Integer(1);
    private Integer max = new Integer(100);
    private Integer step = new Integer(1);
    private SpinnerNumberModel modelSp = new SpinnerNumberModel(value, min, max, step);
    private int fifty = modelSp.getNumber().intValue();
    private JSpinner spinner1 = new JSpinner(modelSp);

    private UtilDateModel model = new UtilDateModel();
    private JDatePanelImpl datePanel = new JDatePanelImpl(model, p);


    public TicketView(String titel){
        super(titel);
    }

    public JComboBox getTypeKaartenComboBox(){ return this.typeKaartenComboBox; }

    public JComboBox getVertrekStationComboBox(){
        return this.stationCombobox;
    }

    public JComboBox getBestemmingsStationComboBox(){
        return this.stationTweeCombobox;
    }

    public JComboBox getKlasseCombobox() { return this.klasseCombobox; }

    public int getTypeKaartIndex(){ return typeKaartenComboBox.getSelectedIndex();}

    public JSpinner getSpinnerAantalPersonen(){
        return this.spinner1;
    }

    public int getAantalPersonen(){ return modelSp.getNumber().intValue(); }

    public String getVertrekStation(){
        return stationCombobox.getSelectedItem().toString();
    }

    public String getBestemmingsStation(){
        return stationTweeCombobox.getSelectedItem().toString();
    }

    public String getKlasse(){
        return klasseCombobox.getSelectedItem().toString();
    }

    public JButton getZoekButton(){
        return this.zoekButton;
    }

    public void setTypeKaartOmschrijving(String omschrijving){
        this.typeKaartOmschrijving.setText(omschrijving);
    }

    public void showVoegTicketToe(){
        AutoCompleteDecorator.decorate(stationCombobox);
        AutoCompleteDecorator.decorate(stationTweeCombobox);

        interactiePanel.setLayout(null);
        kaartLabel.setBounds(30,140,180,25);
        typeKaartenComboBox.setBounds(200,140,180,25);
        typeKaartOmschrijving.setBounds(450,140,180,25);
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

        interactiePanel.add(kaartLabel);
        interactiePanel.add(typeKaartenComboBox);
        interactiePanel.add(typeKaartOmschrijving);
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

<<<<<<< HEAD
        mainPanel.setLayout(new BorderLayout(80,30));
=======
        getMainPanel().setLayout(new BorderLayout(80,30));
>>>>>>> origin/Dietger
        panel.setLayout(new BorderLayout(0,0));

        panel.add(mainNavPanel, BorderLayout.NORTH);
        panel.add(interactiePanel, BorderLayout.CENTER);

<<<<<<< HEAD
        mainPanel.add(welkomPanel, BorderLayout.NORTH);
        mainPanel.add(panel, BorderLayout.CENTER);
=======
        getMainPanel().add(welkomPanel, BorderLayout.NORTH);
        getMainPanel().add(panel, BorderLayout.CENTER);
>>>>>>> origin/Dietger

        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");

        addPath("Verkoop Ticket");
        showWindow();
    }

    public int showPrice(double prijs){
        if (JOptionPane.showConfirmDialog(null, "Het ticket kost € " + prijs + " .") == JOptionPane.YES_OPTION){
            return 1;
        }
        else{
            return -1;
        }
    }
    public void noTicketAdded(){
        JOptionPane.showMessageDialog(null, "Ticket is niet toegevoegd!");
    }

    public void showTickets(Ticket[][] tickets){

    }

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

    }
