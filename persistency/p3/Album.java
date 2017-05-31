package muziekDAO;

import java.sql.Date;

public class Album {
	Integer id;
	String naam;
	Date uitgeefDatum;
	public Album(Integer id, String naam, Date uitgeefDatum) {
		this.id = id;
		this.naam = naam;
		this.uitgeefDatum = uitgeefDatum;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNaam() {
		return naam;
	}
	public void setNaam(String naam) {
		this.naam = naam;
	}
	public Date getUitgeefDatum() {
		return uitgeefDatum;
	}
	public void setUitgeefDatum(Date uitgeefDatum) {
		this.uitgeefDatum = uitgeefDatum;
	}
	@Override
	public String toString() {
		return String.format("Album [id=%s, naam=%s, uitgeefDatum=%s]", id, naam, uitgeefDatum);
	}
	
	
}
