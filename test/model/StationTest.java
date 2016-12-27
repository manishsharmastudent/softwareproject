package model;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Nofel on 27-12-16.
 */
public class StationTest {
    Station station;

    @Test
    public void stationConstructor(){
        station = new Station(42,"Brussel-Centraal", "Brussel");

        assertEquals(42, station.getStationId());
        assertEquals("Brussel-Centraal",station.getNaam());
        assertEquals("Brussel",station.getStad());
    }

}