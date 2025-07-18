package com.example.System_gestion_LEXUS.Dto;

import java.time.LocalDate;

public class EncaissementDTO {
    private Long id;
    private double montantEncaisse;
    private LocalDate dateEncaissement;
    private String description;
    private Long reglementId; // Lien vers le règlement associé

    public EncaissementDTO() {}

    public EncaissementDTO(Long id, double montantEncaisse, LocalDate dateEncaissement, String description, Long reglementId) {
        this.id = id;
        this.montantEncaisse = montantEncaisse;
        this.dateEncaissement = dateEncaissement;
        this.description = description;
        this.reglementId = reglementId;
    }

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public double getMontantEncaisse() { return montantEncaisse; }
    public void setMontantEncaisse(double montantEncaisse) { this.montantEncaisse = montantEncaisse; }

    public LocalDate getDateEncaissement() { return dateEncaissement; }
    public void setDateEncaissement(LocalDate dateEncaissement) { this.dateEncaissement = dateEncaissement; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Long getReglementId() { return reglementId; }
    public void setReglementId(Long reglementId) { this.reglementId = reglementId; }
}

