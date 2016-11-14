package controller;

import model.Traject;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * Created by Nofel on 11-11-16.
 */
public class TrajectParseController {
    public static List<Traject> getTrajecten(JSONArray arrCon){
        List<Traject> trajecten = new ArrayList<Traject>();

        arrCon.forEach(new Consumer<Object>() {
            @Override
            public void accept(Object t) {
                JSONObject obj = (JSONObject)t;
                Traject trj = new Traject();
                trj .setVetrekStation(obj.getString("Departure"));
                trj .setAankomstStation(obj.getString("Arrival"));
                trj .setCancelled(obj.getBoolean("Cancelled"));
                JSONArray arrTrains = obj.getJSONArray("Trains");
                trj .setTreinen(TreinParseController.getTrains(arrTrains, trj .getVertrekStation()));

                trajecten.add(trj);

            }
        });

        return trajecten;
    }
}
