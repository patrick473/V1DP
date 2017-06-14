package muziekDAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class NummerDAO extends BaseDao {
	
	private ArrayList<Nummer> selectNummers(String query){
		ArrayList<Nummer> nummers = new ArrayList<Nummer>();
		try(Connection con = super.connect()){
			Statement stmt = con.createStatement();
			
	ResultSet dbResultSet = stmt.executeQuery(query);
	
	while (dbResultSet.next()){
		Integer id = dbResultSet.getInt("id");
		String titel = dbResultSet.getString("titel");
	
		
		Nummer n = new Nummer(id,titel);
		nummers.add(n);
	}
	}
	catch(SQLException e){
		e.printStackTrace();
	}
		return nummers;
}
	public ArrayList<Nummer> selectAll() {
		return selectNummers("SELECT * FROM nummer");
	}
	
	public Nummer findByCode(int id) {
		return selectNummers("SELECT * FROM nummer WHERE id = " + id ).get(0);
	}
	
	public Nummer insert(Nummer n) {
		try (Connection con = super.connect()) {
			Statement stmt = con.createStatement();
			String query = "insert into nummer "
			+"values(nummer_seq.nextval,'"+ n.getTitel() +"' )";
			stmt.executeUpdate(query);
			
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		
		return n;
	}

}
