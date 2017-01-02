package util;

import com.google.maps.DistanceMatrixApi;
import com.google.maps.GeoApiContext;
import com.google.maps.model.DistanceMatrix;
import com.google.maps.model.TransitMode;
import com.google.maps.model.TravelMode;
import exceptions.HalteNotFoundException;
import exceptions.OnvolledigeTrajectException;
import model.Halte;
import model.Traject;
import org.json.JSONArray;
import org.json.JSONObject;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import static javafx.scene.input.KeyCode.L;

/**
 * Created by Nofel on 11-11-16.
 */
public class TrajectParseUtil {

    private static void getTransferStations(Traject trj, JSONArray transferArray){
        transferArray.forEach(new Consumer<Object>() {
            @Override
            public void accept(Object transfer) {
                JSONObject ts = (JSONObject) transfer;

                if (!ts.isNull("TransferAt")) {
                    String transferStation = null;
                    if(ts.has("TransferAt") && !ts.isNull("TransferAt"))
                        transferStation = ts.getString("TransferAt");

                    String transferPlatform = null;
                    if(ts.has("DeparturePlatform") && !ts.isNull("DeparturePlatform"))
                        transferPlatform = ts.getString("DeparturePlatform");

                    trj.setTransferstations(transferStation, transferPlatform);

                    GeoApiContext a = new GeoApiContext().setApiKey("AIzaSyD6BTwnpskFD9GSRjQOB_h673HflZ6sb1c");

                    long distanceInMeters = 0L;

                    try{
                        DistanceMatrix matrix= DistanceMatrixApi.newRequest(a).origins(trj.getVertrekStation()).destinations(trj.getAankomstStation()).language("nl-BE").mode(TravelMode.TRANSIT).transitModes(TransitMode.TRAIN).await();
                        distanceInMeters = matrix.rows[0].elements[0].distance.inMeters;
                    } catch (Exception exc){

                    }

                    double distanceInKilometers = (double)distanceInMeters / 1000;

                    System.out.println("De afstand is " + distanceInKilometers + "km");
                    trj.setAantalKilometers(distanceInKilometers);
                }
            }
        });

    }
    private static void getRouteTimes(Traject trj) throws HalteNotFoundException {

        Halte hlte;
        try {
            hlte = trj.getTreinen().get(0).getHaltes().stream()
                    .filter(h -> h.getName().equalsIgnoreCase(trj.getVertrekStation()))
                    .findFirst()
                    .get();

            trj.setActualVertrekTijd(hlte.getActualDeparture());
            trj.setVertrekTijd(hlte.getDeparture());
            trj.setVetrekPlatform(hlte.getDeparturePlatform());

        } catch (Exception e) {
            throw new HalteNotFoundException(trj.getVertrekStation());
        }

        try {
            hlte = trj.getTreinen().get(trj.getTreinen().size() - 1).getHaltes().stream()
                    .filter(h -> h.getName().equalsIgnoreCase(trj.getAankomstStation()))
                    .findFirst().get();

            trj.setAankomstTijd(hlte.getArrival());
            trj.setActualAankomstTijd(hlte.getActualArrival());
        } catch (Exception e) {
            throw new HalteNotFoundException(trj.getAankomstStation());
        }
    }

    private static Traject getTraject(JSONObject obj) throws OnvolledigeTrajectException {

        Traject trj = new Traject();
        trj.setVetrekStation(obj.getString("Departure"));
        trj.setAankomstStation(obj.getString("Arrival"));
        trj.setCancelled(obj.getBoolean("Cancelled"));

        JSONArray arrTrains = obj.getJSONArray("Trains");
        trj.setTreinen(TreinParseUtil.getTrains(arrTrains));

        try {
            if (!(trj.getTreinen().isEmpty())) {
                getRouteTimes(trj);
            }

            if (obj.getJSONArray("TransferStations").length() > 1) {
                JSONArray arrTransfer = obj.getJSONArray("TransferStations");
                getTransferStations(trj, arrTransfer);
            }

        } catch (HalteNotFoundException h) {
            throw new OnvolledigeTrajectException(h.getMessage());
        } catch (Exception e) {}

        return trj;
    }

    public static List<Traject> getTrajecten(JSONObject jBase) {
        List<Traject> trajecten = new ArrayList<Traject>();
        JSONArray arrCon = jBase.getJSONArray("Routes");


        arrCon.forEach(new Consumer<Object>() {
            @Override
            public void accept(Object t) {

                JSONObject obj = (JSONObject) t;
                JSONArray arrTrains = obj.getJSONArray("Trains");

                if (arrTrains.length() != 0) {

                    Traject trj = null;
                    try {
                        trj = getTraject(obj);


                        if ((trj.getVertrekTijd() != null) && (trj.getAankomstTijd() != null))
                            trj.setDuur(Duration.between(trj.getVertrekTijd(), trj.getAankomstTijd()));
                    } catch (OnvolledigeTrajectException e) {
                        trj.setException(e.getMessage());
                    }
                    trajecten.add(trj);
                }
            }
        });

        return trajecten;
    }
}