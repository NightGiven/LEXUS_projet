package com.example.System_gestion_LEXUS.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "installations_serveur")

public class Installation extends Service {
     @Column(nullable = false)
    private String description;

    public Installation() {
        super();
    }

    public Installation(Double frais, String description) {
        super(frais);
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
}
