package eObrazovanje.web.model;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.Min;

@Entity(name= "uplata")
public class Uplata {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="uplata_id")
	private Integer uplataId;
	
	@Column(name="datum_uplate", nullable = false)
	private Date datumUplate;
	
	@Column(name="svrha_uplate", nullable = false)
	private String SvrhaUplate;
	
	@Min(value = 1, message = "mora biti +")
	private  float iznos;
	
	@ManyToOne
	@JoinColumn(name="jmbg", referencedColumnName = "jmbg", nullable = false)
	private Ucenik ucenik;

	public Uplata() {
		super();
	}

	public Uplata(Integer uplataId, Date datumUplate, String svrhaUplate, float iznos, Ucenik ucenik) {
		super();
		this.uplataId = uplataId;
		this.datumUplate = datumUplate;
		SvrhaUplate = svrhaUplate;
		this.iznos = iznos;
		this.ucenik = ucenik;
	}

	public Integer getUplataId() {
		return uplataId;
	}

	public void setUplataId(Integer uplataId) {
		this.uplataId = uplataId;
	}

	public Date getDatumUplate() {
		return datumUplate;
	}

	public void setDatumUplate(Date datumUplate) {
		this.datumUplate = datumUplate;
	}

	public String getSvrhaUplate() {
		return SvrhaUplate;
	}

	public void setSvrhaUplate(String svrhaUplate) {
		SvrhaUplate = svrhaUplate;
	}

	public float getIznos() {
		return iznos;
	}

	public void setIznos(float iznos) {
		this.iznos = iznos;
	}

	public Ucenik getUcenik() {
		return ucenik;
	}

	public void setUcenik(Ucenik ucenik) {
		this.ucenik = ucenik;
	}

	@Override
	public String toString() {
		return "Uplata [uplataId=" + uplataId + ", datumUplate=" + datumUplate + ", SvrhaUplate=" + SvrhaUplate
				+ ", iznos=" + iznos + ", ucenik=" + ucenik + "]";
	}
	
	
	
	
	
}
