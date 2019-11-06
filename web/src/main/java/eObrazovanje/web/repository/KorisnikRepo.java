package eObrazovanje.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import eObrazovanje.web.model.Korisnik;

public interface KorisnikRepo extends JpaRepository<Korisnik,Long> {
	
	
	public List<Korisnik>findAll();
	public Korisnik findByKorisnickoIme(String username);

}
