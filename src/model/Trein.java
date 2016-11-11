package model;

import java.sql.Time;

/**
 * Created by Manish on 29/10/2016.
 */
public class Trein {

  private int treinId;
  private int treinType;
  private String treinNaam;
  private boolean cancelled = false;
  private String vetrek, bestemming;

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
}
