package tn.esprim.gestiondefoyer.services;

import tn.esprim.gestiondefoyer.entity.Etudiant;
import java.util.List;
import java.util.Optional;

public interface IEtudiantService {
    Etudiant save(Etudiant etudiant);
    List<Etudiant> findAll();
    Optional<Etudiant> findById(Long id);
    Etudiant update(Long id, Etudiant etudiant);
    void deleteById(Long id);
}