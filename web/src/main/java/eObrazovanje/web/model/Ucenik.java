package eObrazovanje.web.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name ="ucenik")
@DiscriminatorValue("ucenik")
public class Ucenik extends Korisnik{
	
	@Column(name="broj_indeksa", unique = true)
	private String brojIndeksa;
	
	@JsonIgnore
	@OneToMany(mappedBy = "ucenik", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	private List<Dokumenta> dokumenti = new ArrayList<>();
	@JsonIgnore
	@OneToMany(mappedBy = "ucenik", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	private List<PohadjanjePredmeta> pohadjanjePredmeta= new ArrayList<>();
	@JsonIgnore
	@OneToMany(mappedBy = "ucenik", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	private List<Obaveza> obaveza= new ArrayList<>();

	
	
	public Ucenik() {
		super();
	}



	public Ucenik(String brojIndeksa, List<Dokumenta> dokumenti, List<PohadjanjePredmeta> pohadjanjePredmeta,
			List<Obaveza> obaveza) {
		super();
		this.brojIndeksa = brojIndeksa;
		this.dokumenti = dokumenti;
		this.pohadjanjePredmeta = pohadjanjePredmeta;
		this.obaveza = obaveza;
	}



	public String getBrojIndeksa() {
		return brojIndeksa;
	}



	public void setBrojIndeksa(String brojIndeksa) {
		this.brojIndeksa = brojIndeksa;
	}



	public List<Dokumenta> getDokumenti() {
		return dokumenti;
	}



	public void setDokumenti(List<Dokumenta> dokumenti) {
		this.dokumenti = dokumenti;
	}



	public List<PohadjanjePredmeta> getPohadjanjePredmeta() {
		return pohadjanjePredmeta;
	}



	public void setPohadjanjePredmeta(List<PohadjanjePredmeta> pohadjanjePredmeta) {
		this.pohadjanjePredmeta = pohadjanjePredmeta;
	}



	public List<Obaveza> getObaveza() {
		return obaveza;
	}



	public void setObaveza(List<Obaveza> obaveza) {
		this.obaveza = obaveza;
	}



	@Override
	public String toString() {
		return "Ucenik [brojIndeksa=" + brojIndeksa + ", dokumenti=" + dokumenti + ", pohadjanjePredmeta="
				+ pohadjanjePredmeta + ", obaveza=" + obaveza + "]";
	}
	
	
	
	
	

}
