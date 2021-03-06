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

    private GridBagConstraints c = new GridBagConstraints();
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
        abonnementPanel.setLayout(new GridBagLayout());
        c.insets = new Insets(10, 20 , 1 ,0);
        abonnementNummerText.setPreferredSize(new Dimension(110,20));
        abonnementNummerText.setMinimumSize(rijksregisterNummerText.getPreferredSize());
        abonnementNummerText.setMaximumSize(rijksregisterNummerText.getPreferredSize());

        c.fill = GridBagConstraints.HORIZONTAL;
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
        System.out.println(abonnement.getAbonnementId());

        eindDatum.setEnabled(false);
        beginDatum.setEnabled(false);
        eindDatum.setText(abonnement.getBeginDatum().toString());
        beginDatum.setText(abonnement.getVervalDatum().toString());
        textAboId.setText(Integer.toString(abonnement.getAbonnementId()));
        textAboId.setEnabled(false);

        c.gridx = 0;
        c.gridy = 0;
        abonnementPanel.add(new JLabel("Abonnementnummer: "), c);
        c.gridx = 1;
        abonnementPanel.add(textAboId, c);
        c.gridx = 0;
        c.gridy = 1;
        abonnementPanel.add(new JLabel("Korting: "),c);
        kortingComboBox.getModel().setSelectedItem(abonnement.getKorting().getOmschrijving());
        c.gridx = 1;
        abonnementPanel.add(kortingComboBox, c);
        c.gridx = 0;
        c.gridy = 2;
        abonnementPanel.add(new JLabel("Vertrek: "), c);
        vertrekComboBox.getModel().setSelectedItem(abonnement.getVertrekStation().getNaam());
        c.gridx = 1;
        abonnementPanel.add(vertrekComboBox, c);
        c.gridx = 0;
        c.gridy = 3;
        abonnementPanel.add(new JLabel("Bestemming: "), c);
        bestemmingComboBox.getModel().setSelectedItem(abonnement.getBestemmingStation().getNaam());
        c.gridx = 1;
        abonnementPanel.add(bestemmingComboBox, c);
        c.gridx = 0;
        c.gridy = 4;
        abonnementPanel.add(new JLabel("Klant: "), c);
        klantComboBox.getModel().setSelectedItem(abonnement.getKlant().getVoornaam() + " " + abonnement.getKlant().getAchternaam());
        c.gridx = 1;
        abonnementPanel.add(klantComboBox, c);
        c.gridx = 0;
        c.gridy = 5;
        abonnementPanel.add(new JLabel("Begindatum: "), c);
        c.gridx = 1;
        abonnementPanel.add(beginDatum, c);
        c.gridx = 0;
        c.gridy = 6;
        abonnementPanel.add(new JLabel("Einddatum: "), c);
        c.gridx = 1;
        abonnementPanel.add(eindDatum, c);
        if(abonnement.isActive()){active.setSelected(true);}
        c.gridx = 0;
        c.gridy = 7;
        abonnementPanel.add(active, c);
        c.gridx = 0;
        c.gridy = 8;
        abonnementPanel.add(updateButton, c);

        interactiePanel.add(abonnementPanel);
        deleteLastInPath();
        deleteLastInPath();
        showWindow();
    }
    public void showZoekAbonnement(){

        c.gridx = 0;
        c.gridy = 0;
        abonnementPanel.add(rijksregisterLabel, c);
        c.gridx = 1;
        abonnementPanel.add(rijksregisterNummerText,c);
        c.gridx = 2;
        abonnementPanel.add(zoekAbonnementOpKlantIdButton,c);
        c.gridx = 0;
        c.gridy = 1;
        abonnementPanel.add(abonnementIdLabel,c);
        c.gridx = 1;
        abonnementPanel.add(abonnementNummerText,c);
        c.gridx = 2;
        abonnementPanel.add(zoekAbonnementOpAboIdButton,c);

        interactiePanel.add(abonnementPanel);
        path.add("Abonnement zoeken");
        showWindow();
    }
    public void showGevondenAbonnementen(java.util.List<Abonnement>abonnementen){
        initTable(abonnementen);
        gevondenAbonnementen.setLayout(new GridBagLayout());
        JScrollPane scrollPane = new JScrollPane(abonnementenTable);
        c.gridx = 0;
        c.gridy = 0;
        gevondenAbonnementen.add(scrollPane, c);
        c.gridy = 1;
        c.fill = GridBagConstraints.NONE;
        gevondenAbonnementen.add(aanpasButton, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        interactiePanel.add(gevondenAbonnementen);
        showWindow();
    }
    public void showToevoegenAbonnement(){

        c.gridy = 0;
        c.gridx = 0;
        abonnementPanel.add(klantLabel, c);
        c.gridx = 1;
        abonnementPanel.add(klantComboBox, c);
        c.gridy = 1;
        c.gridx = 0;
        abonnementPanel.add(vertrekLabel, c);
        c.gridx = 1;
        abonnementPanel.add(vertrekComboBox, c);
        c.gridy = 2;
        c.gridx = 0;
        abonnementPanel.add(bestemmingLabel, c);
        c.gridx = 1;
        abonnementPanel.add(bestemmingComboBox, c);
        c.gridy = 3;
        c.gridx = 0;
        abonnementPanel.add(kortingLabel, c);
        c.gridx = 1;
        abonnementPanel.add(kortingComboBox, c);
        c.gridy = 4;
        c.gridx = 0;
        abonnementPanel.add(begindatumLabel, c);
        c.gridx = 1;
        abonnementPanel.add(datePickerBeginDatum, c);
        c.gridy = 5;
        c.gridx = 0;
        abonnementPanel.add(einddatumLabel, c);
        c.gridx = 1;
        abonnementPanel.add(datePickerEindDatum, c);
        c.gridy = 6;
        c.gridx = 0;
        abonnementPanel.add(toevoegenAbonnement, c);

        interactiePanel.add(abonnementPanel, c);

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
