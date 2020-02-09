package eObrazovanje.web.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import eObrazovanje.web.model.Nastavnik;
import eObrazovanje.web.model.Predaje;
import eObrazovanje.web.repository.NastavnikRepo;
import eObrazovanje.web.repository.PredajeRepo;

@Service
public class NastavnikService {

	
	@Autowired
	NastavnikRepo nastavnikRepo;
	
	@Autowired
	PredajeRepo predajeRepo;
	
    public List<Nastavnik> getAll(){return  nastavnikRepo.findAll();}
    public void delete(Long jmbg) {nastavnikRepo.deleteByJmbg(jmbg);}
    public Nastavnik add(Nastavnik nastavnik) {return nastavnikRepo.save(nastavnik);}
    public List<Nastavnik> findByPredmet (Integer predmetId) {
    	   List<Nastavnik> nastavnici = predajeRepo.findAllByPredmet_PredmetId(predmetId).stream().map(
                   pohadja -> {
                       return nastavnikRepo.getOne(pohadja.getNastavnik().getJmbg());
                   }
           ).collect(Collectors.toList());

           return nastavnici;
    	
    }
    
    public boolean pohadjaPredmet(Integer id, Long jmbg) {
    	
    	List<Predaje> predmeti = predajeRepo.findAllByNastavnik_Jmbg(jmbg);
    	for (Predaje predaje: predmeti) {
    		if(predaje.getPredmet().getPredmetId() == id) {
    			return true;
    		}
			
		}
    	return false;
    }
    public List<Nastavnik> newNastavnikOnKurs(Integer predmetId){
    	
    	List<Nastavnik> nastavnici = nastavnikRepo.findAll().stream().filter(
    			ucenik -> !findByPredmet(predmetId).contains(ucenik)).collect(Collectors.toList());
    	
    	return nastavnici;
    }
}
