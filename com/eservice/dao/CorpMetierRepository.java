package com.eservice.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.eservice.entities.CorpMetier;
import com.eservice.entities.Utilisateur;

public interface CorpMetierRepository extends JpaRepository<CorpMetier, Long> {
	
	@Query("select c from CorpMetier c where c.service.metier like %:x% and c.ville=:y")
	public List<CorpMetier> searchIgnoreCaseContaining(@Param("x") String metier,@Param("y") String ville);
}
