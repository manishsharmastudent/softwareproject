package model;

public class TypeKaart {
	private int id;
	private String naam;
	private String omschrijving;
	private Korting korting;

	public int getId(){
		return this.id;
	}
	public void setId(int id){
		this.id = id;
	}
	public String getNaam()
	{
		return this.naam;
	}
	public String getOmschrijving()
	{
		return this.omschrijving;
	}
	public Korting getKorting(){
		return korting;
	}
	public boolean setNaam(String naam)
	{
		this.naam = naam;
		return true;
	}
	public boolean setOmschrijving(String omschrijving)
	{
		this.omschrijving = omschrijving;
		return true;
	}
	public boolean setKorting(Korting korting)
	{
		this.korting = korting;
		return true;
	}
}
