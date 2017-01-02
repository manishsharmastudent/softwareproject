package util;

import com.google.maps.model.DistanceMatrix;
import exceptions.HalteNotFoundException;
import exceptions.OnvolledigeTrajectException;
import hibernate.ManageStation;
import model.Halte;
import model.Station;
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
public class TrajectParseUtil {

    private static boolean isStationEqual(Halte h, Station s){
        String halteNaam = h.getName().replace(" ","");
        String stationNaam = s.getNaam();
        String stationNaamFrans = s.getNaamFrans();
        String stationNaamAlt = s.getNaamAfkorting();

        if((h == null) || (s == null))
            return false;

        if(halteNaam.equalsIgnoreCase(stationNaam))
            return true;

        if(stationNaamFrans != null)
            if(halteNaam.equalsIgnoreCase(stationNaamFrans))
                return true;

        if(stationNaamAlt != null)
            if (halteNaam.equalsIgnoreCase(stationNaamAlt))
                return true;

        if(((stationNaamFrans != null) && (stationNaam != null)) &&((stationNaamFrans != "") && stationNaam != "")){
            String str = stationNaam + " / " + stationNaamFrans;
            if(halteNaam.equalsIgnoreCase(str))
                return true;

            String strAlt = stationNaamFrans + " / " + stationNaam;
            if(halteNaam.equalsIgnoreCase(strAlt))
                return true;
        }


        return false;
    }

    private static Station geefStation (List<Station> lijstStation, String naam){
        Station station = null;
        for(Station s : lijstStation) {
            if ((s.getNaam().equalsIgnoreCase(naam) || s.getNaamFrans() == naam))
                return s;
        }
        return station;
    }

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
                }
            }
        });

    }

    private static void getRouteTimes(Traject trj, List<Station> lijstStation) throws HalteNotFoundException {
        String vertrekStationNaam = trj.getVertrekStation();
        String aankomstStationNaam = trj.getAankomstStation();
        Station vertrekStation = geefStation(lijstStation, vertrekStationNaam);
        Station aankomstStation = geefStation(lijstStation,aankomstStationNaam);
        Halte halte;

        try {

            halte = trj.getTreinen().get(0).getHaltes().stream()
                    .filter(h -> (isStationEqual(h,vertrekStation)))
                    .findFirst()
                    .get();

            trj.setActualVertrekTijd(halte.getActualDeparture());
            trj.setVertrekTijd(halte.getDeparture());
            trj.setVetrekPlatform(halte.getDeparturePlatform());

        } catch (Exception e) {
            throw new HalteNotFoundException(trj.getVertrekStation());
        }

        try {
            halte = trj.getTreinen().get(trj.getTreinen().size() - 1).getHaltes().stream()
                    .filter(h ->(isStationEqual(h,aankomstStation)))
                    .findFirst()
                    .get();

            trj.setAankomstTijd(halte.getArrival());
            trj.setActualAankomstTijd(halte.getActualArrival());
        } catch (Exception e) {
            throw new HalteNotFoundException(trj.getAankomstStation());
        }
    }

    private static Traject getTraject(JSONObject obj, List<Station> lijstStation) throws OnvolledigeTrajectException {

        Traject trj = new Traject();
        trj.setVetrekStation(obj.getString("Departure"));
        trj.setAankomstStation(obj.getString("Arrival"));
        trj.setCancelled(obj.getBoolean("Cancelled"));

        JSONArray arrTrains = obj.getJSONArray("Trains");
        trj.setTreinen(TreinParseUtil.getTrains(arrTrains));

        try {
            if (!(trj.getTreinen().isEmpty())) {
                getRouteTimes(trj, lijstStation);
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
        ManageStation manageStation = new ManageStation();
        List<Station> lijstStation = manageStation.listStations();


        arrCon.forEach(new Consumer<Object>() {
            @Override
            public void accept(Object t) {

                JSONObject obj = (JSONObject) t;
                JSONArray arrTrains = obj.getJSONArray("Trains");

                if (arrTrains.length() != 0) {

                    Traject trj = new Traject();

                    try {
                        trj = getTraject(obj, lijstStation);
                        if ((trj.getVertrekTijd() != null) && (trj.getAankomstTijd() != null))
                            trj.setDuur(Duration.between(trj.getVertrekTijd(), trj.getAankomstTijd()));
                    } catch (OnvolledigeTrajectException e) {
                        trj.setException(e.getMessage());
                    } catch (Exception e) {
                    }
                    trajecten.add(trj);
                }
            }
        });

        return trajecten;
    }
}
