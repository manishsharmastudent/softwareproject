package util;

import model.Liveboard;
import model.Station;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by Nofel on 30-12-16.
 */
public class LiveboardParseUtilTest {
    Map<String, Liveboard> liveboardMap;
    Station station;
    Liveboard liveboard;

    @Before
    public void setUp() throws Exception {
        station = new Station();
    }

    @Test
    public void writeLiveboardToCache() throws Exception {
        for(int i = 1; i < 11; i++){
            station.setNaam("Station " + i);
            if(!(LiveboardParseUtil.writeLiveboardToCache(new Liveboard(station, LocalDateTime.now()))))
                fail();
        }
    }

    @Test
    public void getLiveboardFromCacheHashMap() throws Exception {
        liveboardMap = LiveboardParseUtil.getLiveboardFromCache();
        for(int i = 1; i<11;i++)
            assertEquals("Station " + i, liveboardMap.get("Station " + i).getStation().getNaam());
    }

    @Test
    public void getLiveboardFromCacheLiveboard() throws Exception {
        liveboardMap = LiveboardParseUtil.getLiveboardFromCache();
        liveboard = liveboardMap.get("Station 3");
        assertEquals("Station 3", liveboard.getStation().getNaam());
    }

    @Test
    public void getLiveboardFromCacheLiveboardString() throws Exception {
        liveboard = LiveboardParseUtil.getLiveboardFromCache("Station 3");
        assertEquals("Station 3", liveboard.getStation().getNaam());
    }

}