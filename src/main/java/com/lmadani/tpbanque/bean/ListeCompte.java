/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.lmadani.tpbanque.bean;

import com.lmadani.tpbanque.entity.CompteBancaire;
import com.lmadani.tpbanque.service.GestionnaireCompte;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author USER
 */
@Named(value = "listeCompte")
@ViewScoped
public class ListeCompte implements Serializable{

    /**
     * Creates a new instance of ListeCompte
     */
    @Inject
    private GestionnaireCompte gestionnaireCompte;
    
    private List<CompteBancaire> listeComptes ;
    
    public ListeCompte() {
    }
      public List<CompteBancaire> getAllComptes() {
    if (listeComptes == null) {
      listeComptes = gestionnaireCompte.getAllCompte();
    }
    return listeComptes;
  }
    
}
