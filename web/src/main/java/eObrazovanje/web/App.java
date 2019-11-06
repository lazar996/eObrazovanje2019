package eObrazovanje.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;


import eObrazovanje.web.propery.StorageProperties;
import eObrazovanje.web.service.FileService;

@SpringBootApplication
@EnableConfigurationProperties({StorageProperties.class})

public class App 
{
    public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);
    }
	/*@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}*/
}
