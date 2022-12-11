package tn.esprit.spring.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.Entity.Client;
import tn.esprit.spring.Entity.Gare;
import tn.esprit.spring.Entity.Train;
import tn.esprit.spring.repositories.ClientRepository;
import tn.esprit.spring.repositories.GareRepository;
import tn.esprit.spring.repositories.TrainRepository;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class TrainServiceImp implements ITrainService{
    @Autowired
    TrainRepository trainRepository;
    @Autowired
    GareRepository gareRepository;
    @Autowired
    ClientRepository clientRepository;

    @Override
    public Long ajouter_train(Train t) {
        trainRepository.save(t);
        return t.getIdTrain();
    }
    public void affecterTrainAGare(Long idTrain, Long idGareDepart, Long idGareArrivee){
        Gare gareDepart = gareRepository.findById(idGareDepart).get();
        Gare gareArrivee = gareRepository.findById(idGareArrivee).get();
        Train train = trainRepository.findById(idTrain).get();
        train.setVaVers(gareArrivee);
        train.setVient(gareDepart);
        trainRepository.save(train);
    }

    public void affecterTainAClient(Long idClient, Long idGareDepart){
        Client client = clientRepository.findById(idClient).get();
        Gare gare = gareRepository.findById(idGareDepart).get();
        Train train = trainRepository.findByVientNom();
        System.out.println(train.getNbPlaceLibre());
        if(train.getNbPlaceLibre()>0){
            client.setT(train);
            clientRepository.save(client);
            log.info("Ajouté avec succée");
            train.setNbPlaceLibre(train.getNbPlaceLibre()-1);
            trainRepository.save(train);

        }else {
            log.info("Non dispo");
        }
    }

    public int TrainPlacesLibres(Long idGareDepart){
        Gare gare = gareRepository.findById(idGareDepart).get();
        int t = trainRepository.findMoy(gare.getNom());
        return t;
    }

    public List<Train> ListerTrainsIndirects(Long idGareDepart, Long idGareArrivee) {
        Gare garedepart = gareRepository.findById(idGareDepart).get();
        Gare garearrivee= gareRepository.findById(idGareArrivee).get();
        //list de tous les train qui va vers SAKIETE EZZIT
        List<Train> listetrainSE = trainRepository.trainindirectes(garearrivee.getNom());
        //list de tous les train qui vient de TUNIS
        List<Train> listetrainT = trainRepository.trainindirectes2(garedepart.getNom());
        return listetrainT.stream().filter(t -> listetrainSE.stream()
                        .anyMatch(e -> e.getVient().equals(t.getVaVers())))
                .collect(Collectors.toList());
    }

    public void DesaffecterClientsTrain(Long idGareDepart,double heureDepart){
        Gare gare = gareRepository.findById(idGareDepart).get();
        Train train = trainRepository.findByNomAndHeure(gare.getNom(),heureDepart);
        for (int i=0 ; i< train.getClientList().size();i++) {
            train.getClientList().get(i).setT(null);
        }
        train.setNbPlaceLibre(train.getClientList().size());
        train.getClientList().clear();
        trainRepository.save(train);
    }

}
