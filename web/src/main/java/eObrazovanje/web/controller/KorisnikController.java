package eObrazovanje.web.controller;

import java.util.List;

import org.aspectj.weaver.patterns.ThisOrTargetAnnotationPointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import eObrazovanje.web.model.Korisnik;
import eObrazovanje.web.repository.KorisnikRepo;
import eObrazovanje.web.security.TokenUtils;
import eObrazovanje.web.service.KorisnikService;

@RestController
public class KorisnikController {

		@Autowired
	KorisnikService korisnikService;
	
	@Autowired
	KorisnikRepo korisnikRepo;
	

	@CrossOrigin
	@GetMapping("/api/korisnici")
	public ResponseEntity<?>getAll(){
		return new ResponseEntity<List<Korisnik>>(this.korisnikService.getAll(),HttpStatus.OK);
	}
	
}
