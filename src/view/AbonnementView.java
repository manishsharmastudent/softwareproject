package view;

import model.Abonnement;
import model.Klant;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

/**
 * Created by Rik Van Belle on 01/11/2016.
 */
public class AbonnementView extends StandardView {
    private JPanel abonnementPanel = new JPanel();
    private JPanel gevondenAbonnementen = new JPanel();
    Abonnement abonnement = new Abonnement();

    private JLabel rijksregisterLabel = new JLabel("Rijksregisternummer: ");
    private JLabel abonnementIdLabel = new JLabel("Abonnementnummer: ");
    private JTextField rijksregisterNummerText = new JFormattedTextField(createFormatter("##.##.##-###.##"));
    private JTextField abonnementNummerText = new JTextField();

    private JLabel klantLabel = new JLabel("Klant");
    private JLabel routeLabel = new JLabel("Route");
    private JLabel kortingLabel = new JLabel("Korting");
    private JLabel begindatumLabel = new JLabel("Begindatum");
    private JLabel einddatumLabel = new JLabel("Einddatum");
    private JComboBox routeComboBox = new JComboBox();
    private JComboBox klantComboBox = new JComboBox();
    private JComboBox kortingComboBox = new JComboBox();

    private JTextField textAboId = new JTextField();
    private JTextField beginDatum = new JTextField();
    private JTextField eindDatum = new JTextField();
    private JTextField afsluiten = new JTextField();

    private JButton toevoegenAbonnement = new JButton("Abonnement toevoegen");
    private JButton zoekAbonnementOpKlantIdButton = new JButton("Zoeken");
    private JButton zoekAbonnementOpAboIdButton = new JButton("Zoeken");
    private JButton aanpasButton = new JButton("Aanpassen");
    private JButton updateButton = new JButton("Updaten");

    private Properties pBeginDatum = new Properties();
    private UtilDateModel modelBeginDatum = new UtilDateModel();
    private Properties pEindDatum = new Properties();
    private UtilDateModel modelEindDatum = new UtilDateModel();

    private JDatePanelImpl datePanelBeginDatum = new JDatePanelImpl(modelBeginDatum, pBeginDatum);
    private JDatePanelImpl datePanelEindDatum = new JDatePanelImpl(modelEindDatum, pEindDatum);

    public AbonnementView(String titel){
        super(titel);
    }

    public Abonnement getAbonnement(){ return this.abonnement;}
    public JPanel getAbonnementPanel() { return this.abonnementPanel; }
    public JPanel getGevondenAbonnementPanel(){ return gevondenAbonnementen; }
    public String getRijksregisterNummerText(){
        return rijksregisterNummerText.getText();
    }
    public String getAbonnementNummerText(){
        return abonnementNummerText.getText();
    }

    public JComboBox getKlantComboBox(){
        return this.klantComboBox;
    }
    public JComboBox getRouteComboBox(){
        return this.routeComboBox;
    }
    public JComboBox getKortingComboBox(){
        return this.kortingComboBox;
    }
    public int getRoute(){
        String[] data = routeComboBox.getSelectedItem().toString().split("\\.");
        return Integer.parseInt(data[0]);
    }
    public String getKlant(){
        return klantComboBox.getSelectedItem().toString();
    }
    public int getKorting(){
        String[] data = kortingComboBox.getSelectedItem().toString().split("\\.");
        return Integer.parseInt(data[0]);
    }
    public Date getBegindatum() {
        return (Date) datePickerBeginDatum.getModel().getValue();
    }
    public Date getEinddatum() {
        return (Date) datePickerEindDatum.getModel().getValue();
    }
    public JButton getToevoegenAbonnementButton(){
        return this.toevoegenAbonnement;
    }

    public int getAboId(){
        return Integer.parseInt(textAboId.getText());
    }
    public boolean getAfsluiten(){
        if (afsluiten.getText() == "true") {
            return true;
        }
        else {
            return false;
        }
    }
    public JButton getZoekAbonnementByKlantIdButton(){ return this.zoekAbonnementOpKlantIdButton; }
    public JButton getZoekAbonnementByAboIdButton(){ return this.zoekAbonnementOpAboIdButton; }
    public JButton getAanpasButton(){
        return aanpasButton;}
    public JButton getUpdateButton(){
        return updateButton;
    }
    public JDatePickerImpl getDatePickerBeginDatum(){ return this.datePickerBeginDatum; }
    public JDatePickerImpl getDatePickerEindDatum(){ return this.datePickerEindDatum;}

