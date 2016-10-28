package parsers;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.time.*;

/**
 * Created by Nofel on 28-10-16.
 */
public class TimeParser {

    //private DateFormat dFormat;

    public static LocalDateTime getTime (String timeString)
    {
        LocalDateTime d = null;

        if((timeString.length() == 19) && (timeString != "0001-01-01T00:00:00")) {
            d = LocalDateTime.parse(timeString);
        }

        /*
        if((timeString.length() == 19) && (timeString != "0001-01-01T00:00:00")) {
            dFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            Date startDate;
            try {
                startDate = dFormat.parse(timeString);
            } catch (ParseException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        */

        return d;
    }

    public static String getDelay(LocalDateTime departure, LocalDateTime actual){

        int urenDeparture = 0;
        int minutenDeparture = 0;
        int secondenDeparture = 0;

        int urenActual = 0;
        int minutenActual = 0;
        int secondenActual = 0;

        int urenDelay = 0;
        int minutenDelay = 0;
        int secondenDelay = 0;



        if (actual.isAfter(departure)){

            urenDeparture = departure.getHour();
            minutenDeparture = departure.getMinute();
            secondenDeparture = departure.getSecond();
            urenActual = actual.getHour();
            minutenActual = actual.getMinute();
            secondenActual = actual.getSecond();

            urenDelay = urenActual - urenDeparture;
            minutenDelay = minutenActual - minutenDeparture;
            secondenDelay = secondenActual - secondenDeparture;

            if(secondenDelay < 0 ) {
                minutenDelay -= 1;
                secondenDelay = 60 + secondenDelay;
            }

            if(minutenDelay < 0){
                urenDelay -= 1;
                minutenDelay = 60 + minutenDelay;
            }

        }

        if (actual.isBefore(departure)){

            urenDeparture = departure.getHour();
            minutenDeparture = departure.getMinute();
            secondenDeparture = departure.getSecond();
            urenActual = actual.getHour();
            minutenActual = actual.getMinute();
            secondenActual = actual.getSecond();

            urenDelay = urenDeparture - urenActual;
            minutenDelay = minutenDeparture - minutenActual;
            secondenDelay = secondenDeparture- secondenActual;

            if(secondenDelay < 0 ) {
                minutenDelay -= 1;
                secondenDelay = 60 + secondenDelay;
            }

            if(minutenDelay < 0){
                urenDelay -= 1;
                minutenDelay = 60 + minutenDelay;
            }

        }

        return "Uren: " + urenDelay + "\n" + "Minuten: " + minutenDelay + "\n" + "Seconden: " + secondenDelay;

    }
}
