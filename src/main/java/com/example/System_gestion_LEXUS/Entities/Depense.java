package com.example.System_gestion_LEXUS.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "depenses")
public class Depense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Double montant;

  
    @ManyToOne
    @JoinColumn(name = "service_id")
    private Service service;

    // Constructeurs
    public Depense() {}

    public Depense(Double montant, Service service) {
        this.montant = montant;
        this.service = service;
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

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }
}
