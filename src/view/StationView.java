package view;

import model.Station;

/**
 * Created by Rik Van Belle on 01/11/2016.
 */
public class StationView extends StandardView {
    public StationView(String titel){
        super(titel);
        getStandardButton().setText("StationView");
    }
    public void showStation(Station station){

    }
}
