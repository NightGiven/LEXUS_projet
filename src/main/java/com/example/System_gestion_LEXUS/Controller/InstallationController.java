package com.example.System_gestion_LEXUS.Controller;

import com.example.System_gestion_LEXUS.Entities.Installation;
import com.example.System_gestion_LEXUS.Services.InstallationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/installations")
public class InstallationController {

    @Autowired
    private InstallationService installationService;

    // Récupérer toutes les installations
    @GetMapping
    public ResponseEntity<List<Installation>> getAllInstallations() {
        List<Installation> installations = installationService.getAllInstallations();
        return new ResponseEntity<>(installations, HttpStatus.OK);
    }

    // Récupérer une installation par son ID
    @GetMapping("/{id}")
    public ResponseEntity<Installation> getInstallationById(@PathVariable Long id) {
        Optional<Installation> installation = installationService.getInstallationById(id);
        return installation.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Créer une nouvelle installation
    @PostMapping
    public ResponseEntity<Installation> createInstallation(@RequestBody Installation installation) {
        Installation savedInstallation = installationService.saveInstallation(installation);
        return new ResponseEntity<>(savedInstallation, HttpStatus.CREATED);
    }

    // Supprimer une installation
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInstallation(@PathVariable Long id) {
        installationService.deleteInstallation(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
