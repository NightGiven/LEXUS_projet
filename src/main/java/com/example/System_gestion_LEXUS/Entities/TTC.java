package com.example.System_gestion_LEXUS.Entities;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "factures_ttc")
public class TTC extends Facture {
    @Column(name = "montant_avant_taxe", nullable = false)
    private Double montantAvantTaxe;

    @Column(name = "montant_ttc", nullable = false)
    private Double montantTTC;

    public TTC() {}

    public TTC(Client client, List<Service> services, Double montantAvantTaxe, Double montantTTC) {
        super(client, services);
        this.montantAvantTaxe = montantAvantTaxe;
        this.montantTTC = montantTTC;
    }

    public Double getMontantAvantTaxe() {
        return montantAvantTaxe;
    }

    public void setMontantAvantTaxe(Double montantAvantTaxe) {
        this.montantAvantTaxe = montantAvantTaxe;
    }

    public Double getMontantTTC() {
        return montantTTC;
    }

    public void setMontantTTC(Double montantTTC) {
        this.montantTTC = montantTTC;
    }
    
}
