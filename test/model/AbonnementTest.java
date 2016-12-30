package model;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by NT on 25-12-16.
 */
public class AbonnementTest {
    private Abonnement abonnement;
    private Korting korting;
    private Route route;
    private LocalDate beginLocal;
    private LocalDate vervalLocal;
    private Date beginDatum;
    private Date vervalDatum;
    private Klant klant;
    private Float prijs;
    private Station vertrek;
    private Station aankomst;

    @Before
    public void setUp() throws Exception {
        korting = new Korting();
        route = new Route();
        klant = new Klant();

        beginLocal = LocalDate.of(2016,12,25);
        vervalLocal = beginLocal.plusYears(1);
        beginDatum = new Date(beginLocal.toEpochDay());
        vervalDatum = new Date(vervalLocal.toEpochDay());

        korting.setOmschrijving("kortingGetter");
        klant.setAchternaam("klantGetter");
        route.setRouteId(1);

        vertrek.setNaam("Luik");
        aankomst.setNaam("Gent");
    }

    @Test
    public void testConstructorZonderId() throws Exception{
        korting.setOmschrijving("testKortingConstructorZonderId");
        route.setRouteId(12);
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
        klant.setAchternaam("Jef");
        prijs = new Float(23);

        abonnement = new Abonnement(5,korting,beginDatum,vervalDatum,vertrek, aankomst,klant,prijs,true);

        assertEquals(5,abonnement.getAbonnementId());
        assertEquals("testKortingConstructor",abonnement.getKorting().getOmschrijving());

        assertTrue(beginDatum.equals(abonnement.getBeginDatum()));
        assertTrue(vervalDatum.equals(abonnement.getVervalDatum()));

        assertEquals(6,abonnement.getRoute().getRouteId());
        assertEquals("Jef",abonnement.getKlant().getAchternaam());

        assertEquals(23,abonnement.getPrijs().intValue());
        assertTrue(abonnement.isActive());

        assertEquals("Luik", abonnement.getVertrekStation().getNaam());
        assertEquals("Gent", abonnement.getBestemmingStation().getNaam());

    }

}