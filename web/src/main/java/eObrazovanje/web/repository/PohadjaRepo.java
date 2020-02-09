package eObrazovanje.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import eObrazovanje.web.model.PohadjanjePredmeta;


public interface PohadjaRepo extends JpaRepository<PohadjanjePredmeta, Integer>{

 

	void deleteByPredmet_PredmetIdAndUcenik_Jmbg(Integer predmetId, Long jmbg);
  List<PohadjanjePredmeta> findAllByUcenik_BrojIndeksa(String brojIndeksa);
  List<PohadjanjePredmeta> findAllByPredmet_PredmetId(Integer id);
}
