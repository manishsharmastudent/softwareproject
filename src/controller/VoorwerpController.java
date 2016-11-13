package controller;

import model.Voorwerp;
import model.Trein;
import model.Route;
import model.Station;
import view.VoorwerpView;
/**
 * Created by Robbe on 06/11/2016.
 */
public class VoorwerpController {
    private Voorwerp voorwerpModel;
    private VoorwerpView voorwerpView;

    public VoorwerpController(Voorwerp voorwerp, VoorwerpView voorwerpView){
        this.voorwerpModel = voorwerp;
        this.voorwerpView = voorwerpView;
    }


    public int getVoorwerpId(){ return voorwerpModel.getVoorwerpId(); }
    public String getKleur(){ return voorwerpModel.getKleur(); }
    public String getType(){ return voorwerpModel.getType(); }
    public Route getRoute(){ return voorwerpModel.getRoute(); }
    public Station getStation(){ return voorwerpModel.getStation(); }

    public void setVoorwerpId(int voorwerpid){ voorwerpModel.setVoorwerpId(voorwerpid); }
    public void setKleur(String kleur){ voorwerpModel.setKleur(kleur); }
    public void setType(String type){ voorwerpModel.setType(type); }
    public void setRoute(Route route){ voorwerpModel.setRoute(route); }
    public void setStation(Station station){ voorwerpModel.setStation(station); }

    public void showVoorwerp(Voorwerp voorwerp){ voorwerpView.showVoorwerp(voorwerp);}
}
