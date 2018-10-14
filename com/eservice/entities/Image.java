/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eservice.entities;

import java.sql.Blob;

/**
 *
 * @author IRAOUI
 */
public class Image {
    private Long id;
    private String nom;
    private Blob photo;

    public Image(String nom, Blob photo) {
        this.nom = nom;
        this.photo = photo;
    }

    public Image() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id_image) {
        this.id = id_image;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Blob getPhoto() {
        return photo;
    }

    public void setPhoto(Blob photo) {
        this.photo = photo;
    }
    
    
}
