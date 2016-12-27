package model;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Nofel on 27-12-16.
 */
public class TreinTest {
    Trein trein;

    @Test
    public void treinConstructor(){
        trein = new Trein(42,"IC1942");

        assertEquals(42,trein.getTreinId());
        assertEquals("IC1942", trein.getTreinNaam());

    }

}