package model;

import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by Nofel on 27-12-16.
 */
public class TicketTest {
    Route route;
    LocalDate beginLocal;
    LocalDate vervalLocal;
    Date beginDatum;
    Date vervalDatum;
    TypeKaart typeKaart;
    Ticket ticket;
    Station vertrek;
    Station aankomst;

    @Before
    public void setUp() throws Exception {
        route = new Route();
        vertrek = new Station();
        aankomst = new Station();
        route.setRouteId(42);

        beginLocal = LocalDate.of(2016,12,25);
        vervalLocal = beginLocal.plusYears(1);
        beginDatum = new Date(beginLocal.toEpochDay());
        vervalDatum = new Date(vervalLocal.toEpochDay());

        typeKaart = new TypeKaart();
        typeKaart.setId(12);

        vertrek.setNaam("Luik");
        aankomst.setNaam("Gent");

        ticket = new Ticket(21,vertrek,aankomst,beginDatum,vervalDatum,typeKaart,22,54,1);


    }

    @Test
    public void ticketConstructor() throws Exception{
        assertEquals(21,ticket.getTicketId());
        assertTrue(beginDatum.equals(ticket.getBeginDatum()));
        assertTrue(vervalDatum.equals(ticket.getEindDatum()));
        assertEquals(12,ticket.getTypeKaart().getId());
        assertEquals(22,ticket.getAantalPersonen());
        assertEquals(54, (int)ticket.getPrijs());
        assertEquals(1,ticket.getKlasse());
        assertEquals("Luik", ticket.getVertrekStation().getNaam());
        assertEquals("Gent", ticket.getBestemmingStation().getNaam());
    }


}