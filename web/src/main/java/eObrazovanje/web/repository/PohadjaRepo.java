package eObrazovanje.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import eObrazovanje.web.model.PohadjanjePredmeta;

public interface PohadjaRepo extends JpaRepository<PohadjanjePredmeta, Integer>{

}
