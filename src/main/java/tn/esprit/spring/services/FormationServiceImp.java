package tn.esprit.spring.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.spring.Entity.Apprenant;
import tn.esprit.spring.Entity.Formateur;
import tn.esprit.spring.Entity.Formation;
import tn.esprit.spring.Entity.Gare;
import tn.esprit.spring.repositories.ApprenantRepository;
import tn.esprit.spring.repositories.FormateurRepository;
import tn.esprit.spring.repositories.FormationRepository;

import java.util.List;
@EnableScheduling
@Slf4j
@Service
public class FormationServiceImp implements IFormationService{
    @Autowired
    FormationRepository formationRepository;
    @Autowired
    FormateurRepository formateurRepository;
    @Autowired
    ApprenantRepository apprenantRepository;


    public void ajouterFormation(Formation formation, Long idFormateur) {
        Formateur formateur = formateurRepository.findById(idFormateur).get();
        formation.setFormateur(formateur);
        formationRepository.save(formation);
    }

    public void affecterApprenantFormation(Long idApprenant, Long idFormation) {
        Formation formation = formationRepository.findById(idFormation).get();
        Apprenant apprenant = apprenantRepository.findById(idApprenant).get();
        if(formation.getNbrMaxParticipant()>0){
            apprenant.getFormationList().add(formation);
            formation.getApprenantList().add(apprenant);
            apprenantRepository.save(apprenant);
            formationRepository.save(formation);
            log.info("Ajouté avec succée");
            formation.setNbrMaxParticipant(formation.getNbrMaxParticipant()-1);
            formationRepository.save(formation);
        }else {
            log.info("Non dispo");
        }

    }

    @Override
    public int getRevenuByFormation(Long idFormation) {
        Formation formation = formationRepository.findById(idFormation).get();
        int frais = formation.getFrais();
        int particpant = formation.getApprenantList().size();
        return frais * particpant;
    }

   // @Scheduled(fixedRate = 50000 )
    public void getNbrApprenantByFormation() {
        List<Formation> formation = formationRepository.findAll();
        for (int i=0 ; i< formation.size();i++) {
            log.info(formation.get(i).getTitre());
            System.out.println(formation.get(i).getApprenantList().size());
        }
    }

}
