package com.example.amazoncdan.dto;

import java.util.Date;

public class UtilisateurDto {

    private Number id;

    private String nom;

    private String prenom;

    private Date naissance;

    private Date inscription;

    private String type;

    public Number getId() { return id; }
    public void setId(Number id) { this.id =  id; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom =  nom; }

    public String getPrenom() { return prenom; }
    public void setPrenom(String prenom) { this.prenom =  prenom; }

    public Date getNaissance() { return naissance; }
    public void setNaissance(Date naissance) { this.naissance =  naissance; }

    public Date getInscription() { return inscription; }
    public void setInscription(Date inscription) { this.inscription =  inscription; }

    public String getType() { return type; }
    public void setType(String type) { this.type =  type; }


}
