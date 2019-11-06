package eObrazovanje.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import eObrazovanje.web.model.Predmet;
import eObrazovanje.web.service.PredmetService;

@RestController
public class PredmetController {

	@Autowired 
	PredmetService predmetService;
	
	
	@GetMapping("/api/predmeti")
	public ResponseEntity<?> getAll(){
		
		return new ResponseEntity<List<Predmet>>(predmetService.getAll(), HttpStatus.OK);
	}
	
	
}
