package muziekDAO;

public class Nummer {

	Integer id;
	String titel;
	public Nummer(Integer id, String titel) {
		this.id = id;
		this.titel = titel;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitel() {
		return titel;
	}
	public void setTitel(String titel) {
		this.titel = titel;
	}
	@Override
	public String toString() {
		return String.format("Nummer [id=%s, titel=%s]", id, titel);
	}
	
}
