/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eservice.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author IRAOUI
 */
@Entity
public class Service implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String categorie;
    private String metier;
    @OneToMany
    private Collection<CorpMetier> corpMetiers;

    public Collection<CorpMetier> getCorpMetiers() {
        return corpMetiers;
    }

    public void setCorpMetiers(Collection<CorpMetier> corpMetiers) {
        this.corpMetiers = corpMetiers;
    }
            
    public Service() {
    }

    public Service(String categorie, String metier) {
        this.categorie = categorie;
        this.metier = metier;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id_service) {
        this.id = id_service;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getMetier() {
        return metier;
    }

    public void setMetier(String metier) {
        this.metier = metier;
    }
    
    
}
