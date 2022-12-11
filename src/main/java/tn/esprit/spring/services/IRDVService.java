package tn.esprit.spring.services;

import tn.esprit.spring.Entity.RendezVous;
import tn.esprit.spring.Entity.Specialite;

import java.util.Date;
import java.util.List;

public interface IRDVService {
    public void addRDVAndAssignMedAndPatient(RendezVous rdv, Long idMedecin, Long idPatient);
    public List<RendezVous> getRendezVousByCliniqueAndSpecialite(Long idClinique, Specialite specialite);
    public int getNbrRendezVousMedecin(Long idMedecin);
    public int getRevenuMedecin(Long idMedecin, Date startDate, Date endDate);
    public List<RendezVous> retrieveRendezVous();

}