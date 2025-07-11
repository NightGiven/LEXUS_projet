package com.example.System_gestion_LEXUS.Services;

import com.example.System_gestion_LEXUS.Entities.Travail;
import com.example.System_gestion_LEXUS.Repository.TravailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TravailService {

    @Autowired
    private TravailRepository travailRepository;

    public List<Travail> getAllTravaux() {
        return travailRepository.findAll();
    }

    public Optional<Travail> getTravailById(Long id) {
        return travailRepository.findById(id);
    }

    public Travail saveTravail(Travail travail) {
        return travailRepository.save(travail);
    }

    public void deleteTravail(Long id) {
        travailRepository.deleteById(id);
    }
}
