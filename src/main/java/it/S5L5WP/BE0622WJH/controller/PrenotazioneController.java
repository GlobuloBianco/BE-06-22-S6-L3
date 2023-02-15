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
import it.S5L5WP.BE0622WJH.DAO.services.PrenotazioneService;
import it.S5L5WP.BE0622WJH.entity.Edificio;
import it.S5L5WP.BE0622WJH.entity.Prenotazione;

@RestController
@RequestMapping("/api")
public class PrenotazioneController {
	
	@Autowired
	private PrenotazioneService serv;
	
	@GetMapping("prenotazione")
	public ResponseEntity<List<Prenotazione>> getAll() {
		List<Prenotazione> obj = serv.getAll();
		
		if (obj.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(obj, HttpStatus.OK);
	}
	
	@GetMapping("prenotazione/{id}")
	public ResponseEntity<Object> getById(@PathVariable Integer id) {
		Prenotazione obj = serv.getById(id);

		return new ResponseEntity<>(obj, HttpStatus.OK);
	}
	
	@PostMapping("prenotazione")
	public ResponseEntity<Prenotazione> create(@RequestBody Prenotazione x) {
		Prenotazione obj = serv.insert(x);
		
		return new ResponseEntity<>(obj, HttpStatus.CREATED);
	}
	
	@PutMapping("prenotazione/{id}")
	public ResponseEntity<Object> update(@PathVariable Integer id, @RequestBody Prenotazione _obj) {
		Prenotazione obj = serv.getById(id);

		obj.setData(_obj.getData());
		obj.setPostazione(_obj.getPostazione());
		obj.setUtente(_obj.getUtente());
		serv.insert(obj);
		
		return new ResponseEntity<>(obj, HttpStatus.OK);
	}
	
	@DeleteMapping("prenotazione/{id}")
	public ResponseEntity<Object> delete(@PathVariable Integer id) {
		Prenotazione obj = serv.getById(id);
		
		serv.delete(obj);
		return new ResponseEntity<>(String.format("L'elememnto con id %d rimosso!", id), HttpStatus.OK);
	}
	
	@GetMapping("prenotazione_page")
	public ResponseEntity<Object> getAll_page(Pageable pageable) {
		Page<Prenotazione> obj = serv.getAll_page(pageable);
		
		if( obj.isEmpty() ) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(obj, HttpStatus.OK);
	}
}
