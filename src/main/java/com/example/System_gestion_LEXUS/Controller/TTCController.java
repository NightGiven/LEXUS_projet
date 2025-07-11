package com.example.System_gestion_LEXUS.Controller;

import com.example.System_gestion_LEXUS.Entities.TTC;
import com.example.System_gestion_LEXUS.Services.TTCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ttc")
@CrossOrigin(origins = "*") 
public class TTCController {

    @Autowired
    private TTCService ttcService;

    @GetMapping
    public List<TTC> getAllTTC() {
        return ttcService.getAllTTC();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TTC> getTTCById(@PathVariable Long id) {
        return ttcService.getTTCById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public TTC createTTC(@RequestBody TTC ttc) {
        return ttcService.saveTTC(ttc);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TTC> updateTTC(@PathVariable Long id, @RequestBody TTC ttcDetails) {
        return ttcService.getTTCById(id).map(ttc -> {
            ttc.setClient(ttcDetails.getClient());
            ttc.setServices(ttcDetails.getServices());
            ttc.setMontantAvantTaxe(ttcDetails.getMontantAvantTaxe());
            ttc.setMontantTTC(ttcDetails.getMontantTTC());
            TTC updated = ttcService.saveTTC(ttc);
            return ResponseEntity.ok(updated);
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTTC(@PathVariable Long id) {
        if(ttcService.getTTCById(id).isPresent()) {
            ttcService.deleteTTC(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}

