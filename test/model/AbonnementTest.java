package model;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

/**
 * Created by NT on 25-12-16.
 */
public class AbonnementTest {
    private Abonnement abonnement;
    private Abonnement abonnementSetters;
    private Abonnement abonnementGetters;
    private Korting korting;
    private Route route;
    private LocalDate beginDatum;
    private LocalDate vervalDatum;
    private Klant klant;
    private Float prijs;

    @Before
    public void setUp() throws Exception {
        korting = new Korting();
        route = new Route();
        klant = new Klant();
        beginDatum = LocalDate.of(2016,12,26);
        vervalDatum = beginDatum.plusYears(1);
        korting.setOmschrijving("kortingGetter");
        klant.setAchternaam("klantGetter");
        route.setRouteId(1);

        abonnementSetters = new Abonnement();
        abonnementGetters = new Abonnement(13,korting,beginDatum,vervalDatum,route,klant,new Float(8),true);
    }

    @Test
    public void testConstructorZonderId() throws Exception{
        korting.setOmschrijving("testKortingConstructorZonderId");
        route.setRouteId(12);
        beginDatum = LocalDate.of(2016,12,25);
        vervalDatum = beginDatum.plusYears(1);
        klant.setAchternaam("Jef");
        prijs = new Float(15);

        abonnement = new Abonnement(false,korting,beginDatum,vervalDatum,route,klant,prijs);

        assertEquals("testKortingConstructorZonderId",abonnement.getKorting().getOmschrijving());

        assertTrue(beginDatum.equals(abonnement.getBeginDatum()));
        assertTrue(vervalDatum.equals(abonnement.getVervalDatum()));

        assertEquals(12,abonnement.getRoute().getRouteId());
        assertEquals("Jef",abonnement.getKlant().getAchternaam());

        assertEquals(15,abonnement.getPrijs().intValue());
        assertFalse(abonnement.isActive());

    }

    @Test
    public void testConstructorMetId() throws Exception{
        korting.setOmschrijving("testKortingConstructor");
        route.setRouteId(6);
        beginDatum = LocalDate.of(2016,12,28);
        vervalDatum = beginDatum.plusYears(2);
        klant.setAchternaam("Jef");
        prijs = new Float(23);

        abonnement = new Abonnement(5,korting,beginDatum,vervalDatum,route,klant,prijs,true);

        assertEquals(5,abonnement.getAbonnementId());
        assertEquals("testKortingConstructor",abonnement.getKorting().getOmschrijving());

        assertTrue(beginDatum.equals(abonnement.getBeginDatum()));
        assertTrue(vervalDatum.equals(abonnement.getVervalDatum()));

        assertEquals(6,abonnement.getRoute().getRouteId());
        assertEquals("Jef",abonnement.getKlant().getAchternaam());

        assertEquals(23,abonnement.getPrijs().intValue());
        assertTrue(abonnement.isActive());

    }

}