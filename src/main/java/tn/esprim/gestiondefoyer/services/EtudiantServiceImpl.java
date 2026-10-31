package tn.esprim.gestiondefoyer.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprim.gestiondefoyer.entity.Etudiant;
import tn.esprim.gestiondefoyer.repository.EtudiantRepository;
import tn.esprim.gestiondefoyer.services.IEtudiantService;

import java.util.List;
import java.util.Optional;

@Service
public class EtudiantServiceImpl implements IEtudiantService {

    @Autowired
    private EtudiantRepository etudiantRepository;

    @Override
    public Etudiant save(Etudiant etudiant) {
        return etudiantRepository.save(etudiant);
    }

    @Override
    public List<Etudiant> findAll() {
        return etudiantRepository.findAll();
    }

    @Override
    public Optional<Etudiant> findById(Long id) {
        return etudiantRepository.findById(id);
    }

    @Override
    public Etudiant update(Long id, Etudiant etudiant) {
        return etudiantRepository.findById(id).map(existing -> {
            existing.setNomEt(etudiant.getNomEt());
            existing.setPrenomEt(etudiant.getPrenomEt());
            existing.setCin(etudiant.getCin());
            existing.setEcole(etudiant.getEcole());
            existing.setDateNaissance(etudiant.getDateNaissance());
            return etudiantRepository.save(existing);
        }).orElseThrow(() ->
                new RuntimeException("Etudiant introuvable : " + id)
        );
    }

    @Override
    public void deleteById(Long id) {
        etudiantRepository.deleteById(id);
    }
}