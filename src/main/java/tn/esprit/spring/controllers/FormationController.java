package tn.esprit.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.Entity.Formation;
import tn.esprit.spring.Entity.RendezVous;
import tn.esprit.spring.Entity.Specialite;
import tn.esprit.spring.services.IFormationService;
import tn.esprit.spring.services.IRDVService;

import java.util.List;

@RestController
@RequestMapping("/Formation")
public class FormationController {
    @Autowired
    IFormationService iFormationService;
    @PutMapping("/ajouterFormation/{idFormateur}")
    public void ajouterFormation (@RequestBody Formation formation, @PathVariable("idFormateur") Long idFormateur){
        iFormationService.ajouterFormation(formation,idFormateur);
    }

    @PutMapping("/affecterApprenantFormation/{idApprenant}/{idFormation}")
    public void affecterApprenantFormation (@PathVariable("idApprenant") Long idApprenant , @PathVariable("idFormation") Long idFormation) {
        iFormationService.affecterApprenantFormation(idApprenant, idFormation);
    }

    @GetMapping("/Reven/{idFormation}")
    @ResponseBody
    public int getRevenuByFormation (@PathVariable("idFormation") Long idFormation){
        return iFormationService.getRevenuByFormation(idFormation);
    }

    @GetMapping("/nbpart")
    @ResponseBody
    public void getNbrApprenantByFormation (){
        iFormationService.getNbrApprenantByFormation();
    }

}
