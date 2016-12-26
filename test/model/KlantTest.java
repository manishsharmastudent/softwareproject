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

    @Test
    public void getRijksregisterNummer() throws Exception {
        assertEquals("23014563987",klantGetters.getRijksregisterNummer());
    }

    @Test
    public void getVoornaam() throws Exception {
        assertEquals("Jef",klantGetters.getVoornaam());
    }

    @Test
    public void getAchternaam() throws Exception {
        assertEquals("Kazak",klantGetters.getAchternaam());
    }

    @Test
    public void getAdres() throws Exception {
        assertEquals("Rue des Bouchers", klantGetters.getAdres());
    }

    @Test
    public void getPostcode() throws Exception {
        assertEquals(1000,klantGetters.getPostcode());
    }

    @Test
    public void getStad() throws Exception {
        assertEquals("Brussel", klantGetters.getStad());
    }

    @Test
    public void getActive() throws Exception {
        assertTrue(klantGetters.getActive());
    }

    @Test
    public void setRijksregisterNummer() throws Exception {
        klantSetters.setRijksregisterNummer("63259878963");
        assertEquals("63259878963",klantSetters.getRijksregisterNummer());
    }

    @Test
    public void setVoornaam() throws Exception {
        klantSetters.setVoornaam("Madame");
        assertEquals("Madame",klantSetters.getVoornaam());
    }

    @Test
    public void setAchternaam() throws Exception {
        klantSetters.setAchternaam("Chapeau");
        assertEquals("Chapeau",klantSetters.getAchternaam());
    }

    @Test
    public void setAdres() throws Exception {
        klantSetters.setAdres("Pitastraat");
        assertEquals("Pitastraat",klantSetters.getAdres());
    }

    @Test
    public void setPostcode() throws Exception {
        klantSetters.setPostcode(42);
        assertEquals(42,klantSetters.getPostcode());
    }

    @Test
    public void setStad() throws Exception {
        klantSetters.setStad("Meulebeek");
        assertEquals("Meulebeek",klantSetters.getStad());
    }

    @Test
    public void setActive() throws Exception {
        klantSetters.setActive(false);
        assertFalse(klantSetters.getActive());
    }

}