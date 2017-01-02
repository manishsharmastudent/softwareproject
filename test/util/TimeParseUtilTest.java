package util;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

/**
 * Created by NT on 31-12-16.
 */
public class TimeParseUtilTest {
    LocalDateTime localDateTime;
    LocalDateTime compLocalDateTime;
    String tijd;
    String localDateTimeString;
    String delay;
@Before
public void setUp() throws Exception{
    compLocalDateTime = LocalDateTime.parse("2016-02-02T04:04:00");
}
    @Test
    public void getTime() throws Exception {
        tijd = "2016-02-02T04:04:00";
        localDateTime = TimeParseUtil.getTime(tijd);

        assertTrue(compLocalDateTime.equals(localDateTime));
    }

    @Test
    public void getDelayVertraging() throws Exception {
        localDateTime = LocalDateTime.parse("2016-02-02T04:07:00");
        delay = TimeParseUtil.getDelay(compLocalDateTime,localDateTime);

        assertEquals("3 minuten", delay);
    }

    @Test
    public void getDelayVervroegd() throws Exception {
        localDateTime = LocalDateTime.parse("2016-02-02T04:02:00");
        delay = TimeParseUtil.getDelay(compLocalDateTime,localDateTime);

        assertEquals("-2 minuten", delay);
    }

    @Test
    public void getDelayGeenVertraging() throws Exception {
        localDateTime = LocalDateTime.parse("2016-02-02T04:04:00");
        delay = TimeParseUtil.getDelay(compLocalDateTime,localDateTime);

        assertEquals("Geen vertraging", delay);
    }

    @Test
    public void formatTime() throws Exception {
        tijd = TimeParseUtil.formatTime(compLocalDateTime);

        assertEquals("04:04:00", tijd);
    }

    @Test
    public void formatTimeDate() throws Exception {
        localDateTimeString = TimeParseUtil.formatTimeDate(compLocalDateTime);

        assertEquals("02/02/2016 04:04:00", localDateTimeString);
    }

}