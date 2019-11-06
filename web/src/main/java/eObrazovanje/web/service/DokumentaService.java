package eObrazovanje.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import eObrazovanje.web.model.Dokumenta;
import eObrazovanje.web.repository.DokumentaRepo;

@Component
public class DokumentaService {

	@Autowired
	DokumentaRepo dokumentaRepo;
	
	@Autowired
	FileService fileService;
	
	public Dokumenta getOne(Integer id) {
		return dokumentaRepo.getOne(id);
	}
	
	public Dokumenta save(Dokumenta dokumenta) {
		return dokumentaRepo.save(dokumenta);
	}
	
	   public List<Dokumenta> getAll(){
	        return dokumentaRepo.findAll();
	    }

	  public void remove(Integer id){
	        Dokumenta dokumenta = dokumentaRepo.getOne(id);
	        fileService.removeFile(dokumenta.getDownloadUri());
	        dokumentaRepo.deleteById(id);

	    }
}
