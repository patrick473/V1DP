package muziekDAO;

import java.util.ArrayList;

public class Nummer {

	Integer id;
	String titel;
	ArrayList<Album> albumlijst = new ArrayList<Album>();
	
	
	public Nummer(String titel) {
		super();
		this.titel = titel;
	}
	public Nummer(Integer id, String titel) {
		super();
		this.id = id;
		this.titel = titel;

	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitel() {
		return titel;
	}
	public void setTitel(String titel) {
		this.titel = titel;
	}
	public ArrayList<Album> getAlbumlijst() {
		return albumlijst;
	}
	public void setAlbumlijst(ArrayList<Album> albumlijst) {
		this.albumlijst = albumlijst;
	}
	public void addAlbum(Album a){
		albumlijst.add(a);
		System.out.println(albumlijst);
	}
	@Override
	public String toString() {
		return "Nummer [id=" + id + ", titel=" + titel + ", albumlijst=" + albumlijst + "]";
	}
	
	
}
