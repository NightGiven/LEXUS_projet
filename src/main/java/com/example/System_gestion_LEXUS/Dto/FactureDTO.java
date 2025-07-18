package com.example.System_gestion_LEXUS.Dto;

import java.util.List;

public class FactureDTO {
    private Long id;
    private String clientCin;
    private List<Long> servicesIds; // Services inclus dans la facture

    public FactureDTO() {}

    public FactureDTO(Long id, String clientCin, List<Long> servicesIds) {
        this.id = id;
        this.clientCin = clientCin;
        this.servicesIds = servicesIds;
    }

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getClientCin() { return clientCin; }
    public void setClientCin(String clientCin) { this.clientCin = clientCin; }

    public List<Long> getServicesIds() { return servicesIds; }
    public void setServicesIds(List<Long> servicesIds) { this.servicesIds = servicesIds; }
}

