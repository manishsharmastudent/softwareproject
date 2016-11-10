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
public class TicketView {
    private JFrame frame = new JFrame();
    private JLabel welkomLabel = new JLabel("Welkom");
    private JLabel tijdLabel = new JLabel("tijd");
    private JLabel datumLabel = new JLabel("datum");
    private JPanel welkomPanel = new JPanel();
    private JPanel panel = new JPanel();
    private JPanel interactiePanel = new JPanel();
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
    private Properties p = new Properties();
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
        AutoCompleteDecorator.decorate(stationCombobox);


        frame.add(panel);






        panel.setLayout(new BorderLayout(20,20));



        welkomPanel.setLayout(new BoxLayout(welkomPanel, BoxLayout.LINE_AXIS));
        welkomPanel.setPreferredSize(new Dimension(800,50));
        welkomPanel.setMaximumSize(welkomPanel.getPreferredSize());
        welkomPanel.add(welkomLabel);
        welkomPanel.add(tijdLabel);
        welkomPanel.add(datumLabel);
        welkomPanel.setBorder(border);





        interactiePanel.add(datePicker);

        welkomPanel.add(welkomLabel);
        panel.add(welkomPanel, BorderLayout.NORTH);
        panel.add(interactiePanel, BorderLayout.CENTER);



        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");

        frame.setSize(800,700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);




        frame.setLocationRelativeTo(null);

        frame.setVisible(true);



    }

    public static void main(String[] args) {
        TicketView t = new TicketView();

    }

}
