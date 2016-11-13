package controller;

import model.Station;
import model.Trein;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * Created by Nofel on 11-11-16.
 */
public class TreinParseController {

    public static List<Trein> getTrains(JSONArray arr, String vertrek) {
        List<Trein> list = new ArrayList<Trein>();
        arr.forEach(new Consumer<Object>() {
            @Override
            public void accept(Object t) {
                JSONObject obj = (JSONObject) t;
                Trein trein = getTrain(obj, vertrek);
                list.add(trein);
            }
        });
        return list;
    }

    public static Trein getTrain(JSONObject obj, String vetrek) {
        Trein t = new Trein();
        t.setTreinId(obj.getInt("Number"));
        t.setTreinNaam(obj.getString("FullId"));
        if (!obj.isNull("DepartureStation"))
            t.setVetrek(obj.getString("DepartureStation"));
        t.setBestemming(obj.getString("TerminusStation"));
        t.setTreinType(obj.getInt("TrainType"));
        //t.setStops(StopsParserTest.getStops(obj));
        JSONObject stops = obj.getJSONObject("Stops");
        JSONArray arrStations = stops.getJSONArray("Stations");
        arrStations.forEach(new Consumer<Object>() {
            @Override
            public void accept(Object s) {
                if (((JSONObject) s).getString("Name").equalsIgnoreCase(vetrek)) {
                    JSONObject time = ((JSONObject) s).getJSONObject("Time");
                    t.setDeparture(TimeParseController.getTime(time.getString("Departure")));
                    t.setDeparture(TimeParseController.getTime(time.getString("ActualDeparture")));
                }
            }

        });

        return t;
    }

    public static Station getLiveBoard(JSONArray jArray) {
        Station station = new Station();

        station.setTreinen(getTrains(jArray,""));

        return station;
    }

}
