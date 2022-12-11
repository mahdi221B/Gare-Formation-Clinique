package tn.esprit.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.Entity.Apprenant;
import tn.esprit.spring.repositories.ApprenantRepository;

@Service
public class ApprenantServiceImp implements IApprenantService{
    @Autowired
    ApprenantRepository apprenantRepository;

    @Override
    public void ajouterApprenant(Apprenant apprenant) {
        apprenantRepository.save(apprenant);
    }
}
