/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eservice.entities;

import java.util.Date;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 *
 * @author IRAOUI
 */
@Entity
@DiscriminatorValue("ADMIN")
public class Admin extends Utilisateur {

    public Admin() {
    }

    public Admin(String nom, String prenom, String email, String password, String adresse, String dateNaiss) {
        super(nom, prenom, email, password, adresse, dateNaiss);
    }

    
}
