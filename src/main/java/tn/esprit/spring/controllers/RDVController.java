package tn.esprit.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.Entity.Client;
import tn.esprit.spring.Entity.RendezVous;
import tn.esprit.spring.Entity.Specialite;
import tn.esprit.spring.Entity.Train;
import tn.esprit.spring.services.IClientService;
import tn.esprit.spring.services.IRDVService;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/RDV")
public class RDVController {

    @Autowired
    IRDVService irdvService;

    @PutMapping("/affect/{idMedecin}/{idPatient}")
    public void affectTrain (@RequestBody RendezVous rdv, @PathVariable("idMedecin") Long idMedecin, @PathVariable("idPatient") Long idPatient){
        irdvService.addRDVAndAssignMedAndPatient(rdv,idMedecin,idPatient);
    }

    @GetMapping("/ListeRDV/{idClinique}/{specialite}")
    @ResponseBody
    public List<RendezVous> RdvBySpecAndMedcin (@PathVariable("idClinique") Long idClinique, @PathVariable("specialite") Specialite specialite){
        return irdvService.getRendezVousByCliniqueAndSpecialite(idClinique,specialite);
    }

    @GetMapping("/NbRDV/{idMedecin}")
    @ResponseBody
    public int indirect (@PathVariable("idMedecin") Long idMedecin){
        return irdvService.getNbrRendezVousMedecin(idMedecin);
    }

    @GetMapping("/retrieveRendezVous")
    @ResponseBody
    public List<RendezVous> retrieveRendezVous (){
        return irdvService.retrieveRendezVous();
    }

}
