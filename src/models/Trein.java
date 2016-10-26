package models;

import java.util.List;

public class Trein {

	private int number;
	private int traintype;
	private String fullId;
	private String departure, terminus;
	private boolean cancelled;
	private Time time;
	private List<StationStop> stops;
	
	public Trein(){}
	
	public Trein(int number, int traintype, String fullId, String departure, String terminus, List<StationStop> stops) {
		super();
		this.number = number;
		this.traintype = traintype;
		this.fullId = fullId;
		this.departure = departure;
		this.terminus = terminus;
		this.stops = stops;
	}
	
	
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public int getTraintype() {
		return traintype;
	}
	public void setTraintype(int traintype) {
		this.traintype = traintype;
	}
	public String getfullId() {
		return fullId;
	}
	public void setFullId(String fullId) {
		this.fullId = fullId;
	}
	public String getDeparture() {
		return departure;
	}
	public void setDeparture(String departure) {
		this.departure = departure;
	}
	public String getTerminus() {
		return terminus;
	}
	public void setTerminus(String terminus) {
		this.terminus = terminus;
	}
	public List<StationStop> getStops() {
		return stops;
	}
	public void setStops(List<StationStop> stops) {
		this.stops = stops;
	}
	public String stopsToString() {
		String stoppen = "";
		if (stops != null) {
			for (StationStop stationStop : stops) {
				stoppen = stoppen + stationStop.getName() + "\n";
			}
		}
		return stoppen;
	}

	public boolean isCancelled() {
		return cancelled;
	}

	public void setCancelled(boolean cancelled) {
		this.cancelled = cancelled;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

}
