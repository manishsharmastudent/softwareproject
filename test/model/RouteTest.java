package model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Nofel on 27-12-16.
 */
public class RouteTest {
    Route route;
    Station routeVertrek;
    Station routeBestemming;

    @Before
    public void setUp() throws Exception {
        routeVertrek = new Station();
        routeVertrek.setStationId(5);

        routeBestemming = new Station();
        routeBestemming.setStationId(3);
    }

    @Test
    public void routeConstructor(){
        route = new Route(12,routeVertrek,routeBestemming,false);

        assertEquals(12,route.getRouteId());
        assertEquals(routeVertrek.getStationId(), route.getRouteVertrek().getStationId());
        assertEquals(routeBestemming.getStationId(), route.getRouteBestemming().getStationId());
        assertFalse(route.getActive());
    }

}