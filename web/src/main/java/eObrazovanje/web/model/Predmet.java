package eObrazovanje.web.model;

import javax.persistence.Entity;

@Entity(name= "predmet")
public class Predmet {
	private Integer predmetId;
	private String naziv;
	private String opis;
	
	
	
	public Predmet() {
	
	}
	public Predmet(Integer predmetId, String naziv, String opis) {
		super();
		this.predmetId = predmetId;
		this.naziv = naziv;
		this.opis = opis;
	}
	public Integer getPredmetId() {
		return predmetId;
	}
	public void setPredmetId(Integer predmetId) {
		this.predmetId = predmetId;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public String getOpis() {
		return opis;
	}
	public void setOpis(String opis) {
		this.opis = opis;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
	

}
