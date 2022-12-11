package tn.esprit.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.Entity.Client;
import tn.esprit.spring.Entity.Gare;
import tn.esprit.spring.services.IClientService;
import tn.esprit.spring.services.IGareService;

@RestController
@RequestMapping("/Client")
public class ClientController {
    @Autowired
    IClientService iClientService;

    @PostMapping("/addClient")
    @ResponseBody
    public void addClient (@RequestBody Client client){
        iClientService.ajouterClient(client);
    }
}
