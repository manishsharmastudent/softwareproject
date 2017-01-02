package model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Nofel on 26-12-16.
 */
public class KlantTest {
    Klant klant;
    Klant klantGetters;
    Klant klantSetters;

    @Before
    public void setUp() throws Exception {
        klantGetters = new Klant("23014563987", "Jef", "Kazak","Rue des Bouchers", 1000, "Brussel", true);
        klantSetters = new Klant();
    }

    @Test
    public void klantConstructor() throws Exception{
        klant = new Klant("23014563987", "Jef", "Kazak","Rue des Bouchers", 1000, "Brussel", true);

        assertEquals("23014563987",klant.getRijksregisterNummer());
        assertEquals("Jef",klant.getVoornaam());
        assertEquals("Kazak",klant.getAchternaam());
        assertEquals("Rue des Bouchers", klant.getAdres());
        assertEquals(1000,klant.getPostcode());
        assertEquals("Brussel", klant.getStad());
        assertTrue(klant.getActive());

    }
}