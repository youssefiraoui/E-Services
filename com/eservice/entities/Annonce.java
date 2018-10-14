/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eservice.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author IRAOUI
 */
@Entity
public class Annonce implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    @Size(min=5,max=100)
    private String titre;
    private String delai;
    private String description;
    private int prix;
    
    private String image;
    private String ville;
    private String addresse;
    
    
    public String getAddresse() {
		return addresse;
	}

	public void setAddresse(String addresse) {
		this.addresse = addresse;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public Annonce(String titre, String delai, String description, int prix, String image, String ville) {
		super();
		this.titre = titre;
		this.delai = delai;
		this.description = description;
		this.prix = prix;
		this.image = image;
		this.ville = ville;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getPrix() {
		return prix;
	}

	public void setPrix(int prix) {
		this.prix = prix;
	}

	@ManyToOne
    @JoinColumn(name = "COD_CL")
    private Client client;  

    public Annonce(String titre, String delai, String description) {
        this.titre = titre;
        this.delai = delai;
        this.description = description;
    }

    public Annonce() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id_annonce) {
        this.id= id_annonce;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDelai() {
        return delai;
    }

    public void setDelai(String delai) {
        this.delai = delai;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
    
}
