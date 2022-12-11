package tn.esprit.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.Entity.Train;
import tn.esprit.spring.services.ITrainService;

import java.util.List;

@RestController
@RequestMapping("/Train")
public class TrainController {
    @Autowired
    ITrainService iTrainService;

    @PostMapping("/addTrain")
    @ResponseBody
    public void addTrain (@RequestBody Train train){
        iTrainService.ajouter_train(train);
    }

    @PutMapping("/affectTrain/{idTrain}/{idGareDepart}/{idGareArrivee}")
    public void affectTrain (@PathVariable("idTrain") Long idTrain , @PathVariable("idGareDepart") Long idGareDepart,@PathVariable("idGareArrivee") Long idGareArrivee){
        iTrainService.affecterTrainAGare(idTrain,idGareDepart,idGareArrivee);
    }

    @PutMapping("/affectTrainClient/{idClient}/{idGareDepart}")
    public void affectTrainClient (@PathVariable("idClient") Long idClient , @PathVariable("idGareDepart") Long idGareDepart) {
        iTrainService.affecterTainAClient(idClient, idGareDepart);
    }

    @GetMapping("/getMoye/{idGareDepart}")
    @ResponseBody
    public int getMoye (@PathVariable("idGareDepart") Long idGareDepart) {
        return iTrainService.TrainPlacesLibres(idGareDepart);
    }

    @GetMapping("/indirect/{idGareDepart}/{idGareArrivee}")
    public List<Train> indirect (@PathVariable("idGareDepart") Long idGareDepart, @PathVariable("idGareArrivee") Long idGareArrivee){
        return iTrainService.ListerTrainsIndirects(idGareDepart,idGareArrivee);
    }

    @PutMapping("/desaffecter/{idGareDepart}/{heureDepart}")
    public void desaffecter (@PathVariable("idGareDepart") Long idGareDepart, @PathVariable("heureDepart") Double heureDepart){
        iTrainService.DesaffecterClientsTrain(idGareDepart,heureDepart);
    }
}
