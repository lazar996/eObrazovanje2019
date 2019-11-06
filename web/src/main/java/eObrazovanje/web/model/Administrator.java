package eObrazovanje.web.model;

import javax.persistence.Entity;

@Entity(name="administrator")
public class Administrator extends Korisnik {

	
	

    public Administrator(){
        super("administrator");

    }
    
    
    
    
	
	public Administrator(String ime, String prezime, String korisnickoIme, String lozinka, String tipKorisnika, Long jmbg,
			String grad, String ulica, String broj, String email) {
		super(jmbg, "administrator", korisnickoIme, lozinka, korisnickoIme, prezime, grad, ulica, broj, email);
	}
	
	@Override
	public String toString() {
		return "Administrator {}"+ super.toString();
	}
}
