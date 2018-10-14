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
public class Accord implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date dateAccord;
    private String ville;
    private String adresseCl;
 

	@ManyToOne
    @JoinColumn(name = "COD_CLIENT")
    private Client client;
    @ManyToOne
     @JoinColumn(name = "COD_CORPMETIER")
    private CorpMetier corpMetier;

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public CorpMetier getCorpMetier() {
        return corpMetier;
    }

    public void setCorpMetier(CorpMetier corpMetier) {
        this.corpMetier = corpMetier;
    }
    
    public Accord() {
    }

    public Accord(Date dateAccord, String ville, String adresseCl) {
        this.dateAccord = dateAccord;
        this.ville = ville;
        this.adresseCl = adresseCl;
    }

    public Long getId() {
        return id;
    }

    public void setId_accord(Long id_accord) {
        this.id = id_accord;
    }

    public Date getDateAccord() {
        return dateAccord;
    }

    public void setDateAccord(Date dateAccord) {
        this.dateAccord = dateAccord;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getAdresseCl() {
        return adresseCl;
    }

    public void setAdresseCl(String adresseCl) {
        this.adresseCl = adresseCl;
    }

	@Override
	public String toString() {
		return "Accord [id=" + id + ", dateAccord=" + dateAccord + ", ville=" + ville + ", adresseCl=" + adresseCl
				+ ", client=" + client + ", corpMetier=" + corpMetier + "]";
	}
    
    
    
}
