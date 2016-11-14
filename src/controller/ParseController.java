package controller;

import java.util.ArrayList;
import java.util.List;

import model.Station;
import util.NetUtil;
import java.io.IOException;
import java.time.*;
import java.util.function.Consumer;
import org.json.JSONArray;
import org.json.JSONObject;
import model.Traject;
import model.Trein;

/**
 * Created by Nofel on 02-11-16.
 */

public class ParseController {
    /**
     * Voeg hierin het adres van de api die dient gebruikt te worden
     **/
    private static final String CONNECTIONS_URL = "https://traintracks.online/api/";






/**
 * In de blok hieronder komen de methodes van alle soort request die gemaakt kan worden
 * Voor iedere soort request zal een andere methode geschreven moeten worden.
 **/

    /** Deze methode behandeld de vraag naar een route tussen 2 stations **/
    public static List<Traject> getTraject(String from, String to) throws Exception {

        List<Traject>traject = new ArrayList<Traject>();

        try {
            /** vervolledig het request hier **/
            String finalURl = CONNECTIONS_URL + "Route/" + from + "/" + to;
            String curlUrl = NetUtil.curlURL(finalURl);

            JSONObject jBase = new JSONObject(curlUrl);
            if(jBase.has("error")) {
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

    /** Deze methode behandeld de vraag naar alle treinen die in een specifieke station aankomt **/
    public static Station getStationBoard(String s) throws Exception {
        Station station = new Station();

        try {
            /** vervolledig het request hier **/
            String finalURl = CONNECTIONS_URL + "StationBoard/" + s;
            String curlUrl = NetUtil.curlURL(finalURl);

            JSONArray jArray = new JSONArray(curlUrl);

            station = TreinParseController.getLiveBoard(jArray);

        } catch (IOException io) {
            System.err.println("Error");
            io.printStackTrace();
        }

        return station;
    }

    public static void main(String[] args) {
        try {
           // List<Traject> tra = getTraject("Ternat", "Holleken");
           // tra.forEach(e -> System.out.print(e));

            Station antw = getStationBoard("Antwerpen-Centraal");
            System.out.println();
        }catch (Exception e){
            System.out.println(e.toString());
        }

    }
}
