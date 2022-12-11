package tn.esprit.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.Entity.Clinique;

@Repository
public interface CliniqueRepository extends JpaRepository<Clinique, Long> {
}
