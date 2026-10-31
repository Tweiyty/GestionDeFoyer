package tn.esprim.gestiondefoyer.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprim.gestiondefoyer.entity.Universite;
import tn.esprim.gestiondefoyer.repository.UniversiteRepository;
import tn.esprim.gestiondefoyer.services.IUniversiteService;

import java.util.List;
import java.util.Optional;

@Service
public class UniversiteServiceImpl implements IUniversiteService {

    @Autowired
    private UniversiteRepository universiteRepository;

    @Override
    public Universite save(Universite universite) {
        return universiteRepository.save(universite);
    }

    @Override
    public List<Universite> findAll() {
        return universiteRepository.findAll();
    }

    @Override
    public Optional<Universite> findById(Long id) {
        return universiteRepository.findById(id);
    }

    @Override
    public Universite update(Long id, Universite universite) {
        return universiteRepository.findById(id).map(existing -> {
            existing.setNomUniversite(universite.getNomUniversite());
            existing.setAdresse(universite.getAdresse());
            existing.setFoyer(universite.getFoyer());
            return universiteRepository.save(existing);
        }).orElseThrow(() ->
                new RuntimeException("Universite introuvable : " + id)
        );
    }

    @Override
    public void deleteById(Long id) {
        universiteRepository.deleteById(id);
    }
}