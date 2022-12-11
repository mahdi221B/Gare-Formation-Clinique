package tn.esprit.spring.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@ToString
@Data
@Getter
@Setter
public class Formateur implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idFormateur;
    private String nom;
    private String prenom;
    private float tarifHoraire;
    private String email;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "formateur")
    @JsonIgnore
    private List<Formation> formationList;


}
