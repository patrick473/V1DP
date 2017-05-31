package jdbc;



public class Medewerker {
	Integer mnr ;
	String naam ;
	String voorl ;
	String functie;
	Integer chef;
	String gbdatum ;
	Integer maandsal ;
	Integer comm ;
	Integer afd ;
	String geslacht;
	public Medewerker(Integer mnr, String naam, String voorl, String functie, Integer chef, String gbdatum,
			Integer maandsal, Integer comm, Integer afd, String geslacht) {
		this.mnr = mnr;
		this.naam = naam;
		this.voorl = voorl;
		this.functie = functie;
		this.chef = chef;
		this.gbdatum = gbdatum;
		this.maandsal = maandsal;
		this.comm = comm;
		this.afd = afd;
		this.geslacht = geslacht;
	}
	
	public Integer getMnr() {
		return mnr;
	}

	public void setMnr(Integer mnr) {
		this.mnr = mnr;
	}

	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	public String getVoorl() {
		return voorl;
	}

	public void setVoorl(String voorl) {
		this.voorl = voorl;
	}

	public String getFunctie() {
		return functie;
	}

	public void setFunctie(String functie) {
		this.functie = functie;
	}

	public Integer getChef() {
		return chef;
	}

	public void setChef(Integer chef) {
		this.chef = chef;
	}

	public String getGbdatum() {
		return gbdatum;
	}

	public void setGbdatum(String gbdatum) {
		this.gbdatum = gbdatum;
	}

	public Integer getMaandsal() {
		return maandsal;
	}

	public void setMaandsal(Integer maandsal) {
		this.maandsal = maandsal;
	}

	public Integer getComm() {
		return comm;
	}

	public void setComm(Integer comm) {
		this.comm = comm;
	}

	public Integer getAfd() {
		return afd;
	}

	public void setAfd(Integer afd) {
		this.afd = afd;
	}

	public String getGeslacht() {
		return geslacht;
	}

	public void setGeslacht(String geslacht) {
		this.geslacht = geslacht;
	}

	@Override
	public String toString() {
		return String.format(
				"Medewerker [mnr=%s, naam=%s, voorl=%s, functie=%s, chef=%s, gbdatum=%s, maandsal=%s, comm=%s, afd=%s, geslacht=%s]",
				mnr, naam, voorl, functie, chef, gbdatum, maandsal, comm, afd, geslacht);
	}
	
}
