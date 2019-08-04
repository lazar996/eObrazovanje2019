package eObrazovanje.web.dto;

import java.util.Date;

import eObrazovanje.web.model.Obaveza;

public class ObavezaDTO {

	
	
	private Integer id;
	private String brojIndeksa;
	private Integer predmetId;
	private Date datumObaveze;
	private boolean polozenPrdemt;
	private String nazivObaveze;
	private String predmetNaziv;
	private String imePrezime;
	
	
	
	public ObavezaDTO() {
		super();
	}



	public ObavezaDTO(Obaveza obaveza) {
		
		this.id = obaveza.getObavezaId();
		this.brojIndeksa = obaveza.getUcenik().getBrojIndeksa();
		this.predmetId = obaveza.getPredmet().getPredmetId();
		this.datumObaveze = obaveza.getDatumObaveze();
		this.polozenPrdemt = obaveza.getPolozenPredmet();
		this.nazivObaveze = obaveza.getNazivObaveze();
		this.predmetNaziv = obaveza.getPredmet().getNaziv();
		this.imePrezime = obaveza.getUcenik().getIme() + " " + obaveza.getUcenik().getPrezime();
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getBrojIndeksa() {
		return brojIndeksa;
	}



	public void setBrojIndeksa(String brojIndeksa) {
		this.brojIndeksa = brojIndeksa;
	}



	public Integer getPredmetId() {
		return predmetId;
	}



	public void setPredmetId(Integer predmetId) {
		this.predmetId = predmetId;
	}



	public Date getDatumObaveze() {
		return datumObaveze;
	}



	public void setDatumObaveze(Date datumObaveze) {
		this.datumObaveze = datumObaveze;
	}



	public boolean isPolozenPrdemt() {
		return polozenPrdemt;
	}



	public void setPolozenPrdemt(boolean polozenPrdemt) {
		this.polozenPrdemt = polozenPrdemt;
	}



	public String getNazivObaveze() {
		return nazivObaveze;
	}



	public void setNazivObaveze(String nazivObaveze) {
		this.nazivObaveze = nazivObaveze;
	}



	public String getPredmetNaziv() {
		return predmetNaziv;
	}



	public void setPredmetNaziv(String predmetNaziv) {
		this.predmetNaziv = predmetNaziv;
	}



	public String getImePrezime() {
		return imePrezime;
	}



	public void setImePrezime(String imePrezime) {
		this.imePrezime = imePrezime;
	}



	@Override
	public String toString() {
		return "ObavezaDTO [id=" + id + ", brojIndeksa=" + brojIndeksa + ", predmetId=" + predmetId + ", datumObaveze="
				+ datumObaveze + ", polozenPrdemt=" + polozenPrdemt + ", nazivObaveze=" + nazivObaveze
				+ ", predmetNaziv=" + predmetNaziv + ", imePrezime=" + imePrezime + "]";
	}
	
	
}
