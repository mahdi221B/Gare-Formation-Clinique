package tn.esprit.spring.services;

import tn.esprit.spring.Entity.Formation;

public interface IFormationService {
    public void ajouterFormation (Formation formation, Long idFormateur);
    public void affecterApprenantFormation (Long idApprenant, Long idFormation);
    public int  getRevenuByFormation(Long idFormation);
    public void  getNbrApprenantByFormation ();
}
