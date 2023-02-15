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
import it.S5L5WP.BE0622WJH.entity.Edificio;

@RestController
@RequestMapping("/api")
public class EdificioController {
	
	@Autowired
	private EdificioService serv;
	
	@GetMapping("edificio")
	public ResponseEntity<List<Edificio>> getAll() {
		List<Edificio> obj = serv.getAll();
		
		if (obj.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(obj, HttpStatus.OK);
	}
	
	@GetMapping("edificio/{id}")
	public ResponseEntity<Object> getById(@PathVariable Integer id) {
		Edificio obj = serv.getById(id);

		return new ResponseEntity<>(obj, HttpStatus.OK);
	}
	
	@PostMapping("edificio")
	public ResponseEntity<Edificio> create(@RequestBody Edificio x) {
		Edificio obj = serv.insert(x);
		
		return new ResponseEntity<>(obj, HttpStatus.CREATED);
	}
	
	@PutMapping("edificio/{id}")
	public ResponseEntity<Object> update(@PathVariable Integer id, @RequestBody Edificio _obj) {
		Edificio obj = serv.getById(id);

		obj.setCitta(_obj.getCitta());
		obj.setNome(_obj.getNome());
		obj.setIndirizzo(_obj.getIndirizzo());
		serv.insert(obj);
		
		return new ResponseEntity<>(obj, HttpStatus.OK);
	}
	
	@DeleteMapping("edificio/{id}")
	public ResponseEntity<Object> delete(@PathVariable Integer id) {
		Edificio obj = serv.getById(id);
		
		serv.delete(obj);
		return new ResponseEntity<>(String.format("L'elememnto con id %d rimosso!", id), HttpStatus.OK);
	}
	
	@GetMapping("edificio_page")
	public ResponseEntity<Object> getAll_page(Pageable pageable) {
		Page<Edificio> obj = serv.getAll_page(pageable);
		
		if( obj.isEmpty() ) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(obj, HttpStatus.OK);
	}
}
