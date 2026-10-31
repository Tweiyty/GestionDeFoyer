package tn.esprim.gestiondefoyer.entity;

import jakarta.persistence.*;
import lombok.*;
import jakarta.persistence.ManyToOne;
import tn.esprim.gestiondefoyer.entity.Bloc;
import tn.esprim.gestiondefoyer.entity.Reservation;
import tn.esprim.gestiondefoyer.entity.TypeChambre;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Chambre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idChambre;

    private Long numeroChambre;

    @Enumerated(EnumType.STRING)
    private TypeChambre typeC;

    @ManyToOne
    private Bloc bloc;

    @OneToMany(mappedBy = "chambre")
    private List<Reservation> reservations;

}
