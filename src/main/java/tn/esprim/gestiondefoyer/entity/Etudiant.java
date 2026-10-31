package tn.esprim.gestiondefoyer.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import jakarta.persistence.ManyToMany;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Etudiant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEtudiant;
    private String nomEt;
    private String prenomEt;
    private Long cin;
    private String ecole;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dateNaissance;

    @ManyToMany
    private List<Reservation> reservations;
}
