package it.S5L5WP.BE0622WJH.DAO.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.S5L5WP.BE0622WJH.DAO.repositories.PostazioneRepository;
import it.S5L5WP.BE0622WJH.entity.Edificio;
import it.S5L5WP.BE0622WJH.entity.Postazione;

@Service
public class PostazioneService {

	@Autowired
	private PostazioneRepository repo;
	
	public Postazione insert(Postazione e) {
		return repo.save(e);
	}
	
	public List<Postazione> getAll() {
		return repo.findAll();
	}
	
	public Postazione getById(int id) {
		return repo.findById(id);
	}
	
	public void delete(Postazione p) {
		repo.delete(p);
	}
}
