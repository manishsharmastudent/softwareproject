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
    public KlantView(String titel, boolean haveButton){
        super(titel, haveButton);
    }

    public void showKlant(Klant klant){
        //JTextField voornaam = new JTextField(klant.getVoornaam());
        JLabel voornaam = new JLabel(klant.getVoornaam());
        JLabel achternaam = new JLabel(klant.getAchternaam());
        JLabel rijksregisterNummer = new JLabel(klant.getRijksregisterNummer());
        JTextField text = new JTextField();

        getWindow().setVisible(true);
    }
}
