package eObrazovanje.web.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="polaganjePredmeta")
public class PolaganjePredmeta {

	
	@Id
	@GeneratedValue
	@Column(name="polaganje_id")
	private Integer polaganjeId;
	
	@ManyToOne
	@JoinColumn(name="jmbg", referencedColumnName = "jmbg", nullable = false)
	private Ucenik ucenik;
	
	@ManyToOne
	@JoinColumn(name="predmet_id",referencedColumnName = "predmet_id", nullable = false)
	private Predmet predmet;
	
	@Column(nullable = false)
	private Date datumPolaganja;
	
	@Column(nullable = false)
	private Boolean polozenPredmet;
	
	@Column(name="naziv_polaganja", nullable = false)
	private String nazivPolaganja;

	public PolaganjePredmeta(Integer polaganjeId, Ucenik ucenik, Predmet predmet, Date datumPolaganja,
			Boolean polozenPredmet, String nazivPolaganja) {
		super();
		this.polaganjeId = polaganjeId;
		this.ucenik = ucenik;
		this.predmet = predmet;
		this.datumPolaganja = datumPolaganja;
		this.polozenPredmet = polozenPredmet;
		this.nazivPolaganja = nazivPolaganja;
	}

	public PolaganjePredmeta() {
		super();
	}

	public Integer getPolaganjeId() {
		return polaganjeId;
	}

	public void setPolaganjeId(Integer polaganjeId) {
		this.polaganjeId = polaganjeId;
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

	public Date getDatumPolaganja() {
		return datumPolaganja;
	}

	public void setDatumPolaganja(Date datumPolaganja) {
		this.datumPolaganja = datumPolaganja;
	}

	public Boolean getPolozenPredmet() {
		return polozenPredmet;
	}

	public void setPolozenPredmet(Boolean polozenPredmet) {
		this.polozenPredmet = polozenPredmet;
	}

	public String getNazivPolaganja() {
		return nazivPolaganja;
	}

	public void setNazivPolaganja(String nazivPolaganja) {
		this.nazivPolaganja = nazivPolaganja;
	}

	@Override
	public String toString() {
		return "PolaganjePredmeta [polaganjeId=" + polaganjeId + ", ucenik=" + ucenik + ", predmet=" + predmet
				+ ", datumPolaganja=" + datumPolaganja + ", polozenPredmet=" + polozenPredmet + ", nazivPolaganja="
				+ nazivPolaganja + "]";
	}
	
	
	
}
