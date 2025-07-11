package com.example.System_gestion_LEXUS.Services;

import com.example.System_gestion_LEXUS.Entities.Abonnement;
import com.example.System_gestion_LEXUS.Repository.AbonnementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AbonnementService {

    @Autowired
    private AbonnementRepository abonnementRepository;

    public List<Abonnement> getAllAbonnements() {
        return abonnementRepository.findAll();
    }

    public Optional<Abonnement> getAbonnementById(Long id) {
        return abonnementRepository.findById(id);
    }

    public Abonnement saveAbonnement(Abonnement abonnement) {
        return abonnementRepository.save(abonnement);
    }

    public void deleteAbonnement(Long id) {
        abonnementRepository.deleteById(id);
    }
}
