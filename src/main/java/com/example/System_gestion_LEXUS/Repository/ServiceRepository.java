package com.example.System_gestion_LEXUS.Repository;


import com.example.System_gestion_LEXUS.Entities.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<Service, Long> {
    
}
