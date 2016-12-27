package model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Nofel on 27-12-16.
 */
public class VoorwerpTest {
    Voorwerp voorwerp;
    Route route;
    Station station;
    Klant klant;

    @Before
    public void setUp() throws Exception {
        route = new Route();
        station = new Station();
        klant = new Klant();

        route.setRouteId(42);
        station.setStationId(21);
        klant.setVoornaam("Jef");

    }

    @Test
    public void voorwerpConstructor(){
        voorwerp = new Voorwerp(23,45,"Rood","Handschoen","String",route,station,klant,false);

        assertEquals(23,voorwerp.getVoorwerpId());
        assertEquals(45,voorwerp.getTrein());
        assertEquals("Rood", voorwerp.getKleur());
        assertEquals("Handschoen",voorwerp.getType());
        assertEquals("String",voorwerp.getVoorwerpstr());
        assertEquals(42,voorwerp.getRoute().getRouteId());
        assertEquals(21,voorwerp.getStation().getStationId());
        assertEquals("Jef",voorwerp.getKlant().getVoornaam());
        assertFalse(voorwerp.getActive());
    }

}