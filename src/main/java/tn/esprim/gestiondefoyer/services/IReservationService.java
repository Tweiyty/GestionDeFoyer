package tn.esprim.gestiondefoyer.services;

import tn.esprim.gestiondefoyer.entity.Reservation;
import java.util.List;
import java.util.Optional;

public interface IReservationService {
    Reservation save(Reservation reservation);
    List<Reservation> findAll();
    Optional<Reservation> findById(Long id);
    Reservation update(Long id, Reservation reservation);
    void deleteById(Long id);
}