package eObrazovanje.web.listener;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import org.springframework.stereotype.Component;

import eObrazovanje.web.model.Administrator;
import eObrazovanje.web.model.Ucenik;
import eObrazovanje.web.repository.AdministratorRepo;
import eObrazovanje.web.repository.NastavnikRepo;
import eObrazovanje.web.repository.UcenikRepo;
import eObrazovanje.web.repository.UplataRepo;
import eObrazovanje.web.service.FileService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
@Component
public class StartApplicationListener implements ApplicationListener<ContextRefreshedEvent> {

	
	@Autowired 
	UcenikRepo ucenikRepo;
	
	@Autowired
	NastavnikRepo nastavnikRepo;
	
	@Autowired
	FileService fileService;
	
	
	@Autowired 
	UplataRepo uplataRepo;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	AdministratorRepo administratorRepo;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		initializeUcenik();
		initializeAdmin();
		
	}
	
	public void initializeUcenik() {
		
		Ucenik ucenik = new Ucenik();
		ucenik.setBrojIndeksa("Sf38/2015");
		ucenik.setBroj("060660606060");
		ucenik.setEmail("mail");
		ucenik.setKorisnickoIme("pera");
		ucenik.setIme("Petar");
		ucenik.setPrezime("Peric");
		ucenik.setTipKorisnika("ucenik");
		ucenik.setGrad("Novi Sad");
		ucenik.setLozinka(bCryptPasswordEncoder.encode("123"));
		ucenik.setUlica("Perina bb");
		ucenikRepo.save(ucenik);
		
	}
	
	public void initializeAdmin() {
		
		Administrator admin= new Administrator();
		admin.setBroj("060660606060");
		admin.setEmail("mail");
		admin.setKorisnickoIme("mare");
		admin.setLozinka(bCryptPasswordEncoder.encode("123"));
		admin.setIme("Marko");
		admin.setPrezime("Markovic");
		admin.setGrad("Novi Sad");
		admin.setTipKorisnika("administrator");
		admin.setUlica("Perina bb");
		
		administratorRepo.save(admin);		
		
	}
	
	
}
