
package tn.esprim.gestiondefoyer.services;

import tn.esprim.gestiondefoyer.entity.Chambre;

import java.util.List;
import java.util.Optional;

public interface IChambreService {

    Chambre save(Chambre chambre);

    List<Chambre> findAll();

    Optional<Chambre> findById(Long id);

    Chambre update(Chambre chambre);

    Chambre update(Long id, Chambre chambre);

    void deleteById(Long id);
}
