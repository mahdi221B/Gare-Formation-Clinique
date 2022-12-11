package tn.esprit.spring.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;



@Entity
@ToString
@Data
@Getter
@Setter
public class Train implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idTrain;
    @Enumerated(EnumType.STRING)
    private etatTrain etat;
    @Temporal(TemporalType.DATE)
    private Date dateDepart;
    @Temporal(TemporalType.DATE)
    private Date dateArivee;
    private double heureDepart;
    private double heureArivee;
    private int nbPlaceLibre;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "T")
    @JsonIgnore
    private List<Client> clientList;
    @ManyToOne
    private Gare vaVers;
    @ManyToOne
    private Gare Vient;

}
