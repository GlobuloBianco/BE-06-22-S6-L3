package it.S5L5WP.BE0622WJH.DAO.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import it.S5L5WP.BE0622WJH.entity.Edificio;

@Repository
public interface EdificioRepository extends JpaRepository<Edificio, Integer> {
	
	//@Query(value = "SELECT * FROM edificio", nativeQuery = true)
	List<Edificio> findAll();
	  
	Edificio findById(int id);
	List<Edificio> findByCitta(String citta);
	List<Edificio> findByNome(String nome);
}
