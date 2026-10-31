package tn.esprim.gestiondefoyer.services;

import tn.esprim.gestiondefoyer.entity.Universite;
import java.util.List;
import java.util.Optional;

public interface IUniversiteService {
    Universite save(Universite universite);
    List<Universite> findAll();
    Optional<Universite> findById(Long id);
    Universite update(Long id, Universite universite);
    void deleteById(Long id);
}