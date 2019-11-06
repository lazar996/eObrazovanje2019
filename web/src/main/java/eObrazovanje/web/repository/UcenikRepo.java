package eObrazovanje.web.repository;




import org.springframework.data.jpa.repository.*;

import eObrazovanje.web.model.Ucenik;

public interface UcenikRepo extends JpaRepository<Ucenik, Integer> {
/*	public Ucenik findByKorisnickoIme(String korisnickoIme);
	public Ucenik findByBrojIndeksa(String brojIndeksa);
	public void deleteByJmbg(Long jmbg);
*/
}
