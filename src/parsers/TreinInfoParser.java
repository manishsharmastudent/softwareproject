package parsers;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import org.json.JSONArray;
import org.json.JSONObject;

import models.Trein;

public class TreinInfoParser {
	
	public static List<Trein> getTrains(JSONArray arr) {
		List<Trein> list = new ArrayList<Trein>();
		arr.forEach(new Consumer<Object>() {
			@Override
			public void accept(Object t) {
				JSONObject obj = (JSONObject)t;		
				list.add(getTrain(obj));
			}
		});
		return list;
	}
	
	public static Trein getTrain(JSONObject obj) {
		Trein t = new Trein();
		t.setNumber(obj.getInt("Number"));
		t.setFullId(obj.getString("FullId"));
		if(!obj.isNull("DepartureStation"))
		t.setDeparture(obj.getString("DepartureStation"));
		t.setTerminus(obj.getString("TerminusStation"));
		t.setTraintype(obj.getInt("TrainType"));
		t.setStops(StopsParserTest.getStops(obj));
		return t;
	}
	
}