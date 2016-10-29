package model;

public class Korting {
	private int kortingType;
	private String omschrijving;
	
	public int getKortingType(){
		return this.kortingType;
	}
	public String getOmschrijving(){
		return this.omschrijving;
	}
	public boolean setKortingType(int kortingType)
	{
		this.kortingType = kortingType;
		return true;
	}
	public boolean setOmschrijving(String omschrijving)
	{
		this.omschrijving = omschrijving;
		return true;
	}
	public double calculateKorting()
	{
		return 0.0;
	}
}
