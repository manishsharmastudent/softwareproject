package model;

/**
 * Created by Manish on 29/10/2016.
 */
public class Route {
    private int routeId;
    private Station routeVertrek;
    private Station routeBestemming;

    public Route(int routeId, Station routeVertrek, Station routeBestemming) {
        this.routeId = routeId;
        this.routeVertrek = routeVertrek;
        this.routeBestemming = routeBestemming;
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