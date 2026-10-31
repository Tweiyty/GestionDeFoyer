package tn.esprim.gestiondefoyer.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprim.gestiondefoyer.entity.Chambre;
import tn.esprim.gestiondefoyer.repository.ChambreRepository;
import tn.esprim.gestiondefoyer.services.IChambreService;

import java.util.List;
import java.util.Optional;

@Service
public class ChambreServiceImpl implements IChambreService {

    @Autowired
    private ChambreRepository chambreRepository;

    @Override
    public Chambre save(Chambre chambre) {
        return chambreRepository.save(chambre);
    }

    @Override
    public List<Chambre> findAll() {
        return chambreRepository.findAll();
    }

    @Override
    public Optional<Chambre> findById(Long id) {
        return chambreRepository.findById(id);
    }

    @Override
    public Chambre update(Chambre chambre) {
        return chambreRepository.save(chambre);
    }

    @Override
    public Chambre update(Long id, Chambre chambre) {
        return chambreRepository.findById(id).map(existing -> {
            existing.setNumeroChambre(chambre.getNumeroChambre());
            existing.setTypeC(chambre.getTypeC());
            existing.setBloc(chambre.getBloc());
            return chambreRepository.save(existing);
        }).orElseThrow(() ->
                new RuntimeException("Chambre introuvable : " + id)
        );
    }

    @Override
    public void deleteById(Long id) {
        chambreRepository.deleteById(id);
    }
}