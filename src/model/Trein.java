package model;

import java.sql.Time;
import java.time.LocalDateTime;

import controller.TimeParseController;
import controller.TimeParseController.*;

/**
 * Created by Manish on 29/10/2016.
 */
public class Trein {

  private int treinId;
  private int treinType;
  private String treinNaam;
  private boolean cancelled = false;
  private String vetrek, bestemming;
  private String vetrkPlatform;
  private LocalDateTime departure;
  private LocalDateTime actualDeparture;

    public Trein(int treinId, String treinNaam) {
        this.treinId = treinId;
        this.treinNaam = treinNaam;
    }

    public Trein() {
    }

    public int getTreinId() {
        return treinId;
    }

    public boolean setTreinId(int treinId) {
        this.treinId = treinId;
        return true;
    }

    public String getTreinNaam() {
        return treinNaam;
    }

    public boolean setTreinNaam(String treinNaam) {
        this.treinNaam = treinNaam;
        return true;
    }

    public String getVetrek() {
        return vetrek;
    }
    public void setVetrek(String vetrek) {
        this.vetrek = vetrek;
    }
    public String getBestemming() {
        return bestemming;
    }
    public void setBestemming(String bestemming) {
        this.bestemming = bestemming;
    }

    public void setTreinType(int type){

        treinType=type;
    }

    public int getTreinType() {
        return treinType;
    }

    public boolean isCancelled() {
        return cancelled;
    }

    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }

    public String getVetrkPlatform() {
        return vetrkPlatform;
    }

    public void setVetrkPlatform(String vetrkPlatform) {
        this.vetrkPlatform = vetrkPlatform;
    }

    public LocalDateTime getDeparture() {
        return departure;
    }

    public void setDeparture(LocalDateTime departure) {
        this.departure = departure;
    }

    public LocalDateTime getActualDeparture() {
        return actualDeparture;
    }

    public void setActualDeparture(LocalDateTime actualDeparture) {
        this.actualDeparture = actualDeparture;
    }

    @Override
    public String toString() {
        return "Trein{" +
                "treinNaam='" + treinNaam + '\'' +
                ", vetrek='" + vetrek + '\'' +
                ", bestemming='" + bestemming + '\'' +
                ", vetrkPlatform='" + vetrkPlatform + '\'' +
                ", Vetrektijd: " + departure.toLocalTime().toString() +
                '}' +
                '\n';
    }
}
