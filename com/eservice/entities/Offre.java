/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eservice.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author IRAOUI
 */
@Entity
public class Offre implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String adresse;
    private Date dateOffre;
    @ManyToOne
    @JoinColumn(name = "CODE_CLIENT")
    private Client client;
    @OneToMany
    private Collection<Reclamation> reclamations;
    
    private String ville;
    @ManyToOne
    @JoinColumn(name = "CODE_CorpMetier")
    private  CorpMetier corpMetier;

    public CorpMetier getCorpMetier() {
        return corpMetier;
    }

    public void setCorpMetier(CorpMetier corpMetier) {
        this.corpMetier = corpMetier;
    }
    
    public Offre() {
    }

    public Offre(String adresse, Date dateOffre) {
        this.adresse = adresse;
        this.dateOffre = dateOffre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id_offre) {
        this.id = id_offre;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Date getDateOffre() {
        return dateOffre;
    }

    public void setDateOffre(Date dateOffre) {
        this.dateOffre = dateOffre;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Collection<Reclamation> getReclamations() {
        return reclamations;
    }

    public void setReclamations(Collection<Reclamation> reclamations) {
        this.reclamations = reclamations;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }
   
}
