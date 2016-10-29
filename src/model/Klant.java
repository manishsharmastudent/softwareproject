package model;

public class Klant {
	private String rijksregisterNummer;
	private String voornaam;
	private String achternaam;
	private String adres;
	private int postcode;
	private String stad;
	private boolean active;

	public String getRijksregisterNummer(){ return this.rijksregisterNummer; }
	public String getVoornaam(){
		return this.voornaam;
	}
	public String getAchternaam(){
		return this.achternaam;
	}
	public String getAdres(){
		return this.adres;
	}
	public int getPostcode(){
		return this.postcode;
	}
	public String getStad(){
		return this.stad;
	}
	public boolean getActive(){ return this.active; }

	public boolean setRijksregisterNummer(String rijksregisterNummer){
		this.rijksregisterNummer = rijksregisterNummer;
		return true;
	}
	public boolean setVoornaam(String voornaam){
		this.voornaam = voornaam;
		return true;
	}
	public boolean setAchternaam(String achternaam){
		this.achternaam = achternaam;
		return true;
	}
	public boolean setAdres(String adres){
		this.adres = adres;
		return true;
	}
	public boolean setPostcode(int post)
	{
		this.postcode = post;
		return true;
	}
	public boolean setStad(String stad){
		this.stad = stad;
		return true;
	}
	public boolean setActive(boolean active){
		this.active = active;
		return true;
	}
	
}
