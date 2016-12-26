package model;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

/**
 * Created by Nofel on 26-12-16.
 */
public class KortingTest {
    Korting korting;
    Korting kortingGetters;
    Korting kortingSetters;
    LocalDate begindatum;

    @Before
    public void setUp() throws Exception {
        kortingGetters = new Korting(5,3,begindatum,"Senior",true,0.25);
        kortingSetters = new Korting();
        begindatum = LocalDate.of(2016,02,23);
    }

    @Test
    public void kortingConstructor() throws Exception{
        korting = new Korting(5,3,begindatum,"Senior",true,0.25);

        assertEquals(5,korting.getKortingId());
        assertEquals(3,korting.getKortingType());
        assertTrue(begindatum.equals(korting.getBeginDatum()));
        assertEquals("Senior", korting.getOmschrijving());
        assertTrue(korting.isActive());
        assertEquals(25,korting.getProcent(),0.01);
    }

    @Test
    public void getProcent() throws Exception {
        assertEquals(0.25,kortingGetters.getProcent(),0.01);
    }

    @Test
    public void setProcent() throws Exception {
        kortingSetters.setProcent(0.23);
        assertEquals(0.23,kortingSetters.getProcent(),0.01);
    }

    @Test
    public void getKortingId() throws Exception {
        assertEquals(5,kortingGetters.getKortingId());
    }

    @Test
    public void setKortingId() throws Exception {
        kortingSetters.setKortingId(8);
        assertEquals(8,kortingSetters.getKortingId());

    }

    @Test
    public void getKortingType() throws Exception {
        assertEquals(3,kortingGetters.getKortingType());
    }

    @Test
    public void setKortingType() throws Exception {
        kortingSetters.setKortingType(9);
        assertEquals(9,kortingSetters.getKortingType());

    }

    @Test
    public void getBeginDatum() throws Exception {
        assertTrue(kortingGetters.equals(korting.getBeginDatum()));
    }

    @Test
    public void setBeginDatum() throws Exception {
        begindatum = LocalDate.of(2015,3,20);
        kortingSetters.setBeginDatum(begindatum);
        assertTrue(kortingSetters.equals(korting.getBeginDatum()));
    }

    @Test
    public void getOmschrijving() throws Exception {
        assertEquals("Senior", kortingGetters.getOmschrijving());

    }

    @Test
    public void setOmschrijving() throws Exception {
        kortingSetters.setOmschrijving("Student");
        assertEquals("Student", kortingSetters.getOmschrijving());
    }

    @Test
    public void isActive() throws Exception {
        assertTrue(kortingGetters.isActive());
    }

    @Test
    public void setActive() throws Exception {
        kortingSetters.setActive(false);
        assertFalse(kortingSetters.isActive());
    }

}