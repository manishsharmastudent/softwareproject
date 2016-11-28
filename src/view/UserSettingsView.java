package view;

import com.google.maps.DistanceMatrixApi;
import com.google.maps.DistanceMatrixApiRequest;
import com.google.maps.GeoApiContext;
import com.google.maps.errors.ApiException;
import com.google.maps.model.*;
import lu.tudor.santec.jtimechooser.JTimeChooser;

import java.awt.*;

/**
 * Created by User on 28/11/2016.
 */
public class UserSettingsView extends StandardView {


    private JTimeChooser loginTime = new JTimeChooser();


    UserSettingsView(String titel) {
        super(titel);
    }

    public void showUserSettingsView() throws Exception {

        interactiePanel.add(loginTime);





        mainPanel.setLayout(new BorderLayout(80,30));
        panel.setLayout(new BorderLayout(0,0));

        panel.add(mainNavPanel, BorderLayout.NORTH);
        panel.add(interactiePanel, BorderLayout.CENTER);

        mainPanel.add(welkomPanel, BorderLayout.NORTH);
        mainPanel.add(panel, BorderLayout.CENTER);


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

