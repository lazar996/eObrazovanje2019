package eObrazovanje.web.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity(name = "obaveza")
public class Obaveza {

	@Id
	@GeneratedValue
	@Column(name = "obaveza_id")
	private Integer obavezaId;
	
	@ManyToOne
	@JoinColumn(name="jmbg", referencedColumnName = "jmbg", nullable = false)
	private Ucenik ucenik;
	
	@ManyToOne
	@JoinColumn(name="prdmet_id", referencedColumnName = "predmet_id", nullable = false)
	private Predmet predmet;
	
	@Column(nullable = false)
	private Date datumObaveze;
	
	@Column(nullable = false)
	private Boolean polozenPredmet;
	
	@Column(name= "naziv_obaveze", nullable = false)
	private String nazivObaveze;

	
	
	public Obaveza() {
		super();
	}



	public Obaveza(Integer obavezaId, Ucenik ucenik, Predmet predmet, Date datumObaveze, Boolean polozenPredmet,
			String nazivObaveze) {
		super();
		this.obavezaId = obavezaId;
		this.ucenik = ucenik;
		this.predmet = predmet;
		this.datumObaveze = datumObaveze;
		this.polozenPredmet = polozenPredmet;
		this.nazivObaveze = nazivObaveze;
	}



	public Integer getObavezaId() {
		return obavezaId;
	}



	public void setObavezaId(Integer obavezaId) {
		this.obavezaId = obavezaId;
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



	public Date getDatumObaveze() {
		return datumObaveze;
	}



	public void setDatumObaveze(Date datumObaveze) {
		this.datumObaveze = datumObaveze;
	}



	public Boolean getPolozenPredmet() {
		return polozenPredmet;
	}



	public void setPolozenPredmet(Boolean polozenPredmet) {
		this.polozenPredmet = polozenPredmet;
	}



	public String getNazivObaveze() {
		return nazivObaveze;
	}



	public void setNazivObaveze(String nazivObaveze) {
		this.nazivObaveze = nazivObaveze;
	}



	@Override
	public String toString() {
		return "Obaveza [obavezaId=" + obavezaId + ", ucenik=" + ucenik + ", predmet=" + predmet + ", datumObaveze="
				+ datumObaveze + ", polozenPredmet=" + polozenPredmet + ", nazivObaveze=" + nazivObaveze + "]";
	}




	
	
}
