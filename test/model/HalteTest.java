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
    public void setArrivalLocalDateTime() throws Exception {
        arrival = LocalDateTime.of(2016,12,26,23,15);
        halteSetters.setArrival(arrival);

        assertTrue(arrival.equals(halteSetters.getArrival()));

    }

    @Test
    public void setArrivalString() throws Exception {
        String arrivalString = "2016-12-26T23:23:00";
        LocalDateTime tijd = TimeParseUtil.getTime(arrivalString);
        halteSetters.setArrival(arrivalString);

        assertTrue(tijd.equals(halteSetters.getArrival()));
    }

    @Test
    public void setActualArrivalLocalDateTime() throws Exception {
        actualArrival = LocalDateTime.of(2016,12,26,23,15);
        halteSetters.setActualArrival(actualArrival);

        assertTrue(actualArrival.equals(halteSetters.getActualArrival()));
    }

    @Test
    public void setDepartureLocalDateTime() throws Exception {
        departure = LocalDateTime.of(2016,12,26,23,15);
        halteSetters.setDeparture(departure);

        assertTrue(departure.equals(halteSetters.getDeparture()));
    }

    @Test
    public void setActualDepartureLocalDateTime() throws Exception {
        actualDeparture = LocalDateTime.of(2016,12,26,23,15);
        halteSetters.setActualDeparture(actualDeparture);

        assertTrue(actualDeparture.equals(halteSetters.getActualDeparture()));
    }

    @Test
    public void setDepartureString() throws Exception {
        String departureString = "2016-12-26T23:23:00";
        LocalDateTime tijd = TimeParseUtil.getTime(departureString);

        halteSetters.setDeparture(departureString);
        assertTrue(tijd.equals(halteSetters.getDeparture()));
    }

    @Test
    public void setActualDepartureString() throws Exception {
        String actualDepartureString = "2016-12-26T23:23:00";
        LocalDateTime tijd = TimeParseUtil.getTime(actualDepartureString);

        halteSetters.setActualDeparture(actualDepartureString);

        assertTrue(tijd.equals(halteSetters.getActualDeparture()));
    }

    @Test
    public void getCoordinaten() throws Exception {
        halteGetters.setCoordinaten("00335566");

        assertEquals("00335566", halteGetters.getCoordinaten());

    }

    @Test
    public void setCoordinaten() throws Exception {
        halteSetters.setCoordinaten("00335566");

        assertEquals("00335566", halteSetters.getCoordinaten());
    }

    @Test
    public void getName() throws Exception {
        halteGetters.setName("Jeff");

        assertEquals("Jeff", halteGetters.getName());
    }

    @Test
    public void setName() throws Exception {
        halteSetters.setName("Jeff");

        assertEquals("Jeff", halteSetters.getName());
    }

    @Test
    public void getArrival() throws Exception {
        arrival = LocalDateTime.of(2016,12,26,23,15);
        halteGetters.setArrival(arrival);

        assertTrue(arrival.equals(halteGetters.getArrival()));
    }

    @Test
    public void getActualArrival() throws Exception {
        actualArrival = LocalDateTime.of(2016,12,26,23,15);
        halteGetters.setActualArrival(actualArrival);

        assertTrue(actualArrival.equals(halteGetters.getActualArrival()));
    }

    @Test
    public void getDeparture() throws Exception {
        departure = LocalDateTime.of(2016,12,26,23,15);
        halteGetters.setDeparture(departure);

        assertTrue(departure.equals(halteGetters.getDeparture()));
    }


    @Test
    public void getActualDeparture() throws Exception {
        actualDeparture = LocalDateTime.of(2016,12,26,23,15);
        halteGetters.setActualDeparture(actualDeparture);

        assertTrue(actualDeparture.equals(halteGetters.getActualDeparture()));
    }

    @Test
    public void getAankomstPlatform() throws Exception {
        halteGetters.setAankomstPlatform("13");

        assertEquals("13", halteGetters.getAankomstPlatform());
    }

    @Test
    public void setAankomstPlatform() throws Exception {
        halteSetters.setAankomstPlatform("13");

        assertEquals("13", halteSetters.getAankomstPlatform());
    }

    @Test
    public void getDeparturePlatform() throws Exception {
        halteGetters.setDeparturePlatform("12");

        assertEquals("12",halteGetters.getDeparturePlatform());
    }

    @Test
    public void setDeparturePlatform() throws Exception {
        halteSetters.setDeparturePlatform("12");

        assertEquals("12",halteSetters.getDeparturePlatform());
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