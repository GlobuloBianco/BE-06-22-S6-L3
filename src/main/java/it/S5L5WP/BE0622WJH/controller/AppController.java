package it.S5L5WP.BE0622WJH.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import it.S5L5WP.BE0622WJH.DAO.services.AppService;

@RestController
public class AppController {
	
	@Autowired
	AppService s;
	
	@GetMapping("/")
	public String index() {
		return "Sei all'index del compito S6-L2";
	}
	
	@GetMapping("/api")
	public String indexAPI() {
		return "Sei all'index API del compito S6-L2";
	}
	
	@GetMapping("/istruzione/{lang}")
	public String info(@PathVariable String lang) {
		return s.pathInfo(lang);
	}

}
