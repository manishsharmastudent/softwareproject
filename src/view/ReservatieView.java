package view;

import controller.MyDocumentFilter;
import model.Reservatie;
import org.jdatepicker.JDatePicker;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.text.AbstractDocument;
import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Rik Van Belle on 31/12/2016.
 */
public class ReservatieView extends StandardView {
    private JPanel reservatiePanel = new JPanel();
    private JPanel gevondenReservatiePanel = new JPanel();
    private JLabel reservatienrLabel = new JLabel("Reservatienummer");
    private JLabel groepsnaamLabel = new JLabel("Groepsnaam");
    private JLabel vertrekStationLabel = new JLabel("Vertrek station");
    private JLabel aankomstStationLabel = new JLabel("Aankomst station");
    private JLabel aantalPersonenLabel = new JLabel("aantal personen");
    private JLabel datumLabel = new JLabel("Datum");
    private JLabel actiefLabel = new JLabel("Actief");
    private GridBagConstraints c = new GridBagConstraints();

    private JTable reservatieTable = null;
    private String[][] reservatieData = null;

    private JTextField groepsnaamText = new JTextField();
    private JComboBox vertrekStationCombobox = new JComboBox();
    private JComboBox bestemmingStationCombobox = new JComboBox();
    private Properties p = new Properties();
    private Integer value = new Integer(1);
    private Integer min = new Integer(1);
    private Integer max = new Integer(100);
    private Integer step = new Integer(1);
    private SpinnerNumberModel modelSp = new SpinnerNumberModel(value, min, max, step);
    private int fifty = modelSp.getNumber().intValue();
    private JCheckBox actief = new JCheckBox();
    private JTextField reservatienrText = new JTextField();

    private JSpinner spinner1 = new JSpinner(modelSp);
    private UtilDateModel model = new UtilDateModel();
    private JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
    private JCheckBox active = new JCheckBox("Actief");

    private JButton searchButtonReservatieNr = new JButton("Zoeken");
    private JButton searchButtonVertrekStation = new JButton("Zoeken");
    private JButton searchButtonBestemmingStation = new JButton("Zoeken");
    private JButton reservatieToevoegenButton = new JButton("Reservatie toevoegen");
    private JButton reservatieUpdateButton = new JButton("Reservatie aanpassen");
    private JButton aanpassenReservatie = new JButton("Aanpassen");

    public ReservatieView(String titel){
        super(titel);
        reservatiePanel.setLayout(new GridBagLayout());
        c.insets = new Insets(10, 20 , 1 ,10);
        groepsnaamLabel.setPreferredSize(new Dimension(90,20));
        groepsnaamLabel.setMinimumSize(groepsnaamLabel.getPreferredSize());
        groepsnaamLabel.setMaximumSize(groepsnaamLabel.getPreferredSize());
        c.fill = GridBagConstraints.HORIZONTAL;
    }

    public int getReservatieNr(){
        return Integer.parseInt(reservatienrText.getText());
    }
    public JComboBox getVertrekStationCombobox(){
        return this.vertrekStationCombobox;
    }
    public JComboBox getBestemmingStationCombobox(){return this.bestemmingStationCombobox; }
    public JDatePickerImpl getDatePicker(){return datePicker; }
    public String getGroepsnaam(){
        return this.groepsnaamText.getText();
    }
    public int getVertrekStationIndex(){
        return vertrekStationCombobox.getSelectedIndex();
    }
    public int getBestemmingsStationIndex(){
        return bestemmingStationCombobox.getSelectedIndex();
    }
    public int getAantalPersonen(){ return modelSp.getNumber().intValue(); }
    public Date getBeginDatum(){
        Date date = (Date)datePicker.getModel().getValue();
        return date;
    }
    public boolean isActive(){
        return active.isSelected();
    }
    public int getSelectedRow(){
        String[] reservatie = reservatieData[reservatieTable.getSelectedRow()];
        return Integer.parseInt(reservatie[0]);
    }


