package eObrazovanje.web.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import eObrazovanje.web.dto.PolaganjePredmetaDTO;
import eObrazovanje.web.model.Korisnik;
import eObrazovanje.web.model.Nastavnik;
import eObrazovanje.web.model.PolaganjePredmeta;
import eObrazovanje.web.repository.KorisnikRepo;
import eObrazovanje.web.repository.PolaganjePredmetaRepo;
import eObrazovanje.web.service.NastavnikService;
import eObrazovanje.web.service.PolaganjePredmetaService;
import eObrazovanje.web.service.PredmetService;
import eObrazovanje.web.service.UcenikService;

@CrossOrigin
@RestController
public class PolaganjePredmetaController {

	
	@Autowired
	PolaganjePredmetaService polaganjePredmetaService;
	
	@Autowired
	KorisnikRepo korisnikRepo;
	
	@Autowired
	UcenikService ucenikService;
	
	@Autowired
	PredmetService predmetService;
	
	
	@CrossOrigin
	@GetMapping("/api/polaganjePredmeta")
	public ResponseEntity<?> getAll(){
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Korisnik korisnik = korisnikRepo.findByKorisnickoIme(authentication.getName());
        List<PolaganjePredmeta> polaganjePredmeta = new ArrayList<>();
      
        if(korisnik.getTipKorisnika().equals("ucenik")){
        	polaganjePredmeta = polaganjePredmetaService.getAll().stream().filter(polaganje ->{
        	  if(polaganje.getUcenik().getJmbg()== korisnik.getJmbg());
        	  return true;
          }
          ).collect(Collectors.toList());
        }else if(korisnik.getTipKorisnika().equals("nastavnik")) {
        	
        	polaganjePredmeta = polaganjePredmetaService.getAllByNastavnik(korisnik.getJmbg());
        }else {
        	
        	polaganjePredmeta = polaganjePredmetaService.getAll();
        }
        
        List<PolaganjePredmetaDTO> polaganjePredmetaDTO =polaganjePredmeta.stream().map(
        		polaganje -> new PolaganjePredmetaDTO(polaganje)).collect(Collectors.toList());
        
        return new ResponseEntity<List<PolaganjePredmetaDTO>>(polaganjePredmetaDTO,HttpStatus.OK);
		
		}
	@CrossOrigin
	@PostMapping("/api/polaganje")
	public ResponseEntity<?> addPoalganjePredmeta (@Valid @RequestBody PolaganjePredmetaDTO polaganjePredmetaDTO){
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Korisnik korisnik = korisnikRepo.findByKorisnickoIme(authentication.getName());
       
        System.out.println(korisnik.getIme());
        System.out.println("-------------------------------------------/////**/*");
        System.out.println(polaganjePredmetaDTO.getDatumPolaganja());
        if(!polaganjePredmetaDTO.getDatumPolaganja().after(new Date())) {
        	
        	return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        	
        }
        System.out.println("-------****/1111");
      if(korisnik.getTipKorisnika().equals("administrator")) {
    	  
    	  System.out.println("-------****/5555");
    	  System.out.println(polaganjePredmetaDTO.getBrojIndeksa()+"aa " +polaganjePredmetaDTO.getId());
    	  
     
        
        PolaganjePredmeta polaganjePredmeta = new PolaganjePredmeta();
        polaganjePredmeta.setDatumPolaganja(polaganjePredmetaDTO.getDatumPolaganja());
        polaganjePredmeta.setPolozenPredmet(polaganjePredmetaDTO.isPolozenPredmet());
        polaganjePredmeta.setUcenik(ucenikService.findByByIndeksa(polaganjePredmetaDTO.getBrojIndeksa()));
        polaganjePredmeta.setPredmet(predmetService.getOne(polaganjePredmetaDTO.getPredmetId()));
        polaganjePredmeta.setNazivPolaganja(polaganjePredmetaDTO.getNazivPolaganja());
        
        polaganjePredmetaService.save(polaganjePredmeta);

    	return new ResponseEntity<>(HttpStatus.OK);
	}
	
    System.out.println("-------****/22222222");
    return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	
}
	
	@CrossOrigin
	@GetMapping("/api/polaganje/{id}")
	public ResponseEntity<?> polozenPredmet(@PathVariable Integer id){
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Korisnik korisnik = korisnikRepo.findByKorisnickoIme(authentication.getName());
        PolaganjePredmeta polaganjePredmeta = polaganjePredmetaService.getOne(id);
        if(!korisnik.getTipKorisnika().equals("administrator")){
        	return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        polaganjePredmeta.setPolozenPredmet(true);
        polaganjePredmetaService.save(polaganjePredmeta);
        
        return new ResponseEntity<>(HttpStatus.OK);
	}
}

