package com.eservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eservice.entities.Ville;

public interface VilleRepository extends JpaRepository<Ville, Long> {

}
