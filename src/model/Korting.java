package model;

import java.util.Date;

public class Korting {
	private int kortingId;
	private int kortingType;
	private Date beginDatum;
	private String omschrijving;
	private boolean active;

	public int getKortingId(){ return this.kortingId; }
	public int getKortingType(){
		return this.kortingType;
	}
	public Date getBeginDatum(){ return this.beginDatum; }
	public String getOmschrijving(){
		return this.omschrijving;
	}
	public boolean getActive(){ return this.active; }

	public boolean setKortingId(int id){
		this.kortingId = id;
		return true;
	}
	public boolean setKortingType(int kortingType) {
		this.kortingType = kortingType;
		return true;
	}
	public boolean setBeginDatum(Date datum){
		this.beginDatum = datum;
		return true;
	}
	public boolean setOmschrijving(String omschrijving) {
		this.omschrijving = omschrijving;
		return true;
	}
	public boolean setActive(boolean active){
		this.active = active;
		return true;
	}
}
