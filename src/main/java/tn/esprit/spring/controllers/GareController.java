package tn.esprit.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.Entity.Gare;
import tn.esprit.spring.services.IGareService;


@RestController
@RequestMapping("/Gare")
public class GareController{

        @Autowired
        IGareService iGareService;

        @PostMapping("/addGare")
        @ResponseBody
        public void addGare (@RequestBody Gare gare){
                iGareService.ajouter_gare(gare);
        }

}
