package eObrazovanje.web.dto;

import java.util.Date;

import eObrazovanje.web.model.PolaganjePredmeta;

public class PolaganjePredmetaDTO {

	
	private Integer id;
	private String brojIndeksa;
	private Integer predmetId;
	private Date datumPolaganja;
	private boolean polozenPredmet;
	private String nazivPolaganja;
	private String predmetNaziv;
	private String imePrezime;
	
	
	public PolaganjePredmetaDTO() {
		
		super();
	}
	
	
	public PolaganjePredmetaDTO(PolaganjePredmeta polaganjePredmeta) {
		
		this.id= polaganjePredmeta.getPolaganjeId();
		this.brojIndeksa=polaganjePredmeta.getUcenik().getBrojIndeksa();
		this.predmetId=polaganjePredmeta.getPredmet().getPredmetId();
		this.datumPolaganja= polaganjePredmeta.getDatumPolaganja();
		this.polozenPredmet= polaganjePredmeta.getPolozenPredmet();
		this.nazivPolaganja= polaganjePredmeta.getNazivPolaganja();
		this.predmetNaziv= polaganjePredmeta.getPredmet().getNaziv();
		this.imePrezime= polaganjePredmeta.getUcenik().getIme()+ " "+ polaganjePredmeta.getUcenik().getPrezime();
		
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


	public Date getDatumPolaganja() {
		return datumPolaganja;
	}


	public void setDatumPolaganja(Date datumPolaganja) {
		this.datumPolaganja = datumPolaganja;
	}


	public boolean isPolozenPredmet() {
		return polozenPredmet;
	}


	public void setPolozenPredmet(boolean polozenPredmet) {
		this.polozenPredmet = polozenPredmet;
	}


	public String getNazivPolaganja() {
		return nazivPolaganja;
	}


	public void setNazivPolaganja(String nazivPolaganja) {
		this.nazivPolaganja = nazivPolaganja;
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
		return "PolaganjePredmetaDTO [id=" + id + ", brojIndeksa=" + brojIndeksa + ", predmetId=" + predmetId
				+ ", datumPolaganja=" + datumPolaganja + ", polozenPredmet=" + polozenPredmet + ", nazivPolaganja="
				+ nazivPolaganja + ", predmetNaziv=" + predmetNaziv + ", imePrezime=" + imePrezime + "]";
	}
	
	
}
