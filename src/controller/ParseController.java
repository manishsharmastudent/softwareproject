package controller;

import java.util.ArrayList;
import java.util.List;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

    private static List<Traject> getTrajecten(JSONArray arrCon){
        List<Traject> routes = new ArrayList<Traject>();

        arrCon.forEach(new Consumer<Object>() {
            @Override
            public void accept(Object t) {
                JSONObject obj = (JSONObject)t;
                Traject r = new Traject();
                r.setVetrekStation(obj.getString("Departure"));
                r.setAankomstStation(obj.getString("Arrival"));
                r.setCancelled(obj.getBoolean("Cancelled"));
                JSONArray arrTrains = obj.getJSONArray("Trains");
                r.setTreinen(getTrains(arrTrains));

                routes.add(r);

            }
        });

        return routes;
    }

    private static Station getLiveBoard(String s, JSONArray jArray){
        Station station = new Station();

        station.setNaam(s);
        station.setTreinen(getTrains(jArray));

        return station;
    }

    /* private static List<StationStop> getStops(JSONObject obj) {
        JSONArray arrTrains = obj.getJSONArray("Trains");
        List<StationStop> stops = new ArrayList<StationStop>();

        arrTrains.forEach(new Consumer<Object>() {
            @Override
            public void accept(Object t) {
                JSONObject obj = (JSONObject)t;
                JSONObject stps = obj.getJSONObject("Stops");
                JSONArray arrStops = stps.getJSONArray("Stations");

                arrStops.forEach(new Consumer<Object>() {
                    public void accept(Object t) {
                        JSONObject obj = (JSONObject)t;
                        stops.add(getStop(obj));

                    }
                });
            }
        });

        return stops;
    } */

    /*private static StationStop getStop(JSONObject obj) {
        String station = obj.getString("Name");
        String coordinates = obj.getString("Coordinates");

        int arrivalPlatform = 0;
        if(obj.has("ArrivalPlatform") && !obj.isNull("ArrivalPlatform"))
            arrivalPlatform = obj.getInt("ArrivalPlatform");
        else if (!obj.isNull("DeparturePlatform"))
            arrivalPlatform = obj.getInt("DeparturePlatform");

        int departurePlatform = 0;
        if(obj.has("DeparturePlatform") && !obj.isNull("DeparturePlatform"))
            departurePlatform = obj.getInt("DeparturePlatform");
        else if(!obj.isNull("ArrivalPlatform"))
            departurePlatform = obj.getInt("ArrivalPlatform");

        return new StationStop(station, arrivalPlatform, departurePlatform, coordinates);
    } */

    private static LocalDateTime getTime (String timeString)
    {
        LocalDateTime d = null;

        if((timeString.length() == 19) && (timeString != "0001-01-01T00:00:00")) {
            d = LocalDateTime.parse(timeString);
        }

        return d;
    }

    private static String getDelay(LocalDateTime departure, LocalDateTime actual) {

        int urenDeparture = 0;
        int minutenDeparture = 0;
        int secondenDeparture = 0;

        int urenActual = 0;
        int minutenActual = 0;
        int secondenActual = 0;

        int urenDelay = 0;
        int minutenDelay = 0;
        int secondenDelay = 0;

        if (actual != null) {
            if (actual.isAfter(departure)) {

                urenDeparture = departure.getHour();
                minutenDeparture = departure.getMinute();
                secondenDeparture = departure.getSecond();
                urenActual = actual.getHour();
                minutenActual = actual.getMinute();
                secondenActual = actual.getSecond();

                urenDelay = urenActual - urenDeparture;
                minutenDelay = minutenActual - minutenDeparture;
                secondenDelay = secondenActual - secondenDeparture;

                if (secondenDelay < 0) {
                    minutenDelay -= 1;
                    secondenDelay = 60 + secondenDelay;
                }

                if (minutenDelay < 0) {
                    urenDelay -= 1;
                    minutenDelay = 60 + minutenDelay;
                }
                return "+" + ((urenDelay < 10) ? "0" : "") + urenDelay + ":" + ((minutenDelay < 10) ? "0" : "") + minutenDelay + ":" + ((secondenDelay < 10) ? "0" : "") + secondenDelay;
            }

            if (actual.isBefore(departure)) {

                urenDeparture = departure.getHour();
                minutenDeparture = departure.getMinute();
                secondenDeparture = departure.getSecond();
                urenActual = actual.getHour();
                minutenActual = actual.getMinute();
                secondenActual = actual.getSecond();

                urenDelay = urenDeparture - urenActual;
                minutenDelay = minutenDeparture - minutenActual;
                secondenDelay = secondenDeparture - secondenActual;

                if (secondenDelay < 0) {
                    minutenDelay -= 1;
                    secondenDelay = 60 + secondenDelay;
                }

                if (minutenDelay < 0) {
                    urenDelay -= 1;
                    minutenDelay = 60 + minutenDelay;
                }

                return "-" + ((urenDelay < 10) ? "0" : "") + urenDelay + ":" + ((minutenDelay < 10) ? "0" : "") + minutenDelay + ":" + ((secondenDelay < 10) ? "0" : "") + secondenDelay;

            }

            return ((urenDelay < 10) ? "0" : "") + urenDelay + ":" + ((minutenDelay < 10) ? "0" : "") + minutenDelay + ":" + ((secondenDelay < 10) ? "0" : "") + secondenDelay;

        }

        return "0";
    }

    private static List<Trein> getTrains(JSONArray arr) {
        List<Trein> list = new ArrayList<Trein>();
        arr.forEach(new Consumer<Object>() {
            @Override
            public void accept(Object t) {
                JSONObject obj = (JSONObject)t;
                Trein trein = new Trein();
                trein.setTreinNaam(obj.getString("FullId"));
                list.add(trein);
            }
        });
        return list;
    }

    private static Trein getTrain(JSONObject obj) {
        Trein t = new Trein();
        t.setNumber(obj.getInt("Number"));
        t.setFullId(obj.getString("FullId"));
        if(!obj.isNull("DepartureStation"))
            t.setDeparture(obj.getString("DepartureStation"));
        t.setTerminus(obj.getString("TerminusStation"));
        t.setTraintype(obj.getInt("TrainType"));
        t.setStops(StopsParserTest.getStops(obj));
        return t;
    }

/**
 * In de blok hieronder komen de methodes van alle soort request die gemaakt kan worden
 * Voor iedere soort request zal een andere methode geschreven moeten worden.
 **/

    /** Deze methode behandeld de vraag naar een route tussen 2 stations **/
    public static List<Traject> getTraject(String from, String to) throws Exception {

        //List<Route> routes = new ArrayList<Route>();
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
            traject = getTrajecten(arrCon);

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

			/*
			if(jArray.has("error")) {
				throw new Exception("Server of NMBS is down");
			}
			 */
            station = getLiveBoard(s, jArray);

        } catch (IOException io) {
            System.err.println("Error");
            io.printStackTrace();
        }


        return station;
    }
}
