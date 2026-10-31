package tn.esprim.gestiondefoyer.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprim.gestiondefoyer.entity.Foyer;
import tn.esprim.gestiondefoyer.services.IFoyerService;

import java.util.List;

@RestController
@RequestMapping("/foyers")
public class FoyerRestController {

    @Autowired
    private IFoyerService foyerService;

    @PostMapping
    public ResponseEntity<Foyer> ajouter(@RequestBody Foyer foyer) {
        return ResponseEntity.ok(foyerService.save(foyer));
    }

    @GetMapping
    public ResponseEntity<List<Foyer>> getAll() {
        return ResponseEntity.ok(foyerService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Foyer> getById(@PathVariable Long id) {
        return foyerService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Foyer> modifier(
            @PathVariable Long id,
            @RequestBody Foyer foyer) {
        try {
            return ResponseEntity.ok(foyerService.update(id, foyer));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimer(@PathVariable Long id) {
        if (foyerService.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        foyerService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}