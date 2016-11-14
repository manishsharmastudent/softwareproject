package model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by Nofel on 02-11-16.
 */
public class Traject {

    private String vertrekStation;
    private String aankomstStation;
    private boolean cancelled;
    private List<String> transferstations;
    private List<Trein> treinen;

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

    @Override
    public String toString() {
        return "Traject{" +
                "vertrekStation='" + vertrekStation + '\'' +
                ", aankomstStation='" + aankomstStation + '\'' +
                ", treinen=" + treinen +
                '}';
    }
}
