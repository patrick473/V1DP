package muziekDAO;

import java.util.ArrayList;

public class service {
	AlbumNummerDAO andao = new AlbumNummerDAO();
	
	
	public  ArrayList<Nummer> findNummers(Album a){
		ArrayList<AlbumNummer> anlist = andao.findByAlbum(a.getId());
		ArrayList<Nummer> alist = new ArrayList<Nummer>();
		for ( AlbumNummer an : anlist){
			
			alist.add(an.getNummer());
		}
		
		return alist;
	}
	public ArrayList<Album> findAlbums(Nummer n){
		ArrayList<AlbumNummer> anlist = andao.findByNummer(n.getId());
		ArrayList<Album> alist = new ArrayList<Album>();
		for ( AlbumNummer an : anlist){
			
			alist.add(an.getAlbum());
		}
		
		return alist;
	}
}
