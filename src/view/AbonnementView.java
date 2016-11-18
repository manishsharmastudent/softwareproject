package view;

import model.Abonnement;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import javax.swing.*;
import java.awt.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

/**
 * Created by Rik Van Belle on 01/11/2016.
 */
public class AbonnementView extends StandardView {
    private JPanel abonnementPanel = new JPanel();

    private JLabel klantLabel = new JLabel("Klant");
    private JLabel routeLabel = new JLabel("Route");
    private JLabel kortingLabel = new JLabel("Korting");
    private JLabel begindatumLabel = new JLabel("Begindatum");
    private JLabel einddatumLabel = new JLabel("Einddatum");

    private JComboBox routeComboBox = new JComboBox();
    private JComboBox klantComboBox = new JComboBox();
    private JComboBox kortingComboBox = new JComboBox();
    private JTextField begindatumText = new JTextField();
    private JTextField einddatumText = new JTextField();

    private JButton toevoegenAbonnement = new JButton("Abonnement toevoegen");

    private Properties pBeginDatum = new Properties();
    private UtilDateModel modelBeginDatum = new UtilDateModel();
    private Properties pEindDatum = new Properties();
    private UtilDateModel modelEindDatum = new UtilDateModel();

    private JDatePanelImpl datePanelBeginDatum = new JDatePanelImpl(modelBeginDatum, pBeginDatum);
    private JDatePanelImpl datePanelEindDatum = new JDatePanelImpl(modelEindDatum, pEindDatum);

    public AbonnementView(String titel){
        super(titel);
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
    public String getRoute(){
        return routeComboBox.getSelectedItem().toString();
    }
    public String getKlant(){
        return klantComboBox.getSelectedItem().toString();
    }
    public String getKorting(){
        return kortingComboBox.getSelectedItem().toString();
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

    public void showAbonnement(Abonnement abonnement){

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
}
