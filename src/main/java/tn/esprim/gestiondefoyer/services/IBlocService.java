package tn.esprim.gestiondefoyer.services;

import tn.esprim.gestiondefoyer.entity.Bloc;
import java.util.List;
import java.util.Optional;

public interface IBlocService {
    Bloc save(Bloc bloc);
    List<Bloc> findAll();
    Optional<Bloc> findById(Long id);
    Bloc update(Long id, Bloc bloc);
    void deleteById(Long id);
}