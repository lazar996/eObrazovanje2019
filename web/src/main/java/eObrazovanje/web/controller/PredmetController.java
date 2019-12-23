package eObrazovanje.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import eObrazovanje.web.model.Korisnik;
import eObrazovanje.web.model.Predmet;
import eObrazovanje.web.repository.KorisnikRepo;
import eObrazovanje.web.repository.PredmetRepo;
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
	
	@Autowired
	PredmetRepo predmetRepo;
	
	@GetMapping("/api/predmeti")
	public ResponseEntity<?> getAll(){
      /*  Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Korisnik korisnik = korisnikRepo.findByKorisnickoIme(authentication.getName());
        
        if(!korisnik.getTipKorisnika().equals("ucenik")){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }*/
		return new ResponseEntity<List<Predmet>>(predmetService.getAll(), HttpStatus.OK);
	}
	@PostMapping
	public ResponseEntity<Predmet> addPredmet(@RequestBody Predmet predmet){
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Korisnik korisnik = korisnikRepo.findByKorisnickoIme(authentication.getName());
   
		if(!korisnik.getTipKorisnika().equals("administrator")){
	            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	        }
	        return new ResponseEntity<Predmet>(predmetRepo.save(predmet),HttpStatus.OK);
	    
	}
    @PutMapping("api/predmeti/{id}")
    public ResponseEntity<Predmet> editPredmet(@RequestBody Predmet predmet,@PathVariable Integer id){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Korisnik korisnik = korisnikRepo.findByKorisnickoIme(authentication.getName());
        if(!korisnik.getTipKorisnika().equals("administrator")){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if(!predmetRepo.existsById(id)){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Predmet>(predmetRepo.save(predmet),HttpStatus.OK);
    }

	
	@DeleteMapping("api/predmeti/{id}")
	public ResponseEntity<?> deletePredmet(@PathVariable Integer id){
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		Korisnik korisnik = korisnikRepo.findByKorisnickoIme(authentication.getName());
		if(!korisnik.getTipKorisnika().equals("administrator")) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		predmetRepo.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
}
