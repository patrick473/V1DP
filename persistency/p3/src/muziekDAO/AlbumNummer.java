package muziekDAO;

public class AlbumNummer {
	
	Album album;
	Nummer nummer;
	
	public AlbumNummer(Album album, Nummer nummer) {
		super();
		this.album = album;
		this.nummer = nummer;
	}
	public Album getAlbum() {
		return album;
	}
	public void setAlbum(Album album) {
		this.album = album;
	}
	public Nummer getNummer() {
		return nummer;
	}
	public void setNummer(Nummer nummer) {
		this.nummer = nummer;
	}
	@Override
	public String toString() {
		return "AlbumNummer [album=" + album + ", nummer=" + nummer + "]";
	}

	
}

