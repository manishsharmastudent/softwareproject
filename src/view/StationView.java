package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Rik Van Belle on 01/11/2016.
 */
public class StationView extends StandardView {
    HomeView homeView = new HomeView("Homescreen");
    private JLabel naamLabel = new JLabel("Naam: ");
    private JLabel stadLabel = new JLabel("Stad: ");
    private JButton toevoegButton = new JButton("Toevoegen");
    private JTextField naamText = new JTextField();
    private JTextField stadText = new JTextField();

    public StationView(String titel){
        super(titel);
    }

    public JButton getToevoegButton(){
        return this.toevoegButton;
    }

    public String getNaamText(){
        return this.naamText.getText();
    }

    public String getStadText(){
        return this.stadText.getText();
    }

    public void showVoegStationToe(){

        interactiePanel.setLayout(null);
        naamLabel.setBounds(30,140,180,25);
        naamText.setBounds(200,140,180,25);
        stadLabel.setBounds(30, 180, 180, 25);
        stadText.setBounds(200, 180, 180, 25);
        toevoegButton.setBounds(30, 220, 180, 25);

        interactiePanel.add(naamLabel);
        interactiePanel.add(naamText);
        interactiePanel.add(stadLabel);
        interactiePanel.add(stadText);
        interactiePanel.add(toevoegButton);

        addPath("Station toevoegen");

        showWindow();
    }
}
