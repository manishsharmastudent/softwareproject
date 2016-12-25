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
    private Route route;
    private Klant klant;
    private Float prijs;
    private boolean active;


    public Abonnement(int abonnementId, Korting korting, Date beginDatum, Date vervalDatum, Route route, Klant klant, Float prijs, boolean active) {
        this.abonnementId = abonnementId;
        this.korting = korting;
        this.beginDatum = beginDatum;
        this.vervalDatum = vervalDatum;
        this.route = route;
        this.klant = klant;
        this.prijs = prijs;
        this.active = active;
    }

    public Abonnement(boolean active, Korting korting, Date beginDatum, Date vervalDatum, Route route, Klant klant, Float prijs) {
        this.active = active;
        this.korting = korting;
        this.beginDatum = beginDatum;
        this.vervalDatum = vervalDatum;
        this.route = route;
        this.klant = klant;
        this.prijs = prijs;
    }

    public int getAbonnementId() {
        return abonnementId;
    }
    public Korting getKorting() {return korting; }
    public Date getBeginDatum() {
        return beginDatum;
    }
    public Date getVervalDatum() {
        return vervalDatum;
    }
    public Route getRoute() {
        return route;
    }
    public Klant getKlant() {
        return klant;
    }
    public Float getPrijs() {
        return prijs;
    }
    public boolean isActive() {
        return active;
    }

    public void setAbonnementId(int abonnementId) {
        this.abonnementId = abonnementId;
    }
    public void setKorting(Korting korting) {
        this.korting = korting;
    }
    public void setBeginDatum(Date beginDatum) {
        this.beginDatum = beginDatum;
    }
    public void setVervalDatum(Date vervalDatum) {
        this.vervalDatum = vervalDatum;
    }
    public void setRoute(Route route) {
        this.route = route;
    }
    public void setKlant(Klant klant) {
        this.klant = klant;
    }
    public void setPrijs(Float prijs) {
        this.prijs = prijs;
    }
    public void setActive(boolean active) {
        this.active = active;
    }

    public Abonnement() {
    }
}
