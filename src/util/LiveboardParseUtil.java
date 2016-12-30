package util;

import model.Liveboard;
import model.Station;
import model.Trein;
import org.json.JSONArray;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Nofel on 05-12-16.
 */
public class LiveboardParseUtil {

    public static boolean writeLiveboardToCache(Liveboard lb) {
        Map<String,Liveboard> liveboardsList;
        try {
            liveboardsList = getLiveboardFromCache();
        } catch (ClassNotFoundException e) {
            liveboardsList = new HashMap<>();
        } catch (IOException e) {
            liveboardsList = new HashMap<>();
        }

        String naam = lb.getStation().getNaam();

        liveboardsList.put(naam,lb);
        try {
            ObjectOutputStream obos = new ObjectOutputStream(new FileOutputStream("cache_liveboard.tmp"));
            obos.writeObject(liveboardsList);
            obos.close();
        } catch (IOException e) {
            return false;
        }
        return true;
    }


    public static Map<String,Liveboard> getLiveboardFromCache() throws FileNotFoundException, ClassNotFoundException, IOException {
        Map<String,Liveboard> lb = new HashMap<>();
        FileInputStream fis = null;

        try {
            fis = new FileInputStream("cache_liveboard.tmp");
            ObjectInputStream obis = new ObjectInputStream(fis);
            lb = (Map<String,Liveboard>) obis.readObject();
            obis.close();
        } catch (FileNotFoundException e) {
        } catch (ClassNotFoundException e) {
        } catch (IOException e) {}

        return lb;
    }

    public static Liveboard getLiveboardFromCache(String naam) {
        Map<String,Liveboard> liveboardList;
        Liveboard lb = new Liveboard();
        FileInputStream fis = null;

        try {
            fis = new FileInputStream("cache_liveboard.tmp");
            ObjectInputStream obis = new ObjectInputStream(fis);
            liveboardList = (Map<String,Liveboard>) obis.readObject();
            obis.close();
        } catch (FileNotFoundException e) {
            lb.setException(e.getMessage());
            return lb;
        } catch (ClassNotFoundException e) {
            lb.setException(e.getMessage());
            return lb;
        } catch (IOException e) {
            lb.setException(e.getMessage());
            return lb;
        }

        lb = liveboardList.get(naam);
        if(lb == null) {
            lb = new Liveboard();
            lb.setException("cache voor station \'" + naam + "\' niet gevonden");
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
