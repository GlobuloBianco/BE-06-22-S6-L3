package it.S5L5WP.BE0622WJH.DAO.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import it.S5L5WP.BE0622WJH.DAO.repositories.UtenteRepository;
import it.S5L5WP.BE0622WJH.entity.Utente;

@Service
public class UtenteService {

	@Autowired
	private UtenteRepository repo;
	
	public Utente insert(Utente e) {
		return repo.save(e);
	}
	
	public List<Utente> getAll() {
		return repo.findAll();
	}
	
	public Utente getById(int id) {
		return repo.findById(id);
	}
	
	public void delete(Utente p) {
		repo.delete(p);
	}
	
	public Page<Utente> getAll_page(Pageable pageable) {
		return repo.findAll(pageable);
	}
}
