package model;

import java.io.Serializable;

/**
 * Created by Manish on 29/10/2016.
 */
public class Route implements Serializable {
    private int routeId;
    private Station routeVertrek;
    private Station routeBestemming;
    private boolean active;

    public Route(int routeId, Station routeVertrek, Station routeBestemming, boolean active) {
        this.routeId = routeId;
        this.routeVertrek = routeVertrek;
        this.routeBestemming = routeBestemming;
        this.active = active;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Route() {
    }

    public int getRouteId() {
        return routeId;
    }

    public void setRouteId(int routeId) {
        this.routeId = routeId;
    }

    public Station getRouteVertrek() {
        return routeVertrek;
    }

    public void setRouteVertrek(Station routeVertrek) {
        this.routeVertrek = routeVertrek;
    }

    public Station getRouteBestemming() {
        return routeBestemming;
    }

    public void setRouteBestemming(Station routeBestemming) {
        this.routeBestemming = routeBestemming;
    }
}
