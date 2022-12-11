package tn.esprit.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.Entity.RendezVous;
import tn.esprit.spring.Entity.Specialite;
import tn.esprit.spring.Entity.Train;

import java.util.Date;
import java.util.List;

@Repository
public interface RDVRepository extends JpaRepository<RendezVous, Long> {
    @Query("SELECT r FROM RendezVous r"
            + " INNER JOIN r.medecin m"
            + " INNER JOIN Clinique c"
            + " ON c.idClinique = :idClinique"
            + " where m.specialite =:specialite")
    List<RendezVous> findByMedSpec(@Param("idClinique") Long idClinique,@Param("specialite") Specialite specialite);
    @Query("SELECT r FROM RendezVous r WHERE r.medecin.idMedcin = :idMedcin AND r.dateRDV between :startDate AND :endDate ")
    List<RendezVous> findByDte(@Param("idMedcin") Long idMedcin, @Param("startDate") Date startDate, @Param("endDate") Date endDate );

    @Query("SELECT r FROM RendezVous r where r.dateRDV > current_date")
    List<RendezVous> findbySupAct();

}