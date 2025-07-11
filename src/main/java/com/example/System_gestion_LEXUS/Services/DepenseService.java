package com.example.System_gestion_LEXUS.Services;

import com.example.System_gestion_LEXUS.Entities.Depense;
import com.example.System_gestion_LEXUS.Repository.DepenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service
public class DepenseService {

    @Autowired
    private DepenseRepository depenseRepository;

    public List<Depense> getAllDepenses() {
        return depenseRepository.findAll();
    }

    public Optional<Depense> getDepenseById(Long id) {
        return depenseRepository.findById(id);
    }

    public Depense createDepense(Depense depense) {
        return depenseRepository.save(depense);
    }

    public Depense updateDepense(Long id, Depense depenseDetails) {
        Depense depense = depenseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Dépense non trouvée avec l'id: " + id));
        
        depense.setMontant(depenseDetails.getMontant());
        depense.setDate(depenseDetails.getDate());
        
        return depenseRepository.save(depense);
    }

    public void deleteDepense(Long id) {
        depenseRepository.deleteById(id);
    }

    public List<Depense> getDepensesByDate(Date date) {
        return depenseRepository.findByDate(date);
    }

    public List<Depense> getDepensesGreaterThan(Double montant) {
        return depenseRepository.findByMontantGreaterThan(montant);
    }

    public List<Depense> getDepensesBetweenDates(Date startDate, Date endDate) {
        return depenseRepository.findByDateBetween(startDate, endDate);
    }
}