package com.example.System_gestion_LEXUS.Dto;

import java.util.List;

public class ClientDTO {
    private String cin;
    private String nom;
    private String prenom;
    private String telephone;
    private String email;

    private List<Long> encaissementsIds; // Liste des IDs des encaissements associés

    public ClientDTO() {}

    public ClientDTO(String cin, String nom, String prenom, String telephone, String email, List<Long> encaissementsIds) {
        this.cin = cin;
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
        this.email = email;
        this.encaissementsIds = encaissementsIds;
    }

    // Getters & Setters
    public String getCin() { return cin; }
    public void setCin(String cin) { this.cin = cin; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getPrenom() { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }

    public String getTelephone() { return telephone; }
    public void setTelephone(String telephone) { this.telephone = telephone; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public List<Long> getEncaissementsIds() { return encaissementsIds; }
    public void setEncaissementsIds(List<Long> encaissementsIds) { this.encaissementsIds = encaissementsIds; }
}

