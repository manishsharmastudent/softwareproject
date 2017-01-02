package model;

import org.junit.Before;
import org.junit.Test;
import util.TimeParseUtil;

import java.time.Duration;
import java.time.LocalDateTime;

import static org.junit.Assert.*;

/**
 * Created by Nofel on 26-12-16.
 */
public class HalteTest {
    private Halte halteConstructor;
    private Halte halteSetters;
    private Halte halteGetters;
    private String name;
    private LocalDateTime arrival;
    private LocalDateTime actualArrival;
    private LocalDateTime departure;
    private LocalDateTime actualDeparture;
    private String departurePlatform;
    private String aankomstPlatform;
    private String coordinaten;

    @Before
    public void setUp() throws Exception {
        halteGetters = new Halte();
        halteSetters = new Halte();
    }

    @Test
    public void halteConstructor() throws  Exception{
        halteConstructor = new Halte("halteConstructor","1");

        assertEquals("halteConstructor" , halteConstructor.getName());
        assertEquals("1", halteConstructor.getDeparturePlatform());
    }

    @Test
    public void getDelay() throws Exception {
        departure = LocalDateTime.of(2016,12,26,23,10);
        actualDeparture = LocalDateTime.of(2016,12,26,23,15);

        halteGetters.setDeparture(departure);
        halteGetters.setActualDeparture(actualDeparture);

        String delay = TimeParseUtil.getDelay(departure,actualDeparture);

        assertTrue(delay.equals(halteGetters.getDelay()));
    }

}