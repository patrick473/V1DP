package jdbc;



public class testrunner {

	public static void main(String[] args) {
	SchaalDAO sdao = new SchaalDAO();
	MedewerkerDAO mdao = new MedewerkerDAO();
	AfdelingDAO adao = new AfdelingDAO();
	
	System.out.println("crud schaal volgorde select insert update  delete");

	Schaal s = new Schaal(14,9000,9500,240);
	
	System.out.println(sdao.selectAll());
	System.out.println(sdao.insert(s));
	s.setBovengrens(9500);
	System.out.println(sdao.update(s));
	System.out.println(sdao.delete(s));

	
	System.out.println("crud medewerker volgorde select insert update delete");
	
	
	Medewerker m = new Medewerker(8010,"Test","T","VERKOPER",7839,"17-Jan-99",4000,400,30,"m");
	Afdeling afdeling = adao.findByCode(m.getAfd());
	System.out.println(afdeling);
	System.out.println(mdao.selectAll());
	System.out.println(mdao.insert(m));
	m.setNaam("TestT");
	System.out.println(mdao.update(m));
	System.out.println(mdao.delete(m));

	
	
	
	
	}

}
