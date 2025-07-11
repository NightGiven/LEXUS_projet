package com.example.System_gestion_LEXUS.Services;

import com.example.System_gestion_LEXUS.Repository.EncaissementRepository;
import com.example.System_gestion_LEXUS.Entities.Encaissement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EncaissementService {

    @Autowired
    private EncaissementRepository encaissementRepository;

    public List<Encaissement> getAll() {
        return encaissementRepository.findAll();
    }

    public Optional<Encaissement> getById(Long id) {
        return encaissementRepository.findById(id);
    }

    public Encaissement save(Encaissement encaissement) {
        return encaissementRepository.save(encaissement);
    }

    public void delete(Long id) {
        encaissementRepository.deleteById(id);
    }
}
