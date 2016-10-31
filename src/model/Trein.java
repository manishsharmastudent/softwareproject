package model;

import java.sql.Time;

/**
 * Created by Manish on 29/10/2016.
 */
public class Trein {

  private int treinId;
    private String treinNaam;

    public Trein(int treinId, String treinNaam) {
        this.treinId = treinId;
        this.treinNaam = treinNaam;
    }

    public Trein() {
    }

    public int getTreinId() {
        return treinId;
    }

    public void setTreinId(int treinId) {
        this.treinId = treinId;
    }

    public String getTreinNaam() {
        return treinNaam;
    }

    public void setTreinNaam(String treinNaam) {
        this.treinNaam = treinNaam;
    }
}
