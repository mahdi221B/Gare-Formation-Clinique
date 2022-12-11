package tn.esprit.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.Entity.Formateur;
import tn.esprit.spring.Entity.Formation;
import tn.esprit.spring.repositories.FormateurRepository;
import tn.esprit.spring.repositories.FormationRepository;

import java.util.Date;
import java.util.List;

@Service
public class FormateurServiceImp implements IFormateurService{

    @Autowired
    FormateurRepository formateurRepository;
    @Autowired
    FormationRepository formationRepository;

    @Override
    public void ajouterFormateur(Formateur formateur) {
        formateurRepository.save(formateur);
    }

    @Override
    public float getFormateurRemunerationByDate(Long idFormateur, Date dateDebut, Date dateFin) {
        Formateur formateur = formateurRepository.findById(idFormateur).get();
        List<Formation> liste1 = formationRepository.findByFormateurIdFormateurAndDateDebutAfterAndDateFinBefore(idFormateur,dateDebut,dateFin);
        int nbHeureTotal = 0;
        for (int i=0 ; i< liste1.size();i++) {
            nbHeureTotal = nbHeureTotal + liste1.get(i).getNbrHeures();
        }
        System.out.println(nbHeureTotal);
        return nbHeureTotal*formateur.getTarifHoraire();
    }
}
