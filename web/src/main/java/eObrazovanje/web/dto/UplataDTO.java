package eObrazovanje.web.dto;

import java.util.Date;

import eObrazovanje.web.model.Uplata;

public class UplataDTO {

	private Integer id;
	private Date datumUplate;
	private String svrhaUplate;
	private Float iznos;
	private String brojIndeksa;
	private String imePrezime;
	
	
	
	
	public UplataDTO() {
		super();
	}




	public UplataDTO(Uplata uplata) {
		super();
		this.id = uplata.getUplataId();
		this.datumUplate = uplata.getDatumUplate();
		this.svrhaUplate = uplata.getSvrhaUplate();
		this.iznos = uplata.getIznos();
		this.brojIndeksa = uplata.getUcenik().getBrojIndeksa();
		this.imePrezime = uplata.getUcenik().getIme() + " " + uplata.getUcenik().getPrezime();
	}




	public Integer getId() {
		return id;
	}




	public void setId(Integer id) {
		this.id = id;
	}




	public Date getDatumUplate() {
		return datumUplate;
	}




	public void setDatumUplate(Date datumUplate) {
		this.datumUplate = datumUplate;
	}




	public String getSvrhaUplate() {
		return svrhaUplate;
	}




	public void setSvrhaUplate(String svrhaUplate) {
		this.svrhaUplate = svrhaUplate;
	}




	public Float getIznos() {
		return iznos;
	}




	public void setIznos(Float iznos) {
		this.iznos = iznos;
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
		return "UplataDTO [id=" + id + ", datumUplate=" + datumUplate + ", svrhaUplate=" + svrhaUplate + ", iznos="
				+ iznos + ", brojIndeksa=" + brojIndeksa + ", imePrezime=" + imePrezime + "]";
	}
	
	
	
	
}
