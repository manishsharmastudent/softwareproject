package model;

import java.time.LocalDateTime;
import java.util.List;
/**
 * Created by Nofel on 02-11-16.
 */
public class Traject {

    private String vertrekStation;
    private String aankomstStation;
    private boolean cancelled;
    private int platform;
    private LocalDateTime Arrival;
    private LocalDateTime ActualArrival;
    private LocalDateTime Departure;
    private LocalDateTime ActualDeparture;
    private int arrivalPlatform;
    private int departurePlatform;
    private List<Trein> treinen;

    public Traject(){}

    public Traject(String vertrekStation, String aankomstStation, int platform) {
        this.vertrekStation = vertrekStation;
        this.aankomstStation = aankomstStation;
        this.platform = platform;
    }

    public boolean isCancelled() {
        return cancelled;
    }

    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }

    public void setVetrekStation(String station) {
        this.vertrekStation = station;
    }

    public void setAankomstStation(String station) {
        this.aankomstStation = station;
    }

    public String getVertrekStation() {
        return vertrekStation;
    }

    public String getAankomstStation() {
        return aankomstStation;
    }

    public int getPlatform() {
        return platform;
    }

    public void setPlatform(int platform) {
        this.platform = platform;
    }

    public LocalDateTime getArrival() {
        return Arrival;
    }

    public void setArrival(LocalDateTime arrival) {
        Arrival = arrival;
    }

    public LocalDateTime getActualArrival() {
        return ActualArrival;
    }

    public void setActualArrival(LocalDateTime actualArrival) {
        ActualArrival = actualArrival;
    }

    public LocalDateTime getDeparture() {
        return Departure;
    }

    public void setDeparture(LocalDateTime departure) {
        Departure = departure;
    }

    public LocalDateTime getActualDeparture() {
        return ActualDeparture;
    }

    public void setActualDeparture(LocalDateTime actualDeparture) {
        ActualDeparture = actualDeparture;
    }

    public int getArrivalPlatform() {
        return arrivalPlatform;
    }

    public void setArrivalPlatform(int arrivalPlatform) {
        this.arrivalPlatform = arrivalPlatform;
    }

    public int getDeparturePlatform() {
        return departurePlatform;
    }

    public void setDeparturePlatform(int departurePlatform) {
        this.departurePlatform = departurePlatform;
    }

    public List<Trein> getTreinen() {
        return treinen;
    }

    public void setTreinen(List<Trein> treinen) {
        this.treinen = treinen;
    }
}
