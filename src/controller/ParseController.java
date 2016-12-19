package controller;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import model.Liveboard;
import model.Station;
import util.NetUtil;

import org.json.JSONArray;
import org.json.JSONObject;
import model.Traject;

import java.nio.file.Files;
import java.nio.file.Paths;


/**
 * Created by Nofel on 02-11-16.
 */

public class ParseController {
    /**
     * Voeg hierin het adres van de api die dient gebruikt te worden
     **/
    private static final String CONNECTIONS_URL = "https://traintracks.online/api/";

    private static String getStringFromJsonFile(String path) throws IOException {
        return new String(Files.readAllBytes(Paths.get(path)));
    }

    private static String getCurlUrl(String from, String to) throws IOException {
        String curlUrl = null;
        /** vervolledig het request hier **/
        //String finalURl = CONNECTIONS_URL + "Route/" + from + "/" + to;
        curlUrl = getStringFromJsonFile("\\\\dt-srv-file1\\Studentenhomes\\nofel.tiani\\Documents\\Holleken");
        //String curlUrl = NetUtil.curlURL(finalURl);

        return curlUrl;
    }

    private static String getCurlUrl(String station) {
        String curlUrl = null;
        try {
            /** vervolledig het request hier **/
            String finalURl = CONNECTIONS_URL + "StationBoard/" + station;
            curlUrl = NetUtil.curlURL(finalURl);

        } catch (IOException io) {
            System.err.println("Error");
            io.printStackTrace();
        }

        return curlUrl;
    }

/**
 * In de blok hieronder komen de methodes van alle soort request die gemaakt kan worden
 * Voor iedere soort request zal een andere methode geschreven moeten worden.
 **/

    /**
     * Deze methode behandeld de vraag naar een route tussen 2 stations
     **/
    public static List<Traject> getTraject(String from, String to) throws Exception {

        List<Traject> traject = new ArrayList<Traject>();

        try {
            String curlUrl = getCurlUrl(from, to);
            JSONObject jBase = new JSONObject(curlUrl);
            if (jBase.has("error")) {
                throw new Exception("API is down");
            }

            JSONArray arrCon = jBase.getJSONArray("Routes");
            traject = TrajectParseController.getTrajecten(arrCon);

        } catch (IOException io) {
            System.err.println("Error");
            io.printStackTrace();
        }
        return traject;
    }

    /**
     * Deze methode behandeld de vraag naar alle treinen die in een specifieke station aankomt
     **/
    public static Liveboard getStationBoard(String s) {
        Station station = new Station();
        Liveboard lb;

        String curlUrl = getCurlUrl(s);
        try {
            JSONArray jArray = new JSONArray(curlUrl);
            lb = LiveboardParseController.getLiveBoard(jArray, s);
            return lb;
        } catch (Exception e) {
            lb = LiveboardParseController.getLiveboardFromCache(s);
            lb.setJsonException(e.getMessage());
            return lb;
        }
    }
}