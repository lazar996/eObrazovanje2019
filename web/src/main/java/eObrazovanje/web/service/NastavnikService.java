package eObrazovanje.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import eObrazovanje.web.model.Nastavnik;
import eObrazovanje.web.repository.NastavnikRepo;

@Service
public class NastavnikService {

	
	@Autowired
	NastavnikRepo nastavnikRepo;
	
    public List<Nastavnik> getAll(){return  nastavnikRepo.findAll();}
    public void delete(Long jmbg) {nastavnikRepo.deleteByJmbg(jmbg);}
    public Nastavnik add(Nastavnik nastavnik) {return nastavnikRepo.save(nastavnik);}
}
