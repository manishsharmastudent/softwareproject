package exceptions;

/**
 * Created by Nofel on 04-12-16.
 */
public class HalteNotFoundException extends Exception {
    public HalteNotFoundException(String halte){
        super("Halte" + " \'" + halte + "\' " + "werd niet gevonden.");
    }
}
