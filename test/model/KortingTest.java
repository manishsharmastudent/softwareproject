package model;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by Nofel on 26-12-16.
 */
public class KortingTest {
    Korting korting;
    Korting kortingGetters;
    Korting kortingSetters;
    Date begindatum;

    @Before
    public void setUp() throws Exception {
        begindatum = new Date();
        kortingGetters = new Korting(5,3,begindatum,"Senior",true,0.25);
        kortingSetters = new Korting();
    }

    @Test
    public void kortingConstructor() throws Exception{
        korting = new Korting(5,3,begindatum,"Senior",true,0.25);

        assertEquals(5,korting.getKortingId());
        assertEquals(3,korting.getKortingType());
        assertTrue(begindatum.equals(korting.getBeginDatum()));
        assertEquals("Senior", korting.getOmschrijving());
        assertTrue(korting.isActive());
        assertEquals(0.25,korting.getProcent(),0.01);
    }
}