package tn.esprit.spring.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.Entity.Clinique;
import tn.esprit.spring.Entity.Formateur;
import tn.esprit.spring.services.ICliniqueService;
import tn.esprit.spring.services.IFormateurService;

import java.util.Date;

@Slf4j
@RestController
@RequestMapping("/Formateur")
public class FormateurController {
    @Autowired
    IFormateurService iFormateurService;
    @PostMapping("/addFormateur")
    @ResponseBody
    public void addFormateur (@RequestBody Formateur formateur){
        iFormateurService.ajouterFormateur(formateur);
    }

    //chaq 2sec!
   /* @Scheduled(fixedRate = 2000 )
    public void fixedRateMethod(){
        log.info("Hello there!");
    }*/
    @GetMapping(value = "/getFormateurRemunerationByDate/{idFormateur}/{dateDebut}/{dateFin}")
    @ResponseBody
    public float getFormateurRemunerationByDate(@PathVariable("idFormateur") long idFormateur ,  @PathVariable("dateDebut") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateDebut ,  @PathVariable("dateFin") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateFin) {
        return iFormateurService.getFormateurRemunerationByDate(idFormateur ,dateDebut ,dateFin);
    }

}
