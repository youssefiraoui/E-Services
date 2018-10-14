/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eservice.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


/**
 *
 * @author IRAOUI
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE_USER",
        discriminatorType = DiscriminatorType.STRING,
        length = 10)
public class Utilisateur implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    private String email;
    private String password;
    private String adresse;
    private String dateNaiss;
    
    
    private String ville;

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public Utilisateur() {
    }

    public Utilisateur(String nom, String email, String dateNaiss) {
        this.nom = nom;
        this.email = email;
        this.dateNaiss = dateNaiss;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id_user) {
        this.id = id_user;
    }

    public String getNom() {
        return nom;
    }
 

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDateNaiss() {
        return dateNaiss;
    }

    public void setDateNaiss(String dateNaiss) {
        this.dateNaiss = dateNaiss;
    }

    public Utilisateur(String nom, String prenom, String email, String password, String adresse, String dateNaiss) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.password = password;
        this.adresse = adresse;
        this.dateNaiss = dateNaiss;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

	@Override
	public String toString() {
		return "Utilisateur [id_user=" + id + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email
				+ ", password=" + password + ", adresse=" + adresse + ", dateNaiss=" + dateNaiss + ", ville=" + ville
				+ "]";
	}
    
    
    
    
}
