package model;

import java.util.Date;

/**
 * Created by Manish on 23/10/2016.
 */
public class Abonnement {
    private int abonnementId;
    private Korting korting;
    private Date beginDatum;
    private Date vervalDatum;
    //private Route route;
    private Klant klant;
    // private Float prijs;
    private boolean active;
    public int getAbonnementId(){
        return this.abonnementId;
    }
    public Korting getKorting(){
        return this.korting;
    }
    public Date getBeginDatum(){
        return this.beginDatum;
    }
    public Date getVervalDatum(){
        return this.vervalDatum;
    }
    public Klant getKlant(){
        return this.klant;
    }
    public boolean getActive(){
        return this.active;
    }
    public boolean setAbonnementId(int id){
        this.abonnementId = id;
        return true;
    }
    public boolean setKorting(Korting korting){
        this.korting = korting;
        return true;
    }
    public boolean setBeginDatum(Date datum){
        this.beginDatum = datum;
        return true;
    }
    public boolean setVervalDatum(Date datum){
        this.vervalDatum = datum;
        return true;
    }
    public boolean setKlant(Klant k){
        this.klant = k;
        return true;
    }
    public boolean setActive(boolean active){
        this.active = active;
        return true;
    }
}
