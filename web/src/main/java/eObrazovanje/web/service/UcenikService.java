package eObrazovanje.web.service;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eObrazovanje.web.model.Ucenik;
import eObrazovanje.web.repository.PohadjaRepo;
import eObrazovanje.web.repository.UcenikRepo;

@Service
public class UcenikService {

	
	@Autowired
	UcenikRepo ucenikRepo;
	
	@Autowired
	PohadjaRepo pohadjaRepo;
	
	public Ucenik getOne(Long id ) {
		
		return ucenikRepo.getOne(id);
	}
	
	
    public List<Ucenik> getAll(){return ucenikRepo.findAll();}
    
    
    public Ucenik add(Ucenik ucenik){return ucenikRepo.save(ucenik);}
   
    public Ucenik findByByIndeksa(String brojIndeksa){return ucenikRepo.findByBrojIndeksa(brojIndeksa);}

    public List<Ucenik> findByPredmetKojiPohadja(Integer predmetId){
        List<Ucenik> uceniks = pohadjaRepo.findAllByPredmet_PredmetId(predmetId).stream().map(pohadja ->{
        	
        	
        	return ucenikRepo.getOne(pohadja.getUcenik().getJmbg());
                  
                }
        ).collect(Collectors.toList());

        return uceniks;
    }
    
    public List<Ucenik> ucenikKojiNeIdeNaPredmet(Integer predmetId){
    	
    		List<Ucenik> uceniks = ucenikRepo.findAll().stream().filter(ucenik -> !findByPredmetKojiPohadja(predmetId).contains(ucenik)).collect(Collectors.toList());
    	return uceniks;
    }
}
