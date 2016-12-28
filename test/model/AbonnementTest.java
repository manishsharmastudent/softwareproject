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
    public void getAbonnementId() throws Exception {
        abonnementGetters.setAbonnementId(6);
        assertEquals(6,abonnementGetters.getAbonnementId());

    }

    @Test
    public void getKorting() throws Exception {
        assertEquals("kortingGetter",abonnementGetters.getKorting().getOmschrijving());
    }

    @Test
    public void getBeginDatum() throws Exception {
        assertTrue(beginDatum.equals(abonnementGetters.getBeginDatum()));
    }

    @Test
    public void getVervalDatum() throws Exception {
        assertTrue(vervalDatum.equals(abonnementGetters.getVervalDatum()));
    }

    @Test
    public void getRoute() throws Exception {
        assertEquals(1,abonnementGetters.getRoute().getRouteId());
    }

    @Test
    public void getKlant() throws Exception {
        assertEquals("klantGetter",abonnementGetters.getKlant().getAchternaam());
    }

    @Test
    public void getPrijs() throws Exception {
        assertEquals(8,abonnementGetters.getPrijs().intValue());
    }

    @Test
    public void isActive() throws Exception {
        assertTrue(abonnementGetters.isActive());
    }

    @Test
    public void setAbonnementId() throws Exception {
        abonnementSetters.setAbonnementId(9);

        assertEquals(9,abonnementSetters.getAbonnementId());
    }

    @Test
    public void setKorting() throws Exception {
        korting.setOmschrijving("KortingSetKorting");
        abonnementSetters.setKorting(korting);

        assertEquals("KortingSetKorting", abonnementSetters.getKorting().getOmschrijving());

    }

    @Test
    public void setBeginDatum() throws Exception {
        beginDatum = LocalDate.of(2016,8,12);
        abonnementSetters.setBeginDatum(beginDatum);

        assertTrue(beginDatum.equals(abonnementSetters.getBeginDatum()));
    }

    @Test
    public void setVervalDatum() throws Exception {
        vervalDatum = LocalDate.of(2016,10,6);
        abonnementSetters.setVervalDatum(vervalDatum);

        assertTrue(vervalDatum.equals(abonnementSetters.getVervalDatum()));
    }

    @Test
    public void setRoute() throws Exception {
        route.setRouteId(654);
        abonnementSetters.setRoute(route);

        assertEquals(654,abonnementSetters.getRoute().getRouteId());
    }

    @Test
    public void setKlant() throws Exception {
        klant.setAchternaam("José");
        abonnementSetters.setKlant(klant);

        assertEquals("José",abonnementSetters.getKlant().getAchternaam());
    }

    @Test
    public void setPrijs() throws Exception {
        prijs = new Float(56);
        abonnementSetters.setPrijs(prijs);

        assertEquals(56,abonnementSetters.getPrijs().intValue());
    }

    @Test
    public void setActive() throws Exception {
        abonnementSetters.setActive(false);
        assertFalse(abonnementSetters.isActive());
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