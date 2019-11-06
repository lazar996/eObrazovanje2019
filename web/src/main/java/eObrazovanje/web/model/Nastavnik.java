package eObrazovanje.web.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "nastavnik")
public class Nastavnik extends Korisnik {

	
	@Column(name="zvanje")
	private String zvanje;
	
	 @JsonIgnore
	 @OneToMany(mappedBy = "nastavnik",fetch = FetchType.LAZY,cascade = CascadeType.REFRESH)
	private List<Predaje> predaje = new ArrayList<>();
	
	
	
	public Nastavnik() {
		super("nastavnik");
	}



	public String getZvanje() {
		return zvanje;
	}



	public void setZvanje(String zvanje) {
		this.zvanje = zvanje;
	}



	public List<Predaje> getPredaje() {
		return predaje;
	}



	public void setPredaje(List<Predaje> predaje) {
		this.predaje = predaje;
	}



	public Nastavnik(String zvanje, List<Predaje> predaje) {
		super();
		this.zvanje = zvanje;
		this.predaje = predaje;
	}



	@Override
	public String toString() {
		return "Nastavnik [zvanje=" + zvanje + ", predaje=" + predaje + "]";
	}
	
	
}
