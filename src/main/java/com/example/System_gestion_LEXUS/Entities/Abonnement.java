package com.example.System_gestion_LEXUS.Entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "abonnements")
public class Abonnement extends Service {

    @Column(name = "duree_en_mois", nullable = false)
    private int dureeEnMois;

    // Constructeur vide 
    public Abonnement() {
        super();
    }

    // Constructeur complet avec liste de dépenses
    public Abonnement(double frais, int dureeEnMois, List<Depense> depenses) {
        super(frais, depenses);
        this.dureeEnMois = dureeEnMois;
    }

    // ✅ Getters & Setters
    public int getDureeEnMois() {
        return dureeEnMois;
    }

    public void setDureeEnMois(int dureeEnMois) {
        this.dureeEnMois = dureeEnMois;
    }
}
