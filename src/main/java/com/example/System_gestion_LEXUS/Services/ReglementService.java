package com.example.System_gestion_LEXUS.Services;

import com.example.System_gestion_LEXUS.Repository.ReglementRepository;
import com.example.System_gestion_LEXUS.Entities.Reglement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReglementService {

    @Autowired
    private ReglementRepository reglementRepository;

    public List<Reglement> getAll() {
        return reglementRepository.findAll();
    }

    public Optional<Reglement> getById(Long id) {
        return reglementRepository.findById(id);
    }

    public Reglement save(Reglement r) {
        return reglementRepository.save(r);
    }

    public void delete(Long id) {
        reglementRepository.deleteById(id);
    }
}
