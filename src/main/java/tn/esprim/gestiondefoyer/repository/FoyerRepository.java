package tn.esprim.gestiondefoyer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprim.gestiondefoyer.entity.Foyer;

public interface FoyerRepository
        extends JpaRepository<Foyer, Long> {
}