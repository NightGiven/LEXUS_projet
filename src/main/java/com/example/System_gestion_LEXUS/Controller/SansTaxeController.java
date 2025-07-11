package com.example.System_gestion_LEXUS.Controller;

import com.example.System_gestion_LEXUS.Entities.Sans_taxe;
import com.example.System_gestion_LEXUS.Services.SansTaxeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sans-taxe")
@CrossOrigin(origins = "*")
public class SansTaxeController {

    @Autowired
    private SansTaxeService sansTaxeService;

    @GetMapping
    public List<Sans_taxe> getAllSansTaxe() {
        return sansTaxeService.getAllSansTaxe();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sans_taxe> getSansTaxeById(@PathVariable Long id) {
        return sansTaxeService.getSansTaxeById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Sans_taxe createSansTaxe(@RequestBody Sans_taxe sansTaxe) {
        return sansTaxeService.saveSansTaxe(sansTaxe);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Sans_taxe> updateSansTaxe(@PathVariable Long id, @RequestBody Sans_taxe details) {
        return sansTaxeService.getSansTaxeById(id).map(sansTaxe -> {
            sansTaxe.setClient(details.getClient());
            sansTaxe.setServices(details.getServices());
            sansTaxe.setMontantAPayer(details.getMontantAPayer());
            Sans_taxe updated = sansTaxeService.saveSansTaxe(sansTaxe);
            return ResponseEntity.ok(updated);
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSansTaxe(@PathVariable Long id) {
        if (sansTaxeService.getSansTaxeById(id).isPresent()) {
            sansTaxeService.deleteSansTaxe(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
