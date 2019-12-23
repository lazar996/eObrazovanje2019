package eObrazovanje.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import eObrazovanje.web.model.Uplata;
import eObrazovanje.web.service.UplataService;

@RestController
public class UplataController {

	@Autowired
	UplataService uplataService;
	
	@CrossOrigin
	@GetMapping("api/uplate")
	public ResponseEntity<?> getAllUplate(){
		
		return new ResponseEntity<List<Uplata>>(uplataService.getAllUplate(), HttpStatus.OK);
	}
}
