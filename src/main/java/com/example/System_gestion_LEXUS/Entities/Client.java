

package com.entreprise.gestionreglements.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "clients")
public class Client {

    @Id
    @Column(name = "cin", nullable = false, unique = true)
    private String cin;

    @Column(name = "nom", nullable = false)
    private String nom;

    @Column(name = "prenom", nullable = false)
    private String prenom;

    @Column(name = "telephone", nullable = false)
    private String telephone;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Encaissement> encaissements;

    public Client() {
    }

    public Client(String cin, String nom, String prenom, String telephone, String email) {
        this.cin = cin;
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
        this.email = email;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Encaissement> getEncaissements() {
        return encaissements;
    }

    public void setEncaissements(List<Encaissement> encaissements) {
        this.encaissements = encaissements;
    }
}
