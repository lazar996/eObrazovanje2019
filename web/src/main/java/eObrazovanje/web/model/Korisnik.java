package eObrazovanje.web.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name ="korisnik")
public class Korisnik {

	
	private String ime;
	private String prezime;
	private String korisnickoIme;
	private String lozinka;
	private String tipKorisnika;
	private String jmbg;
	private String grad;
	private String ulica;
	private String broj;
	private String email;
	
	
	
	public Korisnik() {
		
	}



	public Korisnik(String ime, String prezime, String korisnickoIme, String lozinka, String tipKorisnika, String jmbg,
			String grad, String ulica, String broj, String email) {
		super();
		this.ime = ime;
		this.prezime = prezime;
		this.korisnickoIme = korisnickoIme;
		this.lozinka = lozinka;
		this.tipKorisnika = tipKorisnika;
		this.jmbg = jmbg;
		this.grad = grad;
		this.ulica = ulica;
		this.broj = broj;
		this.email = email;
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



	public String getTipKorisnika() {
		return tipKorisnika;
	}



	public void setTipKorisnika(String tipKorisnika) {
		this.tipKorisnika = tipKorisnika;
	}



	public String getJmbg() {
		return jmbg;
	}



	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
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
		return "korisnik [ime=" + ime + ", prezime=" + prezime + ", korisnickoIme=" + korisnickoIme + ", lozinka="
				+ lozinka + ", tipKorisnika=" + tipKorisnika + ", jmbg=" + jmbg + ", grad=" + grad + ", ulica=" + ulica
				+ ", broj=" + broj + ", email=" + email + "]";
	}
	
	
	
	
}
