package tn.esprim.gestiondefoyer.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprim.gestiondefoyer.entity.Bloc;
import tn.esprim.gestiondefoyer.repository.BlocRepository;
import tn.esprim.gestiondefoyer.services.IBlocService;

import java.util.List;
import java.util.Optional;

@Service
public class BlocServiceImpl implements IBlocService {

    @Autowired
    private BlocRepository blocRepository;

    @Override
    public Bloc save(Bloc bloc) {
        return blocRepository.save(bloc);
    }

    @Override
    public List<Bloc> findAll() {
        return blocRepository.findAll();
    }

    @Override
    public Optional<Bloc> findById(Long id) {
        return blocRepository.findById(id);
    }

    @Override
    public Bloc update(Long id, Bloc bloc) {
        return blocRepository.findById(id).map(existing -> {
            existing.setNomBloc(bloc.getNomBloc());
            existing.setCapaciteBloc(bloc.getCapaciteBloc());
            existing.setFoyer(bloc.getFoyer());
            return blocRepository.save(existing);
        }).orElseThrow(() ->
                new RuntimeException("Bloc introuvable : " + id)
        );
    }

    @Override
    public void deleteById(Long id) {
        blocRepository.deleteById(id);
    }
}