package tn.esprit.spring.services;

import tn.esprit.spring.Entity.Formateur;

import java.util.Date;

public interface IFormateurService {
    public void ajouterFormateur(Formateur formateur);
    public float  getFormateurRemunerationByDate(Long idFormateur, Date dateDebut, Date dateFin);
}
