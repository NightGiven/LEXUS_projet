package com.example.System_gestion_LEXUS.Controller;

import com.example.System_gestion_LEXUS.Repository.ReglementRepository;
import com.example.System_gestion_LEXUS.Repository.ClientRepository;
import com.example.System_gestion_LEXUS.Repository.TypePaiementRepository;
import com.example.System_gestion_LEXUS.Repository.FactureRepository;
import com.example.System_gestion_LEXUS.Entities.Reglement;
import com.example.System_gestion_LEXUS.Entities.Client;
import com.example.System_gestion_LEXUS.Entities.TypePaiement;
import com.example.System_gestion_LEXUS.Entities.Facture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/reglements")
@CrossOrigin(origins = "*") // Autoriser React ou tout autre frontend
public class ReglementController {

    @Autowired
    private ReglementRepository reglementRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private TypePaiementRepository typePaiementRepository;

    @Autowired
    private FactureRepository factureRepository;

    // 🔹 GET : tous les règlements
    @GetMapping
    public List<Reglement> getAllReglements() {
        return reglementRepository.findAll();
    }

    // 🔹 GET : un règlement par ID
    @GetMapping("/{id}")
    public ResponseEntity<Reglement> getReglementById(@PathVariable Long id) {
        Optional<Reglement> reglement = reglementRepository.findById(id);
        return reglement.map(ResponseEntity::ok)
                        .orElse(ResponseEntity.notFound().build());
    }

    // 🔹 POST : créer un nouveau règlement
    @PostMapping
    public ResponseEntity<Reglement> createReglement(@RequestBody Reglement reglement) {
        // Vérifie que client et typePaiement existent
        if (reglement.getClient() != null && reglement.getClient().getCin() != null) {
            Optional<Client> clientOpt = clientRepository.findById(reglement.getClient().getCin());
            clientOpt.ifPresent(reglement::setClient);
        }

        if (reglement.getTypePaiement() != null && reglement.getTypePaiement().getId() != null) {
            Optional<TypePaiement> tpOpt = typePaiementRepository.findById(reglement.getTypePaiement().getId());
            tpOpt.ifPresent(reglement::setTypePaiement);
        }

        // Facultatif : charger les factures complètes si besoin
        if (reglement.getFactures() != null && !reglement.getFactures().isEmpty()) {
            List<Facture> completeFactures = new ArrayList<>();
            for (Facture f : reglement.getFactures()) {
                factureRepository.findById(f.getIdFacture()).ifPresent(completeFactures::add);
            }
            reglement.setFactures(completeFactures);
        }

        return ResponseEntity.ok(reglementRepository.save(reglement));
    }

    // 🔹 PUT : modifier un règlement
    @PutMapping("/{id}")
    public ResponseEntity<Reglement> updateReglement(@PathVariable Long id, @RequestBody Reglement updated) {
        Optional<Reglement> existingOpt = reglementRepository.findById(id);
        if (existingOpt.isEmpty()) return ResponseEntity.notFound().build();

        Reglement reglement = existingOpt.get();
        reglement.setMontantTotal(updated.getMontantTotal());
        reglement.setMontantPaye(updated.getMontantPaye());
        reglement.setMontantRestant(updated.getMontantRestant());

        if (updated.getClient() != null)
            clientRepository.findById(updated.getClient().getCin()).ifPresent(reglement::setClient);

        if (updated.getTypePaiement() != null)
            typePaiementRepository.findById(updated.getTypePaiement().getId()).ifPresent(reglement::setTypePaiement);

        if (updated.getFactures() != null && !updated.getFactures().isEmpty()) {
            List<Facture> factures = new ArrayList<>();
            for (Facture f : updated.getFactures()) {
                factureRepository.findById(f.getIdFacture()).ifPresent(factures::add);
            }
            reglement.setFactures(factures);
        }

        return ResponseEntity.ok(reglementRepository.save(reglement));
    }

    // 🔹 DELETE : supprimer un règlement
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReglement(@PathVariable Long id) {
        if (!reglementRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        reglementRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

