package tn.esprit.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.Entity.Client;
import tn.esprit.spring.Entity.Clinique;
import tn.esprit.spring.Entity.Medecin;
import tn.esprit.spring.Entity.Train;
import tn.esprit.spring.services.IClientService;
import tn.esprit.spring.services.ICliniqueService;

@RestController
@RequestMapping("/Clinqiue")
public class CliniqueController {
    @Autowired
    ICliniqueService iCliniqueService;

    @PostMapping("/addClinique")
    @ResponseBody
    public void addClient (@RequestBody Clinique clinique){
        iCliniqueService.addClinique(clinique);
    }

    @PutMapping("/affectMedClinique/{cliniqueId}")
    public void affectTrainClient (@RequestBody Medecin medecin, @PathVariable("cliniqueId") Long cliniqueId) {
        iCliniqueService.addMedecinAndAssignToClinique(medecin, cliniqueId);
    }
}
