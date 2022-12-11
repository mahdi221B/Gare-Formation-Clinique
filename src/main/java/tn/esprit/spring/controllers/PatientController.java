package tn.esprit.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.Entity.Clinique;
import tn.esprit.spring.Entity.Patient;
import tn.esprit.spring.services.ICliniqueService;
import tn.esprit.spring.services.IPatientServiceImp;

@RestController
@RequestMapping("/Patient")
public class PatientController {
    @Autowired
    IPatientServiceImp iPatientServiceImp;

    @PostMapping("/addPatient")
    @ResponseBody
    public void addPatient (@RequestBody Patient patient){
        iPatientServiceImp.addPatient(patient);
    }
}
