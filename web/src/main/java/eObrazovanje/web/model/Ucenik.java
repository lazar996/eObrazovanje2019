package eObrazovanje.web.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.swing.plaf.basic.BasicToolBarUI.DockingListener;

@Entity(name ="ucenik")
public class Ucenik extends Korisnik{
	
	private String brojIndeksa;
	
	private List<Dokumenta> dokumenti = new ArrayList<>();
	
	private List<PohadjanjePredmeta> pohadjanjePredmeta= new ArrayList<>();
	
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
