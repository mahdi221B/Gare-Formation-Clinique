package tn.esprit.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.Entity.Clinique;
import tn.esprit.spring.Entity.Gare;
import tn.esprit.spring.Entity.Medecin;
import tn.esprit.spring.repositories.CliniqueRepository;

@Service
public class CliniqueService implements ICliniqueService{
    @Autowired
    CliniqueRepository cliniqueRepository;

    public Clinique addClinique (Clinique clinique){
        return cliniqueRepository.save(clinique);
    }
    public Medecin addMedecinAndAssignToClinique (Medecin medecin, Long cliniqueId){
        Clinique clinique= cliniqueRepository.findById(cliniqueId).get();
        clinique.getMedecins().add(medecin);
        cliniqueRepository.save(clinique);
        return medecin;
    }


}
