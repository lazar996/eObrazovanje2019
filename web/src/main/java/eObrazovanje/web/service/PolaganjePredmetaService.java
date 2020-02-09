package eObrazovanje.web.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eObrazovanje.web.model.PolaganjePredmeta;
import eObrazovanje.web.repository.KorisnikRepo;
import eObrazovanje.web.repository.PolaganjePredmetaRepo;
import eObrazovanje.web.repository.PredajeRepo;

@Service
public class PolaganjePredmetaService {

	
	@Autowired
	PolaganjePredmetaRepo polaganjePredmetaRepo;
	
	@Autowired
	PredajeRepo predajeRepo;
	
	@Autowired
	NastavnikService nastavnikService;
	
	@Autowired
	KorisnikRepo korisnikRepo;
	
	
	public PolaganjePredmeta getOne(Integer id ) {return polaganjePredmetaRepo.getOne(id);}
	public PolaganjePredmeta save(PolaganjePredmeta polaganjePredmeta) {
		return polaganjePredmetaRepo.save(polaganjePredmeta);
	}
	public List<PolaganjePredmeta> getAll(){ return polaganjePredmetaRepo.findAll();}
	
	 public List<PolaganjePredmeta> getAllByNastavnik(Long jmbg){
	        List<PolaganjePredmeta> obaveze = polaganjePredmetaRepo.findAll().stream().filter(
	                obaveza -> {
	                    if(nastavnikService.pohadjaPredmet(obaveza.getPredmet().getPredmetId(),jmbg)){
	                        return true;
	                    }

	                    return false;
	                }

	        ).collect(Collectors.toList());

	        return obaveze;
	             }
}
