package model;

public class TypeKaart {

	private int typeId;
	private String naam;
	private String omschrijving;
	private Korting korting;
	private boolean active;

	public TypeKaart(int typeId, String naam, String omschrijving, Korting korting, boolean active) {
		this.typeId = typeId;
		this.naam = naam;
		this.omschrijving = omschrijving;
		this.korting = korting;
		this.active = active;
	}

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	public String getOmschrijving() {
		return omschrijving;
	}

	public void setOmschrijving(String omschrijving) {
		this.omschrijving = omschrijving;
	}

	public Korting getKorting() {
		return korting;
	}

	public void setKorting(Korting korting) {
		this.korting = korting;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public TypeKaart() {
	}
}
