package eObrazovanje.web.dto;

public class PohadjanjePredmetaDTO {

	
	private long jmbg;
	private int predmetId;
	
	
	
	public PohadjanjePredmetaDTO() {
		super();
	}



	public PohadjanjePredmetaDTO(long jmbg, int predmetId) {
		super();
		this.jmbg = jmbg;
		this.predmetId = predmetId;
	}



	public long getJmbg() {
		return jmbg;
	}



	public void setJmbg(long jmbg) {
		this.jmbg = jmbg;
	}



	public int getPredmetId() {
		return predmetId;
	}



	public void setPredmetId(int predmetId) {
		this.predmetId = predmetId;
	}
	
	
	
}
