package tn.esprim.gestiondefoyer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprim.gestiondefoyer.entity.Bloc;

public interface BlocRepository
        extends JpaRepository<Bloc, Long> {
}