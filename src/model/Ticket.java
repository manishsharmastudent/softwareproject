package model;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * Created by Manish on 29/10/2016.
 */
public class Ticket {
    private int ticketId;
    private Route route;
    private LocalDateTime beginDatum;
    private LocalDateTime eindDatum;
    private TypeKaart typeKaart;
    private int aantalPersonen;
    private float prijs;
    private int klasse;

    public Ticket(int ticketId, Route route, LocalDateTime beginDatum, LocalDateTime eindDatum, TypeKaart typeKaart, int aantalPersonen, float prijs, int klasse) {
        this.ticketId = ticketId;
        this.route = route;
        this.beginDatum = beginDatum;
        this.eindDatum = eindDatum;
        this.typeKaart = typeKaart;
        this.aantalPersonen = aantalPersonen;
        this.prijs = prijs;
        this.klasse = klasse;
    }

    public Ticket() {
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public LocalDateTime getBeginDatum() {
        return beginDatum;
    }

    public void setBeginDatum(LocalDateTime beginDatum) {
        this.beginDatum = beginDatum;
    }

    public LocalDateTime getEindDatum() {
        return eindDatum;
    }

    public void setEindDatum(LocalDateTime eindDatum) {
        this.eindDatum = eindDatum;
    }

    public TypeKaart getTypeKaart() {
        return typeKaart;
    }

    public void setTypeKaart(TypeKaart typeKaart) {
        this.typeKaart = typeKaart;
    }

    public int getAantalPersonen() {
        return aantalPersonen;
    }

    public void setAantalPersonen(int aantalPersonen) {
        this.aantalPersonen = aantalPersonen;
    }

    public float getPrijs() {
        return prijs;
    }

    public void setPrijs(float prijs) {
        this.prijs = prijs;
    }

    public int getKlasse() {
        return klasse;
    }

    public void setKlasse(int klasse) {
        this.klasse = klasse;
    }
}
