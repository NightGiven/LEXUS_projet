package com.example.System_gestion_LEXUS.Controller;

import com.example.System_gestion_LEXUS.Entities.Abonnement;
import com.example.System_gestion_LEXUS.Services.AbonnementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/abonnements")
@CrossOrigin(origins = "*")
public class AbonnementController {

    @Autowired
    private AbonnementService abonnementService;

    @GetMapping
    public List<Abonnement> getAllAbonnements() {
        return abonnementService.getAllAbonnements();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Abonnement> getAbonnementById(@PathVariable Long id) {
        return abonnementService.getAbonnementById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Abonnement createAbonnement(@RequestBody Abonnement abonnement) {
        return abonnementService.saveAbonnement(abonnement);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Abonnement> updateAbonnement(@PathVariable Long id, @RequestBody Abonnement details) {
        return abonnementService.getAbonnementById(id).map(abonnement -> {
            abonnement.setFrais(details.getFrais());
            abonnement.setDepenses(details.getDepenses());
            abonnement.setDureeEnMois(details.getDureeEnMois());
            Abonnement updated = abonnementService.saveAbonnement(abonnement);
            return ResponseEntity.ok(updated);
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAbonnement(@PathVariable Long id) {
        if (abonnementService.getAbonnementById(id).isPresent()) {
            abonnementService.deleteAbonnement(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}

