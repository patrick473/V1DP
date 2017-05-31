package muziekDAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Date;
import java.sql.PreparedStatement;

public class AlbumDAO extends BaseDao{

	private ArrayList<Album> selectAlbums(String query){
		ArrayList<Album> albums = new ArrayList<Album>();
		try(Connection con = super.connect()){
			Statement stmt = con.createStatement();
	ResultSet dbResultSet = stmt.executeQuery(query);
	
	while (dbResultSet.next()){
		Integer id = dbResultSet.getInt("id");
		String naam = dbResultSet.getString("naam");
		Date uitgeefdate = dbResultSet.getDate("uitgeef_datum");
		
		Album a = new Album(id,naam,uitgeefdate);
		albums.add(a);
	}
	}
	catch(SQLException e){
		e.printStackTrace();
	}
		return albums;
}
	public ArrayList<Album> selectAll() {
		return selectAlbums("SELECT * FROM album");
	}
	
	public Album findByCode(int id) {
		return selectAlbums("SELECT * FROM album WHERE id = " + id ).get(0);
	}
	public Album insert(Album a) {
		try (Connection con = super.connect()) {
			PreparedStatement stmt = con.prepareStatement("insert into album(id,naam,uitgeef_datum"
					+ ") values(?,?,?)");
			stmt.setInt(1, a.getId());
			stmt.setString(2, a.getNaam());
			Date aDate = a.getUitgeefDatum();
			String s = new SimpleDateFormat("dd/MMM/yy").format( aDate );
			System.out.println(aDate);
			stmt.setDate(3,aDate);
			System.out.println(stmt);
			stmt.executeUpdate();
			
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		
		return findByCode(a.getId());
	}
}
