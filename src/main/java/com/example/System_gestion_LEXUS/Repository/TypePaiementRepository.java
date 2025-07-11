package com.example.System_gestion_LEXUS.Repository;



import com.example.System_gestion_LEXUS.Entities.TypePaiement;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TypePaiementRepository extends JpaRepository<TypePaiement, Long> {
    
    Optional<TypePaiement> findByNom(String nom);
}
