package controller;

import model.Halte;
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

        if (!(trj.getTreinen().isEmpty())){
            Halte hlte = trj.getTreinen().get(0).getHaltes().stream()
                    .filter(h -> h.getName().equalsIgnoreCase(trj.getVertrekStation()))
                    .findFirst()
                    .get();

            trj.setActualVertrekTijd(hlte.getActualDeparture());
            trj.setVertrekTijd(hlte.getDeparture());
            trj.setVetrekPlatform(hlte.getDeparturePlatform());

            hlte = trj.getTreinen().get(trj.getTreinen().size() - 1).getHaltes().stream()
                    .filter(h -> h.getName().equalsIgnoreCase(trj.getAankomstStation()))
                    .findFirst()
                    .get();

            trj.setAankomstTijd(hlte.getArrival());
            trj.setActualAankomstTijd(hlte.getActualArrival());
        }

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
