package tn.esprim.gestiondefoyer.services;

import tn.esprim.gestiondefoyer.entity.Foyer;
import java.util.List;
import java.util.Optional;

public interface IFoyerService {
    Foyer save(Foyer foyer);
    List<Foyer> findAll();
    Optional<Foyer> findById(Long id);
    Foyer update(Long id, Foyer foyer);
    void deleteById(Long id);
}