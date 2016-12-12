package controller;

import hibernate.ManageStation;
import model.Liveboard;
import model.Station;
import view.StationView;
import controller.ParseController;

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
                if (stationManage.addStation(station) > 0){
                    JOptionPane.showMessageDialog(stationView.getWindow(), "Station " + station.getNaam() + " is toegevoegd!");
                    backToHomeScreen();
                }
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
    public void showSearchLiveboard(){
        stationView.showSearchLiveboard();
        searchLiveBoard();
    }
    public void searchLiveBoard(){
        stationView.getZoekLiveboardButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    System.out.println(stationView.getStadText());
                    Liveboard liveboard = ParseController.getStationBoard(stationView.getStadText());
                    stationView.showLiveboard(liveboard);
            }
        });
    }

}
