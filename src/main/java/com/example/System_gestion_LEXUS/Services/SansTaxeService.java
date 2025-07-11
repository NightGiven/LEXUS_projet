package com.example.System_gestion_LEXUS.Services;

import com.example.System_gestion_LEXUS.Entities.Sans_taxe;
import com.example.System_gestion_LEXUS.Repository.SansTaxeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SansTaxeService {

    @Autowired
    private SansTaxeRepository sansTaxeRepository;

    public List<Sans_taxe> getAllSansTaxe() {
        return sansTaxeRepository.findAll();
    }

    public Optional<Sans_taxe> getSansTaxeById(Long id) {
        return sansTaxeRepository.findById(id);
    }

    public Sans_taxe saveSansTaxe(Sans_taxe sansTaxe) {
        return sansTaxeRepository.save(sansTaxe);
    }

    public void deleteSansTaxe(Long id) {
        sansTaxeRepository.deleteById(id);
    }
}
