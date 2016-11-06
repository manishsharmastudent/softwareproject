package model;

public class TypeKaart {
	private int id;
	private String naam;
	private String omschrijving;
	private Korting korting;

	public int getId(){
		return this.id;
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

	public void setId(int id){
		this.id = id;
	}
	public void setNaam(String naam){this.naam = naam;}
	public void setOmschrijving(String omschrijving){this.omschrijving = omschrijving;}
	public void setKorting(Korting korting){this.korting = korting;}
}
