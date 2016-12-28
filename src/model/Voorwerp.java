package model;

/**
 * Created by Manish on 29/10/2016.
 */
public class Voorwerp {
    private int voorwerpId;
    private int trein;
    private String kleur;
    private String type;
    private String voorwerpstr;
    private Station vertrekStation;
    private Station bestemmingStation;
    private Klant klant;
    private boolean active;


    public Voorwerp() {}
    public Voorwerp(int voorwerpId, int trein, String kleur, String type, String voorwerpstr, Station vertrekStation, Station bestemmingStation, Klant klant, boolean active) {
        this.voorwerpId = voorwerpId;
        this.trein = trein;
        this.kleur = kleur;
        this.type = type;
        this.voorwerpstr = voorwerpstr;
        this.vertrekStation = vertrekStation;
        this.bestemmingStation = bestemmingStation;
        this.klant = klant;
        this.active = active;
    }

    public String getVoorwerpstr() {
        return voorwerpstr;
    }
    public void setVoorwerpstr(String voorwerpstr) {
        this.voorwerpstr = voorwerpstr;
    }
    public int getVoorwerpId() {
        return this.voorwerpId;
    }
    public void setVoorwerpId(int voorwerpId) { this.voorwerpId = voorwerpId;}
    public int getTrein() {
        return trein;
    }
    public void setTrein(int trein) {
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
    public String getVoorwerp() {
        return voorwerpstr;
    }
    public void setVoorwerp(String voorwerpstr) {
        this.voorwerpstr = voorwerpstr;
    }
    public Station getVertrekStation() {
        return this.vertrekStation;
    }
    public void setVertrekStation(Station station) {
        this.vertrekStation = station;
    }
    public Station getBestemmingStation(){return this.bestemmingStation;}
    public void setBestemmingStation(Station station){this.bestemmingStation = station;}
    public Klant getKlant() {
        return klant;
    }
    public void setKlant(Klant klant) {
        this.klant = klant;
    }
    public boolean getActive() {
        return active;
    }
    public void setActive(boolean active) {
        this.active = active;
    }
}
