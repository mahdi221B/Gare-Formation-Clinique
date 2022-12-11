package tn.esprit.spring.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import tn.esprit.spring.Entity.*;
import tn.esprit.spring.repositories.CliniqueRepository;
import tn.esprit.spring.repositories.MedecinRepository;
import tn.esprit.spring.repositories.PatientRepository;
import tn.esprit.spring.repositories.RDVRepository;

import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class IRDVServiceImp implements IRDVService {
    @Autowired
    CliniqueRepository cliniqueRepository;
    @Autowired
    RDVRepository rdvRepository;
    @Autowired
    PatientRepository patientRepository;
    @Autowired
    MedecinRepository medecinRepository;

    @Override
    public void addRDVAndAssignMedAndPatient(RendezVous rdv, Long idMedecin, Long idPatient) {
        Medecin medecin= medecinRepository.findById(idMedecin).get();
        Patient patient= patientRepository.findById(idPatient).get();
        rdv.setPatient(patient);
        rdv.setMedecin(medecin);
        rdvRepository.save(rdv);
    }

    public int getNbrRendezVousMedecin(Long idMedecin) {
        Medecin medecin= medecinRepository.findById(idMedecin).get();
        return medecin.getRendezVouslist().size();
    }

    @Override
    public int getRevenuMedecin(Long idMedecin, Date startDate, Date endDate) {
        return 0;
    }

    public List<RendezVous> getRendezVousByCliniqueAndSpecialite(Long idClinique, Specialite specialite) {
        List<RendezVous> liste = rdvRepository.findByMedSpec(idClinique,specialite);
        return liste;
    }
    public List<RendezVous> retrieveRendezVous(){
        List<RendezVous> liste = rdvRepository.findbySupAct();
        return liste;
    }

}