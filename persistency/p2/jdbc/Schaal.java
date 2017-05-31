package jdbc;

public class Schaal {

	
	Integer snr;
	Integer ondergrens;
	Integer bovengrens;
	Integer toelage;
	public Schaal(Integer snr, Integer ondergrens, Integer bovengrens,Integer toelage){
		this.snr = snr;
		this.ondergrens = ondergrens;
		this.bovengrens = bovengrens;
		this.toelage = toelage;
	}
	
	public Integer getSnr() {
		return snr;
	}

	public void setSnr(Integer snr) {
		this.snr = snr;
	}

	public Integer getOndergrens() {
		return ondergrens;
	}

	public void setOndergrens(Integer ondergrens) {
		this.ondergrens = ondergrens;
	}

	public Integer getBovengrens() {
		return bovengrens;
	}

	public void setBovengrens(Integer bovengrens) {
		this.bovengrens = bovengrens;
	}

	public Integer getToelage() {
		return toelage;
	}

	public void setToelage(Integer toelage) {
		this.toelage = toelage;
	}

	@Override
	public String toString() {
		return String.format("Schaal [snr=%s, ondergrens=%s, bovengrens=%s, toelage=%s]", snr, ondergrens, bovengrens,
				toelage);
	}
}
