package tn.esprit.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.Entity.Gare;
import tn.esprit.spring.Entity.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
}
