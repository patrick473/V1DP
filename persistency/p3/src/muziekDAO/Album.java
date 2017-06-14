package muziekDAO;

import java.sql.Date;
import java.util.ArrayList;

public class Album {
	Integer id;
	String naam;
	Date uitgeefDatum;
	ArrayList<Nummer> nummerlijst = new ArrayList<Nummer>();
	
	public Album(String naam, Date uitgeefDatum) {
		super();
		this.naam = naam;
		this.uitgeefDatum = uitgeefDatum;
		
	}
	public Album(Integer id, String naam, Date uitgeefDatum) {
		super();
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
	public ArrayList<Nummer> getNummerlijst() {
		return nummerlijst;
	}
	public void setNummerlijst(ArrayList<Nummer> nummerlijst) {
		this.nummerlijst = nummerlijst;
	}
	public void addNummer(Nummer n){
		nummerlijst.add(n);
		System.out.println(nummerlijst);
	}
	@Override
	public String toString() {
		return "Album [id=" + id + ", naam=" + naam + ", uitgeefDatum=" + uitgeefDatum + ", nummerlijst=" + nummerlijst
				+ "]";
	}
}
