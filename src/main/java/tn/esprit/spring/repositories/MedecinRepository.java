package tn.esprit.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.Entity.Medecin;
 @Repository
public interface MedecinRepository extends JpaRepository<Medecin,Long> {
}
