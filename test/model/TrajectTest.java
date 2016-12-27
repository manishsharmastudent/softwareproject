package model;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Nofel on 27-12-16.
 */
public class TrajectTest {
    Traject traject;

    @Test
    public void trajectContructor(){
        traject = new Traject("Brussel","Antwerpen");

        assertEquals("Brussel", traject.getVertrekStation());
        assertEquals("Antwerpen", traject.getAankomstStation());
    }
}