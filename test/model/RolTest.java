package model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Nofel on 27-12-16.
 */
public class RolTest {
    Rol rol;

   @Test
    public void rolConstructor() throws Exception{
       rol = new Rol(true,3,"Medewerker");

       assertTrue(rol.isActive());
       assertEquals(3,rol.getRolId());
       assertEquals("Medewerker",rol.getRolBeschrijving());
   }

}