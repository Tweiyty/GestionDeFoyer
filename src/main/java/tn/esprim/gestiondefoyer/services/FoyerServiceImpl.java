package tn.esprim.gestiondefoyer.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprim.gestiondefoyer.entity.Foyer;
import tn.esprim.gestiondefoyer.repository.FoyerRepository;
import tn.esprim.gestiondefoyer.services.IFoyerService;

import java.util.List;
import java.util.Optional;

@Service
public class FoyerServiceImpl implements IFoyerService {

    @Autowired
    private FoyerRepository foyerRepository;

    @Override
    public Foyer save(Foyer foyer) {
        return foyerRepository.save(foyer);
    }

    @Override
    public List<Foyer> findAll() {
        return foyerRepository.findAll();
    }

    @Override
    public Optional<Foyer> findById(Long id) {
        return foyerRepository.findById(id);
    }

    @Override
    public Foyer update(Long id, Foyer foyer) {
        return foyerRepository.findById(id).map(existing -> {
            existing.setNomFoyer(foyer.getNomFoyer());
            existing.setCapaciteFoyer(foyer.getCapaciteFoyer());
            return foyerRepository.save(existing);
        }).orElseThrow(() ->
                new RuntimeException("Foyer introuvable : " + id)
        );
    }

    @Override
    public void deleteById(Long id) {
        foyerRepository.deleteById(id);
    }
}