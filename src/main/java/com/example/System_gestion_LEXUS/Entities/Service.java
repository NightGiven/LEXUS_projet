package com.example.System_gestion_LEXUS.Entities;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "services")
public abstract class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column(nullable = false)
    protected Double frais;

    // Relation avec les dépenses
    @OneToMany(mappedBy = "service", cascade = CascadeType.ALL, orphanRemoval = true)
    protected List<Depense> depenses;

    // Constructeurs
    public Service() {}

    public Service(Double frais, List<Depense> depenses) {
        this.frais = frais;
        this.depenses = depenses;
    }

    // Getters & Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getFrais() {
        return frais;
    }

    public void setFrais(Double frais) {
        this.frais = frais;
    }

    public List<Depense> getDepenses() {
        return depenses;
    }

    public void setDepenses(List<Depense> depenses) {
        this.depenses = depenses;
    }

}
