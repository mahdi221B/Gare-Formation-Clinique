package tn.esprit.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.Entity.Train;

import java.util.List;

@Repository
public interface TrainRepository extends JpaRepository<Train, Long> {
    @Query("SELECT t FROM Train t WHERE t.Vient.nom = 'EZZAHRA LYCEE' AND t.heureDepart=7.45 AND t.vaVers.nom='RADES LYCEE'")
    Train findByVientNom();
    @Query("SELECT AVG(t.nbPlaceLibre) FROM Train t WHERE t.Vient.nom = :nom ")
    Integer findMoy(@Param("nom") String nom);
    @Query("SELECT T FROM Train T WHERE T.vaVers.nom =:nom")
    List<Train> trainindirectes(@Param("nom") String nom ) ;
    @Query("SELECT T FROM Train T WHERE T.Vient.nom =:nom")
    List<Train> trainindirectes2(@Param("nom") String nom ) ;

    @Query("SELECT t FROM Train t WHERE t.Vient.nom =:nom AND t.heureDepart= :heureDepart")
    Train findByNomAndHeure(@Param("nom") String nom ,@Param("heureDepart") Double heureDepart );
}