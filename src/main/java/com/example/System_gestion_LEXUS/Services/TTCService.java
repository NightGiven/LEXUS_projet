package com.example.System_gestion_LEXUS.Services;

import com.example.System_gestion_LEXUS.Entities.TTC;
import com.example.System_gestion_LEXUS.Repository.TTCRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TTCService {

    @Autowired
    private TTCRepository ttcRepository;

    public List<TTC> getAllTTC() {
        return ttcRepository.findAll();
    }

    public Optional<TTC> getTTCById(Long id) {
        return ttcRepository.findById(id);
    }

    public TTC saveTTC(TTC ttc) {
        return ttcRepository.save(ttc);
    }

    public void deleteTTC(Long id) {
        ttcRepository.deleteById(id);
    }
}
