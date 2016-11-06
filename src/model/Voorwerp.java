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

    public Trein getTrein() {
        return trein;
    }

    public void setTrein(Trein trein) {
        this.trein = trein;
    }

    public String getKleur() {
        return kleur;
    }

    public void setKleur(String kleur) {
        this.kleur = kleur;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }
}
