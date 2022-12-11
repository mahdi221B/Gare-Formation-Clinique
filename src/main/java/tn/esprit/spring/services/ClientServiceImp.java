package tn.esprit.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.Entity.Client;
import tn.esprit.spring.Entity.Gare;
import tn.esprit.spring.Entity.Train;
import tn.esprit.spring.repositories.ClientRepository;
import tn.esprit.spring.repositories.GareRepository;
import tn.esprit.spring.repositories.TrainRepository;

@Service
public class ClientServiceImp  implements IClientService{
    @Autowired
    ClientRepository clientRepository;
    @Autowired
    TrainRepository trainRepository;

    public void ajouterClient (Client c) {
        clientRepository.save(c);
    }

}
