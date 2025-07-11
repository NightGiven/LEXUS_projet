package com.example.System_gestion_LEXUS.Entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "installations_serveur")
public class Installation extends Service {

    @Column(nullable = false)
    private String description;

    // Constructeur vide pour JPA
    public Installation() {
        super();
    }


    // Constructeur complet avec frais, description et dépenses
    public Installation(Double frais, String description, List<Depense> depenses) {
        super(frais, depenses);
        this.description = description;
    }

    // ✅ Getters & Setters
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
