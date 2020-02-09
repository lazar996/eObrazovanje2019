package eObrazovanje.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import eObrazovanje.web.model.Korisnik;
import eObrazovanje.web.model.Nastavnik;
import eObrazovanje.web.repository.KorisnikRepo;
import eObrazovanje.web.service.NastavnikService;

import javax.transaction.Transactional;
import javax.validation.Valid;
@CrossOrigin
@RestController
public class NastavnikController {

	
	@Autowired
	NastavnikService nastavnikService;
	
	@Autowired
	KorisnikRepo korisnikRepo;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	
	@CrossOrigin
	@GetMapping("/api/nastavnici")
	public ResponseEntity<?> getAll(){
		return new ResponseEntity<List<Nastavnik>>(nastavnikService.getAll(),HttpStatus.OK);
		
	}
	
	@CrossOrigin
	@Transactional
	@DeleteMapping("/api/nastavnici/{jmbg}")
	public ResponseEntity<?> deleteNastavnik(@PathVariable Long jmbg){
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		Korisnik korisnik = korisnikRepo.findByKorisnickoIme(authentication.getName());
		if (korisnik.getTipKorisnika().equals("ucenik")) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			
		}
		nastavnikService.delete(jmbg);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	@CrossOrigin
    @PostMapping("/api/nastavnici")
    public ResponseEntity<?> addNastavnik(@Valid @RequestBody Nastavnik nastavnik){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Korisnik korisnik = korisnikRepo.findByKorisnickoIme(authentication.getName());
        if(!korisnik.getTipKorisnika().equals("administrator")){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        nastavnik.setLozinka(bCryptPasswordEncoder.encode(nastavnik.getLozinka()));
        return new ResponseEntity<Nastavnik>(nastavnikService.add(nastavnik),HttpStatus.OK);
    }
	
	@CrossOrigin
    @PutMapping("/api/nastavnici")
    public ResponseEntity<?> editStudent(@Valid @RequestBody Nastavnik nastavnik){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Korisnik korisnik = korisnikRepo.findByKorisnickoIme(authentication.getName());
        if(!korisnik.getTipKorisnika().equals("administrator")){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<Nastavnik>(
                nastavnikService.add(nastavnik),
                HttpStatus.OK
        );
    }
    @GetMapping("/api/nastavnik/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id){
    	
    	return new ResponseEntity<List<Nastavnik>>(nastavnikService.findByPredmet(id), HttpStatus.OK);
    }
    
    @GetMapping("/api/nastavnik/new/{id}")
    public ResponseEntity<?> getNewNastavnik(@PathVariable Integer id){
    	
    	return new ResponseEntity<List<Nastavnik>>(nastavnikService.newNastavnikOnKurs(id), HttpStatus.OK);
    }
    
}
