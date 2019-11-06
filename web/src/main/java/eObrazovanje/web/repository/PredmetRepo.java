package eObrazovanje.web.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import eObrazovanje.web.model.Predmet;

public interface PredmetRepo extends JpaRepository<Predmet, Integer>{

	

}
