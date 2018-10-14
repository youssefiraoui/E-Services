package com.eservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eservice.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
