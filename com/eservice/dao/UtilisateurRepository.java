package com.eservice.dao;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.eservice.entities.CorpMetier;
import com.eservice.entities.Utilisateur;


public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long>{
	//@Query("SELECT u.nom,a.titre,a.description from utilisateur u, annonce a WHERE u.id_user=a.cod_cl and u.type_user='CLIENT' ")
	//public List<Utilisateur> afficherAllAnnonces();
	//public List<Utilisateur> findById_user(Long id_user);
	public Utilisateur findByEmailAndPassword(String email,String password);
	@Query("select c from Utilisateur c where c.service.metier like %:x% and c.ville=:y")
	public List<Utilisateur> searchIgnoreCaseContaining(@Param("x") String metier,@Param("y") String ville);

}
