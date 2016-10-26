package parsers;

import org.json.JSONArray;

import models.Station;

public class StationParser {
	
	public static Station getLiveBoard(String s, JSONArray jArray){
		Station station = new Station();
		
		station.setNaam(s);
		station.setTreinen(TreinInfoParser.getTrains(jArray));
		
		return station;
	}

}
