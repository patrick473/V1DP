package muziekDAO;

public class AlbumNummer {
	@Override
	public String toString() {
		return String.format("AlbumNummer [albumID=%s, nummerID=%s]", albumID, nummerID);
	}
	Integer albumID;
	Integer nummerID;

	public AlbumNummer(Integer albumID, Integer nummerID) {
		this.albumID = albumID;
		this.nummerID = nummerID;
	}
	public Integer getAlbumID() {
		return albumID;
	}
	public void setAlbumID(Integer albumID) {
		this.albumID = albumID;
	}
	public Integer getNummerID() {
		return nummerID;
	}
	public void setNummerID(Integer nummerID) {
		this.nummerID = nummerID;
	}
	
}

