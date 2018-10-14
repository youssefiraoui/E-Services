package com.eservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eservice.entities.Service;

public interface ServiceRepository extends JpaRepository<Service, Long> {

}
