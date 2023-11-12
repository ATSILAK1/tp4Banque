/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.lmadani.tpbanque.bean;

import com.lmadani.tpbanque.entity.CompteBancaire;
import com.lmadani.tpbanque.service.GestionnaireCompte;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

/**
 *
 * @author USER
 */

@Named(value = "transfert")
@RequestScoped
public class Transfert {

    @Inject
    private GestionnaireCompte gestionnaireCompte;

    private long idSource;
    private long idDestination;
    private int montant;

    public Transfert(long idSource, long idDestination, int montant) {
        this.idSource = idSource;
        this.idDestination = idDestination;
        this.montant = montant;
    }
    
    
    
    public long getIdSource() {
        return idSource;
    }

    public void setIdSource(long id) {
        this.idSource = id;
    }

    public long getIdDestination() {
        return idDestination;
    }

    public void setIdDestination(long id) {
        this.idDestination = id;
    }

    public int getMontant() {
        return montant;
    }

    public void setMontant(int montant) {
        this.montant = montant;
    }
                                 
    public String enregistrer()
    {
        CompteBancaire source = gestionnaireCompte.findById(idSource);
        CompteBancaire destination = gestionnaireCompte.findById(idDestination);
        if (source == null )
            return "erreur avec compte source ";
        if (destination == null)
            return "erreur avec le compte destination ";
        
        gestionnaireCompte.transferer(source, destination, montant);
        return  "transfert effectue avec succes";
    }
}
