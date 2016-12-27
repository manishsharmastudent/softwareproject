package model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Nofel on 27-12-16.
 */
public class TypeKaartTest {
    Korting korting;
    TypeKaart typeKaart;

    @Before
    public void setUp() throws Exception {
        korting = new Korting();
        korting.setKortingId(21);
    }

    @Test
    public void typeKaartConstructorZonderKorting(){
        typeKaart = new TypeKaart(14,15,"EendagsTicket","24uren geldige ticket");

        assertEquals(14,typeKaart.getId());
        assertEquals("EendagsTicket", typeKaart.getNaam());
        assertEquals("24uren geldige ticket",typeKaart.getOmschrijving());
        assertTrue(typeKaart.getActive());
    }

    @Test
    public void typeKaartConstructorMetKorting(){
        typeKaart = new TypeKaart(14,"EendagsTicket","24uren geldige ticket", korting);

        assertEquals(14,typeKaart.getId());
        assertEquals("EendagsTicket", typeKaart.getNaam());
        assertEquals("24uren geldige ticket",typeKaart.getOmschrijving());
        assertTrue(typeKaart.getActive());
        assertEquals(korting.getKortingId(), typeKaart.getKorting().getKortingId());
    }


}