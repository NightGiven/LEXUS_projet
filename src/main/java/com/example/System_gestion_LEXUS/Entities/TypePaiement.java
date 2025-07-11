package com.example.System_gestion_LEXUS.Entities;


import jakarta.persistence.*;



@Entity
@Table(name = "types_paiement")
public class TypePaiement {

@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nom; 


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

   

    
}
