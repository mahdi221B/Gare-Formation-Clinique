package tn.esprit.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.Entity.Gare;
import tn.esprit.spring.repositories.GareRepository;

@Service
public class GareServiceImp implements IGareService{

    @Autowired
    GareRepository gareRepository;

    public Long ajouter_gare (Gare g) {
        gareRepository.save(g);
        return g.getIdGare();
    }
}
