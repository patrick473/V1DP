package jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class MedewerkerDAO extends BaseDao{
	private ArrayList<Medewerker> selectMedewerkers(String query){
		ArrayList<Medewerker> medewerkers = new ArrayList<Medewerker>();
		try(Connection con = super.connect()){
			Statement stmt = con.createStatement();
	ResultSet dbResultSet = stmt.executeQuery(query);
	
	while (dbResultSet.next()){
		Integer mnr = dbResultSet.getInt("MNR");
		String naam = dbResultSet.getString("NAAM");
		String voorl = dbResultSet.getString("VOORL");
		String functie = dbResultSet.getString("FUNCTIE");
		Integer chef = dbResultSet.getInt("CHEF");
		Date gbdatum = dbResultSet.getDate("GBDATUM");
		Integer maandsal = dbResultSet.getInt("MAANDSAL");
		Integer comm = dbResultSet.getInt("COMM");
		Integer afd = dbResultSet.getInt("AFD");
		String geslacht= dbResultSet.getString("GESLACHT");
		  String dateString = null;
		   SimpleDateFormat sdfr = new SimpleDateFormat("dd/MMM/yy");
		   dateString = sdfr.format( gbdatum );
		Medewerker medewerker = new Medewerker(mnr,naam,voorl,functie,chef,dateString,maandsal,comm,afd,geslacht);
	medewerkers.add(medewerker);
	}
	}
	catch(SQLException e){
		e.printStackTrace();
	}
		return medewerkers;
}

public ArrayList<Medewerker> selectAll() {
	return selectMedewerkers("SELECT * FROM medewerkers");
}

public Medewerker findByCode(int id) {
	return selectMedewerkers("SELECT * FROM Medewerkers WHERE mnr = " + id + "").get(0);
}

public Medewerker update(Medewerker m) {
	try (Connection con = super.connect()) {
		Statement stmt = con.createStatement();
		String query = "UPDATE medewerkers SET mnr=" + m.getMnr()
				+ ", naam='" + m.getNaam() + "',voorl='"
				+ m.getVoorl() + "', functie='" + m.getFunctie()
				+ "', chef=" + m.getChef() + ", gbdatum=to_date('"+
				m.getGbdatum() +"','DD-Mon-YY'), maandsal="+m.getMaandsal()
				+ ",comm= "+m.getComm()+", afd="+m.getAfd()+", geslacht='"+m.getGeslacht()
				+ "' WHERE mnr = "+ m.getMnr();
		stmt.executeUpdate(query);
		
	} catch (SQLException sqle) {
		sqle.printStackTrace();
	}
	
	return findByCode(m.getMnr());
}

public boolean delete(Medewerker m) {
	try (Connection con = super.connect()) {
		Statement stmt = con.createStatement();
		String query = "update afdelingen "
				+ "set hoofd=null "
				+ "where hoofd="+m.getMnr()+" ";
		stmt.executeUpdate(query);
		query = "DELETE FROM historie WHERE mnr=" + m.getMnr() + "";
		stmt.executeUpdate(query);
		query = "delete from inschrijvingen where cursist="+m.getMnr();
		stmt.executeUpdate(query);
		query ="update uitvoeringen "
				+ "set docent=null "
				+ "where docent= "+m.getMnr()+" ";
		stmt.executeUpdate(query);
		query ="delete from medewerkers where mnr="+m.getMnr()+" ";
		return true;
		
	} catch (SQLException sqle) {
		sqle.printStackTrace();
		return false;
	}
}

public Medewerker insert(Medewerker m) {
	try (Connection con = super.connect()) {
		Statement stmt = con.createStatement();
		String query = "INSERT INTO medewerkers"
				+ "(mnr,naam,voorl,functie,chef,gbdatum,maandsal,comm,afd,geslacht) "
				+ "VALUES (" + m.getMnr()
				+ ", '" + m.getNaam() + "','"
				+ m.getVoorl() + "', '" + m.getFunctie()
				+ "', " + m.getChef() + ", to_date('"+
				m.getGbdatum() +"','DD-Mon-YY'), "+m.getMaandsal()
				+ ", "+m.getComm()+", "+m.getAfd()+", '"+m.getGeslacht()+"')";
		stmt.executeUpdate(query);
		
	} catch (SQLException sqle) {
		sqle.printStackTrace();
	}
	
	return findByCode(m.getMnr());
}
}