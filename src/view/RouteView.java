package view;

import model.Traject;

import javax.swing.*;
import java.awt.*;
import java.util.List;
/**
 * Created by Rik Van Belle on 01/11/2016.
 */
public class RouteView extends StandardView {
    private JPanel routePanel = new JPanel();

    private JLabel datumLabel = new JLabel("Datum: ");
    private JTextField datum = new JTextField();
    private JLabel vertrekLabel = new JLabel("Vertrek: ");
    private JComboBox vertrekStation = new JComboBox();
    private JComboBox bestemmingStation = new JComboBox();
    private JLabel bestemmingLabel = new JLabel("Bestemming: ");
    private JButton getRouteButton = new JButton("Opzoeken");

    public JComboBox getVertrekStationBox(){
        return vertrekStation;
    }
    public JComboBox getBestemmingStationBox(){
        return bestemmingStation;
    }
    public String getDatum(){
        return this.datum.getText();
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

    public RouteView(String titel){
        super(titel);
    }

    public void showRoute(){

        routePanel.setLayout(new GridLayout(4,2));

        routePanel.add(datumLabel);
        routePanel.add(datum);
        routePanel.add(vertrekLabel);
        routePanel.add(vertrekStation);
        routePanel.add(bestemmingLabel);
        routePanel.add(bestemmingStation);
        routePanel.add(getRouteButton);

        mainPanel.add(routePanel);
        addPath("Route opzoeken");

        showWindow();
    }

    public void showSearchedRoutes(List<Traject> trajectList){
        JFrame gevondenRoutes = new JFrame("Hallo");
        JPanel searchedRoutes = new JPanel();
        GridLayout layout = new GridLayout(trajectList.size(), 3);

        layout.setHgap(35);
        layout.setVgap(50);

        searchedRoutes.setLayout(layout);
        for(int i = 0; i < trajectList.size();i++){
            JLabel vertrekStation = new JLabel(trajectList.get(i).getVertrekStation());
            JLabel bestemmingStation = new JLabel(trajectList.get(i).getAankomstStation());
            JLabel aantalOverstappen = null;
            if (trajectList.get(i).getTransferstations() == null){
                aantalOverstappen = new JLabel("0");
            }
            else {
                aantalOverstappen = new JLabel(Integer.toString(trajectList.get(i).getTransferstations().size()));
            }

            //JLabel vertrekTijd = new JLabel(trajectList.get(i).getVertrekTijd());
            //JLabel aankomstTijd = new JLabel(trajectList.get(i).getAankomstTijd();

            searchedRoutes.add(vertrekStation);
            searchedRoutes.add(bestemmingStation);
            searchedRoutes.add(aantalOverstappen);
        }

        addPath(trajectList.get(0).getVertrekStation() + " - " + trajectList.get(0).getAankomstStation());
        mainPanel.add(searchedRoutes);
        showWindow();
    }

    public void showError(){
        JOptionPane.showMessageDialog(null, "Er is iets foutgelopen bij het opzoeken van de route!");
    }
}
