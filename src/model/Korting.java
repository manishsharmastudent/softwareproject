package model;

import java.time.LocalDate;
import java.util.Date;

public class Korting {
	private int kortingId;
	private int kortingType;
	private Date beginDatum;
	private String omschrijving;
	private double procent;
	private boolean active;

	public Korting(int kortingId, int kortingType, Date beginDatum, String omschrijving, boolean active, double procent) {
		this.kortingId = kortingId;
		this.kortingType = kortingType;
		this.beginDatum = beginDatum;
		this.omschrijving = omschrijving;
		this.procent = procent;
		this.active = active;
	}

	public double getProcent(){ return this.procent; }

	public void setProcent(double procent){this.procent = procent;}

	public int getKortingId() {
		return kortingId;
	}

	public void setKortingId(int kortingId) {
		this.kortingId = kortingId;
	}

	public int getKortingType() {
		return kortingType;
	}

	public void setKortingType(int kortingType) {
		this.kortingType = kortingType;
	}

	public Date getBeginDatum() {
		return beginDatum;
	}

	public void setBeginDatum(Date beginDatum) {
		this.beginDatum = beginDatum;
	}

	public String getOmschrijving() {
		return omschrijving;
	}

	public void setOmschrijving(String omschrijving) {
		this.omschrijving = omschrijving;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Korting() {

	}
}
