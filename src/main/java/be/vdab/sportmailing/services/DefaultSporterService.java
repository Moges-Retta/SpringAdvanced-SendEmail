package be.vdab.sportmailing.services;

import be.vdab.sportmailing.domain.Sporter;
import be.vdab.sportmailing.repositories.SportArtikelRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class DefaultSporterService implements SporterService{
    private final SportArtikelRepository repository;

    public DefaultSporterService(SportArtikelRepository repository) {
        this.repository = repository;
    }

     @Override
     @Transactional
    public List<Sporter> findAll() {
        return repository.findAll();
    }
}
