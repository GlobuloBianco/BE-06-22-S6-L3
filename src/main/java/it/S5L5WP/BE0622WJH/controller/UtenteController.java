package it.S5L5WP.BE0622WJH.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.S5L5WP.BE0622WJH.DAO.services.EdificioService;
import it.S5L5WP.BE0622WJH.DAO.services.UtenteService;
import it.S5L5WP.BE0622WJH.entity.Edificio;
import it.S5L5WP.BE0622WJH.entity.Utente;

@RestController
@RequestMapping("/api")
public class UtenteController {
	
	@Autowired
	private UtenteService serv;
	
	@GetMapping("utente")
	public ResponseEntity<List<Utente>> getAll() {
		List<Utente> obj = serv.getAll();
		
		if (obj.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(obj, HttpStatus.OK);
	}
	
	@GetMapping("utente/{id}")
	public ResponseEntity<Object> getById(@PathVariable Integer id) {
		Utente obj = serv.getById(id);

		return new ResponseEntity<>(obj, HttpStatus.OK);
	}
	
	@PostMapping("utente")
	public ResponseEntity<Utente> create(@RequestBody Utente x) {
		Utente obj = serv.insert(x);
		
		return new ResponseEntity<>(obj, HttpStatus.CREATED);
	}
	
	@PutMapping("utente/{id}")
	public ResponseEntity<Object> update(@PathVariable Integer id, @RequestBody Utente _obj) {
		Utente obj = serv.getById(id);

		obj.setEmail(_obj.getEmail());
		obj.setNome(_obj.getNome());
		obj.setUsername(_obj.getUsername());
		serv.insert(obj);
		
		return new ResponseEntity<>(obj, HttpStatus.OK);
	}
	
	@DeleteMapping("utente/{id}")
	public ResponseEntity<Object> delete(@PathVariable Integer id) {
		Utente obj = serv.getById(id);
		
		serv.delete(obj);
		return new ResponseEntity<>(String.format("L'elememnto con id %d rimosso!", id), HttpStatus.OK);
	}
	
	@GetMapping("utente_page")
	public ResponseEntity<Object> getAll_page(Pageable pageable) {
		Page<Utente> obj = serv.getAll_page(pageable);
		
		if( obj.isEmpty() ) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(obj, HttpStatus.OK);
	}
}