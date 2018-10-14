package com.eservice.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.eservice.entities.Annonce;


public interface AnnonceRepository extends JpaRepository<Annonce, Long> {
	@Query("select a from Annonce a where a.titre like %:x% and a.ville=:y")
	public List<Annonce> searchIgnoreCaseContaining(@Param("x") String titre,@Param("y") String ville);

}
