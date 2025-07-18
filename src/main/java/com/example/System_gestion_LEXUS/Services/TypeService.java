package com.example.System_gestion_LEXUS.Services;

import com.example.System_gestion_LEXUS.Entities.TypePaiement;
import com.example.System_gestion_LEXUS.Repository.TypePaiementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TypeService {

    @Autowired
    private TypePaiementRepository typePaiementRepository;

    public List<TypePaiement> getAllTypesPaiement() {
        return typePaiementRepository.findAll();
    }

    public Optional<TypePaiement> getTypePaiementById(Long id) {
        return typePaiementRepository.findById(id);
    }

    public TypePaiement saveTypePaiement(TypePaiement typePaiement) {
        return typePaiementRepository.save(typePaiement);
    }

    public void deleteTypePaiement(Long id) {
        typePaiementRepository.deleteById(id);
    }

    public Optional<TypePaiement> getTypePaiementByNom(String nom) {
        return typePaiementRepository.findByNom(nom);
    }
}
