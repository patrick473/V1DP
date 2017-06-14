package muziekDAO;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;

public class Main {

	public static void main(String[] args) {
		Album ab = new Album("TestAlbum1",new Date(17,10,17));
		Album ac = new Album("TestAlbum2",new Date(17,10,17));
		Nummer n1 = new Nummer ("test1");
		Nummer n2 = new Nummer("test2");
		
		
		AlbumDAO adao = new AlbumDAO();
		NummerDAO ndao = new NummerDAO();
		AlbumNummerDAO andao = new AlbumNummerDAO();
		service s = new service();
	Album a = adao.findByCode(4);
	ArrayList<AlbumNummer> anlist = andao.findByAlbum(a.getId());
	ArrayList<Nummer> alist = new ArrayList<Nummer>();
	for ( AlbumNummer an : anlist){
		
		alist.add(an.getNummer());
	}
	a.setNummerlijst(alist);
	System.out.println(a);
	
	System.out.println(adao.insert(ab));
	System.out.println(adao.insert(ac));
	System.out.println(ndao.insert(n1));
	System.out.println(ndao.insert(n2));
	ab = adao.findByCode(29);
	ac= adao.findByCode(20);
	n1=  ndao.findByCode(1);
	n2 = ndao.findByCode(41);
	AlbumNummer an1 = new AlbumNummer(ab,n1);
	AlbumNummer an2 = new AlbumNummer(ab,n2);
	AlbumNummer an3 = new AlbumNummer(ac,n1);
	AlbumNummer an4 = new AlbumNummer(ac,n2);
	System.out.println(andao.insert(an1));
	System.out.println(andao.insert(an2));
	System.out.println(andao.insert(an3));
	System.out.println(andao.insert(an4));
	
	Nummer n = ndao.findByCode(53);
	ArrayList<AlbumNummer> anslist = andao.findByNummer(n.getId());
	ArrayList<Album> nlist = new ArrayList<Album>();
	for ( AlbumNummer an : anslist){
		
		nlist.add(an.getAlbum());
	}
	n.setAlbumlijst(nlist);
	System.out.println(n);
	n.setTitel("dit is een geupdate titel");
	System.out.println(n);
	
	Nummer nnn = ndao.findByCode(n.getId());
	System.out.println(nnn);
	}
	
	

}
