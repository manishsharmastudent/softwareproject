package model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Nofel on 27-12-16.
 */
public class VoorwerpTest {
    Voorwerp voorwerp;
    Klant klant;
    Station vertrek;
    Station aankomst;

    @Before
    public void setUp() throws Exception {
        klant = new Klant();
        vertrek = new Station();
        aankomst = new Station();

        klant.setVoornaam("Jef");
        vertrek.setNaam("Luik");
        aankomst.setNaam("Gent");
    }

    @Test
    public void voorwerpConstructor(){
        voorwerp = new Voorwerp(23,45,"Rood","Handschoen","String",vertrek,aankomst,klant,false);

        assertEquals(23,voorwerp.getVoorwerpId());
        assertEquals(45,voorwerp.getTrein());
        assertEquals("Rood", voorwerp.getKleur());
        assertEquals("Handschoen",voorwerp.getType());
        assertEquals("String",voorwerp.getVoorwerpstr());
        assertEquals("Luik", voorwerp.getVertrekStation().getNaam());
        assertEquals("Gent", voorwerp.getBestemmingStation().getNaam());
        assertEquals("Jef",voorwerp.getKlant().getVoornaam());
        assertFalse(voorwerp.getActive());
    }

}