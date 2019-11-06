package eObrazovanje.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import eObrazovanje.web.model.Korisnik;
import eObrazovanje.web.repository.KorisnikRepo;

@Service
public class KorisnikService {
	
	@Autowired
	KorisnikRepo korisnikRepo;
	
	
	public List<Korisnik> getAll() {return korisnikRepo.findAll();}

}
