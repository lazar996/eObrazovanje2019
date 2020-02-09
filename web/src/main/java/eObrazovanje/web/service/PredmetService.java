package eObrazovanje.web.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eObrazovanje.web.model.Predmet;
import eObrazovanje.web.repository.PohadjaRepo;
import eObrazovanje.web.repository.PredajeRepo;
import eObrazovanje.web.repository.PredmetRepo;


@Service
public class PredmetService {

	
	
	@Autowired
	PredmetRepo predmetRepo;
	@Autowired
	PohadjaRepo pohadjaRepo;

	@Autowired
	PredajeRepo predajeRepo;
	
	public List<Predmet> getAll(){return predmetRepo.findAll();}
	public Predmet getOne(Integer id) {return predmetRepo.getOne(id);}
	
	public List<Predmet> allNastavnikPredmetPredaje(Long jmbg){
		List<Predmet> predmeti = predajeRepo.findAllByNastavnik_Jmbg(jmbg).stream().map(
				pohadja -> {Predmet predmet = predmetRepo.getOne(pohadja.getPredmet().getPredmetId());
				return predmet;}).collect(Collectors.toList());
		
		return predmeti;
		}
	
		
	
	
	
	public List<Predmet> allUcenikPredmetPohadja(String brojIndeksa){
		
		List<Predmet> predmeti = pohadjaRepo.findAllByUcenik_BrojIndeksa(brojIndeksa).stream().map(
				pohadja -> {Predmet predmet = predmetRepo.getOne(pohadja.getPredmet().getPredmetId());
				return predmet;}).collect(Collectors.toList());
		
		return predmeti;
		}
	
	
	public boolean yesNoPredmet(Integer id, String brojIndeksa) {
		for (Predmet predmet: allUcenikPredmetPohadja(brojIndeksa)) {
			if(predmet.getPredmetId()== id) {
				
				return true;
			}
			
		}
		return false;
	}
	
	
}
