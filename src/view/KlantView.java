package view;

import com.sun.xml.internal.bind.api.impl.NameConverter;
import model.Klant;

import javax.swing.*;

/**
 * Created by Rik Van Belle on 01/11/2016.
 */
public class KlantView extends StandardView {
    public KlantView(String titel, boolean haveButton){
        super(titel, haveButton);
        standardButton.setText("Klant view");
    }

    public void showKlant(Klant klant){
        JTextField voornaam = new JTextField(klant.getVoornaam());
        content.add(voornaam);
        window.setVisible(true);
    }
}
