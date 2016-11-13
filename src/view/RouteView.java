package view;

import model.Route;

/**
 * Created by Rik Van Belle on 01/11/2016.
 */
public class RouteView extends StandardView {
    public RouteView(String titel, boolean haveButton){
        super(titel, haveButton);
        getStandardButton().setText("RouteView");
    }

    public void showRoute(Route route){

    }
}
