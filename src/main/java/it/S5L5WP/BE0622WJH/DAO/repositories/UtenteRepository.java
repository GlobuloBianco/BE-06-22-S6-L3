package it.S5L5WP.BE0622WJH.DAO.repositories;

import org.springframework.stereotype.Repository;
import it.S5L5WP.BE0622WJH.entity.Utente;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UtenteRepository extends JpaRepository <Utente, Integer> {
	
	Utente findById(int id);
	Utente findByUsername(int utente);
	List<Utente> findByNome(String nome);
	List<Utente> findByEmail(String email);
}
