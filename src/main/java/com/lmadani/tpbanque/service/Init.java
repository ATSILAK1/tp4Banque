/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.lmadani.tpbanque.service;

import com.lmadani.tpbanque.entity.CompteBancaire;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.Initialized;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.servlet.ServletContext;


/**
 *
 * @author USER
 */
@Named(value = "init")
@ApplicationScoped
public class Init {
    
    @Inject
    private GestionnaireCompte gestionnaireCompte;
    /**
     * Creates a new instance of Init
     */
    
    public Init() {
    }
    
     public void initComptes( @Observes @Initialized(ApplicationScoped.class) ServletContext context) {
   
 
    gestionnaireCompte.creerCompte(new CompteBancaire("John Lennon", 150000));
    gestionnaireCompte.creerCompte(new CompteBancaire("Paul McCartney", 950000));
    gestionnaireCompte.creerCompte(new CompteBancaire("Ringo Starr", 20000));
    gestionnaireCompte.creerCompte(new CompteBancaire("Georges Harrisson", 100000));
  }
}
