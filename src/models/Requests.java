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
    /**
    * Voeg hierin het adres van de api die dient gebruikt te worden
    **/
	private static final String CONNECTIONS_URL = "https://traintracks.online/api/";

/**
 * In de blok hieronder komen de methodes van alle soort request die gemaakt kan worden
 * Voor iedere soort request zal een andere methode geschreven moeten worden.
 **/

	/** Deze methode behandeld de vraag naar een route tussen 2 stations **/
	public static List<Route> getRoutes(String from, String to) throws Exception {
		
		List<Route> routes = new ArrayList<Route>();
		
		try {
            /** vervolledig het request hier **/
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

	/** Deze methode behandeld de vraag naar alle treinen die in een specifieke station aankomt **/
	public static Station getStationBoard(String s) throws Exception {
		Station station = new Station();
		
		try {
            /** vervolledig het request hier **/
			String finalURl = CONNECTIONS_URL + "StationBoard/" + s;
			String curlUrl = NetUtil.curlURL(finalURl);
			
			JSONArray jArray = new JSONArray(curlUrl);
			
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
