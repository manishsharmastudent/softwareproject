import java.util.Date;

import softwareproject.Route;
import softwareproject.TypeKaart;

public class Ticket {
	
	private Route route = new Route();
	private Date beginDatum = new Date();
	private Date eindDatum = new Date();
	private TypeKaart type = new TypeKaart();
	private int aantalPersonen;
	private float prijs;

	public Route getRoute(){
		return this.route;
	}
	public Date getBeginDatum(){
		return this.beginDatum;
	}
	public Date getEindDatum(){
		return this.eindDatum;
	}
	public TypeKaart getType(){
		return this.type;
	}
	public public Korting getKorting(){
		return this.korting;
	}
	public int getAantalPersonen(){
		return this.aantalPersonen;
	}
	public boolean setRoute(Route r){
		this.route = r;
	}
	public Boolean setBeginDatum(Date d){
		this.beginDatum = d;
	}
	public boolean setType(TypeKaart t){
		this.type = t;
	}
	public Boolean setKorting(Korting k){
		this.korting = k;
	}
	public Boolean setAantalPersonen(int a){
		this.aantalPersonen = a;
	}
	
	
}
