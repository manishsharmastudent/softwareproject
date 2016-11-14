package controller;

import view.HomeView;

/**
 * Created by Rik Van Belle on 11/11/2016.
 */
public class MainController {
    HomeView home;

    public void showHomeScreen(){
       home = new HomeView("Home", false);
    }
}
