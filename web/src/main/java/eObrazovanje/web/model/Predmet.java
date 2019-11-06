package eObrazovanje.web.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity(name= "predmet")
public class Predmet {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="predmet_id")
	private Integer predmetId;
	
	@NotBlank(message = "unesite naziv")
	@Column(nullable = false)
	private String naziv;
	
	@Column
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
		return "Predmet [predmetId=" + predmetId + ", naziv=" + naziv + ", opis=" + opis + "]";
	}

	
	

}
