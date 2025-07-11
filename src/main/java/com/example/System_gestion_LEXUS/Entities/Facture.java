package com.example.System_gestion_LEXUS.Entities;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "factures")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Facture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFacture;

    @ManyToOne(optional = false)
    @JoinColumn(name = "client_cin", referencedColumnName = "cin")
    private Client client;

    @ManyToMany
    @JoinTable(
        name = "facture_services",
        joinColumns = @JoinColumn(name = "facture_id"),
        inverseJoinColumns = @JoinColumn(name = "service_id")
    )
    private List<Travail> services;

    public Facture() {}

    public Facture(Client client, List<Travail> services) {
        this.client = client;
        this.services = services;
    }

    // Getters et setters

    public Long getIdFacture() {
        return idFacture;
    }

    public void setIdFacture(Long idFacture) {
        this.idFacture = idFacture;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Travail> getServices() {
        return services;
    }

    public void setServices(List<Travail> services) {
        this.services = services;
    }
    
}
