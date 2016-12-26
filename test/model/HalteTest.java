package model;

import org.junit.Before;
import org.junit.Test;

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
    private LocalDateTime Arrival;
    private LocalDateTime ActualArrival;
    private LocalDateTime Departure;
    private LocalDateTime ActualDeparture;
    private String departurePlatform;
    private String aankomstPlatform;
    private String coordinaten;

    @Before
    public void setUp() throws Exception {
        halteGetters = new Halte();
        halteSetters = new Halte();
    }

    @Test
    public void setArrival() throws Exception {

    }

    @Test
    public void setActualArrival() throws Exception {

    }

    @Test
    public void setDeparture() throws Exception {

    }

    @Test
    public void setActualDeparture() throws Exception {

    }

    @Test
    public void getCoordinaten() throws Exception {

    }

    @Test
    public void setCoordinaten() throws Exception {

    }

    @Test
    public void getName() throws Exception {

    }

    @Test
    public void setName() throws Exception {

    }

    @Test
    public void getArrival() throws Exception {

    }

    @Test
    public void setArrival1() throws Exception {

    }

    @Test
    public void getActualArrival() throws Exception {

    }

    @Test
    public void setActualArrival1() throws Exception {

    }

    @Test
    public void getDeparture() throws Exception {

    }

    @Test
    public void setDeparture1() throws Exception {

    }

    @Test
    public void getActualDeparture() throws Exception {

    }

    @Test
    public void setActualDeparture1() throws Exception {

    }

    @Test
    public void getAankomstPlatform() throws Exception {

    }

    @Test
    public void setAankomstPlatform() throws Exception {

    }

    @Test
    public void getDeparturePlatform() throws Exception {

    }

    @Test
    public void setDeparturePlatform() throws Exception {

    }

    @Test
    public void getDelay() throws Exception {

    }

}