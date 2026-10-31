package tn.esprim.gestiondefoyer.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprim.gestiondefoyer.entity.Etudiant;
import tn.esprim.gestiondefoyer.services.IEtudiantService;

import java.util.List;

@RestController
@RequestMapping("/etudiants")
public class EtudiantRestController {

    @Autowired
    private IEtudiantService etudiantService;

    @PostMapping
    public ResponseEntity<Etudiant> ajouter(@RequestBody Etudiant etudiant) {
        return ResponseEntity.ok(etudiantService.save(etudiant));
    }

    @GetMapping
    public ResponseEntity<List<Etudiant>> getAll() {
        return ResponseEntity.ok(etudiantService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Etudiant> getById(@PathVariable Long id) {
        return etudiantService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Etudiant> modifier(
            @PathVariable Long id,
            @RequestBody Etudiant etudiant) {
        try {
            return ResponseEntity.ok(etudiantService.update(id, etudiant));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimer(@PathVariable Long id) {
        if (etudiantService.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        etudiantService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}