package com.example.System_gestion_LEXUS.Dto;

import java.util.List;

public class ReglementDTO {
    private Long id;
    private double montantTotal;
    private double montantPaye;
    private double montantRestant;

    private List<Long> facturesIds;
    private String typePaiement;  // Exemple : "Espèce", "Chèque"
    private String clientCin;     // Lien vers le client

    public ReglementDTO() {}

    public ReglementDTO(Long id, double montantTotal, double montantPaye, double montantRestant,
                        List<Long> facturesIds, String typePaiement, String clientCin) {
        this.id = id;
        this.montantTotal = montantTotal;
        this.montantPaye = montantPaye;
        this.montantRestant = montantRestant;
        this.facturesIds = facturesIds;
        this.typePaiement = typePaiement;
        this.clientCin = clientCin;
    }

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public double getMontantTotal() { return montantTotal; }
    public void setMontantTotal(double montantTotal) { this.montantTotal = montantTotal; }

    public double getMontantPaye() { return montantPaye; }
    public void setMontantPaye(double montantPaye) { this.montantPaye = montantPaye; }

    public double getMontantRestant() { return montantRestant; }
    public void setMontantRestant(double montantRestant) { this.montantRestant = montantRestant; }

    public List<Long> getFacturesIds() { return facturesIds; }
    public void setFacturesIds(List<Long> facturesIds) { this.facturesIds = facturesIds; }

    public String getTypePaiement() { return typePaiement; }
    public void setTypePaiement(String typePaiement) { this.typePaiement = typePaiement; }

    public String getClientCin() { return clientCin; }
    public void setClientCin(String clientCin) { this.clientCin = clientCin; }
}

