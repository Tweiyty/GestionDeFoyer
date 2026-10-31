package tn.esprim.gestiondefoyer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprim.gestiondefoyer.entity.Etudiant;

import java.util.Date;
import java.util.List;

public interface EtudiantRepository
        extends JpaRepository<Etudiant, Long> {

    List<Etudiant> findByDateNaissanceBetween(
            Date dateDebut,
            Date dateFin
    );
}