package eObrazovanje.web.model;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name ="korisnik")
public class Korisnik {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long jmbg;
	
	@Column(name = "tip_korisnika")
	private String tipKorisnika;
	
	@Column(name="korisnicko_ime")
	private String korisnickoIme;
	
	@Column
	private String lozinka;
	
	
	@Column
	private String ime;
	@Column
	private String prezime;
	



	@Column
	private String grad;
	@Column
	private String ulica;
	@Column
	private String broj;
	@Column
	private String email;
	
	
	
	public Korisnik() {

		
	}



	public Korisnik(Long jmbg, String tipKorisnika, String korisnickoIme, String lozinka, String ime, String prezime,
			String grad, String ulica, String broj, String email) {
		super();
		this.jmbg = jmbg;
		this.tipKorisnika = tipKorisnika;
		this.korisnickoIme = korisnickoIme;
		this.lozinka = lozinka;
		this.ime = ime;
		this.prezime = prezime;
		this.grad = grad;
		this.ulica = ulica;
		this.broj = broj;
		this.email = email;
	}


    public Korisnik(String tipKorisnika){
        this.tipKorisnika = tipKorisnika;
    }
	public Long getJmbg() {
		return jmbg;
	}



	public void setJmbg(Long jmbg) {
		this.jmbg = jmbg;
	}



	public String getTipKorisnika() {
		return tipKorisnika;
	}



	public void setTipKorisnika(String tipKorisnika) {
		this.tipKorisnika = tipKorisnika;
	}



	public String getKorisnickoIme() {
		return korisnickoIme;
	}



	public void setKorisnickoIme(String korisnickoIme) {
		this.korisnickoIme = korisnickoIme;
	}



	public String getLozinka() {
		return lozinka;
	}



	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
	}



	public String getIme() {
		return ime;
	}



	public void setIme(String ime) {
		this.ime = ime;
	}



	public String getPrezime() {
		return prezime;
	}



	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	
	



	public String getGrad() {
		return grad;
	}



	public void setGrad(String grad) {
		this.grad = grad;
	}



	public String getUlica() {
		return ulica;
	}



	public void setUlica(String ulica) {
		this.ulica = ulica;
	}



	public String getBroj() {
		return broj;
	}



	public void setBroj(String broj) {
		this.broj = broj;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	@Override
	public String toString() {
		return "Korisnik {jmbg=" + jmbg + ", tipKorisnika=" + tipKorisnika + ", korisnickoIme=" + korisnickoIme
				+ ", lozinka=" + lozinka + ", ime=" + ime + ", prezime=" + prezime + ", grad=" + grad + ", ulica="
				+ ulica + ", broj=" + broj + ", email=" + email + "}";
	}

	
	
	


	
}
