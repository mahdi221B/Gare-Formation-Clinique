package tn.esprit.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.Entity.Formation;
import tn.esprit.spring.Entity.RendezVous;
import tn.esprit.spring.Entity.Specialite;

import java.util.Date;
import java.util.List;

@Repository
public interface FormationRepository extends JpaRepository <Formation,Long>{
    public List<Formation> findByFormateurIdFormateurAndDateDebutAfterAndDateFinBefore(Long idFormateur, Date dateDebut,Date dateFin);
}
