package view;

import com.sun.xml.internal.bind.api.impl.NameConverter;
import model.Klant;

import javax.swing.*;
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
    private JLabel voornaamLabel = new JLabel("Voornaam");
    private JLabel achternaamLabel = new JLabel("Achternaam");
    private JLabel rijksregisterNummerLabel = new JLabel("Rijksregister-nummer");
    private JLabel adresLabel = new JLabel("Adres");
    private JLabel postcodeLabel = new JLabel("Postcode");
    private JLabel stadLabel = new JLabel("Stad");

    private JTextField voornaamText = new JTextField();
    private JTextField achternaamText = new JTextField();
    private JTextField rijksregisterNummerText = new JTextField();
    private JTextField adresText = new JTextField();
    private JTextField postcodeText = new JTextField();
    private JTextField stadText = new JTextField();

    private JButton klantToevoegenButton = new JButton("Klant toevoegen");

    public KlantView(String titel){
        super(titel);
    }

    /*private JTextField voornaamText = new JTextField();
    private JTextField achternaamText = new JTextField();
    private JTextField rijksregisterNummerText = new JTextField();
    private JTextField adresText = new JTextField();
    private JTextField postcodeText = new JTextField();
    private JTextField stadText = new JTextField();

    private JButton klantToevoegenButton = new JButton("Klant toevoegen");*/

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

    public void showKlant(Klant klant){
        //JTextField voornaam = new JTextField(klant.getVoornaam());
        JLabel voornaam = new JLabel(klant.getVoornaam());
        JLabel achternaam = new JLabel(klant.getAchternaam());
        JLabel rijksregisterNummer = new JLabel(klant.getRijksregisterNummer());
        JTextField text = new JTextField();

        getWindow().setVisible(true);
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

        mainPanel.add(klantPanel);

        path.add("Klant Toevoegen");
        showWindow();
    }

}
