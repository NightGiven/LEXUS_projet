package com.example.System_gestion_LEXUS.Repository;

import com.example.System_gestion_LEXUS.Entities.Encaissement;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EncaissementRepository extends JpaRepository<Encaissement, Long>  {
    
}
