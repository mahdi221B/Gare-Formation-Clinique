package tn.esprit.spring.services;

import org.springframework.stereotype.Service;
import tn.esprit.spring.Entity.Clinique;
import tn.esprit.spring.Entity.Medecin;

@Service
public interface ICliniqueService {
    public Clinique addClinique (Clinique clinique);
    public Medecin addMedecinAndAssignToClinique (Medecin medecin, Long cliniqueId);
}
