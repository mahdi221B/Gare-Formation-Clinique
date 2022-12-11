package tn.esprit.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.Entity.Apprenant;
import tn.esprit.spring.Entity.Client;
import tn.esprit.spring.services.IApprenantService;

@RestController
@RequestMapping("/Apprenant")
public class ApprenantController {
    @Autowired
    IApprenantService iApprenantService;
    @PostMapping("/addApprenant")
    @ResponseBody
    public void addApprenant (@RequestBody Apprenant apprenant){
        iApprenantService.ajouterApprenant(apprenant);
    }
}
