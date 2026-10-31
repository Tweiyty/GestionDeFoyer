package tn.esprim.gestiondefoyer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprim.gestiondefoyer.entity.Reservation;

public interface ReservationRepository
        extends JpaRepository<Reservation, Long> {
}