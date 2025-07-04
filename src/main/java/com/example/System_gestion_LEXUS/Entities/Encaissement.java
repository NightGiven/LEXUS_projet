package com.example.System_gestion_LEXUS.Entities;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "encaissements")
public class Encaissement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private double montant;

    @Column(nullable = false)
    private LocalDate date;

    @ManyToOne(optional = false)
    @JoinColumn(name = "client_cin", referencedColumnName = "cin")
    private Client client;

    @ManyToOne(optional = false)
    @JoinColumn(name = "type_id")
    private TypePaiement type;

    // Constructeurs
    public Encaissement() {
    }

    public Encaissement(Double montant, LocalDate date, Client client, TypePaiement type) {
        this.montant = montant;
        this.date = date;
        this.client = client;
        this.type = type;
    }

    // Getters et Setters

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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public TypePaiement getType() {
        return type;
    }

    public void setType(TypePaiement type) {
        this.type = type;
    }
}
