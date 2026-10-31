package tn.esprim.gestiondefoyer.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprim.gestiondefoyer.entity.Bloc;
import tn.esprim.gestiondefoyer.services.IBlocService;

import java.util.List;

@RestController
@RequestMapping("/blocs")
public class BlocRestController {

    @Autowired
    private IBlocService blocService;

    @PostMapping
    public ResponseEntity<Bloc> ajouter(@RequestBody Bloc bloc) {
        return ResponseEntity.ok(blocService.save(bloc));
    }

    @GetMapping
    public ResponseEntity<List<Bloc>> getAll() {
        return ResponseEntity.ok(blocService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bloc> getById(@PathVariable Long id) {
        return blocService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Bloc> modifier(
            @PathVariable Long id,
            @RequestBody Bloc bloc) {
        try {
            return ResponseEntity.ok(blocService.update(id, bloc));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimer(@PathVariable Long id) {
        if (blocService.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        blocService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}