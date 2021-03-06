package view;

import model.Traject;
import model.Route;
import model.Trein;

import javax.swing.*;
import java.awt.*;
import java.time.format.DateTimeFormatter;
import java.util.List;
/**
 * Created by Rik Van Belle on 01/11/2016.
 */
public class RouteView extends StandardView {
    private JPanel routePanel = new JPanel();

    private JLabel vertrekLabel = new JLabel("Vertrek: ");
    private JComboBox vertrekStation = new JComboBox();
    private JComboBox bestemmingStation = new JComboBox();
    private JLabel bestemmingLabel = new JLabel("Bestemming: ");
    private JButton getRouteButton = new JButton("Opzoeken");
    private JButton moreInfoButton = new JButton("Meer info over geselecteerde route");
    JTable trajectTable = null;
    String[][] dataTraject = null;

    public JComboBox getVertrekStationBox(){
        return vertrekStation;
    }
    public JComboBox getBestemmingStationBox(){
        return bestemmingStation;
    }
    public String getVertrekStation(){
        return vertrekStation.getSelectedItem().toString();
    }
    public String getBestemmingStation(){
        return this.bestemmingStation.getSelectedItem().toString();
    }
    public JButton getRouteButton(){
        return getRouteButton;
    }
    public JButton getMoreInfoButton(){return moreInfoButton;}
    public RouteView(String titel){
        super(titel);
    }

    public void showRoute(){

        routePanel.setLayout(new GridLayout(3,2));

        routePanel.add(vertrekLabel);
        routePanel.add(vertrekStation);
        routePanel.add(bestemmingLabel);
        routePanel.add(bestemmingStation);
        routePanel.add(getRouteButton);

        interactiePanel.add(routePanel);
        addPath("Route opzoeken");

        showWindow();
    }
    public void showSearchedRoutes(List<Traject> trajectList){
        initTable(trajectList);
        JScrollPane scrollPane = new JScrollPane(trajectTable);

        addPath(trajectList.get(0).getVertrekStation() + " - " + trajectList.get(0).getAankomstStation());
        interactiePanel.removeAll();
        interactiePanel.add(scrollPane);
        //interactiePanel.add(moreInfoButton);
        interactiePanel.updateUI();
    }
    public void showGeenGeldigeRoute(){
        JOptionPane.showMessageDialog(null, "Geen geldige route gevonden");
    }
    public void initTable(java.util.List<Traject> trajectList){
        String[] headers = {"Vertrek", "Bestemming", "Vertrektijd", "Aankomstijd", "Aantal overstappen"};
        dataTraject = new String[trajectList.size()][5];

        for (int row = 0; row < trajectList.size(); row++) {
            for (int col = 0; col < 6; col++) {
                Traject trj = trajectList.get(row);
                switch (col) {
                    case 0:
                        dataTraject[row][col] = trj.getVertrekStation();
                        break;
                    case 1:
                        dataTraject[row][col] = trj.getAankomstStation();
                        break;
                    case 2:
                        dataTraject[row][col] = trj.getVertrekTijd().toString();
                        break;
                    case 3:
                        dataTraject[row][col] = trj.getAankomstTijd().toString();
                        break;
                    case 4:
                        if(trj.getTransferstations() == null){
                            dataTraject[row][col] = "0";
                        }
                        else { dataTraject[row][col] = Integer.toString(trj.getTransferstations().size());}
                        break;
                }
            }
        }

        trajectTable = new JTable(dataTraject, headers){
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
    }
    public void showError(){
        JOptionPane.showMessageDialog(null, "Er is iets foutgelopen bij het opzoeken van de route!");
    }
}

