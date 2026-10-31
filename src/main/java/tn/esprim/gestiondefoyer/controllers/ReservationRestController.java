package tn.esprim.gestiondefoyer.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprim.gestiondefoyer.entity.Reservation;
import tn.esprim.gestiondefoyer.services.IReservationService;

import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservationRestController {

    @Autowired
    private IReservationService reservationService;

    @PostMapping
    public ResponseEntity<Reservation> ajouter(
            @RequestBody Reservation reservation) {
        return ResponseEntity.ok(reservationService.save(reservation));
    }

    @GetMapping
    public ResponseEntity<List<Reservation>> getAll() {
        return ResponseEntity.ok(reservationService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reservation> getById(@PathVariable Long id) {
        return reservationService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reservation> modifier(
            @PathVariable Long id,
            @RequestBody Reservation reservation) {
        try {
            return ResponseEntity.ok(
                    reservationService.update(id, reservation)
            );
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimer(@PathVariable Long id) {
        if (reservationService.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        reservationService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}