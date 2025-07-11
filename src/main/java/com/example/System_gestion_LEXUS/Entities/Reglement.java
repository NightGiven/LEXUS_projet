package com.example.System_gestion_LEXUS.Entities;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "reglements")

public class Reglement {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "montant_total", nullable = false)
    private Double montantTotal;

    @Column(name = "montant_paye", nullable = false)
    private Double montantPaye;

    @Column(name = "montant_restant", nullable = false)
    private Double montantRestant;

    @ManyToMany
    @JoinTable(
        name = "reglement_factures",
        joinColumns = @JoinColumn(name = "reglement_id"),
        inverseJoinColumns = @JoinColumn(name = "facture_id")
    )
    private List<Facture> factures;

   
    @ManyToOne
    @JoinColumn(name = "type_paiement_id")
    private TypePaiement typePaiement;

    @ManyToOne
    @JoinColumn(name = "client_cin", referencedColumnName = "cin")
    private Client client;

    // Constructeurs
    public Reglement() {}

    public Reglement(Double montantTotal, Double montantPaye, Double montantRestant,
                     List<Facture> factures, TypePaiement typePaiement, Client client) {
        this.montantTotal = montantTotal;
        this.montantPaye = montantPaye;
        this.montantRestant = montantRestant;
        this.factures = factures;
        this.typePaiement = typePaiement;
        this.client = client;
    }

    // Getters & Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getMontantTotal() {
        return montantTotal;
    }

    public void setMontantTotal(Double montantTotal) {
        this.montantTotal = montantTotal;
    }

    public Double getMontantPaye() {
        return montantPaye;
    }

    public void setMontantPaye(Double montantPaye) {
        this.montantPaye = montantPaye;
    }

    public Double getMontantRestant() {
        return montantRestant;
    }

    public void setMontantRestant(Double montantRestant) {
        this.montantRestant = montantRestant;
    }

    public List<Facture> getFactures() {
        return factures;
    }

    public void setFactures(List<Facture> factures) {
        this.factures = factures;
    }

    public TypePaiement getTypePaiement() {
        return typePaiement;
    }

    public void setTypePaiement(TypePaiement typePaiement) {
        this.typePaiement = typePaiement;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
    
}
