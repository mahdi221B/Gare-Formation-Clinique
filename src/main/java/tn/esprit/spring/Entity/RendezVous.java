package tn.esprit.spring.Entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@ToString
@Data
@Getter
@Setter
public class RendezVous implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idRDV;
    @Temporal(TemporalType.DATE)
    private Date dateRDV;
    private String remarque;
    @ManyToOne
    private Patient patient;
    @ManyToOne
    private Medecin medecin;

}
