package model;

import java.time.LocalDate;
import java.util.Date;

/**
 * Created by Rik Van Belle on 31/12/2016.
 */
public class Reservatie {
    private int reservatienr;
    private String groepsnaam;
    private Station vertrekStation;
    private Station aankomstStation;
    private Date reservatieDatum;
    private int aantalPersonen;
    private boolean active;

    public Reservatie(){

    }
    public Reservatie(int reservatienr, String groepsnaam, Station vertrek, Station aankomst, Date datum, int aantal, boolean active){
        this.reservatienr = reservatienr;
        this.groepsnaam = groepsnaam;
        this.vertrekStation = vertrek;
        this.aankomstStation = aankomst;
        this.reservatieDatum = datum;
        this.aantalPersonen = aantal;
        this.active = active;
    }
    public int getReservatienr(){return this.reservatienr;}
    public String getGroepsnaam() {
        return groepsnaam;
    }
    public Station getVertrekStation() {
        return vertrekStation;
    }
    public Station getAankomstStation() {
        return aankomstStation;
    }
    public Date getReservatieDatum() {
        return reservatieDatum;
    }
    public int getAantalPersonen() {
        return aantalPersonen;
    }
    public boolean getActive(){return active;}
    public void setReservatienr(int reservatienr) {
        this.reservatienr = reservatienr;
    }
    public void setGroepsnaam(String groepsnaam) {
        this.groepsnaam = groepsnaam;
    }
    public void setVertrekStation(Station vertrekStation) {
        this.vertrekStation = vertrekStation;
    }
    public void setAankomstStation(Station aankomstStation) {
        this.aankomstStation = aankomstStation;
    }
    public void setReservatieDatum(Date reservatieDatum) {
        this.reservatieDatum = reservatieDatum;
    }
    public void setAantalPersonen(int aantalPersonen) {
        this.aantalPersonen = aantalPersonen;
    }
    public void setActive(boolean active){this.active = active; }
}
