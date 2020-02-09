package eObrazovanje.web.listener;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import org.springframework.stereotype.Component;

import eObrazovanje.web.model.Administrator;
import eObrazovanje.web.model.Nastavnik;
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
		
		initializeAdmin();
		initializeNastavnika();
		
	}
	
	public void initializeNastavnika() {
		
		Nastavnik nastavnik = new Nastavnik();
		
		nastavnik.setBroj("060660606060");
		nastavnik.setEmail("mail");
		nastavnik.setKorisnickoIme("Ivan");
		nastavnik.setIme("Petar");
		nastavnik.setPrezime("Peric");
		nastavnik.setTipKorisnika("nastavnik");
		nastavnik.setGrad("Novi Sad");
		nastavnik.setLozinka(bCryptPasswordEncoder.encode("123"));
		nastavnik.setUlica("Perina bb");
		nastavnik.setZvanje("docent");
		nastavnikRepo.save(nastavnik);
		
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
