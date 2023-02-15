package it.S5L5WP.BE0622WJH.DAO.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import it.S5L5WP.BE0622WJH.DAO.repositories.EdificioRepository;
import it.S5L5WP.BE0622WJH.entity.Edificio;

@Service
public class EdificioService {

	@Autowired
	private EdificioRepository repo;
	
	public Edificio insert(Edificio e) {
		return repo.save(e);
	}
	
	public List<Edificio> getAll() {
		return repo.findAll();
	}
	
	public Edificio getById(int id) {
		return repo.findById(id);
	}
	
	public void delete(Edificio p) {
		repo.delete(p);
	}
	
	public Page<Edificio> getAll_page(Pageable pageable) {
		return repo.findAll(pageable);
	}
}
