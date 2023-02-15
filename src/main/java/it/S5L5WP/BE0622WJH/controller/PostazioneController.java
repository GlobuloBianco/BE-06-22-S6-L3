package it.S5L5WP.BE0622WJH.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import it.S5L5WP.BE0622WJH.DAO.services.PostazioneService;
import it.S5L5WP.BE0622WJH.entity.Postazione;

@RestController
@RequestMapping("/api")
public class PostazioneController {

	@Autowired
	private PostazioneService serv;
	
	@GetMapping("postazione")
	public ResponseEntity<List<Postazione>> getAll() {
		List<Postazione> obj = serv.getAll();
		
		if (obj.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(obj, HttpStatus.OK);
	}
	
	@GetMapping("postazione/{id}")
	public ResponseEntity<Object> getById(@PathVariable Integer id) {
		Postazione obj = serv.getById(id);

		return new ResponseEntity<>(obj, HttpStatus.OK);
	}
	
	@PostMapping("postazione")
	public ResponseEntity<Postazione> create(@RequestBody Postazione x) {
		Postazione obj = serv.insert(x);
		
		return new ResponseEntity<>(obj, HttpStatus.CREATED);
	}
	
	@PutMapping("postazione/{id}")
	public ResponseEntity<Object> update(@PathVariable Integer id, @RequestBody Postazione _obj) {
		Postazione obj = serv.getById(id);

		obj.setEdificio(_obj.getEdificio());
		obj.setDesc(_obj.getDesc());
		obj.setMax(_obj.getMax());
		obj.setTipo(_obj.getTipo());
		serv.insert(obj);
		
		return new ResponseEntity<>(obj, HttpStatus.OK);
	}
	
	@DeleteMapping("postazione/{id}")
	public ResponseEntity<Object> delete(@PathVariable Integer id) {
		Postazione obj = serv.getById(id);
		
		serv.delete(obj);
		return new ResponseEntity<>(String.format("L'elememnto con id %d rimosso!", id), HttpStatus.OK);
	}
}
