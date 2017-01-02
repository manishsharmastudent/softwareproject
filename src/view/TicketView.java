package view;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import javax.swing.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
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
    private JComboBox vertrekStationCombobox = new JComboBox();
    private JComboBox bestemmingStationCombobox = new JComboBox();
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
        return this.vertrekStationCombobox;
    }

    public JComboBox getBestemmingsStationComboBox(){
        return this.bestemmingStationCombobox;
    }

    public JComboBox getKlasseCombobox() { return this.klasseCombobox; }

    public int getTypeKaartIndex(){
        return typeKaartenComboBox.getSelectedIndex();
    }

    public JSpinner getSpinnerAantalPersonen(){
        return this.spinner1;
    }

    public int getAantalPersonen(){ return modelSp.getNumber().intValue(); }

    public int getVertrekStationIndex(){
        return vertrekStationCombobox.getSelectedIndex();
    }

    public int getBestemmingsStationIndex(){
        return bestemmingStationCombobox.getSelectedIndex();
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

    public JDatePickerImpl getDatePicker(){return datePicker;}

    public Date getBeginDatum(){
            Date date = (Date)datePicker.getModel().getValue();
            //LocalDate lDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            return date;
    }

    public void showVoegTicketToe(){
        AutoCompleteDecorator.decorate(vertrekStationCombobox);
        AutoCompleteDecorator.decorate(bestemmingStationCombobox);

        interactiePanel.setLayout(null);
        kaartLabel.setBounds(30,140,180,25);
        typeKaartenComboBox.setBounds(200,140,180,25);
        typeKaartOmschrijving.setBounds(450,140,180,25);
        vertrekLabel.setBounds(30, 180, 180, 25);
        vertrekStationCombobox.setBounds(200, 180, 180, 25);
        aankomstLabel.setBounds(30, 220, 180, 25);
        bestemmingStationCombobox.setBounds(200, 220, 180, 25);
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
        interactiePanel.add(vertrekStationCombobox);
        interactiePanel.add(vertrekLabel);
        interactiePanel.add(bestemmingStationCombobox);
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
    public void stationsAreTheSame(){JOptionPane.showMessageDialog(null, "Stations mogen niet hetzelfde zijn.");}
    public void addSucceed(){JOptionPane.showMessageDialog(null, "Ticket is toegevoegd");}

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
