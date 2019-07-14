package eObrazovanje.web.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;

@Entity(name = "nastavnik")
public class Nastavnik extends Korisnik {

	
	private String zvanje;
	private List<Predaje> predaje = new ArrayList<>();
	
	
	
	public Nastavnik() {
		super();
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
