/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eservice.entities;

import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

/**
 *
 * @author IRAOUI
 */
@Entity
@DiscriminatorValue("CLIENT")
public class Client extends Utilisateur {

    
private String image;
    public String getImage() {
	return image;
}

public void setImage(String image) {
	this.image = image;
}

	private long tel;
    @ManyToMany
    @JoinTable(name = "MESSAGES",
            joinColumns =@JoinColumn(name = "COD_CL"),
            inverseJoinColumns = @JoinColumn(name ="COD_EMP" ))
    private Collection<CorpMetier> corpMetiers;
    
    @OneToMany
    private Collection<Annonce> annonces;
    
    @OneToMany
    private Collection<Reclamation> reclamations;
    
    @OneToMany
    private Collection<Offre> offres;
    public Collection<Reclamation> getReclamations() {
        return reclamations;
    }

    public void setReclamations(Collection<Reclamation> reclamations) {
        this.reclamations = reclamations;
    }

    public Collection<Offre> getOffres() {
        return offres;
    }

    public void setOffres(Collection<Offre> offres) {
        this.offres = offres;
    }
    
    public Collection<Annonce> getAnnonces() {
        return annonces;
    }

    public void setAnnonces(Collection<Annonce> annonces) {
        this.annonces = annonces;
    }

    public Client(String nom, String prenom, String email, String password, String adresse, String dateNaiss,long tel) {
        super(nom, prenom, email, password, adresse, dateNaiss);
        this.tel = tel;
    }
    
    

    public Client() {
    }

    public long getTel() {
        return tel;
    }

    public void setTel(long tel) {
        this.tel = tel;
    }

    public Collection<CorpMetier> getCorpMetiers() {
        return corpMetiers;
    }

    public void setCorpMetiers(Collection<CorpMetier> corpMetiers) {
        this.corpMetiers = corpMetiers;
    }
    

    
}
