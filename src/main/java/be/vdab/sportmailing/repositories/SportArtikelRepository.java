package be.vdab.sportmailing.repositories;

import be.vdab.sportmailing.domain.Sporter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SportArtikelRepository extends JpaRepository<Sporter, Long> {
}
