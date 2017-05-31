package muziekDAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class AlbumNummerDAO extends BaseDao {
	private ArrayList<AlbumNummer> selectAlbumNummer(String query){
		ArrayList<AlbumNummer> aN = new ArrayList<AlbumNummer>();
		try(Connection con = super.connect()){
			Statement stmt = con.createStatement();
	ResultSet dbResultSet = stmt.executeQuery(query);
	
	while (dbResultSet.next()){
		Integer aid = dbResultSet.getInt("album_id");
		Integer nid = dbResultSet.getInt("nummer_id");
		AlbumNummer an = new AlbumNummer(aid,nid);
		aN.add(an);
	}
	}
	catch(SQLException e){
		e.printStackTrace();
	}
		return aN;
}
	public ArrayList<AlbumNummer> selectAll() {
		return selectAlbumNummer("SELECT * FROM album_nummer");
	}
	
	public AlbumNummer findByAlbum(int id) {
		return selectAlbumNummer("SELECT * FROM album_nummer WHERE album_id = " + id ).get(0);
	}
	public AlbumNummer findByNummer(int id) {
		return selectAlbumNummer("SELECT * FROM album_nummer WHERE nummer_id = " + id ).get(0);
	}
	public AlbumNummer findByAlbumNummer(int aid,int nid) {
		return selectAlbumNummer("SELECT * FROM album_nummer WHERE( album_id = " + aid +" and nummer_id= "+ nid+")").get(0);
	}
	public AlbumNummer insert(AlbumNummer an) {
		try (Connection con = super.connect()) {
			Statement stmt = con.createStatement();
			String query = "insert into album_nummer(album_id,nummer_id)"
			+"values("+an.getAlbumID()+","+ an.getNummerID() +" )";
			stmt.executeQuery(query);
			
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		
		return findByAlbumNummer(an.getAlbumID(),an.getNummerID());
	}
}
