package jdbc;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SchaalDAO extends BaseDao {
	private ArrayList<Schaal> selectSchalen(String query){
		ArrayList<Schaal> schalen = new ArrayList<Schaal>();
		try(Connection con = super.connect()){
			Statement stmt = con.createStatement();
	ResultSet dbResultSet = stmt.executeQuery(query);
	
	while (dbResultSet.next()){
		Integer snr = dbResultSet.getInt("SNR");
		Integer ondergrens = dbResultSet.getInt("ONDERGRENS");
		Integer bovengrens = dbResultSet.getInt("BOVENGRENS");
		Integer toelage = dbResultSet.getInt("TOELAGE");
		
		Schaal schaal = new Schaal(snr,ondergrens,bovengrens,toelage);
		schalen.add(schaal);
	}
	}
	catch(SQLException e){
		e.printStackTrace();
	}
		return schalen;
}
	public ArrayList<Schaal> selectAll() {
		return selectSchalen("SELECT * FROM schalen");
	}
	
	public Schaal findByCode(int id) {
		return selectSchalen("SELECT * FROM schalen WHERE snr = " + id ).get(0);
	}
	
	public Schaal update(Schaal schaal) {
		try (Connection con = super.connect()) {
			Statement stmt = con.createStatement();
			String query = " update schalen set snr= "+schaal.getSnr()+", ondergrens= "+schaal.getOndergrens()+",  bovengrens="+schaal.getBovengrens()+" , toelage= "+schaal.getToelage()+" where snr= "+schaal.getSnr();
			System.out.println(query);
			stmt.executeUpdate(query);
			
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		
		return findByCode(schaal.getSnr());
	}
	
	public boolean delete(Schaal s) {
		try (Connection con = super.connect()) {
			Statement stmt = con.createStatement();
			String query = "DELETE FROM schalen WHERE snr=" + s.getSnr();
			stmt.executeUpdate(query);
			return true;
			
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			return false;
		}
	}
	
	public Schaal insert(Schaal s) {
		try (Connection con = super.connect()) {
			Statement stmt = con.createStatement();
			String query = "insert into schalen(snr,ondergrens,bovengrens,toelage)"
			+"values("+s.getSnr()+","+ s.getOndergrens() +","+ s.getBovengrens() +","+ s.getToelage()+" )";
			stmt.executeQuery(query);
			
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		
		return findByCode(s.getSnr());
	}
}
