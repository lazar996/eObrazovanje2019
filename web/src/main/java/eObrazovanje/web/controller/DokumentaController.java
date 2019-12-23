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
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
	@GetMapping("api/dokumenta")
	public ResponseEntity<?>getAll(){
		
		return new ResponseEntity<List<Dokumenta>>(dokumentaService.getAll(),HttpStatus.OK);
	}
	 @CrossOrigin
	 @PostMapping(value = "api/uploadDoc",consumes = "multipart/form-data")
	    public UploadFile uploadFile(@RequestParam(value="dokument") String dokumentString, @RequestPart("file") MultipartFile file) throws IOException {
	        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	        Korisnik korisnik = korisnikRepo.findByKorisnickoIme(authentication.getName());
	        ObjectMapper mapper = new ObjectMapper();
	        DokumentaDTO dokumentaDTO = mapper.readValue(dokumentString,DokumentaDTO.class);
	        System.out.println(dokumentaDTO.toString());
	        Ucenik ucenik = null;
	        if(korisnik.getTipKorisnika().equals("ucenik")){
	        	ucenik = ucenikRepo.findByKorisnickoIme(korisnik.getKorisnickoIme());
	        }
	        if(korisnik.getTipKorisnika().equals("administrator")){
	        	ucenik = ucenikRepo.findByBrojIndeksa(dokumentaDTO.getBrojIndeksa());
	        }
	        Dokumenta dokument = new Dokumenta();
	        String fileName = fileService.storeFiles(file,ucenik.getKorisnickoIme());
	        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/downloadFile/").path(fileName).toUriString();
	        dokument.setDownloadUri(fileName);
	        dokument.setUcenik(ucenik);
	        dokument.setNaziv(dokumentaDTO.getNaziv());
	        dokument.setTipDokumenta(dokumentaDTO.getTipDokumenta());
	        dokumentaService.save(dokument);



	        return new UploadFile(fileName,fileDownloadUri,file.getContentType(),file.getSize());

	    }
	@CrossOrigin
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
	@CrossOrigin
    @DeleteMapping("api/dokument/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
    	
    	dokumentaService.remove(id);
    	return new ResponseEntity<>(HttpStatus.OK);
    }
    

	}

