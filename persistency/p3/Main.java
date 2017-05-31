package muziekDAO;

import java.sql.Date;
import java.util.Calendar;

public class Main {

	public static void main(String[] args) {
	Album ab = new Album(32,"TestAlbum1",new Date(17,10,17));
	Album ac = new Album(33,"TestAlbum2",new Date(17,10,17));
	Nummer n1 = new Nummer (56,"test1");
	Nummer n2 = new Nummer(57,"test2");
	AlbumNummer an1 = new AlbumNummer(32,56);
	AlbumNummer an2 = new AlbumNummer(32,57);
	AlbumNummer an3 = new AlbumNummer(33,56);
	AlbumNummer an4 = new AlbumNummer(33,57);
	
	AlbumNummerDAO andao = new AlbumNummerDAO();
	AlbumDAO adao = new AlbumDAO();
	NummerDAO ndao = new NummerDAO();
	
	
	System.out.println(adao.insert(ab));
	System.out.println(adao.insert(ac));
	System.out.println(ndao.insert(n1));
	System.out.println(ndao.insert(n2));
	
	System.out.println(andao.insert(an1));
	System.out.println(andao.insert(an2));
	System.out.println(andao.insert(an3));
	System.out.println(andao.insert(an4));
	System.out.println(andao.findByAlbum(32));
	System.out.println(andao.findByAlbum(33));
	System.out.println(andao.findByNummer(56));
	System.out.println(andao.findByNummer(57));
	}

}
