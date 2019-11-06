package eObrazovanje.web.dto;

import eObrazovanje.web.model.Dokumenta;

public class DokumentaDTO {

	
	
	private Integer id;
	private String naziv;
	private String tipDokumenta;
	private String brojIndeksa;
	private String imePrezime;
	
	
	public DokumentaDTO() {
		super();
	}


	public DokumentaDTO(Dokumenta dokumenta) {
	
		this.id = dokumenta.getDokumentId();
		this.naziv = dokumenta.getNaziv();
		this.tipDokumenta = dokumenta.getTipDokumenta();
		this.brojIndeksa = dokumenta.getUcenik().getBrojIndeksa();
		this.imePrezime = dokumenta.getUcenik().getIme()+ " " + dokumenta.getUcenik().getPrezime();
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
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


	public String getBrojIndeksa() {
		return brojIndeksa;
	}


	public void setBrojIndeksa(String brojIndeksa) {
		this.brojIndeksa = brojIndeksa;
	}


	public String getImePrezime() {
		return imePrezime;
	}


	public void setImePrezime(String imePrezime) {
		this.imePrezime = imePrezime;
	}


	@Override
	public String toString() {
		return "DokmentaDTO [id=" + id + ", naziv=" + naziv + ", tipDokumenta=" + tipDokumenta + ", brojIndeksa="
				+ brojIndeksa + ", imePrezime=" + imePrezime + "]";
	}
	
	
}
