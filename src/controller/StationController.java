package controller;

import hibernate.ManageStation;
import model.Station;
import view.StationView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Rik Van Belle on 14/11/2016.
 */
public class StationController {
    private Station stationModel;
    private StationView stationView;
    private ManageStation stationManage;

    public StationController(){
        stationModel = new Station();
        stationView = new StationView("Station");
        stationManage = new ManageStation();
    }
    public StationView getView(){
        return this.stationView;
    }
    public void showToevoegenStation(){
        stationView.showVoegStationToe();
        clickToevoegenStation();
        terugButton();
    }
    public void clickToevoegenStation(){
        final Station station = new Station();
        stationView.getToevoegButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
<<<<<<< HEAD
<<<<<<< HEAD
              //  Station station = new Station(0, "Station " + stationView.getNaamText(), stationView.getStadText(),true);
              /*  if (stationManage.addStation(station) > 0){
=======
=======
>>>>>>> origin/Rik
                if (stationManage.addStation(station) > 0){
>>>>>>> origin/Rik
                    JOptionPane.showMessageDialog(stationView.getWindow(), "Station " + station.getNaam() + " is toegevoegd!");
                    backToHomeScreen();
                };*/
            }
        });
    }
    public void terugButton(){
        stationView.getTerugButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                backToHomeScreen();
            }
        });
    }
    public void backToHomeScreen(){
        stationView.getWindow().setVisible(false);
        stationView.getWindow().dispose();
        stationView.deleteLastInPath();
        new MainController().showHomeScreen();
    }
}
