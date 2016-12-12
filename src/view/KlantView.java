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

    private JTextField voornaamText = new JTextField();
    private JTextField achternaamText = new JTextField();
    private JTextField rijksregisterNummerText = new JFormattedTextField(createFormatter("##.##.##-###.##"));
    private JTextField adresText = new JTextField();
    private JTextField postcodeText = new JFormattedTextField(createFormatter("####"));
    private JTextField stadText = new JTextField();

    private JButton searchButtonRijksregisterNummer = new JButton("Zoeken");
    private JButton searchButtonSurname = new JButton("Zoeken");
    private JButton searchButtonLastname = new JButton("Zoeken");
    private JButton klantToevoegenButton = new JButton("Klant toevoegen");

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

    public JButton getKlantToevoegenButton(){
        return this.klantToevoegenButton;
    }
    public JButton getSearchButtonSurname(){ return this.searchButtonSurname; }
    public JButton getSearchButtonLastname(){ return this.searchButtonLastname; }
    public JButton getSearchButtonRijksregisterNummer(){ return this.searchButtonRijksregisterNummer; }

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

        mainPanel.add(klantPanel);

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

        mainPanel.add(klantPanel);
        addPath("Klant zoeken");
        showWindow();
    }
    public void showKlanten(List<Klant> klanten){
        gevondenKlantenPanel.setLayout(new GridLayout(klanten.size(), 1));
        for (int i = 0;i < klanten.size();i++){
            gevondenKlantenPanel.add(new JLabel(klanten.get(i).getVoornaam() + " " + klanten.get(i).getAchternaam()));
        }
       klantPanel.add(gevondenKlantenPanel);
    }
}
