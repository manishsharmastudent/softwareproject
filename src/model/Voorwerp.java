package model;

/**
 * Created by Manish on 29/10/2016.
 */
public class Voorwerp {
    private int voorwerpId;
    private Trein trein;
    private String kleur;
    private String type;
    private Route route;
    private Station station;

    public Voorwerp(Trein trein, Station station, Route route, String type, String kleur) {
        this.trein = trein;
        this.station = station;
        this.route = route;
        this.type = type;
        this.kleur = kleur;
    }

    public Voorwerp() {
    }

    public int getVoorwerpId(){return voorwerpId; }
    public Trein getTrein() {
        return trein;
    }
    public String getKleur() {
        return kleur;
    }
    public String getType() {
        return type;
    }
    public Route getRoute() {
        return route;
    }
    public Station getStation() {
        return station;
    }

    public void setVoorwerpId(int voorwerpId){this.voorwerpId = voorwerpId; }
    public void setTrein(Trein trein) {
        this.trein = trein;
    }
    public void setKleur(String kleur) {
        this.kleur = kleur;
    }
    public void setType(String type) {
        this.type = type;
    }
    public void setRoute(Route route) {
        this.route = route;
    }
    public void setStation(Station station) {
        this.station = station;
    }
}
