package eObrazovanje.web.model;

import java.util.Date;

public class Obaveza {

	
	private Integer obavezaId;
	private Ucenik ucenik;
	
	private Predmet predmet;
	
	private Date datumObaveze;
	
	private Boolean polozenPredmet;
	
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
