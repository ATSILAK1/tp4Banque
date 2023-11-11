/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.lmadani.tpbanque.config;

import com.lmadani.tpbanque.entity.CompteBancaire;
import com.lmadani.tpbanque.service.GestionnaireCompte;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

/**
 *
 * @author USER
 */
@ApplicationScoped
@Named(value = "init")
public class init {

    /**
     * Creates a new instance of init     
     */
    @Inject
    private GestionnaireCompte gestionnaireCompte;
    
    public init() {
    }
    @PostConstruct
    public void initCompte()
    {
        gestionnaireCompte.creerCompte(new CompteBancaire("John Lennon", 150000));
        gestionnaireCompte.creerCompte(new CompteBancaire("Paul McCartney", 950000));
        gestionnaireCompte.creerCompte(new CompteBancaire("Ringo Starr", 20000));
        gestionnaireCompte.creerCompte(new CompteBancaire("Georges Harrisson",100000));
        
        
    }
}
