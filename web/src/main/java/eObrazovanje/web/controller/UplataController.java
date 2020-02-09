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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import eObrazovanje.web.dto.UplataDTO;
import eObrazovanje.web.model.Korisnik;
import eObrazovanje.web.model.Uplata;
import eObrazovanje.web.repository.KorisnikRepo;
import eObrazovanje.web.repository.UcenikRepo;
import eObrazovanje.web.repository.UplataRepo;
import eObrazovanje.web.service.UplataService;

@RestController
public class UplataController {

	@Autowired
	UplataService uplataService;
	
	@Autowired
	KorisnikRepo korisnikRepo;
	
	@Autowired
	UplataRepo uplataRepo;
	
	@Autowired
	UcenikRepo ucenikRepo;
	
	@CrossOrigin
	@GetMapping("api/uplate")
	public ResponseEntity<List<UplataDTO>> getAllUplate(){
		List<Uplata> uplate = new ArrayList<>();
		uplate = uplataService.getAllUplate();
        List<UplataDTO> uplataDTOS = uplate.stream().map(
                uplata -> new UplataDTO(uplata)
        ).collect(Collectors.toList());

		return new ResponseEntity<List<UplataDTO>>(uplataDTOS, HttpStatus.OK);
	}
	
	@CrossOrigin
	@DeleteMapping("api/uplate/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id){
		
		uplataService.remove(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@CrossOrigin
	@PutMapping("api/uplata")
	public ResponseEntity<?> editUplata(@RequestBody UplataDTO uplataDTO){
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		Korisnik korisnik = korisnikRepo.findByKorisnickoIme(authentication.getName());
		
		if(!korisnik.getTipKorisnika().equals("administrator")) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		 Uplata uplata = new Uplata();
		 uplata.setUplataId(uplataDTO.getUplataId());
		 uplata.setSvrhaUplate(uplataDTO.getSvrhaUplate());
		 uplata.setIznos(uplataDTO.getIznos());
		 uplata.setDatumUplate(uplataDTO.getDatumUplate());
		 uplata.setUcenik(ucenikRepo.findByBrojIndeksa(uplataDTO.getBrojIndeksa()));
		
		return new ResponseEntity<UplataDTO>(new UplataDTO(uplataService.save(uplata)), HttpStatus.OK);
	}
	
	@CrossOrigin
	@PostMapping("/api/uplata")
	public ResponseEntity<?> addUplata(@RequestBody UplataDTO uplataDTO){
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		Korisnik korisnik = korisnikRepo.findByKorisnickoIme(authentication.getName());
		 if(!korisnik.getTipKorisnika().equals("administrator")){
			 return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		 }
		 
		 Uplata uplata = new Uplata();
			uplata.setUplataId(uplataDTO.getUplataId());
			uplata.setSvrhaUplate(uplataDTO.getSvrhaUplate());
			uplata.setIznos(uplataDTO.getIznos());
			uplata.setDatumUplate(new Date());
			uplata.setUcenik(ucenikRepo.findByBrojIndeksa(uplataDTO.getBrojIndeksa()));
			
			System.out.println(uplata);
		 return new ResponseEntity<Uplata>(uplataService.save(uplata),HttpStatus.OK);
		
	}
}
