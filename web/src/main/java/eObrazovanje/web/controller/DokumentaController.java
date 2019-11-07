package eObrazovanje.web.controller;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import eObrazovanje.web.dto.DokumentaDTO;
import eObrazovanje.web.model.Dokumenta;
import eObrazovanje.web.model.Korisnik;
import eObrazovanje.web.model.Ucenik;
import eObrazovanje.web.repository.KorisnikRepo;
import eObrazovanje.web.repository.UcenikRepo;
import eObrazovanje.web.response.UploadFile;
import eObrazovanje.web.service.DokumentaService;
import eObrazovanje.web.service.FileService;

@RestController
public class DokumentaController {

	
	@Autowired
	DokumentaService dokumentaService;
	
	@Autowired
	FileService fileService;
	
	@Autowired
	KorisnikRepo korisnikRepo;
	
	@Autowired
	UcenikRepo ucenikRepo;
	
	

 
	
	@CrossOrigin
	@GetMapping("/dokument/all")
	public ResponseEntity<?>getAll(){
		
		return new ResponseEntity<List<Dokumenta>>(dokumentaService.getAll(),HttpStatus.OK);
	}
	
    @GetMapping("/dokument/{id}")
    public ResponseEntity<DokumentaDTO> getOne(@PathVariable Integer id){
        Dokumenta dokumenta = dokumentaService.getOne(id);
        if(fileService.checkIfFileExist(dokumenta.getDownloadUri())){
        	DokumentaDTO dokumentaDTO = new DokumentaDTO(dokumenta);
            return new ResponseEntity<DokumentaDTO>(dokumentaDTO,HttpStatus.OK);
        } else {
            dokumentaService.remove(id);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        
        

    }
    

	}

