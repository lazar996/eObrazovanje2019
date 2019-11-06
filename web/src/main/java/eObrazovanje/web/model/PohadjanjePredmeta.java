package eObrazovanje.web.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="pohadjanjePredmeta")
public class PohadjanjePredmeta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="pohadjanjePredmeta_id")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="jmbg", referencedColumnName = "jmbg", nullable = false)
	private Ucenik ucenik;
	
	
	@ManyToOne
	@JoinColumn(name = "prdmet_id", referencedColumnName = "predmet_id", nullable = false)
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
