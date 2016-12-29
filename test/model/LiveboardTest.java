package model;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

/**
 * Created by Nofel on 26-12-16.
 */
public class LiveboardTest {
    Liveboard liveboard;
    Liveboard liveboardGetters;
    Liveboard liveboardSetters;
    LocalDateTime localDateTime;
    Station station;

    @Before
    public void setUp() throws Exception {
        liveboardGetters = new Liveboard();
        liveboardSetters = new Liveboard();

        localDateTime = LocalDateTime.of(2016,12,26,14,15);
        station = new Station();
        station.setStationId(2);

        liveboardGetters.setStation(station);
        liveboardGetters.setTimeVersion(localDateTime);
        liveboardGetters.setLive(true);
        liveboardGetters.setException("exceptionGetter");
        liveboardGetters.setJsonException("jsonExceptionGetter");
    }

    @Test
    public void liveboardConstructor() throws Exception{

        liveboard = new Liveboard(station,true,localDateTime);

        assertEquals(2, liveboard.getStation().getStationId());
        assertTrue(liveboard.getLive());
        assertTrue(localDateTime.equals(liveboard.getTimeVersion()));
    }
}