    public JButton getAanpassenReservatie(){
        return aanpassenReservatie;
    }
    public JButton getReservatieToevoegenButton(){
        return this.reservatieToevoegenButton;
    }
    public JButton getSearchButtonReservatieNr(){ return this.searchButtonReservatieNr; }
    public JButton getSearchButtonVertrekStation(){ return this.searchButtonVertrekStation; }
    public JButton getSearchButtonBestemmingStation(){ return this.searchButtonBestemmingStation; }
    public JButton getReservatieUpdateButton(){return this.reservatieUpdateButton;}
    public void showUpdateReservatie(Reservatie reservatie){
        interactiePanel.removeAll();
        interactiePanel.updateUI();
        reservatiePanel.removeAll();
        reservatiePanel.updateUI();


        c.gridy = 0;
        c.gridx = 0;
        reservatiePanel.add(groepsnaamLabel, c);
        groepsnaamText.setText(reservatie.getGroepsnaam());
        c.gridx = 1;
        reservatiePanel.add(groepsnaamText, c);
        c.gridy = 1;
        c.gridx = 0;
        reservatiePanel.add(vertrekStationLabel, c);
        vertrekStationCombobox.getModel().setSelectedItem(reservatie.getVertrekStation().getNaam());
        c.gridx = 1;
        reservatiePanel.add(vertrekStationCombobox, c);
        c.gridy = 2;
        c.gridx = 0;
        reservatiePanel.add(aankomstStationLabel, c);
        bestemmingStationCombobox.getModel().setSelectedItem(reservatie.getAankomstStation().getNaam());
        c.gridx = 1;
        reservatiePanel.add(bestemmingStationCombobox, c);
        c.gridy = 3;
        c.gridx = 0;
        reservatiePanel.add(aantalPersonenLabel, c);
        spinner1.setValue(reservatie.getAantalPersonen());
        c.gridx = 1;
        reservatiePanel.add(spinner1, c);
        c.gridy = 4;
        c.gridx = 0;
        reservatiePanel.add(datumLabel, c);
        datePicker.getJFormattedTextField().setText(reservatie.getReservatieDatum().toString());
        c.gridx = 1;
        reservatiePanel.add(datePicker, c);
        c.gridy = 5;
        c.gridx = 0;
        reservatiePanel.add(actiefLabel, c);
        if(reservatie.getActive() == true){active.setSelected(true);}
        else{active.setSelected(false);}
        c.gridx = 1;
        reservatiePanel.add(active, c);
        c.gridy = 6;
        c.gridx = 0;
        reservatiePanel.add(reservatieUpdateButton, c);

        interactiePanel.add(reservatiePanel);
        deleteLastInPath();
        deleteLastInPath();
        path.add("Reservatie Aanpassen");
        showWindow();
    }
    public void showReservatieToevoegen(){
        interactiePanel.removeAll();
        interactiePanel.updateUI();
        reservatiePanel.removeAll();
        reservatiePanel.updateUI();
        c.weightx = 1;
        c.weighty = 1;

        c.gridy = 0;
        c.gridx = 0;
        reservatiePanel.add(groepsnaamLabel, c);
        c.gridx = 1;
        reservatiePanel.add(groepsnaamText, c);
        c.gridy = 1;
        c.gridx = 0;
        reservatiePanel.add(vertrekStationLabel, c);
        c.gridx = 1;
        reservatiePanel.add(vertrekStationCombobox, c);
        c.gridy = 2;
        c.gridx = 0;
        reservatiePanel.add(aankomstStationLabel, c);
        c.gridx = 1;
        reservatiePanel.add(bestemmingStationCombobox, c);
        c.gridy = 3;
        c.gridx = 0;
        reservatiePanel.add(aantalPersonenLabel, c);
        c.gridx = 1;
        reservatiePanel.add(spinner1, c);
        c.gridy = 4;
        c.gridx = 0;
        reservatiePanel.add(datumLabel, c);
        c.gridx = 1;
        reservatiePanel.add(datePicker, c);
        c.gridy = 5;
        c.gridx = 0;
        reservatiePanel.add(actiefLabel, c);
        c.gridx = 1;
        reservatiePanel.add(active, c);
        c.gridy = 6;
        c.gridx = 0;
        reservatiePanel.add(reservatieToevoegenButton, c);


        interactiePanel.add(reservatiePanel);

        path.add("Reservatie Toevoegen");
        showWindow();
    }
    public void showReservatieZoeken(){
        interactiePanel.removeAll();
        interactiePanel.updateUI();
        reservatiePanel.removeAll();
        reservatiePanel.updateUI();
        c.weightx = 1;
        c.weighty = 1;


        c.gridy = 0;
        c.gridx = 0;
        reservatiePanel.add(reservatienrLabel, c);
        c.gridx = 1;
        reservatiePanel.add(reservatienrText, c);
        c.gridx =2;
        reservatiePanel.add(searchButtonReservatieNr, c);
        c.gridy = 1;
        c.gridx = 0;
        reservatiePanel.add(vertrekStationLabel, c);
        c.gridx = 1;
        reservatiePanel.add(vertrekStationCombobox, c);
        c.gridx = 2;
        reservatiePanel.add(searchButtonVertrekStation, c);
        c.gridy = 2;
        c.gridx = 0;
        reservatiePanel.add(aankomstStationLabel, c);
        c.gridx = 1;
        reservatiePanel.add(bestemmingStationCombobox, c);
        c.gridx = 2;
        reservatiePanel.add(searchButtonBestemmingStation, c);

        interactiePanel.add(reservatiePanel);
        addPath("Reservatie zoeken");
        showWindow();
    }
    public void showReservaties(java.util.List<Reservatie> reservaties){
        interactiePanel.removeAll();
        interactiePanel.updateUI();
        reservatiePanel.removeAll();
        reservatiePanel.updateUI();

        gevondenReservatiePanel.setLayout(new GridBagLayout());
        initTable(reservaties);

        JScrollPane scrollPane = new JScrollPane(reservatieTable,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        for (int column = 0; column < reservatieTable.getColumnCount(); column++)
        {
            TableColumn tableColumn = reservatieTable.getColumnModel().getColumn(column);
            tableColumn.setMinWidth(80);
            int preferredWidth = tableColumn.getMinWidth();
            int maxWidth = tableColumn.getMaxWidth();

            for (int row = 0; row < reservatieTable.getRowCount(); row++)
            {
                TableCellRenderer cellRenderer = reservatieTable.getCellRenderer(row, column);
                Component c = reservatieTable.prepareRenderer(cellRenderer, row, column);
                int width = c.getPreferredSize().width + reservatieTable.getIntercellSpacing().width;
                preferredWidth = Math.max(preferredWidth, width);

                //  We've exceeded the maximum width, no need to check other rows

                if (preferredWidth >= maxWidth)
                {
                    preferredWidth = maxWidth;
                    break;
                }
            }

            tableColumn.setPreferredWidth( preferredWidth );


        }



        c.gridy = 0;
        c.gridx = 0;
        gevondenReservatiePanel.add(scrollPane, c);
        c.gridy = 1;
        c.fill = GridBagConstraints.NONE;
        gevondenReservatiePanel.add(aanpassenReservatie, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        interactiePanel.add(gevondenReservatiePanel);


    }
    public void initTable(java.util.List<Reservatie> reservatieList){
        String[] headers = {"Reservatienr", "Groepsnaam", "Route", "Aantal personen", "Datum"};
        reservatieData = new String[reservatieList.size()][5];

        for (int row = 0; row < reservatieList.size(); row++) {
            for (int col = 0; col < 6; col++) {
                Reservatie reservatie = reservatieList.get(row);
                switch (col) {
                    case 0:
                        reservatieData[row][col] = Integer.toString(reservatie.getReservatienr());
                        break;
                    case 1:
                        reservatieData[row][col] = reservatie.getGroepsnaam();
                        break;
                    case 2:
                        reservatieData[row][col] = reservatie.getVertrekStation().getNaam() + "-" + reservatie.getAankomstStation().getNaam();
                        break;
                    case 3:
                        reservatieData[row][col] = Integer.toString(reservatie.getAantalPersonen());
                        break;
                    case 4:
                        reservatieData[row][col] = reservatie.getReservatieDatum().toString();
                        break;
                }
            }
        }

        reservatieTable = new JTable(reservatieData, headers){
            public boolean isCellEditable(int row, int column) {
                return true;
            }
        };
        reservatieTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        reservatieTable.setFillsViewportHeight(true);


    }
    public void stationsAreTheSame(){JOptionPane.showMessageDialog(null, "Stations mogen niet hetzelfde zijn!");}
    public void reservatieInsertFailed(){JOptionPane.showMessageDialog(null, "Er is iets foutgelopen bij het toevoegen.");}
    public void reservatieNotFound(){
        JOptionPane.showMessageDialog(null, "Reservatie is niet gevonden");
    }
    public void reservatieUpdateSucceed(){
        JOptionPane.showMessageDialog(null, "Reservatie is geupdated");
    }
    public void reservatieInsertSucceed(){
        JOptionPane.showMessageDialog(null, "Reservatie is toegevoegd!");
    }
    public void reservatieUpdateFailure(){
        JOptionPane.showMessageDialog(null, "Er is iets misgelopen tijdens het updaten.");
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
