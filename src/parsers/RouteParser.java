package parsers;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import org.json.JSONArray;
import org.json.JSONObject;

import models.Route;

public class RouteParser {

	public static List<Route> getRoutes(JSONArray arrCon){
		List<Route> routes = new ArrayList<Route>();
		
		arrCon.forEach(new Consumer<Object>() {
			@Override
			public void accept(Object t) {
				JSONObject obj = (JSONObject)t;
				Route r = new Route();
				r.setArrival(obj.getString("Arrival"));
				r.setDeparture(obj.getString("Departure"));
				r.setCancelled(obj.getBoolean("Cancelled"));
				JSONArray arrTrains = obj.getJSONArray("Trains");
				r.setTreinen(TreinInfoParser.getTrains(arrTrains));
				if(r.getTreinen().size() != 0)
					routes.add(r);

			}
		});
		
		return routes;
	} 
}
