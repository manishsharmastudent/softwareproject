package model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Manish on 29/10/2016.
 */
public class Station implements Serializable{
    private int stationId;
    private String naam;
    private String naamFrans;
    private String naamAfkorting;
    private String stad;
    private List<Trein> treinen;
    private boolean active;

    public Station(int stationId, String naam, String frans, String afk, String stad) {
        this.stationId = stationId;
        this.naam = naam;
        this.naamFrans = frans;
        this.naamAfkorting = afk;
        this.stad = stad;
    }
    public Station() {}
    public boolean getActive() {
        return this.active;
    }
    public void setActive(boolean active){
        this.active = active;
    }
    public int getStationId() {
        return stationId;
    }
    public void setStationId(int stationId){
        this.stationId = stationId;
    }
    public String getNaamFrans(){return naamFrans; }
    public void setNaamFrans(String naam){ this.naamFrans = naam;}
    public String getNaamAfkorting(){return naamAfkorting; }
    public void setNaamAfkorting(String naam){this.naamAfkorting = naam;}
    public String getNaam() {
        return naam;
    }
    public void setNaam(String naam) {
        this.naam = naam;
    }
    public List<Trein> getTreinen() {
        return treinen;
    }
    public void setTreinen(List<Trein> treinen) {
        this.treinen = treinen;
    }
}
