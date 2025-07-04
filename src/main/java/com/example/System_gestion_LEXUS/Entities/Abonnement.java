package com.example.System_gestion_LEXUS.Entities;

import jakarta.persistence.*;
@Entity
@Table(name = "abonnements")

public class Abonnement extends Service {
        @Column(name = "duree_en_mois", nullable = false)
    private int dureeEnMois;

    public Abonnement() {
        super();
    }

    public Abonnement(double frais, int dureeEnMois) {
        super(frais);
        this.dureeEnMois = dureeEnMois;
    }

    public int getDureeEnMois() {
        return dureeEnMois;
    }

    public void setDureeEnMois(int dureeEnMois) {
        this.dureeEnMois = dureeEnMois;
    }
    
}
