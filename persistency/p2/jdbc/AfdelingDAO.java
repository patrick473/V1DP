package jdbc;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
public class AfdelingDAO extends BaseDao {
		private ArrayList<Afdeling> selectAfdelingen(String query){
			ArrayList<Afdeling> afdelingen = new ArrayList<Afdeling>();
			try(Connection con = super.connect()){
				Statement stmt = con.createStatement();
		ResultSet dbResultSet = stmt.executeQuery(query);
		
		while (dbResultSet.next()){
			Integer anr = dbResultSet.getInt("ANR");
			String naam = dbResultSet.getString("NAAM");
			String locatie = dbResultSet.getString("LOCATIE");
			int hoofd = dbResultSet.getInt("HOOFD");
			MedewerkerDAO mdao = new MedewerkerDAO();
			Medewerker hoofdpersoon = mdao.findByCode(hoofd);
			Afdeling afdeling = new Afdeling(anr,naam,locatie,hoofdpersoon);
			afdelingen.add(afdeling);
		}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
			return afdelingen;
	}

	public ArrayList<Afdeling> selectAll() {
		return selectAfdelingen("SELECT * FROM afdelingen");
	}

	public Afdeling findByCode(int id) {
		return selectAfdelingen("SELECT * FROM afdelingen WHERE anr = " + id + "").get(0);
	}

	}
	