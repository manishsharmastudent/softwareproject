package exceptions;

/**
 * Created by nofel.tiani on 12/12/2016.
 */
public class OnvolledigeTrajectException extends Exception{
    public OnvolledigeTrajectException(String error){
        super("Traject is onvolledig: " + error);
    }
}