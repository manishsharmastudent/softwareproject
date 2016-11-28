package model;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;

/**
 * Created by Nofel on 02-11-16.
 */
public class Traject {

    private String vertrekStation;
    private String aankomstStation;
    private LocalDateTime vertrekTijd;
    private LocalDateTime actualVertrekTijd;
    private LocalDateTime aankomstTijd;
    private LocalDateTime actualAankomstTijd;
    private Duration duur;
    private boolean cancelled;
    private List<String> transferstations;
    private List<Trein> treinen;
    private double aantalKilometers;

    public Traject(){}

    public Traject(String vertrekStation, String aankomstStation) {
        this.vertrekStation = vertrekStation;
        this.aankomstStation = aankomstStation;
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

    public List<Trein> getTreinen() {
        return treinen;
    }

    public void setTreinen(List<Trein> treinen) {
        this.treinen = treinen;
    }

    public void setVertrekStation(String vertrekStation) {
        this.vertrekStation = vertrekStation;
    }

    public List<String> getTransferstations() {
        return transferstations;
    }

    public void setTransferstations(List<String> transferstations) {
        this.transferstations = transferstations;
    }

    public void setTransferstations(String transferstation) {
        if(transferstations == null)
            transferstations = new ArrayList<String>();
        transferstations.add(transferstation);
    }

    public LocalDateTime getVertrekTijd() {
        return vertrekTijd;
    }

    public void setVertrekTijd(LocalDateTime vetrekTijd) {
        this.vertrekTijd = vetrekTijd;
    }

    public LocalDateTime getAankomstTijd() {
        return aankomstTijd;
    }

    public void setAankomstTijd(LocalDateTime aankomstTijd) {
        this.aankomstTijd = aankomstTijd;
    }

    public Duration getDuur() {
        return duur;
    }

    public void setDuur(Duration duur) {
        this.duur = duur;
    }

    public LocalDateTime getActualVertrekTijd() {
        return actualVertrekTijd;
    }

    public void setActualVertrekTijd(LocalDateTime actualVertrekTijd) {
        this.actualVertrekTijd = actualVertrekTijd;
    }

    public LocalDateTime getActualAankomstTijd() {
        return actualAankomstTijd;
    }

    public void setActualAankomstTijd(LocalDateTime actualAankomstTijd) {
        this.actualAankomstTijd = actualAankomstTijd;
    }

    public double getAantalKilometers(){
        return this.aantalKilometers;
    }
    public void setAantalKilometers(double kilometers){
        this.aantalKilometers = kilometers;
    }
    @Override
    public String toString() {
        String s = "Traject: van " + vertrekStation +
                " tot " + aankomstStation + ". \n" +
                "Routes:";

        for (Trein e:treinen) {
            if(treinen.indexOf(e) > 0)
            s += "Transfer at: "+transferstations.get(treinen.indexOf(e) - 1 ) + '\n';
            s += e.toString() + '\n';
        }

        return s;
    }
}
