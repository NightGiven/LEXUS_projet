package com.example.System_gestion_LEXUS.Entities;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "encaissements")
public class Encaissement {

     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "montant_encaisse", nullable = false)
    private Double montantEncaisse;

    @Column(name = "date_encaissement", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateEncaissement;

    @Column(length = 255)
    private String description;

    // 🔁 Relation avec Reglement (ManyToOne)
    @ManyToOne
    @JoinColumn(name = "reglement_id")
    private Reglement reglement;

    // ✅ Constructeurs
    public Encaissement() {}

    public Encaissement(Double montantEncaisse, Date dateEncaissement, String description, Reglement reglement) {
        this.montantEncaisse = montantEncaisse;
        this.dateEncaissement = dateEncaissement;
        this.description = description;
        this.reglement = reglement;
    }

    // ✅ Getters & Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getMontantEncaisse() {
        return montantEncaisse;
    }

    public void setMontantEncaisse(Double montantEncaisse) {
        this.montantEncaisse = montantEncaisse;
    }

    public Date getDateEncaissement() {
        return dateEncaissement;
    }

    public void setDateEncaissement(Date dateEncaissement) {
        this.dateEncaissement = dateEncaissement;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Reglement getReglement() {
        return reglement;
    }

    public void setReglement(Reglement reglement) {
        this.reglement = reglement;
    }
}
