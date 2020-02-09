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
import eObrazovanje.web.model.PohadjanjePredmeta;
import eObrazovanje.web.model.Predmet;
import eObrazovanje.web.model.Ucenik;
import eObrazovanje.web.repository.KorisnikRepo;
import eObrazovanje.web.repository.PohadjaRepo;
import eObrazovanje.web.repository.PredmetRepo;
import eObrazovanje.web.repository.UcenikRepo;
@CrossOrigin
@RestController
public class PohadjanjePredmetaController {

	@Autowired
	PohadjaRepo pohadjaRepo;
	
	@Autowired
	UcenikRepo ucenikRepo;
	
	@Autowired
	KorisnikRepo korisnikRepo;
	
	@Autowired 
	PredmetRepo predmetRepo;
	
	@CrossOrigin
	@PostMapping("/api/pohadjanje/")
	public ResponseEntity<?> addPohadjanje (@RequestBody PohadjanjePredmetaDTO pohadjanjePredmetaDTO){
		
		 Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	        Korisnik korisnik = korisnikRepo.findByKorisnickoIme(authentication.getName());
	        if(!korisnik.getTipKorisnika().equals("administrator")){
	            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	        }
	        Predmet predmet = predmetRepo.getOne(pohadjanjePredmetaDTO.getPredmetId());
	        Ucenik ucenik = ucenikRepo.getOne(pohadjanjePredmetaDTO.getJmbg());
	        PohadjanjePredmeta pohadjanjePredmeta = new PohadjanjePredmeta();
	        pohadjanjePredmeta.setPredmet(predmet);
	        pohadjanjePredmeta.setUcenik(ucenik);
	        
	        pohadjaRepo.save(pohadjanjePredmeta);
	        
	        return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@CrossOrigin
	@Transactional
	@DeleteMapping("/api/pohadja/delete/{predmetId}/{jmbg}")
	public ResponseEntity<?> deletePohadja (@PathVariable Integer predmetId, @PathVariable Long jmbg){
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Korisnik korisnik = korisnikRepo.findByKorisnickoIme(authentication.getName());
        if(!korisnik.getTipKorisnika().equals("administrator")){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        pohadjaRepo.deleteByPredmet_PredmetIdAndUcenik_Jmbg(predmetId,jmbg);
        return new ResponseEntity<>(HttpStatus.OK);
	}
}
