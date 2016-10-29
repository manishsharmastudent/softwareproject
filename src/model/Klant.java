
public class Klant {
	private String rijksregisterNummer;
	private String voornaam;
	private String achternaam;
	private String adres;
	private int postcode;
	private String stad;
	
	public String getRijkstregister(){
		return this.rijksregisterNummer;
	}
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
	
	public boolean setRijkstregister(String rijksregister)
	{
		this.rijksregisterNummer = rijksRegister;
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

	
}
