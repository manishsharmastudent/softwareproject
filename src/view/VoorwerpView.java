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

    JTable overviewVoorwerpen = null;
    String[][] voorwerpenTable = null;

    JTextField treinText = new JTextField();
    JComboBox stationComboBox = new JComboBox();
    JComboBox routeComboBox = new JComboBox();
    JTextField voorwerpText = new JTextField();
    JComboBox kleurComboBox = new JComboBox();
    JComboBox typeComboBox = new JComboBox();
    JComboBox klantComboBox = new JComboBox();

    JButton toevoegenVoorwerpButton = new JButton("Voorwerp toevoegen");
    JButton zoekButtonNaam = new JButton("Zoeken");
    JButton voorwerpAfgehaald = new JButton("Afgehaald");

    public VoorwerpView(String titel){
        super(titel);
    }

    public JPanel getVoorwerpenPanel(){
        return this.voorwerpenPanel;
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
    public int getSelectedRow(){
        String[] voorwerp = voorwerpenTable[overviewVoorwerpen.getSelectedRow()];
        return Integer.parseInt(voorwerp[0]);
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
    public JButton getZoekButtonNaam(){return this.zoekButtonNaam; }
    public JButton getVoorwerpAfgehaald(){return this.voorwerpAfgehaald; }

    public void showVoorwerpenZoeken(){
        voorwerpenPanel.setLayout(new GridLayout(1,3));

        voorwerpenPanel.add(voorwerpLabel);
        voorwerpenPanel.add(voorwerpText);
        voorwerpenPanel.add(zoekButtonNaam);
        //voorwerpenPanel.add(typeLabel);
        //voorwerpenPanel.add(typeComboBox);

        mainPanel.add(voorwerpenPanel);
        addPath("Voorwerp zoeken");
        showWindow();
    }
    public void showVoorwerp(Voorwerp voorwerp){

    }
    public void showVoorwerpen(java.util.List<Voorwerp> voorwerpen){
        initTable(voorwerpen);
        voorwerpenPanel.setLayout(new GridLayout(2,1));
        JScrollPane scrollPane = new JScrollPane(overviewVoorwerpen);
        voorwerpenPanel.add(scrollPane);
        mainPanel.add(voorwerpenPanel);
        mainPanel.add(voorwerpAfgehaald);
        deleteLastInPath();
        deleteLastInPath();
        addPath("Overzicht voorwerpen");
        showWindow();
    }
    public void showVoorwerpenToevoegen(){
        voorwerpenPanel.setLayout(new GridLayout(7,2));

        voorwerpenPanel.add(treinLabel);
        voorwerpenPanel.add(treinText);
        //voorwerpenPanel.add(stationLabel);
        //voorwerpenPanel.add(stationComboBox);
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
    public void geenVoorwerpenGevonden(){
        JOptionPane.showMessageDialog(null, "Er zijn geen voorwerpen gevonden met dit zoekcriteria");
    }
    public void initTable(java.util.List<Voorwerp> voorwerpen) {
        String[] headers = {"ID", "Voorwerp", "Trein", "Route", "Voorwerp type", "Kleur", "Klant"};
        voorwerpenTable = new String[voorwerpen.size()][7];

        for (int row = 0; row < voorwerpen.size(); row++) {
            for (int col = 0; col < 6; col++) {
                Voorwerp vw = voorwerpen.get(row);
                switch (col) {
                    case 0:
                        voorwerpenTable[row][col] = Integer.toString(vw.getVoorwerpId());
                        break;
                    case 1:
                        voorwerpenTable[row][col] = vw.getVoorwerp();
                        break;
                    case 2:
                        voorwerpenTable[row][col] = Integer.toString(vw.getTrein());
                        break;
                    case 3:
                        voorwerpenTable[row][col] = vw.getRoute().getRouteVertrek().getNaam() + "-" + vw.getRoute().getRouteBestemming().getNaam();
                        break;
                    case 4:
                        voorwerpenTable[row][col] = vw.getType();
                        break;
                    case 5:
                        voorwerpenTable[row][col] = vw.getKleur();
                        break;
                    case 6:
                        voorwerpenTable[row][col] = vw.getKlant().getVoornaam() + " " + vw.getKlant().getAchternaam();
                        break;
                }
            }
        }

        overviewVoorwerpen = new JTable(voorwerpenTable, headers);
    }
    public void showSucceed(int id){
        JOptionPane.showMessageDialog(null, "Voorwerp met id: " + id + " is verwijderd");
    }
    public void showError(int id){
        JOptionPane.showMessageDialog(null, "Er is iets foutgelopen bij het verwijderen van voorwerp met id: " + id + ".");
    }
}
