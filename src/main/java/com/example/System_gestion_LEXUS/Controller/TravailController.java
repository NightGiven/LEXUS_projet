package com.example.System_gestion_LEXUS.Controller;

import com.example.System_gestion_LEXUS.Entities.Travail;
import com.example.System_gestion_LEXUS.Services.TravailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/travaux")
@CrossOrigin(origins = "*")
public class TravailController {

    @Autowired
    private TravailService travailService;

    @GetMapping
    public List<Travail> getAllTravaux() {
        return travailService.getAllTravaux();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Travail> getTravailById(@PathVariable Long id) {
        return travailService.getTravailById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Travail createTravail(@RequestBody Travail travail) {
        return travailService.saveTravail(travail);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Travail> updateTravail(@PathVariable Long id, @RequestBody Travail details) {
        return travailService.getTravailById(id).map(travail -> {
            travail.setFrais(details.getFrais());
            travail.setDepenses(details.getDepenses());
            Travail updated = travailService.saveTravail(travail);
            return ResponseEntity.ok(updated);
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTravail(@PathVariable Long id) {
        if (travailService.getTravailById(id).isPresent()) {
            travailService.deleteTravail(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}

