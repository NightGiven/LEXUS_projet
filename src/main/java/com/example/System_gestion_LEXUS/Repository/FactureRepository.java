package com.example.System_gestion_LEXUS.Repository;

import com.example.System_gestion_LEXUS.Entities.Facture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FactureRepository extends JpaRepository<Facture, Long> {
    
}
