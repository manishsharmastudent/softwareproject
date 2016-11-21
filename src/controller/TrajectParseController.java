package controller;

import model.Traject;
import org.json.JSONArray;
import org.json.JSONObject;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * Created by Nofel on 11-11-16.
 */
public class TrajectParseController {

    private static Traject getTraject(JSONObject obj) {

        Traject trj = new Traject();
        trj.setVetrekStation(obj.getString("Departure"));
        trj.setAankomstStation(obj.getString("Arrival"));
        trj.setCancelled(obj.getBoolean("Cancelled"));


        JSONArray arrTrains = obj.getJSONArray("Trains");
        trj.setTreinen(TreinParseController.getTrains(arrTrains));

        if (obj.getJSONArray("TransferStations").length() > 1) {
            JSONArray arrTransfer = obj.getJSONArray("TransferStations");
            arrTransfer.forEach(new Consumer<Object>() {
                @Override
                public void accept(Object transfer) {
                    JSONObject ts = (JSONObject) transfer;

                    if (!ts.isNull("TransferAt")) {
                        trj.setTransferstations(ts.getString("TransferAt"));
                    }
                }
            });
        }
        if (arrTrains.length() > 1) {
            arrTrains.forEach(new Consumer<Object>() {
                @Override
                public void accept(Object s) {
                    JSONObject trn = (JSONObject) s;
                    JSONObject stops = trn.getJSONObject("Stops");
                    JSONArray arrStations = stops.getJSONArray("Stations");
                    arrStations.forEach(new Consumer<Object>() {
                        @Override
                        public void accept(Object s) {
                            if (((JSONObject) s).getString("Name").equalsIgnoreCase(trj.getVertrekStation()) || ((JSONObject) s).getString("Name").equalsIgnoreCase(trj.getAankomstStation())) {
                                if (((JSONObject) s).getString("Name").equalsIgnoreCase(trj.getVertrekStation())) {
                                    JSONObject time = ((JSONObject) s).getJSONObject("Time");
                                    trj.setVertrekTijd(TimeParseController.getTime(time.getString("Departure")));
                                    trj.setActualVertrekTijd(TimeParseController.getTime(time.getString("ActualDeparture")));
                                } else if (((JSONObject) s).getString("Name").equalsIgnoreCase(trj.getAankomstStation())) {
                                    JSONObject time = ((JSONObject) s).getJSONObject("Time");
                                    trj.setAankomstTijd(TimeParseController.getTime(time.getString("Arrival")));
                                    trj.setActualAankomstTijd(TimeParseController.getTime(time.getString("ActualArrival")));
                                }
                            }
                        }
                    });
                }
            });
        }
        return trj;
    }

    public static List<Traject> getTrajecten(JSONArray arrCon) {
        List<Traject> trajecten = new ArrayList<Traject>();

        arrCon.forEach(new Consumer<Object>() {
            @Override
            public void accept(Object t) {

                JSONObject obj = (JSONObject) t;
                JSONArray arrTrains = obj.getJSONArray("Trains");

                if (arrTrains.length() != 0) {

                    Traject trj = getTraject(obj);

                    if (trj.getVertrekTijd() != null)
                        trj.setDuur(Duration.between(trj.getVertrekTijd(), trj.getAankomstTijd()));

                    trajecten.add(trj);
                }
            }
        });

        return trajecten;
    }
}
