package com.example.System_gestion_LEXUS.Dto;

import java.util.List;

public class ServiceDTO {
    private Long id;
    private double frais;
    private List<Long> depensesIds;

    public ServiceDTO() {}

    public ServiceDTO(Long id, double frais, List<Long> depensesIds) {
        this.id = id;
        this.frais = frais;
        this.depensesIds = depensesIds;
    }

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public double getFrais() { return frais; }
    public void setFrais(double frais) { this.frais = frais; }

    public List<Long> getDepensesIds() { return depensesIds; }
    public void setDepensesIds(List<Long> depensesIds) { this.depensesIds = depensesIds; }
}

