package model;

/**
 * Created by Manish on 29/10/2016.
 */
public class Station {
    private int stationId;
    private String naam;
    private String stad;
    private boolean active;

    public Station(int stationId, String naam, String stad, boolean active) {
        this.stationId = stationId;
        this.naam = naam;
        this.stad = stad;
        this.active = active;
    }

    public Station() {
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getStationId() {
        return stationId;
    }

    public void setStationId(int stationId){
     this.stationId = stationId;
    }

    public String getStad() {
        return stad;
    }

    public void setStad(String stad) {
        this.stad = stad;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }
}
