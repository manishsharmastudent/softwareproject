
public class Voorwerp {

	private Trein trein = new Trein();
	private String kleur;
	private String type;
	private Route route = new Route();
	private Station station = new Station();
	
	public int getTreinId(){
		return this.trein;
	}
	public Route getTreinRoute(){
		return this.route;
	}
	public String getKleur(){
		return this.kleur;
	}
	public String getType(){
		return this.type;
	}
	public boolean setRoute(Route r){
		this.route = r;
	}
	public boolean setType(String t){
		this.type = t;
	}
	public boolean setTreinId(int td){

		//?????? kan functie niet aanroepen van trein
		
	}
	public boolean setKleur(String k){
		this.kleur = k;
	}
	
}
