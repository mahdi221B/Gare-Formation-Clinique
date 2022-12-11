package tn.esprit.spring.services;

import tn.esprit.spring.Entity.Train;

import java.util.List;

public interface ITrainService {
    public Long ajouter_train (Train t);

    public void affecterTrainAGare(Long idTrain, Long idGareDepart, Long idGareArrivee);
    public void affecterTainAClient(Long idClient, Long idGareDepart);
    public int TrainPlacesLibres(Long idGareDepart);
    public List<Train> ListerTrainsIndirects(Long idGareDepart, Long idGareArrivee);
    public void DesaffecterClientsTrain(Long idGareDepart,double heureDepart);
}
