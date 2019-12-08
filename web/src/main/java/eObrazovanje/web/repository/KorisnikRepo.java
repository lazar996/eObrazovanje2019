package eObrazovanje.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import eObrazovanje.web.model.Korisnik;

public interface KorisnikRepo extends JpaRepository<Korisnik,Long> {
	
	@Query(value = "select * from korisnik",nativeQuery = true)
	public List<Korisnik>findAll();
	public Korisnik findByKorisnickoIme(String korisnicko_ime);
	public Korisnik findByTipKorisnika (String tipKorisnika);

}
