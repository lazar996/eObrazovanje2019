package eObrazovanje.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import eObrazovanje.web.model.Dokumenta;

@Component
public interface DokumentaRepo extends JpaRepository<Dokumenta, Integer>{

	

}
