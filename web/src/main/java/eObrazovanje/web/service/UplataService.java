package eObrazovanje.web.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eObrazovanje.web.model.Uplata;

import eObrazovanje.web.repository.UplataRepo;

@Service
public class UplataService {
	
	@Autowired
	UplataRepo uplataRepo;
	
	public List<Uplata> getAllUplate() {
		return uplataRepo.findAll();}
	
	
	public void remove(Integer id) {
		
		Uplata uplata = uplataRepo.getOne(id);
		uplataRepo.deleteById(id);
		
	}
	

	
	public Uplata save(Uplata uplata) {
		
		return uplataRepo.save(uplata);
	}
	
	   

}
