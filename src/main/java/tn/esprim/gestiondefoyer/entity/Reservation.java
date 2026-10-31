package tn.esprim.gestiondefoyer.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String idReservation;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date anneeUniversitaire;
    private boolean estValise;

    @ManyToMany(mappedBy = "reservations")
    private List<Etudiant> etudiants;
}
