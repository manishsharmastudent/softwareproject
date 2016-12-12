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

        if((departure == null) || (actual == null) || (departure.equals(actual))) {
            return "Geen vertraging";
        }
        else {
            Duration duur = Duration.between(departure, actual);
            long minuten;

            minuten = duur.getSeconds() / 60;


            String vertraging = minuten + " minuten";


            return vertraging;
        }

    }

    public static String formatTime(LocalDateTime tijd){
        int uur;
        int minuten;
        int seconden;

        uur = tijd.getHour();
        minuten = tijd.getMinute();
        seconden = tijd.getSecond();

        String formattedTijd = uur + ":" + minuten + ":" + seconden;
        return formattedTijd;
    }

}
