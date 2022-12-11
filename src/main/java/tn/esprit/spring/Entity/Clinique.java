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
public class Clinique implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idClinique;
    private String nomClinique;
    private String adress;
    private int telephone;
    @ManyToMany(cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Medecin> medecins;
}