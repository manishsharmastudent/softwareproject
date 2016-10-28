package TestClasses;

import parsers.TimeParser;

import java.time.LocalDateTime;

/**
 * Created by Nofel on 28-10-16.
 */
public class TimeTest {
    public static void main(String args[]) {

        LocalDateTime d = TimeParser.getTime("2016-06-01T13:33:28");
        LocalDateTime d2 = TimeParser.getTime("2016-06-01T13:25:53");

        System.out.println(TimeParser.getDelay(d,d2));



    }
}
