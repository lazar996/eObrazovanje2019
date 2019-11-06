package eObrazovanje.web.model;

import javax.persistence.*;

@Entity(name = "predaje")
public class Predaje {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "predaje_id")
	private Integer predajeId;
	
	@ManyToOne
	@JoinColumn(name="jmbg", referencedColumnName = "jmbg", nullable = false)
	private Nastavnik nastavnik;
	
	
	@ManyToOne
	@JoinColumn(name="predmet_id", referencedColumnName = "predmet_id", nullable = false)
	private Predmet predmet;

	public Predaje() {
		super();
	}

	public Predaje(Integer predajeId, Nastavnik nastavnik, Predmet predmet) {
		super();
		this.predajeId = predajeId;
		this.nastavnik = nastavnik;
		this.predmet = predmet;
	}

	public Integer getPredajeId() {
		return predajeId;
	}

	public void setPredajeId(Integer predajeId) {
		this.predajeId = predajeId;
	}

	public Nastavnik getNastavnik() {
		return nastavnik;
	}

	public void setNastavnik(Nastavnik nastavnik) {
		this.nastavnik = nastavnik;
	}

	public Predmet getPredmet() {
		return predmet;
	}

	public void setPredmet(Predmet predmet) {
		this.predmet = predmet;
	}

	@Override
	public String toString() {
		return "Predaje [predajeId=" + predajeId + ", nastavnik=" + nastavnik + ", predmet=" + predmet + "]";
	}
	
	
}
