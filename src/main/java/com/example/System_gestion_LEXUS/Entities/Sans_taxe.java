package com.example.System_gestion_LEXUS.Entities;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "factures_sanstaxe")

public class Sans_taxe extends Facture {
     @Column(name = "montant_a_payer", nullable = false)
    private Double montantAPayer;

    public Sans_taxe() {}

    public Sans_taxe(Client client, List<Service> services, Double montantAPayer) {
        super(client, services);
        this.montantAPayer = montantAPayer;
    }

    public Double getMontantAPayer() {
        return montantAPayer;
    }

    public void setMontantAPayer(Double montantAPayer) {
        this.montantAPayer = montantAPayer;
    }
    
}
