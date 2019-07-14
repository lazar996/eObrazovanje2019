package eObrazovanje.web.model;

public class Dokumenta {

	private Integer dokumentId;
	
	private String naziv;
	
	private String tipDokumenta;

	
	
	
	public Dokumenta() {
	
	}




	public Dokumenta(Integer dokumentId, String naziv, String tipDokumenta) {
		super();
		this.dokumentId = dokumentId;
		this.naziv = naziv;
		this.tipDokumenta = tipDokumenta;
	}




	public Integer getDokumentId() {
		return dokumentId;
	}




	public void setDokumentId(Integer dokumentId) {
		this.dokumentId = dokumentId;
	}




	public String getNaziv() {
		return naziv;
	}




	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}




	public String getTipDokumenta() {
		return tipDokumenta;
	}




	public void setTipDokumenta(String tipDokumenta) {
		this.tipDokumenta = tipDokumenta;
	}




	@Override
	public String toString() {
		return "Dokumenta [dokumentId=" + dokumentId + ", naziv=" + naziv + ", tipDokumenta=" + tipDokumenta + "]";
	}
	
	
	
	
}
