package view;

import model.Traject;
import model.Route;
import javax.swing.*;
import java.awt.*;
import java.time.format.DateTimeFormatter;
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

    public JPanel getRoutePanel(){ return this.routePanel; }
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

        interactiePanel.add(routePanel);
        addPath("Route opzoeken");

        showWindow();
    }

    public void showSearchedRoutes(List<Traject> trajectList){
        JPanel searchedRoutes = new JPanel();
        GridLayout layout = new GridLayout(trajectList.size(), 5);

        layout.setHgap(35);
        layout.setVgap(50);

        searchedRoutes.setLayout(layout);
        for(int i = 0; i < trajectList.size();i++){
            JLabel vertrekStation = new JLabel(trajectList.get(i).getVertrekStation());
            JLabel bestemmingStation = new JLabel(trajectList.get(i).getAankomstStation());
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
            String tijd = trajectList.get(i).getAankomstTijd().format(formatter);
            JLabel vertrekTijd = new JLabel(tijd);
            tijd = trajectList.get(i).getVertrekTijd().format(formatter);
            JLabel aankomstTijd = new JLabel(tijd);
            JLabel aantalOverstappen = null;
            if (trajectList.get(i).getTransferstations() == null){
                aantalOverstappen = new JLabel("0");
            }
            else {
                aantalOverstappen = new JLabel(Integer.toString(trajectList.get(i).getTransferstations().size()));
            }


            searchedRoutes.add(vertrekStation);
            searchedRoutes.add(bestemmingStation);
            searchedRoutes.add(vertrekTijd);
            searchedRoutes.add(aankomstTijd);
            searchedRoutes.add(aantalOverstappen);
        }

        addPath(trajectList.get(0).getVertrekStation() + " - " + trajectList.get(0).getAankomstStation());
        interactiePanel.removeAll();
        interactiePanel.add(searchedRoutes);
        interactiePanel.updateUI();
    }

    public void showError(){
        JOptionPane.showMessageDialog(null, "Er is iets foutgelopen bij het opzoeken van de route!");
    }
}
