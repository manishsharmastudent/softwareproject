package model;

public class TypeKaart {
	private int id;
	private String naam;
	private String omschrijving;
	private Korting korting;
    private boolean active;

	public TypeKaart(int id, int kortingId, String naam, String omschrijving){
		this.id=id;
		this.naam=naam;
		this.omschrijving=omschrijving;
        this.active = true;
	}
	public TypeKaart(){};

	public TypeKaart(int id,String naam,String omschrijving,Korting korting)
	{
		this.id=id;
		this.naam=naam;
		this.omschrijving=omschrijving;
		this.korting=korting;
        this.active = true;
	}

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
	public boolean setNaam(String naam)
	{
		this.naam = naam;
		return true;
	}

	public String getOmschrijving()
	{
		return this.omschrijving;
	}
	public Korting getKorting(){
		return korting;
	}
	public boolean getActive(){
        return this.active;
    }
    public boolean setActive(boolean active){
        this.active = active;
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