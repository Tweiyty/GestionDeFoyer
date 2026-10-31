package tn.esprim.gestiondefoyer.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprim.gestiondefoyer.entity.Chambre;
import tn.esprim.gestiondefoyer.services.IChambreService;

import java.util.List;

@RestController
@RequestMapping("/chambres")
public class ChambreRestController {

    @Autowired
    private IChambreService chambreService;

    @PostMapping
    public ResponseEntity<Chambre> ajouter(@RequestBody Chambre chambre) {
        return ResponseEntity.ok(chambreService.save(chambre));
    }

    @GetMapping
    public ResponseEntity<List<Chambre>> getAll() {
        return ResponseEntity.ok(chambreService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Chambre> getById(@PathVariable Long id) {
        return chambreService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Chambre> modifier(
            @PathVariable Long id,
            @RequestBody Chambre chambre) {
        try {
            return ResponseEntity.ok(chambreService.update(id, chambre));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimer(@PathVariable Long id) {
        if (chambreService.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        chambreService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}