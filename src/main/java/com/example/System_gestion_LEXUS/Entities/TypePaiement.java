package com.example.System_gestion_LEXUS.Entities;


import jakarta.persistence.*;
import java.util.List;


@Entity
@Table(name = "types_paiement")
public class TypePaiement {

@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nom; 

    @OneToMany(mappedBy = "type", cascade = CascadeType.ALL)
    private List<Encaissement> encaissements;

    public TypePaiement() {
    }

    public TypePaiement(String nom) {
        this.nom = nom;
    }

    // Getters et Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Encaissement> getEncaissements() {
        return encaissements;
    }

    public void setEncaissements(List<Encaissement> encaissements) {
        this.encaissements = encaissements;
    }

    
}
