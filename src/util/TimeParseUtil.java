package util;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 * Created by Nofel on 11-11-16.
 */
public class TimeParseUtil {

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
            int minuten;

            minuten = (int) duur.getSeconds() / 60;


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

        String formattedTijd = (uur<10?("0"+uur):uur) + ":" + (minuten<10?("0"+minuten):minuten) + ":" + (seconden<10?("0"+seconden):seconden);
        return formattedTijd;
    }

    public static String formatTimeDate(LocalDateTime tijd){
        String uur = formatTime(tijd);

        int dag;
        int maand;
        int jaar;

        dag = tijd.getDayOfMonth();
        maand = tijd.getMonthValue();
        jaar = tijd.getYear();

        String formattedTijd = (dag<10?("0"+dag):dag) +"/" + (maand<10?"0"+maand:maand) + "/" + jaar + " " + uur;
        return formattedTijd;
    }

}
