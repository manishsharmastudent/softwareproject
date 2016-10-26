package parsers;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import org.json.JSONArray;
import org.json.JSONObject;

import models.StationStop;

public class StopsParserTest {

	public static List<StationStop> getStops(JSONObject treinObj) {
		List<StationStop> stops = new ArrayList<StationStop>();
		
		
		/* arrTrains.forEach(new Consumer<Object>() {
			@Override
			public void accept(Object t) {
				JSONObject obj = (JSONObject)t;
				
		*/
				JSONObject stps = treinObj.getJSONObject("Stops");
				JSONArray arrStops = stps.getJSONArray("Stations");
				arrStops.forEach(new Consumer<Object>() {
					public void accept(Object t) {
						JSONObject obj = (JSONObject)t;
						stops.add(getStop(obj));
					}
				});
			/*
			 * }
		});
		*/
		return stops;
	}

	public static StationStop getStop(JSONObject obj) {
		String station = obj.getString("Name");
		String coordinates = obj.getString("Coordinates");

		/*int arrivalPlatform = 0;
		if(obj.has("ArrivalPlatform") && !obj.isNull("ArrivalPlatform"))
			arrivalPlatform = obj.getInt("ArrivalPlatform");
		else if (!obj.isNull("DeparturePlatform"))
			arrivalPlatform = obj.getInt("DeparturePlatform");

		int departurePlatform = 0;
		if(obj.has("DeparturePlatform") && !obj.isNull("DeparturePlatform"))
			departurePlatform = obj.getInt("DeparturePlatform");
		else if(!obj.isNull("ArrivalPlatform")) 
			departurePlatform = obj.getInt("ArrivalPlatform");*/
		
		int arrivalPlatform = 0;
		int departurePlatform = 0;
		

		return new StationStop(station, arrivalPlatform, departurePlatform, coordinates);
	}

}
