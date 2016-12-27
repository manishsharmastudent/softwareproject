package model;

import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Type;
import java.time.LocalDateTime;

import static org.junit.Assert.*;

/**
 * Created by Nofel on 27-12-16.
 */
public class TicketTest {
    Route route;
    LocalDateTime begindatum;
    LocalDateTime einddatum;
    TypeKaart typeKaart;
    Ticket ticket;

    @Before
    public void setUp() throws Exception {
        route = new Route();
        route.setRouteId(42);

        begindatum = LocalDateTime.of(2016,12,26,12,00);
        einddatum = begindatum.plusYears(1);

        typeKaart = new TypeKaart();
        typeKaart.setId(12);

    }

    @Test
    public void ticketConstructor() throws Exception{
        ticket = new Ticket(21,route,begindatum,einddatum,typeKaart,22,54,1);

        assertEquals(21,ticket.getTicketId());
        assertEquals(42,ticket.getRoute().getRouteId());
        assertTrue(begindatum.equals(ticket.getBeginDatum()));
        assertTrue(einddatum.equals(ticket.getEindDatum()));
        assertEquals(12,ticket.getTypeKaart().getId());
        assertEquals(22,ticket.getAantalPersonen());
        assertEquals(54, (int)ticket.getPrijs());
        assertEquals(1,ticket.getKlasse());
    }


}