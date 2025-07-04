package com.example.System_gestion_LEXUS.Repository;


import com.example.System_gestion_LEXUS.Entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ClientRepository extends JpaRepository<Client, String> {
    
}
