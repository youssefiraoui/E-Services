/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eservice.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author IRAOUI
 */
@Entity
public class Reclamation implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    private Date dateReclamation;
    private String description;
    
    @ManyToOne
    @JoinColumn(name = "CLIENT_NUM")
    private Client client;
    
    
    @ManyToOne
    @JoinColumn(name = "OFFRE_NUM")
    private Offre offre;

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Offre getOffre() {
        return offre;
    }

    public void setOffre(Offre offre) {
        this.offre = offre;
    }

    public Reclamation() {
    }

    public Reclamation(String type, Date dateReclamation, String description) {
        this.type = type;
        this.dateReclamation = dateReclamation;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id_reclamation) {
        this.id = id_reclamation;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDateReclamation() {
        return dateReclamation;
    }

    public void setDateReclamation(Date dateReclamation) {
        this.dateReclamation = dateReclamation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
}
