package tn.esprim.gestiondefoyer.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprim.gestiondefoyer.entity.Reservation;
import tn.esprim.gestiondefoyer.repository.ReservationRepository;
import tn.esprim.gestiondefoyer.services.IReservationService;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationServiceImpl implements IReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Override
    public Reservation save(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public List<Reservation> findAll() {
        return reservationRepository.findAll();
    }

    @Override
    public Optional<Reservation> findById(Long id) {
        return reservationRepository.findById(id);
    }

    @Override
    public Reservation update(Long id, Reservation reservation) {
        return reservationRepository.findById(id).map(existing -> {
            existing.setAnneeUniversitaire(
                    reservation.getAnneeUniversitaire()
            );
            existing.setEstValise(reservation.isEstValise());
            return reservationRepository.save(existing);
        }).orElseThrow(() ->
                new RuntimeException("Reservation introuvable : " + id)
        );
    }

    @Override
    public void deleteById(Long id) {
        reservationRepository.deleteById(id);
    }
}