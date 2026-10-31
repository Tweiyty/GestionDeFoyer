package tn.esprim.gestiondefoyer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprim.gestiondefoyer.entity.Universite;

public interface UniversiteRepository
        extends JpaRepository<Universite, Long> {
}