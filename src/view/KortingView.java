package view;

import model.Korting;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import org.jdesktop.swingx.prompt.PromptSupport;

import javax.swing.*;
import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;

/**
 * Created by Rik Van Belle on 01/11/2016.
 */
public class KortingView extends StandardView {
    private JPanel kortingPanel = new JPanel(new GridBagLayout());
    private JLabel kortingIDLabel = new JLabel("Korting ID");
    private JLabel kortingTypeLabel = new JLabel("Korting type");
    private JLabel eindDatumLabel = new JLabel("Eind Datum");
    private JLabel beginDatumLabel = new JLabel("Begin Datum");
    private JLabel omschrijvingLabel = new JLabel("Omschrijving");
    private JLabel percentageLabel = new JLabel("Percentage");
    private JComboBox kortingIDComboBox = new JComboBox();
    private JComboBox typeIDComboBox = new JComboBox();
    private Properties p = new Properties();
    private UtilDateModel model = new UtilDateModel();
    private JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
    private JDatePickerImpl datePickerBeginDatum = new JDatePickerImpl(datePanel, new JFormattedTextField.AbstractFormatter() {

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
    private JDatePickerImpl datePickerEindDatum = new JDatePickerImpl(datePanel, new JFormattedTextField.AbstractFormatter() {

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
    private JTextArea omschrijvingArea = new JTextArea(10,20);
    private SpinnerNumberModel modelSp = new SpinnerNumberModel(0,0,100,1);
    private JSpinner percentageSpinner = new JSpinner(modelSp);
    private JButton saveButton = new JButton("Opslaan");
    private GridBagConstraints c = new GridBagConstraints();

    public KortingView(String titel){
        super(titel);
    }


    public void showKorting(Korting korting){
        AutoCompleteDecorator.decorate(kortingIDComboBox);
        PromptSupport.setPrompt("Omschrijving van korting...",omschrijvingArea);

        kortingPanel.setLayout(new GridBagLayout());
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(10,150,10,10);
        c.gridx = 0;
        c.gridy = 0;
        kortingPanel.add(kortingIDLabel, c);
        c.gridx = 1;
        c.gridy = 0;
        c.weightx = 0.5;
        kortingPanel.add(kortingIDComboBox, c);
        c.gridx = 0;
        c.gridy = 1;
        kortingPanel.add(kortingTypeLabel, c);
        c.gridx = 1;
        c.gridy = 1;
        kortingPanel.add(typeIDComboBox, c);
        c.gridx = 0;
        c.gridy = 2;
        kortingPanel.add(beginDatumLabel, c);
        c.gridx = 1;
        c.gridy = 2;
        kortingPanel.add(datePickerBeginDatum, c);
        c.gridx = 0;
        c.gridy = 3;
        kortingPanel.add(eindDatumLabel, c);
        c.gridx = 1;
        c.gridy = 3;
        kortingPanel.add(datePickerEindDatum, c);
        c.gridx = 0;
        c.gridy = 4;
        kortingPanel.add(omschrijvingLabel, c);
        c.gridx = 1;
        c.gridy = 4;
        omschrijvingArea.setBorder(border);
        kortingPanel.add(omschrijvingArea, c);
        c.gridx = 0;
        c.gridy = 5;
        kortingPanel.add(percentageLabel, c);
        c.gridx = 1;
        c.gridy = 5;
        kortingPanel.add(percentageSpinner, c);
        c.gridx = 0;
        c.insets = new Insets(50,150,10,10);
        c.gridy = 6;
        kortingPanel.add(saveButton, c);


        interactiePanel.add(kortingPanel);
//
        //////

        //;/
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");

        addPath("Instellingen Korting");
        showWindow();
        ////



        /////ik heb author name bij push geschreven

        //////cocmsdkovnhaisduhfiobjszduirhxfg
    }
    public static void main(String [] args){

        KortingView v = new KortingView("korting");
        Korting k = new Korting();
        v.showKorting(k);
    }
}
