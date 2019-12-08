package eObrazovanje.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eObrazovanje.web.model.Predmet;
import eObrazovanje.web.repository.PredmetRepo;


@Service
public class PredmetService {

	
	
	@Autowired
	PredmetRepo predmetRepo;
	


	public List<Predmet> getAll(){return predmetRepo.findAll();}
	
}
