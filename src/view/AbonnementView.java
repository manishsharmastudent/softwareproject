package view;

import model.Abonnement;
import model.Klant;
import org.jdatepicker.JDatePicker;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import javax.swing.*;
import java.awt.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
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
    private JLabel vertrekLabel = new JLabel("Vertrek");
    private JLabel bestemmingLabel = new JLabel("Bestemming");
    private JLabel kortingLabel = new JLabel("Korting");
    private JLabel begindatumLabel = new JLabel("Begindatum");
    private JLabel einddatumLabel = new JLabel("Einddatum");
    private JComboBox vertrekComboBox = new JComboBox();
    private JComboBox bestemmingComboBox = new JComboBox();
    private JComboBox klantComboBox = new JComboBox();
    private JComboBox kortingComboBox = new JComboBox();
    private JTable abonnementenTable = null;
    private String[][] dataAbonnementen = null;

    private JTextField textAboId = new JTextField();
    private JTextField beginDatum = new JTextField();
    private JTextField eindDatum = new JTextField();
    private JCheckBox active = new JCheckBox("Actief");

    private JButton zoekAbonnementOpKlantIdButton = new JButton("Zoeken");
    private JButton zoekAbonnementOpAboIdButton = new JButton("Zoeken");
    private JButton aanpasButton = new JButton("Aanpassen");
    private JButton updateButton = new JButton("Updaten");
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
    public JComboBox getVertrekComboBox(){
        return this.vertrekComboBox;
    }
    public JComboBox getBestemmingComboBox(){return this.bestemmingComboBox; }
    public JComboBox getKortingComboBox(){
        return this.kortingComboBox;
    }
    public int getVertrekStationIndex() {
        return vertrekComboBox.getSelectedIndex();
    }
    public int getBestemmingStationIndex() {
        return bestemmingComboBox.getSelectedIndex();
    }
    public int getKortingIndex(){
        return kortingComboBox.getSelectedIndex();
    }
    public int getKlantIndex(){
        return klantComboBox.getSelectedIndex();
    }
    public Date getBegindatum() {
        return (Date) datePickerBeginDatum.getModel().getValue();
    }
    public ArrayList<Integer> getBeginDatas(){
        ArrayList<Integer> begindatas = new ArrayList<>();
        begindatas.add(datePanelBeginDatum.getModel().getDay());
        begindatas.add(datePanelBeginDatum.getModel().getMonth());
        begindatas.add(datePanelBeginDatum.getModel().getYear());
        return begindatas;
    }
    public ArrayList<Integer> getEindDatas(){
        ArrayList<Integer> einddatas = new ArrayList<>();
        einddatas.add(datePanelEindDatum.getModel().getDay());
        einddatas.add(datePanelEindDatum.getModel().getMonth());
        einddatas.add(datePanelEindDatum.getModel().getYear());
        return einddatas;
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
    public boolean isActive(){
        return active.isSelected();
    }
    public JButton getZoekAbonnementByKlantIdButton(){ return this.zoekAbonnementOpKlantIdButton; }
    public JButton getZoekAbonnementByAboIdButton(){ return this.zoekAbonnementOpAboIdButton; }
    public JButton getAanpasButton(){
        return aanpasButton;}
    public JButton getUpdateButton(){
        return updateButton;
    }
    public int getSelectedRow(){
        String[] abonnement = dataAbonnementen[abonnementenTable.getSelectedRow()];
        return Integer.parseInt(abonnement[0]);
    }
    public void showAanpassenAbonnement(Abonnement abonnement){
        abonnementPanel.setLayout(new GridLayout(9,2));
        System.out.println(abonnement.getAbonnementId());

        eindDatum.setText("12-12-2015");
        beginDatum.setText("12-12-2015");
        textAboId.setText(Integer.toString(abonnement.getAbonnementId()));
        textAboId.setEnabled(false);

        abonnementPanel.add(new JLabel("Abonnementnummer: "));
        abonnementPanel.add(textAboId);
        abonnementPanel.add(new JLabel("Korting: "));
        abonnementPanel.add(kortingComboBox);
        abonnementPanel.add(new JLabel("Vertrek: "));
        abonnementPanel.add(vertrekComboBox);
        abonnementPanel.add(new JLabel("Bestemming: "));
        abonnementPanel.add(bestemmingComboBox);
        abonnementPanel.add(new JLabel("Klant: "));
        abonnementPanel.add(klantComboBox);
        abonnementPanel.add(new JLabel("Begindatum: "));
        abonnementPanel.add(beginDatum);
        abonnementPanel.add(new JLabel("Einddatum: "));
        abonnementPanel.add(eindDatum);
        if(abonnement.isActive()){active.setSelected(true);}
        abonnementPanel.add(active);
        abonnementPanel.add(updateButton);

        interactiePanel.add(abonnementPanel);
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

        interactiePanel.add(abonnementPanel);
        path.add("Abonnement zoeken");
        showWindow();
    }
    public void showGevondenAbonnementen(java.util.List<Abonnement>abonnementen){
            gevondenAbonnementen.setLayout(new GridLayout(1,2));
            initTable(abonnementen);
            JScrollPane scrollPane = new JScrollPane(abonnementenTable);
            gevondenAbonnementen.add(scrollPane);
            gevondenAbonnementen.add(aanpasButton);
            interactiePanel.add(gevondenAbonnementen);
            showWindow();
        }
    public void showToevoegenAbonnement(){
        abonnementPanel.setLayout(new GridLayout(7,2));

        abonnementPanel.add(klantLabel);
        abonnementPanel.add(klantComboBox);
        abonnementPanel.add(vertrekLabel);
        abonnementPanel.add(vertrekComboBox);
        abonnementPanel.add(bestemmingLabel);
        abonnementPanel.add(bestemmingComboBox);
        abonnementPanel.add(kortingLabel);
        abonnementPanel.add(kortingComboBox);
        abonnementPanel.add(begindatumLabel);
        abonnementPanel.add(datePickerBeginDatum);
        abonnementPanel.add(einddatumLabel);
        abonnementPanel.add(datePickerEindDatum);
        abonnementPanel.add(toevoegenAbonnement);

        interactiePanel.add(abonnementPanel);

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
    public JDatePicker getDatePickerEindDatum(){
        return this.datePickerEindDatum;
    }
    public JDatePicker getDatePickerBeginDatum(){
        return this.datePickerBeginDatum;
    }
    public void showSuccesfullAdd(Klant klant){ JOptionPane.showMessageDialog(null, "Abonnement voor " + klant.getAchternaam() + " " + klant.getVoornaam() + " is toegevoegd!");}
    public int showPrice(double price){
        if (JOptionPane.showConfirmDialog(null, "Het bedrag van € " + price + " betalen?") == JOptionPane.YES_OPTION){
            return 1;
        }
        else {
            return -1;
        }
    }
    public void showAbonnementNotFound(){
        JOptionPane.showMessageDialog(null, "Abonnement niet gevonden");
    }
    public void initTable(java.util.List<Abonnement> abonnementList){
        String[] headers = {"ID", "Klant", "Route", "Korting", "Begindatum", "Einddatum"};
        dataAbonnementen = new String[abonnementList.size()][6];

        for (int row = 0; row < abonnementList.size(); row++) {
            for (int col = 0; col < 6; col++) {
                Abonnement abo = abonnementList.get(row);
                switch (col) {
                    case 0:
                        dataAbonnementen[row][col] = Integer.toString(abo.getAbonnementId());
                        break;
                    case 1:
                        dataAbonnementen[row][col] = abo.getKlant().getVoornaam() + " " + abo.getKlant().getAchternaam();
                        break;
                    case 2:
                        dataAbonnementen[row][col] = abo.getVertrekStation().getNaam() + "-" + abo.getBestemmingStation().getNaam();
                        break;
                    case 3:
                        dataAbonnementen[row][col] = Double.toString(abo.getKorting().getProcent());
                        break;
                    case 4:
                        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                        dataAbonnementen[row][col] = df.format(abo.getBeginDatum());
                        break;
                    case 5:
                        df= new SimpleDateFormat("dd/MM/yyyy");
                        dataAbonnementen[row][col] = df.format(abo.getVervalDatum());
                        break;
                }
            }
        }

        abonnementenTable = new JTable(dataAbonnementen, headers){
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
    }
}
