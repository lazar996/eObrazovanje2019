package eObrazovanje.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import eObrazovanje.web.model.PohadjanjePredmeta;

public interface PohadjaRepo extends JpaRepository<PohadjanjePredmeta, Integer>{
	

	
 // List<PohadjanjePredmeta> findAllUcenikByBrojIndeksa(String brojIndeksa);
  List<PohadjanjePredmeta> findAllByPredmet_PredmetId(Integer id);
}
