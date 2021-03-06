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
    private GridBagConstraints c = new GridBagConstraints();
    JPanel voorwerpenPanel = new JPanel();
    JLabel vertrekStationLabel = new JLabel("Vertrek");
    JLabel bestemmingStationLabel = new JLabel("Bestemming");
    JLabel voorwerpLabel = new JLabel("Voorwerp");
    JLabel kleurLabel = new JLabel("Kleur");
    JLabel typeLabel = new JLabel("Type");
    JLabel klantLabel = new JLabel("Klant");

    JTable overviewVoorwerpen = null;
    String[][] voorwerpenTable = null;

    JComboBox vertrekStationComboBox = new JComboBox();
    JComboBox bestemmingStationComboBox = new JComboBox();
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
        c.insets = new Insets(10, 20 , 1 ,20);
        c.fill = GridBagConstraints.HORIZONTAL;
    }

    public JPanel getVoorwerpenPanel(){
        return this.voorwerpenPanel;
    }

    public JComboBox getVertrekStationComboBox(){
        return this.vertrekStationComboBox;
    }
    public JComboBox getBestemmingStationComboBox(){
        return this.bestemmingStationComboBox;
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

    public int getVertrekStationIndex(){
        return vertrekStationComboBox.getSelectedIndex();
    }
    public int getBestemmingStationIndex(){
        return bestemmingStationComboBox.getSelectedIndex();
    }
    public String getRoute(){
        return routeComboBox.getSelectedItem().toString();
    }
    public String getVoorwerp(){
        return voorwerpText.getText();
    }
    public String getKleur(){ return kleurComboBox.getSelectedItem().toString();}
    public String getType(){ return typeComboBox.getSelectedItem().toString();}
    public int getKlantIndex(){ return klantComboBox.getSelectedIndex()-1; }
    public JButton getToevoegenVoorwerpButton(){
        return toevoegenVoorwerpButton;
    }
    public JButton getZoekButtonNaam(){return this.zoekButtonNaam; }
    public JButton getVoorwerpAfgehaald(){return this.voorwerpAfgehaald; }

    public void showVoorwerpenZoeken(){
        voorwerpenPanel.setLayout(new GridBagLayout());

        c.gridy = 0;
        c.gridx = 0;
        voorwerpenPanel.add(voorwerpLabel, c);

        voorwerpText.setPreferredSize(new Dimension(110,25));
        voorwerpText.setMinimumSize(voorwerpText.getPreferredSize());
        voorwerpText.setMaximumSize(voorwerpText.getPreferredSize());
        c.gridx =1;
        voorwerpenPanel.add(voorwerpText, c);
        c.gridx = 2;
        voorwerpenPanel.add(zoekButtonNaam, c);

        interactiePanel.add(voorwerpenPanel);
        addPath("Voorwerp zoeken");
        showWindow();
    }
    public void showVoorwerpen(java.util.List<Voorwerp> voorwerpen){
        initTable(voorwerpen);
        voorwerpenPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5,5,5,5);

        JScrollPane scrollPane = new JScrollPane(overviewVoorwerpen);
        c.gridx = 0;
        c.gridy = 0;
        voorwerpenPanel.add(scrollPane, c);

        c.fill = GridBagConstraints.NONE;

        c.gridy = 1 ;
        voorwerpAfgehaald.setHorizontalAlignment(0);
        voorwerpenPanel.add(voorwerpAfgehaald, c);
        interactiePanel.add(voorwerpenPanel);
        deleteLastInPath();
        deleteLastInPath();
        addPath("Overzicht voorwerpen");
        showWindow();
    }
    public void showVoorwerpenToevoegen(){
        voorwerpenPanel.setLayout(new GridLayout(7,2));

        voorwerpenPanel.add(vertrekStationLabel);
        voorwerpenPanel.add(vertrekStationComboBox);
        voorwerpenPanel.add(bestemmingStationLabel);
        voorwerpenPanel.add(bestemmingStationComboBox);
        voorwerpenPanel.add(voorwerpLabel);
        voorwerpenPanel.add(voorwerpText);
        voorwerpenPanel.add(kleurLabel);
        voorwerpenPanel.add(kleurComboBox);
        voorwerpenPanel.add(typeLabel);
        voorwerpenPanel.add(typeComboBox);
        voorwerpenPanel.add(klantLabel);
        voorwerpenPanel.add(klantComboBox);
        voorwerpenPanel.add(toevoegenVoorwerpButton);

        interactiePanel.add(voorwerpenPanel);

        path.add("Voorwerp toevoegen");
        showWindow();

    }
    public void geenVoorwerpenGevonden(){
        JOptionPane.showMessageDialog(null, "Er zijn geen voorwerpen gevonden met dit zoekcriteria");
    }
    public void initTable(java.util.List<Voorwerp> voorwerpen) {
        String[] headers = {"ID", "Voorwerp", "Route", "Voorwerp type", "Kleur", "Klant"};
        voorwerpenTable = new String[voorwerpen.size()][7];

        for (int row = 0; row < voorwerpen.size(); row++) {
            for (int col = 0; col < 5; col++) {
                Voorwerp vw = voorwerpen.get(row);
                switch (col) {
                    case 0:
                        voorwerpenTable[row][col] = Integer.toString(vw.getVoorwerpId());
                        break;
                    case 1:
                        voorwerpenTable[row][col] = vw.getVoorwerp();
                        break;
                    case 2:
                        voorwerpenTable[row][col] = vw.getVertrekStation().getNaam() + "-" + vw.getBestemmingStation().getNaam();
                        break;
                    case 3:
                        voorwerpenTable[row][col] = vw.getType();
                        break;
                    case 4:
                        voorwerpenTable[row][col] = vw.getKleur();
                        break;
                    case 5:
                        voorwerpenTable[row][col] = vw.getKlant().getVoornaam() + " " + vw.getKlant().getAchternaam();
                        break;
                }
            }
        }

        overviewVoorwerpen = new JTable(voorwerpenTable, headers){
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
    }
    public void showSucceed(int id){
        JOptionPane.showMessageDialog(null, "Voorwerp met id: " + id + " is verwijderd");
    }
    public void showError(int id){
        JOptionPane.showMessageDialog(null, "Er is iets foutgelopen bij het verwijderen van voorwerp met id: " + id + ".");
    }
    public void addVoorwerpSucceed(String voorwerp){
        JOptionPane.showMessageDialog(null, "Voorwerp " + voorwerp + " is toegevoegd!");
    }
    public void addVoorwerpFailed(){
        JOptionPane.showMessageDialog(null, "Er is iets foutgelopen bij het toevoegen van het voorwerp.");
    }
}
