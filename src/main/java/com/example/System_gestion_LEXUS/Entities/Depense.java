package com.example.System_gestion_LEXUS.Entities;

import java.sql.Date;

import jakarta.persistence.*;

@Entity
@Table(name = "depenses")
public class Depense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Double montant;

    @Column(nullable = false)
    private Date date;
  
    // Constructeurs
    public Depense() {}

    public Depense(Double montant) {
        this.montant = montant;
    
    }

    // Getters & Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getMontant() {
        return montant;
    }

    public void setMontant(Double montant) {
        this.montant = montant;
    }

     public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
