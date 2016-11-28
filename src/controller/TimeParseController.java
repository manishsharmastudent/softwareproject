package controller;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 * Created by Nofel on 11-11-16.
 */
public class TimeParseController {

    public static LocalDateTime getTime (String timeString)
    {
        LocalDateTime d = null;

        if((timeString != "0001-01-01T00:00:00")) {
           if (!(timeString.substring(11).equals("00:00:00+01:00")))
                d = LocalDateTime.parse(timeString);
        }
        return d;
    }

    public static String getDelay(LocalDateTime departure, LocalDateTime actual) {

        int urenDeparture = 0;
        int minutenDeparture = 0;
        int secondenDeparture = 0;

        int urenActual = 0;
        int minutenActual = 0;
        int secondenActual = 0;

        int urenDelay = 0;
        int minutenDelay = 0;
        int secondenDelay = 0;


        if (actual != null) {
            if (actual.isAfter(departure)) {

                urenDeparture = departure.getHour();
                minutenDeparture = departure.getMinute();
                secondenDeparture = departure.getSecond();
                urenActual = actual.getHour();
                minutenActual = actual.getMinute();
                secondenActual = actual.getSecond();

                urenDelay = urenActual - urenDeparture;
                minutenDelay = minutenActual - minutenDeparture;
                secondenDelay = secondenActual - secondenDeparture;

                if (secondenDelay < 0) {
                    minutenDelay -= 1;
                    secondenDelay = 60 + secondenDelay;
                }

                if (minutenDelay < 0) {
                    urenDelay -= 1;
                    minutenDelay = 60 + minutenDelay;
                }
                return "+" + ((urenDelay < 10) ? "0" : "") + urenDelay + ":" + ((minutenDelay < 10) ? "0" : "") + minutenDelay + ":" + ((secondenDelay < 10) ? "0" : "") + secondenDelay;
            }

            if (actual.isBefore(departure)) {

                urenDeparture = departure.getHour();
                minutenDeparture = departure.getMinute();
                secondenDeparture = departure.getSecond();
                urenActual = actual.getHour();
                minutenActual = actual.getMinute();
                secondenActual = actual.getSecond();

                urenDelay = urenDeparture - urenActual;
                minutenDelay = minutenDeparture - minutenActual;
                secondenDelay = secondenDeparture - secondenActual;

                if (secondenDelay < 0) {
                    minutenDelay -= 1;
                    secondenDelay = 60 + secondenDelay;
                }

                if (minutenDelay < 0) {
                    urenDelay -= 1;
                    minutenDelay = 60 + minutenDelay;
                }

                return "-" + ((urenDelay < 10) ? "0" : "") + urenDelay + ":" + ((minutenDelay < 10) ? "0" : "") + minutenDelay + ":" + ((secondenDelay < 10) ? "0" : "") + secondenDelay;

            }

            return ((urenDelay < 10) ? "0" : "") + urenDelay + ":" + ((minutenDelay < 10) ? "0" : "") + minutenDelay + ":" + ((secondenDelay < 10) ? "0" : "") + secondenDelay;

        }

        return "0";
    }

}
