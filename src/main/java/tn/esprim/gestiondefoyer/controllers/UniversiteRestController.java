package tn.esprim.gestiondefoyer.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprim.gestiondefoyer.entity.Universite;
import tn.esprim.gestiondefoyer.services.IUniversiteService;

import java.util.List;

@RestController
@RequestMapping("/universites")
public class UniversiteRestController {

    @Autowired
    private IUniversiteService universiteService;

    @PostMapping
    public ResponseEntity<Universite> ajouter(
            @RequestBody Universite universite) {
        return ResponseEntity.ok(universiteService.save(universite));
    }

    @GetMapping
    public ResponseEntity<List<Universite>> getAll() {
        return ResponseEntity.ok(universiteService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Universite> getById(@PathVariable Long id) {
        return universiteService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Universite> modifier(
            @PathVariable Long id,
            @RequestBody Universite universite) {
        try {
            return ResponseEntity.ok(
                    universiteService.update(id, universite)
            );
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimer(@PathVariable Long id) {
        if (universiteService.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        universiteService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}