package com.example.System_gestion_LEXUS.Entities;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "services")
public abstract class Service {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id_Service;

    @Column(nullable = false)
    private Double frais;

     @Column(nullable = false)
    private LocalDate date;

    // Constructeurs
    public Service() {}

    public Service(Double frais) {
        this.frais = frais;
    }

    // Getters & Setters
    public Long getIdService() {
        return Id_Service;
    }

    public void setIdService(Long idService) {
        this.Id_Service = idService;
    }

    public Double getFrais() {
        return frais;
    }

    public void setFrais(Double frais) {
        this.frais = frais;
    }

    public LocalDate getdate() {
        return date;
    }

    public void setdate(LocalDate date) {
        this.date = date;
    }



    
}
