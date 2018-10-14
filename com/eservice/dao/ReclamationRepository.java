package com.eservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eservice.entities.Reclamation;

public interface ReclamationRepository extends JpaRepository<Reclamation, Long> {

}
