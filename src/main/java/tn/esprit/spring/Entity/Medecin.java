package tn.esprit.spring.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@ToString
@Data
@Getter
@Setter
public class Medecin implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idMedcin;
    private String nomMedcin;
    private int telephone;
    private int prixConsultation;
    @Enumerated(EnumType.STRING)
    private Specialite specialite;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "medecin")
    @JsonIgnore
    private List<RendezVous> rendezVouslist;
    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "medecins")
    @JsonIgnore
    private List <Clinique> cliniques;
}
