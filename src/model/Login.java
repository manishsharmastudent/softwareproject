package model;

import java.util.Date;

/**
 * Created by Manish on 23/10/2016.
 */
public class Login {
    private int id;
    private String  loginNaam;
    private String loginWachtwoord;
    //private Rol rol;
    private Date lastChanged;
    private boolean active;
    private int stationId;

    /*public Rol getRolId() {
        return this.rol;
    }*/

   /* public void setRolId(Rol rol) {
        this.rol = rol;
    }*/

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

    public Date getLastChanged() {
        return lastChanged;
    }

    public void setLastChanged(Date lastChanged) {
        this.lastChanged = lastChanged;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getStationId() {
        return stationId;
    }

    public void setStationId(int stationId) {
        this.stationId = stationId;
    }

    public Login( String loginNaam, String loginWachtwoord, int rolId, Date lastChanged, boolean active, int stationId) {
        this.loginNaam = loginNaam;
        this.loginWachtwoord = loginWachtwoord;
        //this.rol = rol;
        this.lastChanged = lastChanged;
        this.active = active;
        this.stationId = stationId;
    }

    public Login() {};
}
