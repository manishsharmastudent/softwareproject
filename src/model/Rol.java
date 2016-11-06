package model;

/**
 * Created by Manish on 29/10/2016.
 */
public class Rol {
    private int rolId;
    private String rolBeschrijving;
    private boolean active;

    public Rol(boolean active, int rolId, String rolBeschrijving) {
        this.active = active;
        this.rolId = rolId;
        this.rolBeschrijving = rolBeschrijving;
    }

    public Rol() {
    }

    public int getRolId() {
        return rolId;
    }

    public void setRolId(int rolId) {
        this.rolId = rolId;
    }

    public String getRolBeschrijving() {
        return rolBeschrijving;
    }

    public void setRolBeschrijving(String rolBeschrijving) {
        this.rolBeschrijving = rolBeschrijving;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

}
