package it.S5L5WP.BE0622WJH.DAO.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import it.S5L5WP.BE0622WJH.DAO.repositories.PrenotazioneRepository;
import it.S5L5WP.BE0622WJH.entity.Prenotazione;

@Service
public class PrenotazioneService {

	@Autowired
	private PrenotazioneRepository repo;
	
	public Prenotazione insert(Prenotazione e) {
		return repo.save(e);
	}
	
	public List<Prenotazione> getAll() {
		return repo.findAll();
	}
	
	public Prenotazione getById(int id) {
		return repo.findById(id);
	}
	
	public void delete(Prenotazione obj) {
		repo.delete(obj);
	}
	
	public Page<Prenotazione> getAll_page(Pageable pageable) {
		return repo.findAll(pageable);
	}
}
