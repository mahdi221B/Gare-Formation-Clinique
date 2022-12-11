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
public class Formation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idFormation;
    private String titre;
    @Enumerated(EnumType.STRING)
    private Niveau niveau;
    @Temporal(TemporalType.DATE)
    private Date dateDebut;
    @Temporal(TemporalType.DATE)
    private Date dateFin;
    private int nbrHeures;
    private int nbrMaxParticipant;
    private int frais;
    @ManyToOne
    private Formateur formateur;
    @ManyToMany(cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Apprenant> apprenantList;
}
