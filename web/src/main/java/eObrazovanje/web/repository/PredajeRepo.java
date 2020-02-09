package eObrazovanje.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import eObrazovanje.web.model.Predaje;

public interface PredajeRepo extends JpaRepository<Predaje, Integer> {
	List<Predaje> findAllByPredmet_PredmetId(Integer id);
	List<Predaje> findAllByNastavnik_Jmbg(Long jmbg);
	void deleteByPredmet_PredmetIdAndNastavnik_Jmbg(Integer predmetId, Long jmbg);

}
