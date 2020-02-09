package eObrazovanje.web.controller;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

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
import eObrazovanje.web.model.Ucenik;
import eObrazovanje.web.repository.KorisnikRepo;
import eObrazovanje.web.repository.UcenikRepo;
import eObrazovanje.web.service.UcenikService;
@CrossOrigin
@RestController
public class UcenikController {

	
	@Autowired 
	UcenikService ucenikService;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	KorisnikRepo korisnikRepo;
	
	@Autowired 
	UcenikRepo ucenikRepo;
	@CrossOrigin
	@GetMapping("api/ucenici")
	public ResponseEntity<?> getAll(){
		
		return new ResponseEntity<List<Ucenik>>(ucenikService.getAll(),HttpStatus.OK);
	}
	
	@CrossOrigin
	@GetMapping("/api/ucenik/{id}")
	public ResponseEntity<?>getUcenikByPredmetId(@PathVariable Integer id){
		
		return new ResponseEntity<List<Ucenik>>(ucenikService.findByPredmetKojiPohadja(id),HttpStatus.OK);
	}
	
	@CrossOrigin
	@GetMapping("/api/ucenik/not/{id}")
	public ResponseEntity<?> getUcenikKojiNeIde(@PathVariable Integer id){
		
		return new ResponseEntity<List<Ucenik>>(ucenikService.ucenikKojiNeIdeNaPredmet(id),HttpStatus.OK);
	}
	
	
    @PutMapping("api/ucenik")
    public ResponseEntity<?> editStudent(@Valid @RequestBody Ucenik ucenik){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Korisnik korisnik = korisnikRepo.findByKorisnickoIme(authentication.getName());
        if(!korisnik.getTipKorisnika().equals("administrator")){
          return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<Ucenik>(
                ucenikRepo.save(ucenik),
                HttpStatus.OK
        );
    }
    
    @PostMapping("/api/ucenik")
    public ResponseEntity<?> addUcenik(@Valid @RequestBody Ucenik ucenik){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Korisnik korisnik = korisnikRepo.findByKorisnickoIme(authentication.getName());
        if(korisnik.getTipKorisnika().equals("ucenik")){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        ucenik.setLozinka(bCryptPasswordEncoder.encode(ucenik.getLozinka()));
        return new ResponseEntity<Ucenik>(ucenikRepo.save(ucenik),HttpStatus.OK);
    }
    
    @CrossOrigin
	@Transactional
    @DeleteMapping("api/ucenik/{jmbg}")
    public ResponseEntity<?> deleteUcenik(@PathVariable Long jmbg){
    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Korisnik korisnik = korisnikRepo.findByKorisnickoIme(authentication.getName());
        System.out.println(korisnik.getTipKorisnika());
        if(!korisnik.getTipKorisnika().equals("administrator")){
              return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
          }
        System.out.println("----*****************----------");
        this.ucenikRepo.deleteByJmbg(jmbg);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @GetMapping("/api/ucenici/new/{id}")
    public ResponseEntity<?> getNewUcenik(@PathVariable Integer id){
    	
    	return new ResponseEntity< List<Ucenik>>(ucenikService.ucenikKojiNeIdeNaPredmet(id), HttpStatus.OK);
    }
}
