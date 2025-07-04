package com.example.System_gestion_LEXUS.Entities;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "reglements")

public class Reglement {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_reglement;

    @Column(name = "montant_total", nullable = false)
    private Double montantTotal;

    @Column(name = "montant_paye", nullable = false)
    private Double montant_Paye;

    @Column(name = "montant_restant", nullable = false)
    private Double montant_Restant;

    @ManyToMany
    @JoinTable(
        name = "reglement_factures",
        joinColumns = @JoinColumn(name = "reglement_id"),
        inverseJoinColumns = @JoinColumn(name = "facture_id")
    )
    private List<Facture> factures;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "reglement_id") // FK dans la table encaissements
    private List<Encaissement> encaissements;

    // Constructeurs
    public Reglement() {}

    public Reglement(Double montantTotal, Double montantPaye, Double montantRestant,
                     List<Facture> factures, List<Encaissement> encaissements) {
        this.montantTotal = montantTotal;
        this.montant_Paye = montantPaye;
        this.montant_Restant = montantRestant;
        this.factures = factures;
        this.encaissements = encaissements;
    }

    // Getters & Setters

    public Long getId() {
        return id_reglement;
    }

    public void setId(Long id) {
        this.id_reglement = id;
    }

    public Double getMontantTotal() {
        return montantTotal;
    }

    public void setMontantTotal(Double montantTotal) {
        this.montantTotal = montantTotal;
    }

    public Double getMontantPaye() {
        return montant_Paye;
    }

    public void setMontantPaye(Double montantPaye) {
        this.montant_Paye = montantPaye;
    }

    public Double getMontantRestant() {
        return montant_Restant;
    }

    public void setMontantRestant(Double montantRestant) {
        this.montant_Restant = montantRestant;
    }

    public List<Facture> getFactures() {
        return factures;
    }

    public void setFactures(List<Facture> factures) {
        this.factures = factures;
    }

    public List<Encaissement> getEncaissements() {
        return encaissements;
    }

    public void setEncaissements(List<Encaissement> encaissements) {
        this.encaissements = encaissements;
    }
    
}
