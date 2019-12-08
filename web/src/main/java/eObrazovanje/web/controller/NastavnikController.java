package eObrazovanje.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import eObrazovanje.web.model.Nastavnik;
import eObrazovanje.web.repository.KorisnikRepo;
import eObrazovanje.web.service.NastavnikService;
@CrossOrigin
@RestController
public class NastavnikController {

	
	@Autowired
	NastavnikService nastavnikService;
	
/*	@Autowired
	KorisnikRepo korisnikRepo;*/
	
	
	@CrossOrigin
	@GetMapping("/api/nastavnici")
	public ResponseEntity<?> getAll(){
		return new ResponseEntity<List<Nastavnik>>(nastavnikService.getAll(),HttpStatus.OK);
		
	}
}
