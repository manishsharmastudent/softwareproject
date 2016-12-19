package view;

import com.google.maps.DistanceMatrixApi;
import com.google.maps.GeoApiContext;
import com.google.maps.model.*;

import java.awt.*;

/**
 * Created by User on 28/11/2016.
 */
public class UserSettingsView extends StandardView {


    UserSettingsView(String titel) {
        super(titel);
    }

    public void showUserSettingsView() throws Exception {

        //interactiePanel.add(loginTime);




        GeoApiContext a = new GeoApiContext().setApiKey("AIzaSyD6BTwnpskFD9GSRjQOB_h673HflZ6sb1c");



        DistanceMatrix matrix=DistanceMatrixApi.newRequest(a).origins("Halle (Belgium)").destinations("Brussel-Zuid").language("nl-BE").mode(TravelMode.TRANSIT).transitModes(TransitMode.TRAIN).await();


        long distanceInMeters = matrix.rows[0].elements[0].distance.inMeters;

        double distanceInKilometers = (double)distanceInMeters / 1000;

        System.out.println("De afstand is " + distanceInKilometers + "km");





        showWindow();



    }




    public static void main(String [] args) throws Exception {
        UserSettingsView s = new UserSettingsView("iets");
        s.showUserSettingsView();
    }



}

