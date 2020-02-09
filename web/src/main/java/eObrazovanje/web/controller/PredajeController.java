package eObrazovanje.web.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import eObrazovanje.web.dto.PohadjanjePredmetaDTO;
import eObrazovanje.web.model.Korisnik;
import eObrazovanje.web.model.Nastavnik;
import eObrazovanje.web.model.Predaje;
import eObrazovanje.web.model.Predmet;
import eObrazovanje.web.repository.KorisnikRepo;
import eObrazovanje.web.repository.NastavnikRepo;
import eObrazovanje.web.repository.PredajeRepo;
import eObrazovanje.web.repository.PredmetRepo;
@CrossOrigin
@RestController
public class PredajeController {

	
	@Autowired
	PredajeRepo predajeRepo;
	
	@Autowired
	NastavnikRepo nastavnikRepo;
	
	@Autowired
	PredmetRepo predmetRepo;
	
	@Autowired
	KorisnikRepo korisnikRepo;
	
	@CrossOrigin
	@PostMapping("/api/predaje")
	public ResponseEntity<?> addPredavanje(@RequestBody PohadjanjePredmetaDTO pohadjanjePredmetaDTO){
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Korisnik korisnik = korisnikRepo.findByKorisnickoIme(authentication.getName());
        if(!korisnik.getTipKorisnika().equals("administrator")){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        
        Predmet predmet = predmetRepo.getOne(pohadjanjePredmetaDTO.getPredmetId());
        Nastavnik nastavnik = nastavnikRepo.getOne(pohadjanjePredmetaDTO.getJmbg());
        
        Predaje predaje = new Predaje();
        predaje.setPredmet(predmet);
        predaje.setNastavnik(nastavnik);
        
        predajeRepo.save(predaje);
        
        return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@CrossOrigin
	@Transactional
	@DeleteMapping("/api/predaje/delete/{predmetId}/{jmbg}")
	public ResponseEntity<?> deletePohadja (@PathVariable Integer predmetId, @PathVariable Long jmbg){
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Korisnik korisnik = korisnikRepo.findByKorisnickoIme(authentication.getName());
        if(!korisnik.getTipKorisnika().equals("administrator")){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        predajeRepo.deleteByPredmet_PredmetIdAndNastavnik_Jmbg(predmetId,jmbg);
        return new ResponseEntity<>(HttpStatus.OK);
	}
}
