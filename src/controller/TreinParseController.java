package controller;

import model.Station;
import model.Trein;
import model.Halte;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * Created by Nofel on 11-11-16.
 */
public class TreinParseController {

    public static Station getLiveBoard(JSONArray jArray) {
        Station station = new Station();

        station.setTreinen(getTrains(jArray));

        return station;
    }

    public static List<Trein> getTrains(JSONArray arr) {
        List<Trein> list = new ArrayList<Trein>();
        arr.forEach(new Consumer<Object>() {
            @Override
            public void accept(Object t) {
                JSONObject obj = (JSONObject) t;
                Trein trein = getTrain(obj);
                list.add(trein);
            }
        });
        return list;
    }

    public static Trein getTrain(JSONObject obj) {
        Trein t = new Trein();
        t.setTreinId(obj.getInt("Number"));
        t.setTreinNaam(obj.getString("FullId"));

        if (!obj.isNull("DepartureStation"))
            t.setVetrek(obj.getString("DepartureStation"));

        t.setBestemming(obj.getString("TerminusStation"));
        t.setTreinType(obj.getInt("TrainType"));

        JSONObject stops = obj.getJSONObject("Stops");
        JSONArray arrStations = stops.getJSONArray("Stations");

        t.setHaltes(getHaltes(arrStations));

        return t;
    }

    public static List<Halte> getHaltes(JSONArray arrStations) {
        List<Halte> haltes = new ArrayList<Halte>();
        arrStations.forEach(new Consumer<Object>() {
            @Override
            public void accept(Object t) {
                JSONObject obj = (JSONObject) t;
                haltes.add(getStop(obj));
             }
        });
        return haltes;
    }

    public static Halte getStop(JSONObject obj) {
        Halte h = new Halte();
        h.setName(obj.getString("Name"));
        h.setCoordinaten(obj.getString("Coordinates"));

       String arrivalPlatform = "0";
        if (obj.has("ArrivalPlatform") && !obj.isNull("ArrivalPlatform"))
            arrivalPlatform = obj.getString("ArrivalPlatform");
        else if (!obj.isNull("DeparturePlatform"))
            arrivalPlatform = obj.getString("DeparturePlatform");

        String departurePlatform = "0";
        if (obj.has("DeparturePlatform") && !obj.isNull("DeparturePlatform"))
            departurePlatform = obj.getString("DeparturePlatform");
        else if (!obj.isNull("ArrivalPlatform"))
            departurePlatform = obj.getString("ArrivalPlatform");
        JSONObject halteTime = obj.getJSONObject("Time");

        h.setAankomstPlatform(arrivalPlatform);
        h.setDeparturePlatform(departurePlatform);
        h.setArrival(TimeParseController.getTime(halteTime.getString("Arrival")));
        h.setActualArrival(TimeParseController.getTime(halteTime.getString("ActualArrival")));
        h.setDeparture(TimeParseController.getTime(halteTime.getString("Departure")));
        h.setActualDeparture(TimeParseController.getTime(halteTime.getString("ActualDeparture")));
        return h;
    }
}
