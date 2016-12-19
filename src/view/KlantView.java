package view;

import com.sun.xml.internal.bind.api.impl.NameConverter;
import model.Klant;

import java.util.List;
import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by Rik Van Belle on 01/11/2016.
 */
public class KlantView extends StandardView {
    private JPanel klantPanel = new JPanel();
    private JPanel gevondenKlantenPanel = new JPanel();
    private JLabel voornaamLabel = new JLabel("Voornaam");
    private JLabel achternaamLabel = new JLabel("Achternaam");
    private JLabel rijksregisterNummerLabel = new JLabel("Rijksregister-nummer");
    private JLabel adresLabel = new JLabel("Adres");
    private JLabel postcodeLabel = new JLabel("Postcode");
    private JLabel stadLabel = new JLabel("Stad");

    private JTable klantTable = null;
    private String[][] klantData = null;

    private JTextField voornaamText = new JTextField();
    private JTextField achternaamText = new JTextField();
    private JTextField rijksregisterNummerText = new JFormattedTextField(createFormatter("##.##.##-###.##"));
    private JTextField adresText = new JTextField();
    private JTextField postcodeText = new JFormattedTextField(createFormatter("####"));
    private JTextField stadText = new JTextField();
    private JCheckBox active = new JCheckBox("Actief");

    private JButton searchButtonRijksregisterNummer = new JButton("Zoeken");
    private JButton searchButtonSurname = new JButton("Zoeken");
    private JButton searchButtonLastname = new JButton("Zoeken");
    private JButton klantToevoegenButton = new JButton("Klant toevoegen");
    private JButton klantUpdateButton = new JButton("Klant aanpassen");
    private JButton aanpassenKlant = new JButton("Aanpassen");

    public KlantView(String titel){
        super(titel);
    }

    public String getRijksregisterNummer(){
        return this.rijksregisterNummerText.getText();
    }
    public String getVoornaam(){
        return this.voornaamText.getText();
    }
    public String getAchternaam(){
        return this.achternaamText.getText();
    }
    public String getAdres(){
        return this.adresText.getText();
    }
    public int getPostcode(){
        return Integer.parseInt(this.postcodeText.getText());
    }
    public String getStad(){
        return this.stadText.getText();
    }
    public String getSelectedRow(){
        String[] klant = klantData[klantTable.getSelectedRow()];
        return klant[0];
    }
    public boolean isActive(){
        return active.isSelected();
    }

    public JButton getAanpassenKlant(){
        return aanpassenKlant;
    }
    public JButton getKlantToevoegenButton(){
        return this.klantToevoegenButton;
    }
    public JButton getSearchButtonSurname(){ return this.searchButtonSurname; }
    public JButton getSearchButtonLastname(){ return this.searchButtonLastname; }
    public JButton getSearchButtonRijksregisterNummer(){ return this.searchButtonRijksregisterNummer; }
    public JButton getKlantUpdateButton(){return this.klantUpdateButton;}
    public void showUpdateKlant(Klant klant){
        klantPanel.removeAll();
        klantPanel.updateUI();
        klantPanel.setLayout(new GridLayout(8,1));

        klantPanel.add(rijksregisterNummerLabel);
        rijksregisterNummerText.setText(klant.getRijksregisterNummer());
        klantPanel.add(rijksregisterNummerText);
        klantPanel.add(voornaamLabel);
        voornaamText.setText(klant.getVoornaam());
        klantPanel.add(voornaamText);
        klantPanel.add(achternaamLabel);
        achternaamText.setText(klant.getAchternaam());
        klantPanel.add(achternaamText);
        klantPanel.add(adresLabel);
        adresText.setText(klant.getAdres());
        klantPanel.add(adresText);
        klantPanel.add(postcodeLabel);
        postcodeText.setText(Integer.toString(klant.getPostcode()));
        klantPanel.add(postcodeText);
        klantPanel.add(stadLabel);
        stadText.setText(klant.getStad());
        klantPanel.add(stadText);
        if(klant.getActive()){active.setSelected(true);}
        klantPanel.add(active);
        klantPanel.add(klantUpdateButton);

        mainPanel.add(klantPanel);
        deleteLastInPath();
        deleteLastInPath();
        path.add("Klant Aanpassen");
        showWindow();
    }
    public void showKlantToevoegen(){
        klantPanel.setLayout(new GridLayout(7,1));

        klantPanel.add(rijksregisterNummerLabel);
        klantPanel.add(rijksregisterNummerText);
        klantPanel.add(voornaamLabel);
        klantPanel.add(voornaamText);
        klantPanel.add(achternaamLabel);
        klantPanel.add(achternaamText);
        klantPanel.add(adresLabel);
        klantPanel.add(adresText);
        klantPanel.add(postcodeLabel);
        klantPanel.add(postcodeText);
        klantPanel.add(stadLabel);
        klantPanel.add(stadText);
        klantPanel.add(klantToevoegenButton);

        interactiePanel.add(klantPanel);

        path.add("Klant Toevoegen");
        showWindow();
    }
    public void showKlantZoeken(){
        klantPanel.setLayout(new GridLayout(4,3));

        klantPanel.add(rijksregisterNummerLabel);
        klantPanel.add(rijksregisterNummerText);
        klantPanel.add(searchButtonRijksregisterNummer);
        klantPanel.add(voornaamLabel);
        klantPanel.add(voornaamText);
        klantPanel.add(searchButtonSurname);
        klantPanel.add(achternaamLabel);
        klantPanel.add(achternaamText);
        klantPanel.add(searchButtonLastname);

        interactiePanel.add(klantPanel);
        addPath("Klant zoeken");
        showWindow();
    }
    public void showKlanten(List<Klant> klanten){
        klantPanel.removeAll();
        klantPanel.updateUI();
        gevondenKlantenPanel.setLayout(new GridLayout(1, 2));
        initTable(klanten);
        JScrollPane scrollPane = new JScrollPane(klantTable);
        gevondenKlantenPanel.add(scrollPane);
        gevondenKlantenPanel.add(aanpassenKlant);
        interactiePanel.add(gevondenKlantenPanel);
    }
    public void initTable(java.util.List<Klant> klantList){
        String[] headers = {"Rijksregister", "Voornaam", "Achternaam", "Adres", "Postcode", "Stad"};
        klantData = new String[klantList.size()][6];

        for (int row = 0; row < klantList.size(); row++) {
            for (int col = 0; col < 6; col++) {
                Klant klant = klantList.get(row);
                switch (col) {
                    case 0:
                        klantData[row][col] = klant.getRijksregisterNummer();
                        break;
                    case 1:
                        klantData[row][col] = klant.getVoornaam();
                        break;
                    case 2:
                        klantData[row][col] = klant.getAchternaam();
                        break;
                    case 3:
                        klantData[row][col] = klant.getAdres();
                        break;
                    case 4:
                        klantData[row][col] = Integer.toString(klant.getPostcode());
                        break;
                    case 5:
                        klantData[row][col] = klant.getStad();
                        break;
                }
            }
        }

        klantTable = new JTable(klantData, headers);
    }
    public void klantNotFound(){
        JOptionPane.showMessageDialog(null, "Klant is niet gevonden");
    }
    public void klantUpdateSucceed(){
        JOptionPane.showMessageDialog(null, "Klant is geupdate");
    }
    public void klantUpdateFailure(){
        JOptionPane.showMessageDialog(null, "Er is iets misgelopen tijdens het updaten.");
    }
}
