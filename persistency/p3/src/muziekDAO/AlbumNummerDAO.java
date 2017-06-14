package muziekDAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class AlbumNummerDAO extends BaseDao {
	AlbumDAO adao = new AlbumDAO();
	NummerDAO ndao = new NummerDAO();
	private ArrayList<AlbumNummer> selectAlbumNummer(String query){
		ArrayList<AlbumNummer> aN = new ArrayList<AlbumNummer>();
		try(Connection con = super.connect()){
			Statement stmt = con.createStatement();
	ResultSet dbResultSet = stmt.executeQuery(query);
	
	while (dbResultSet.next()){
		Integer aid = dbResultSet.getInt("album_id");
		Integer nid = dbResultSet.getInt("nummer_id");
		Album a = adao.findByCode(aid);
		Nummer n = ndao.findByCode(nid);
		AlbumNummer an = new AlbumNummer(a,n);
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
	
	public ArrayList<AlbumNummer> findByAlbum(int id) {
		return selectAlbumNummer("SELECT * FROM album_nummer WHERE album_id = " + id );
	}
	public ArrayList<AlbumNummer> findByNummer(int id) {
		return selectAlbumNummer("SELECT * FROM album_nummer WHERE nummer_id = " + id );
	}
	public AlbumNummer findByAlbumNummer(int aid,int nid) {
		return selectAlbumNummer("SELECT * FROM album_nummer WHERE( album_id = " + aid +" and nummer_id= "+ nid+")").get(0);
	}
	public AlbumNummer insert(AlbumNummer an) {
		try (Connection con = super.connect()) {
			Statement stmt = con.createStatement();
			String query = "insert into album_nummer "
			+"values("+an.getAlbum().getId()+","+ an.getNummer().getId() +" )";
			stmt.executeUpdate(query);
			
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		
		return an;
	}
}
