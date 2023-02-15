package it.S5L5WP.BE0622WJH.DAO.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import it.S5L5WP.BE0622WJH.entity.Postazione;

@Repository
public interface PostazioneRepository extends JpaRepository<Postazione, Integer>{
	Postazione findById(int id);
}
