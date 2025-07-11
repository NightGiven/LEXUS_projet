package com.example.System_gestion_LEXUS.Controller;

import com.example.System_gestion_LEXUS.Entities.Facture;
import com.example.System_gestion_LEXUS.Services.FactureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/factures")
@CrossOrigin(origins = "*") // à adapter
public class FactureController {

    @Autowired
    private FactureService factureService;

    @GetMapping
    public List<Facture> getAllFactures() {
        return factureService.getAllFactures();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Facture> getFactureById(@PathVariable Long id) {
        return factureService.getFactureById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Facture createFacture(@RequestBody Facture facture) {
        return factureService.saveFacture(facture);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Facture> updateFacture(@PathVariable Long id, @RequestBody Facture factureDetails) {
        return factureService.getFactureById(id).map(facture -> {
            facture.setClient(factureDetails.getClient());
            facture.setServices(factureDetails.getServices());
            Facture updated = factureService.saveFacture(facture);
            return ResponseEntity.ok(updated);
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFacture(@PathVariable Long id) {
        if(factureService.getFactureById(id).isPresent()) {
            factureService.deleteFacture(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
