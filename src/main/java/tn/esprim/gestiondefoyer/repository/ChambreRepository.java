package tn.esprim.gestiondefoyer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprim.gestiondefoyer.entity.Chambre;

public interface ChambreRepository
        extends JpaRepository<Chambre, Long> {
}