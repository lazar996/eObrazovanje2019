package eObrazovanje.web.model;

import javax.persistence.Entity;

@Entity(name="pohadjanjePredmeta")
public class PohadjanjePredmeta {

	
	private Integer id;
	
	private Ucenik ucenik;
	
	private Predmet predmet;

	
	public PohadjanjePredmeta() {
		
	}


	public PohadjanjePredmeta(Integer id, Ucenik ucenik, Predmet predmet) {
		super();
		this.id = id;
		this.ucenik = ucenik;
		this.predmet = predmet;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Ucenik getUcenik() {
		return ucenik;
	}


	public void setUcenik(Ucenik ucenik) {
		this.ucenik = ucenik;
	}


	public Predmet getPredmet() {
		return predmet;
	}


	public void setPredmet(Predmet predmet) {
		this.predmet = predmet;
	}


	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
	
}
