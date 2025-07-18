package com.example.System_gestion_LEXUS.Controller;

import com.example.System_gestion_LEXUS.Entities.TypePaiement;
import com.example.System_gestion_LEXUS.Services.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/types-paiement")
public class TypeController {

    @Autowired
    private TypeService typePaiementService;

    @GetMapping
    public ResponseEntity<List<TypePaiement>> getAllTypesPaiement() {
        List<TypePaiement> types = typePaiementService.getAllTypesPaiement();
        return new ResponseEntity<>(types, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TypePaiement> getTypePaiementById(@PathVariable Long id) {
        return typePaiementService.getTypePaiementById(id)
                .map(type -> new ResponseEntity<>(type, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<TypePaiement> createTypePaiement(@RequestBody TypePaiement typePaiement) {
        TypePaiement savedType = typePaiementService.saveTypePaiement(typePaiement);
        return new ResponseEntity<>(savedType, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTypePaiement(@PathVariable Long id) {
        typePaiementService.deleteTypePaiement(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/by-nom/{nom}")
public ResponseEntity<TypePaiement> getTypePaiementByNom(@PathVariable String nom) {
    Optional<TypePaiement> type = typePaiementService.getTypePaiementByNom(nom);
    if (type.isPresent()) {
        return new ResponseEntity<>(type.get(), HttpStatus.OK);
    }
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
}

}
