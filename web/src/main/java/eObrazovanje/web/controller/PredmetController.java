package eObrazovanje.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import eObrazovanje.web.model.Korisnik;
import eObrazovanje.web.model.Predmet;
import eObrazovanje.web.repository.KorisnikRepo;
import eObrazovanje.web.repository.UcenikRepo;
import eObrazovanje.web.service.PredmetService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
@CrossOrigin
@RestController
public class PredmetController {

	@Autowired 
	PredmetService predmetService;
	
	@Autowired
	KorisnikRepo korisnikRepo;
	
	//@Autowired 
	//UcenikRepo UcenikRepo;
	
	
	@GetMapping("/api/predmeti")
	public ResponseEntity<?> getAll(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Korisnik korisnik = korisnikRepo.findByKorisnickoIme(authentication.getName());
        
        if(!korisnik.getTipKorisnika().equals("ucenik")){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
		return new ResponseEntity<List<Predmet>>(predmetService.getAll(), HttpStatus.OK);
	}
	
	
}
