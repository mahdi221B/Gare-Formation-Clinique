package tn.esprit.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.Entity.Patient;
import tn.esprit.spring.repositories.PatientRepository;

@Service
public class IPatientServiceImp implements IPatientService{
    @Autowired
    PatientRepository patientRepository;

    public Patient addPatient(Patient patient) {
        return  patientRepository.save(patient);
    }
}
