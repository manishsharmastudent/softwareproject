package view;

import model.Ticket;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;

/**
 * Created by Rik Van Belle on 01/11/2016.
 */
public class TicketView extends StandardView {
    private JLabel vertrekLabel = new JLabel("Vertrekpunt");
    private JLabel aankomstLabel = new JLabel("Aankomst");
    private JLabel datumticketLabel = new JLabel("Datum");
    private JLabel aantalLabel = new JLabel("Aantal");
    private JLabel klasseLabel = new JLabel("Klasse");
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

    private UtilDateModel model = new UtilDateModel();
    private JDatePanelImpl datePanel = new JDatePanelImpl(model, p);


    public TicketView(String titel, boolean haveButton){
        super(titel, haveButton);
        getStandardButton().setText("Ticket View");
        setGui();
        terugButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deleteLastInPath();
            }
        });
    }
    public void showTicket(Ticket ticket){

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

    private void setGui(){
        stationCombobox = new JComboBox(new Object[]{"","test", "aardappeltest"});
        stationTweeCombobox = new JComboBox(new Object[]{"","test", "aardappeltest"});
        klasseCombobox = new JComboBox(new Object[]{"","Eerste klasse", "Tweede klasse"});

        AutoCompleteDecorator.decorate(stationCombobox);
        AutoCompleteDecorator.decorate(stationTweeCombobox);

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

        getMainPanel().setLayout(new BorderLayout(80,30));
        panel.setLayout(new BorderLayout(0,0));

        panel.add(mainNavPanel, BorderLayout.NORTH);
        panel.add(interactiePanel, BorderLayout.CENTER);

        getMainPanel().add(welkomPanel, BorderLayout.NORTH);
        getMainPanel().add(panel, BorderLayout.CENTER);

        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");

        addPath("Home");
        addPath("Tickets en Abonnementen");

        addPath("Verkoop Ticket");

        showPath();

        getWindow().setResizable(false);
        showWindow();
        }

    public static void main(String[] args){
        TicketView tV = new TicketView("Ticket", false);
    }

    }
