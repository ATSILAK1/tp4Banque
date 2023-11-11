/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lmadani.tpbanque.service;

import com.lmadani.tpbanque.entity.CompteBancaire;
import jakarta.annotation.sql.DataSourceDefinition;
import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import java.util.List;

/**
 *
 * @author USER
 */
@DataSourceDefinition (
    className="com.mysql.cj.jdbc.MysqlDataSource",
    name="java:app/jdbc/banque",
    serverName="localhost",
    portNumber=3306,
    user="root",              // nom et
    password="root", // mot de passe que vous avez donnés lors de la création de la base de données
    databaseName="banque",
    properties = {
      "useSSL=false",
      "allowPublicKeyRetrieval=true",
      "driverClass=com.mysql.cj.jdbc.Driver"
    })
@RequestScoped
public class GestionnaireCompte {
    
    @PersistenceContext(unitName = "banquePU")
    private EntityManager em; 
            
    public void creerCompte(CompteBancaire c ){
        em.persist(c);
        
    }
    public List<CompteBancaire> getAllCompte(){
        Query query = em.createQuery("SELECT * from CompteBancaire;");
        return query.getResultList() ;
    }
    
}