    public void showAanpassenAbonnement(Abonnement abonnement){
        abonnementPanel.setLayout(new GridLayout(8,2));
        System.out.println(abonnement.getAbonnementId());

        afsluiten.setText(Boolean.toString(abonnement.isActive()));
        eindDatum.setText("12-12-2015");
        beginDatum.setText("12-12-2015");
        textAboId.setText(Integer.toString(abonnement.getAbonnementId()));
        textAboId.setEnabled(false);

        abonnementPanel.add(new JLabel("Abonnementnummer: "));
        abonnementPanel.add(textAboId);
        abonnementPanel.add(new JLabel("Korting: "));
        abonnementPanel.add(kortingComboBox);
        abonnementPanel.add(new JLabel("Route: "));
        abonnementPanel.add(routeComboBox);
        abonnementPanel.add(new JLabel("Klant: "));
        abonnementPanel.add(klantComboBox);
        abonnementPanel.add(new JLabel("Begindatum: "));
        abonnementPanel.add(beginDatum);
        abonnementPanel.add(new JLabel("Einddatum: "));
        abonnementPanel.add(eindDatum);
        abonnementPanel.add(new JLabel("Afsluiten: "));
        abonnementPanel.add(afsluiten);
        abonnementPanel.add(updateButton);

        mainPanel.add(abonnementPanel);
        deleteLastInPath();
        deleteLastInPath();
        showWindow();
    }
    public void showZoekAbonnement(){
        abonnementPanel.setLayout(new GridLayout(2,3));

        abonnementPanel.add(rijksregisterLabel);
        abonnementPanel.add(rijksregisterNummerText);
        abonnementPanel.add(zoekAbonnementOpKlantIdButton);
        abonnementPanel.add(abonnementIdLabel);
        abonnementPanel.add(abonnementNummerText);
        abonnementPanel.add(zoekAbonnementOpAboIdButton);

        mainPanel.add(abonnementPanel);
        path.add("Abonnement zoeken");
        showWindow();
    }
    public void showGevondenAbonnementen(Abonnement abonnement){
        this.abonnement = abonnement;
        GridLayout layout = new GridLayout(2,3);
        layout.setHgap(25);
        gevondenAbonnementen.setLayout(layout);
        if (abonnement == null){
            JOptionPane.showMessageDialog(null, "Er is geen abonnement gevonden!");
        }
        else {
            gevondenAbonnementen.add(new JLabel("Naam"));
            gevondenAbonnementen.add(new JLabel("Abonnementnummer"));
            gevondenAbonnementen.add(new JLabel());
                Klant klant = abonnement.getKlant();

                JLabel klantNaam = new JLabel(klant.getVoornaam() + " " + klant.getAchternaam());
                JLabel abonnementNummer = new JLabel(Integer.toString(abonnement.getAbonnementId()));

                gevondenAbonnementen.add(klantNaam);
                gevondenAbonnementen.add(abonnementNummer);
                gevondenAbonnementen.add(aanpasButton);
            }
            mainPanel.add(gevondenAbonnementen);
        }
    public void showToevoegenAbonnement(){
        abonnementPanel.setLayout(new GridLayout(6,2));

        abonnementPanel.add(klantLabel);
        abonnementPanel.add(klantComboBox);
        abonnementPanel.add(routeLabel);
        abonnementPanel.add(routeComboBox);
        abonnementPanel.add(kortingLabel);
        abonnementPanel.add(kortingComboBox);
        abonnementPanel.add(begindatumLabel);
        abonnementPanel.add(datePickerBeginDatum);
        abonnementPanel.add(einddatumLabel);
        abonnementPanel.add(datePickerEindDatum);
        abonnementPanel.add(toevoegenAbonnement);

        mainPanel.add(abonnementPanel);

        path.add("Abonnement toevoegen");

        showWindow();
    }
    public void showErrorDate(){
        JOptionPane.showMessageDialog(null, "Einddatum moet na begindatum zijn.");
    }
    private JDatePickerImpl datePickerBeginDatum = new JDatePickerImpl(datePanelBeginDatum, new JFormattedTextField.AbstractFormatter() {

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
    private JDatePickerImpl datePickerEindDatum = new JDatePickerImpl(datePanelEindDatum, new JFormattedTextField.AbstractFormatter() {
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
    public void showSuccesfullAdd(Klant klant){ JOptionPane.showMessageDialog(null, "Abonnement voor " + klant.getAchternaam() + " " + klant.getVoornaam() + " is toegevoegd!");}
    public int showPrice(double price){
        if (JOptionPane.showConfirmDialog(null, "Het bedrag van € " + price + " betalen?") == JOptionPane.YES_OPTION){;
            return 1;
        }
        else {
            return -1;
        }
    }
    public void alreadyAbonnement(int id){
        JOptionPane.showMessageDialog(null, "Klant heeft al een abonnement" + "Id: " + id);
    }
}
