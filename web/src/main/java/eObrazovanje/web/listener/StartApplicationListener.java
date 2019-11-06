package eObrazovanje.web.listener;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import org.springframework.stereotype.Component;

import eObrazovanje.web.repository.NastavnikRepo;
import eObrazovanje.web.repository.UcenikRepo;
import eObrazovanje.web.repository.UplataRepo;
import eObrazovanje.web.service.FileService;

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
	
/*	@Autowired
	BCryptPasswordEncoder BCryptPasswordEncoder;
	*/
	

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		
		
	}
	
	
}
