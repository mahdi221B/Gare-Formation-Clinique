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
public class Apprenant implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idApprenant;
    private String nom;
    private String prenom;
    private int telephone;
    private String email;
    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "apprenantList")
    @JsonIgnore
    private List<Formation> formationList;

}
