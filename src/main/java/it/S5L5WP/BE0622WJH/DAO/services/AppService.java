package it.S5L5WP.BE0622WJH.DAO.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

@Service
@PropertySource("classpath:application.properties")
public class AppService {
	
		@Value("${appservice.ita}")
		private String ita;
		@Value("${appservice.eng}")
		private String eng;
		@Value("${appservice.errore}")
		private String errore;
		
	public String pathInfo(String path) {
		if (path.equals("it")) {
			return ita;
		} else if (path.equals("en")) {
			return eng;
		} else {
			return errore;
		}
	}
}
