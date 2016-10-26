package testMain;

import java.util.List;
import models.Requests;
import models.Route;
import models.Station;
import models.Trein;

/**
 * Created by Nofel on 26-10-16.
 */

public class Main{
    public static void main(String args[]) {

        try {

			/*

			List<Route> r = Requests.getRoutes("Ternat", "Holleken");
			int x = 1;
			for (Route route : r) {

				System.out.println("Route: " + x + "\n");
				System.out.println(route.getDeparture());
				for (Trein t : route.getTreinen()) {
					System.out.println("Trein: " + t.getfullId() + "\n");
					System.out.println(t.stopsToString() + "\n");
				}

				x++;
			}
			*/

            Station station = new Station();
            station = Requests.getStationBoard("Brussel-Centraal");

            for (Trein t : station.getTreinen()) {
                System.out.println("Trein: " + t.getfullId() + "\n");
                System.out.println(t.stopsToString() + "\n");
            }



        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}