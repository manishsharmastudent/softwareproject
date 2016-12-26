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

    @Test
    public void getStation() throws Exception {
        assertEquals(2, liveboardGetters.getStation().getStationId());
    }

    @Test
    public void setStation() throws Exception {
        liveboardSetters.setStation(station);
        assertEquals(2, liveboardSetters.getStation().getStationId());
    }

    @Test
    public void getLive() throws Exception {
        assertTrue(liveboardGetters.getLive());
    }

    @Test
    public void setLive() throws Exception {
        liveboardSetters.setLive(false);
        assertFalse(liveboardSetters.getLive());
    }

    @Test
    public void getTimeVersion() throws Exception {
        assertTrue(localDateTime.equals(liveboardGetters.getTimeVersion()));
    }

    @Test
    public void setTimeVersion() throws Exception {
        liveboardSetters.setTimeVersion(localDateTime);
        assertTrue(localDateTime.equals(liveboardSetters.getTimeVersion()));
    }

    @Test
    public void getException() throws Exception {
        assertEquals("exceptionGetter", liveboardGetters.getException());
    }

    @Test
    public void setException() throws Exception {
        liveboardSetters.setException("exceptionSet");
        assertEquals("exceptionSet", liveboardSetters.getException());
    }

    @Test
    public void getJsonException() throws Exception {
        assertEquals("jsonExceptionGetter", liveboardGetters.getJsonException());
    }

    @Test
    public void setJsonException() throws Exception {
        liveboardSetters.setJsonException("jsonSet");
        assertEquals("jsonSet", liveboardSetters.getJsonException());
    }

}