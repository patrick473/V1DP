package jdbc;

public class Afdeling {
	int anr;
	String naam;
	String locatie;
	Medewerker hoofd;
	
	@Override
	public String toString() {
		return "Afdeling [anr=" + anr + ", naam=" + naam + ", locatie=" + locatie + ", hoofd=" + hoofd + "]";
	}

	public int getAnr() {
		return anr;
	}

	public void setAnr(int anr) {
		this.anr = anr;
	}

	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	public String getLocatie() {
		return locatie;
	}

	public void setLocatie(String locatie) {
		this.locatie = locatie;
	}

	public Medewerker getHoofd() {
		return hoofd;
	}

	public void setHoofd(Medewerker hoofd) {
		this.hoofd = hoofd;
	}

	public Afdeling(int anr, String naam, String locatie, Medewerker hoofd) {
		super();
		this.anr = anr;
		this.naam = naam;
		this.locatie = locatie;
		this.hoofd = hoofd;
	}
	
}
