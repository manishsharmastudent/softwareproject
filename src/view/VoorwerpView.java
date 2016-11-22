package view;

import model.Voorwerp;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Vector;

/**
 * Created by Rik Van Belle on 01/11/2016.
 */
public class VoorwerpView extends StandardView {
    JPanel voorwerpenPanel = new JPanel();
    JLabel treinLabel = new JLabel("Trein");
    JLabel stationLabel = new JLabel("Station");
    JLabel routeLabel = new JLabel("Route");
    JLabel voorwerpLabel = new JLabel("Voorwerp");
    JLabel kleurLabel = new JLabel("Kleur");
    JLabel typeLabel = new JLabel("Type");
    JLabel klantLabel = new JLabel("Klant");

    JTextField treinText = new JTextField();
    JComboBox stationComboBox = new JComboBox();
    JComboBox routeComboBox = new JComboBox();
    JTextField voorwerpText = new JTextField();
    JComboBox kleurComboBox = new JComboBox();
    JComboBox typeComboBox = new JComboBox();
    JComboBox klantComboBox = new JComboBox();

    JButton toevoegenVoorwerpButton = new JButton("Voorwerp toevoegen");


    public VoorwerpView(String titel){
        super(titel);
    }

    public JComboBox getStationComboBox(){
        return this.stationComboBox;
    }
    public JComboBox getRouteComboBox(){
        return routeComboBox;
    }
    public JComboBox getKleurComboBox(){
        return kleurComboBox;
    }
    public JComboBox getTypeComboBox(){
        return typeComboBox;
    }
    public JComboBox getKlantComboBox(){
        return klantComboBox;
    }

    public String getStation(){
        return this.stationComboBox.getSelectedItem().toString();
    }
    public int getTrein(){
        return Integer.parseInt(this.treinText.getText());
    }
    public String getRoute(){
        return routeComboBox.getSelectedItem().toString();
    }
    public String getVoorwerp(){
        return voorwerpText.getText();
    }
    public String getKleur(){ return kleurComboBox.getSelectedItem().toString();}
    public String getType(){ return typeComboBox.getSelectedItem().toString();}
    public String getKlant(){ return klantComboBox.getSelectedItem().toString();}
    public JButton getToevoegenVoorwerpButton(){
        return toevoegenVoorwerpButton;
    }

    public void showVoorwerp(Voorwerp voorwerp){

    }
    public void showVoorwerpen(Vector<Voorwerp> vw){
        for (int i = 0; i < vw.size();i++){
            voorwerpenPanel.add(new JLabel(vw.get(i).getVoorwerp()));
        }
        voorwerpenPanel.setVisible(true);
        showWindow();
    }
    public void showVoorwerpenToevoegen(){
        voorwerpenPanel.setLayout(new GridLayout(8,2));

        voorwerpenPanel.add(treinLabel);
        voorwerpenPanel.add(treinText);
        voorwerpenPanel.add(stationLabel);
        voorwerpenPanel.add(stationComboBox);
        voorwerpenPanel.add(routeLabel);
        voorwerpenPanel.add(routeComboBox);
        voorwerpenPanel.add(voorwerpLabel);
        voorwerpenPanel.add(voorwerpText);
        voorwerpenPanel.add(kleurLabel);
        voorwerpenPanel.add(kleurComboBox);
        voorwerpenPanel.add(typeLabel);
        voorwerpenPanel.add(typeComboBox);
        voorwerpenPanel.add(klantLabel);
        voorwerpenPanel.add(klantComboBox);
        voorwerpenPanel.add(toevoegenVoorwerpButton);

        mainPanel.add(voorwerpenPanel);

        path.add("Voorwerp toevoegen");
        showWindow();

    }
}
