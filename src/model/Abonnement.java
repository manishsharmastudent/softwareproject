package model;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * Created by Manish on 23/10/2016.
 */
public class Abonnement {
    private int abonnementId;
    private Korting korting;
    private LocalDateTime beginDatum;
    private LocalDateTime vervalDatum;
    private Route route;
    private Klant klant;
    private float prijs;
    private boolean active;


    public Abonnement(int abonnementId, Korting korting, LocalDateTime beginDatum, LocalDateTime vervalDatum, Route route, Klant klant, float prijs, boolean active) {
        this.abonnementId = abonnementId;
        this.korting = korting;
        this.beginDatum = beginDatum;
        this.vervalDatum = vervalDatum;
        this.route = route;
        this.klant = klant;
        this.prijs = prijs;
        this.active = active;
    }

    public Abonnement(boolean active, Korting korting, LocalDateTime beginDatum, LocalDateTime vervalDatum, Route route, Klant klant, float prijs) {
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
    public LocalDateTime getBeginDatum() {
        return beginDatum;
    }
    public LocalDateTime getVervalDatum() {
        return vervalDatum;
    }
    public Route getRoute() {
        return route;
    }
    public Klant getKlant() {
        return klant;
    }
    public float getPrijs() {
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
    public void setBeginDatum(LocalDateTime beginDatum) {
        this.beginDatum = beginDatum;
    }
    public void setVervalDatum(LocalDateTime vervalDatum) {
        this.vervalDatum = vervalDatum;
    }
    public void setRoute(Route route) {
        this.route = route;
    }
    public void setKlant(Klant klant) {
        this.klant = klant;
    }
    public void setPrijs(float prijs) {
        this.prijs = prijs;
    }
    public void setActive(boolean active) {
        this.active = active;
    }

    public Abonnement() {
    }
}
