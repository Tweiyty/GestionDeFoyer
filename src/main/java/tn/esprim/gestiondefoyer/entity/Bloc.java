package tn.esprim.gestiondefoyer.entity;

import jakarta.persistence.*;
import lombok.*;
import jakarta.persistence.ManyToOne;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Bloc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBloc;
    private String nomBloc;
    private Long capaciteBloc;

    @ManyToOne
    private Foyer foyer;
    @OneToMany(mappedBy = "bloc")
    private List<Chambre> chambres;
}
