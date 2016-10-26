package models;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import parsers.RouteParser;
import parsers.StationParser;
import util.NetUtil;

public class Requests {
	private static final String CONNECTIONS_URL = "https://traintracks.online/api/";
	
	public static List<Route> getRoutes(String from, String to) throws Exception {
		
		List<Route> routes = new ArrayList<Route>();
		
		try {
			String finalURl = CONNECTIONS_URL + "Route/" + from + "/" + to;
			String curlUrl = NetUtil.curlURL(finalURl);

			JSONObject jBase = new JSONObject(curlUrl);
			if(jBase.has("error")) {
				throw new Exception("Server of NMBS is down");
			}
			
			JSONArray arrCon = jBase.getJSONArray("Routes");
			routes = RouteParser.getRoutes(arrCon);
			
		} catch (IOException io) {
			System.err.println("Error");
			io.printStackTrace();
		}
		return routes;
	}
	
	public static Station getStationBoard(String s) throws Exception {
		Station station = new Station();
		
		try {
			String finalURl = CONNECTIONS_URL + "StationBoard/" + s;
			String curlUrl = NetUtil.curlURL(finalURl);
			
			JSONArray jArray = new JSONArray(curlUrl);
			//JSONObject jBase = new JSONObject(curlUrl);
			
			/*
			if(jArray.has("error")) {
				throw new Exception("Server of NMBS is down");
			}
			 */
			station = StationParser.getLiveBoard(s, jArray);
			
		} catch (IOException io) {
			System.err.println("Error");
			io.printStackTrace();
		}
		
		
		return station;
	}
	
}
