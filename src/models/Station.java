package models;
import java.util.List;

public class Station {
	private String naam = "";
	private List<Trein> treinen;
	
	public Station(){};
	
	public Station(String naam, List<Trein> treinen) {
		super();
		this.naam = naam;
		this.treinen = treinen;
	}
	
	public String getNaam() {
		return naam;
	}
	public void setNaam(String naam) {
		this.naam = naam;
	}
	public List<Trein> getTreinen() {
		return treinen;
	}
	public void setTreinen(List<Trein> treinen) {
		this.treinen = treinen;
	}
	

}
