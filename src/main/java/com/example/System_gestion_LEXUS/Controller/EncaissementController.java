package com.example.System_gestion_LEXUS.Controller;

import com.example.System_gestion_LEXUS.Entities.Encaissement;
import com.example.System_gestion_LEXUS.Services.EncaissementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/encaissements")
@CrossOrigin(origins = "*")
public class EncaissementController {

    @Autowired
    private EncaissementService service;

    @GetMapping
    public List<Encaissement> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Encaissement> getById(@PathVariable Long id) {
        return service.getById(id).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Encaissement create(@RequestBody Encaissement e) {
        return service.save(e);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}

