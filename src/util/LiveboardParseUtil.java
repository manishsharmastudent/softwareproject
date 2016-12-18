package util;

import model.Liveboard;
import model.Station;
import model.Trein;
import org.json.JSONArray;

import java.io.*;
import java.time.LocalDateTime;

/**
 * Created by Nofel on 05-12-16.
 */
public class LiveboardParseUtil {

    public static boolean writeLiveboardToCache(Liveboard lb) {
        String naam = lb.getStation().getNaam();
        try {
            ObjectOutputStream obos = new ObjectOutputStream(new FileOutputStream("cache_liveboard_" + naam + ".tmp"));
            obos.writeObject(lb);
            obos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    public static Liveboard getLiveboardFromCache(String naam) {
        Liveboard lb = new Liveboard();
        FileInputStream fis = null;

        try {
            fis = new FileInputStream("cache_liveboard_" + naam + ".tmp");
            ObjectInputStream obis = new ObjectInputStream(fis);
            lb = (Liveboard) obis.readObject();
            obis.close();
        } catch (FileNotFoundException e) {
            lb.setException(e.getMessage());
        } catch (ClassNotFoundException e) {
            lb.setException(e.getMessage());
        } catch (IOException e) {
            lb.setException(e.getMessage());
        }

        return lb;
    }

    public static Liveboard getLiveBoard(JSONArray jArray, String s){
        Liveboard lb;
        Station station;
        
        station = TreinParseUtil.getLiveBoard(jArray);
        station.setNaam(s);
        for (Trein trein:station.getTreinen()) {
            trein.setVetrkPlatform(trein.getHaltes().get(0).getDeparturePlatform());
        }

        lb = new Liveboard(station, LocalDateTime.now());
        LiveboardParseUtil.writeLiveboardToCache(lb);
        lb.setLive(true);
        return lb;
    }
}
