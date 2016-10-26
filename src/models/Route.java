package models;

import java.util.List;

public class Route {

	private String departure;
	private String arrival;
	private String treinLijn = "";
	private boolean cancelled;
	private List<Trein> treinen;
	

	public Route() {

	}

	public Route(String departure, String arrival) {
		super();
		this.departure = departure;
		this.arrival = arrival;
	}

	public String getDeparture() {
		return departure;
	}

	public void setDeparture(String departure) {
		this.departure = departure;
	}

	public String getArrival() {
		return arrival;
	}

	public void setArrival(String arrival) {
		this.arrival = arrival;
	}

	public String getTreinLijn() {
		return treinLijn;
	}

	public void setTreinLijn(String treinLijn) {
		this.treinLijn = treinLijn;
	}

	
	public void setTreinen(List<Trein> lst) {
		treinen = lst;
	}

	public List<Trein> getTreinen()
	{
		return treinen;
	}

	public boolean isCancelled() {
		return cancelled;
	}

	public void setCancelled(boolean cancelled) {
		this.cancelled = cancelled;
	}

	/*
	 * @Override public String toString() { }
	 */

}
