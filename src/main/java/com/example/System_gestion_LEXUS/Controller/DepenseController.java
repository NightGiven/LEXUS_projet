package com.example.System_gestion_LEXUS.Controller;

import com.example.System_gestion_LEXUS.Entities.Depense;
import com.example.System_gestion_LEXUS.Services.DepenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/api/depenses")
public class DepenseController {

    @Autowired
    private DepenseService depenseService;

    @GetMapping
    public ResponseEntity<List<Depense>> getAllDepenses() {
        List<Depense> depenses = depenseService.getAllDepenses();
        return new ResponseEntity<>(depenses, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Depense> getDepenseById(@PathVariable Long id) {
        return depenseService.getDepenseById(id)
                .map(depense -> new ResponseEntity<>(depense, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Depense> createDepense(@RequestBody Depense depense) {
        Depense newDepense = depenseService.createDepense(depense);
        return new ResponseEntity<>(newDepense, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Depense> updateDepense(@PathVariable Long id, @RequestBody Depense depense) {
        try {
            Depense updatedDepense = depenseService.updateDepense(id, depense);
            return new ResponseEntity<>(updatedDepense, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDepense(@PathVariable Long id) {
        depenseService.deleteDepense(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/by-date/{date}")
    public ResponseEntity<List<Depense>> getDepensesByDate(@PathVariable Date date) {
        List<Depense> depenses = depenseService.getDepensesByDate(date);
        return new ResponseEntity<>(depenses, HttpStatus.OK);
    }

    @GetMapping("/greater-than/{montant}")
    public ResponseEntity<List<Depense>> getDepensesGreaterThan(@PathVariable Double montant) {
        List<Depense> depenses = depenseService.getDepensesGreaterThan(montant);
        return new ResponseEntity<>(depenses, HttpStatus.OK);
    }

    @GetMapping("/between-dates")
    public ResponseEntity<List<Depense>> getDepensesBetweenDates(
            @RequestParam Date startDate,
            @RequestParam Date endDate) {
        List<Depense> depenses = depenseService.getDepensesBetweenDates(startDate, endDate);
        return new ResponseEntity<>(depenses, HttpStatus.OK);
    }
}