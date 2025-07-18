package com.example.System_gestion_LEXUS.Dto;

public class DepenseDTO {
    private Long id;
    private double montantDepense;

    public DepenseDTO() {}

    public DepenseDTO(Long id, double montantDepense) {
        this.id = id;
        this.montantDepense = montantDepense;
    }

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public double getMontantDepense() { return montantDepense; }
    public void setMontantDepense(double montantDepense) { this.montantDepense = montantDepense; }
}

