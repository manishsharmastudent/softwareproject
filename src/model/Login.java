package model;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Manish on 23/10/2016.
 */
public class Login {
    private int id;
    private String  loginNaam;
    private String loginWachtwoord;
    private Rol rol;
    private Date lastChanged;
    private boolean active;
    private Station station;

    public Login(int id, String loginNaam, String loginWachtwoord, Rol rol, Date lastChanged, boolean active, Station station) {
        this.id = id;
        this.loginNaam = loginNaam;
        this.loginWachtwoord = loginWachtwoord;
        this.rol = rol;
        this.lastChanged = lastChanged;
        this.active = active;
        this.station = station;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLoginNaam() {
        return loginNaam;
    }

    public void setLoginNaam(String loginNaam) {
        this.loginNaam = loginNaam;
    }

    public String getLoginWachtwoord() {
        return loginWachtwoord;
    }

    public void setLoginWachtwoord(String loginWachtwoord) {
        this.loginWachtwoord = loginWachtwoord;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Date getLastChanged() {
        return lastChanged;
    }

    public void setLastChanged(Date lastChanged) {
        this.lastChanged = lastChanged;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }

    public Login() {
    }
}
