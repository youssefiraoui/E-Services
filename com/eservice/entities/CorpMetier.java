/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eservice.entities;


import java.util.Collection;


import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


/**
 *
 * @author IRAOUI
 */
@Entity
@DiscriminatorValue("CORPMETIR")
public class CorpMetier extends Utilisateur {
    
    private int experience;
    private String cin;
    private String image;
    private Long tel;
    public Long getTel() {
		return tel;
	}

	public void setTel(Long tel) {
		this.tel = tel;
	}

	@ManyToMany(mappedBy = "corpMetiers")
    private Collection<Client> clients;
    
    @ManyToOne
    @JoinColumn(name = "SERV")
    private Service service;
    @OneToMany(cascade=CascadeType.ALL)
    private Collection<Accord> accords;
    @OneToMany(cascade=CascadeType.ALL)
    private Collection<Offre> offres;

    public Collection<Offre> getOffres() {
        return offres;
    }

    public void setOffres(Collection<Offre> offres) {
        this.offres = offres;
    }

    public Collection<Accord> getAccords() {
        return accords;
    }

    public void setAccords(Collection<Accord> accords) {
        this.accords = accords;
    }

    public CorpMetier(int experience, String image, String nom, String prenom, String email, String password, String adresse, String dateNaiss) {
        super(nom, prenom, email, password, adresse, dateNaiss);
        this.experience = experience;
        this.image = image;
    }

   
    
   

    public CorpMetier() {
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Collection<Client> getClients() {
        return clients;
    }

    public void setClients(Collection<Client> clients) {
        this.clients = clients;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

	@Override
	public String toString() {
		return "CorpMetier [experience=" + experience + ", cin=" + cin + ", image=" + image + ", clients=" + clients
				+ ", service=" + service + ", accords=" + accords + ", offres=" + offres + "]";
	}
    
}
