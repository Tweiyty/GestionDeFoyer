package tn.esprim.gestiondefoyer.entity;

import jakarta.persistence.*;
import lombok.*;
import jakarta.persistence.OneToOne;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Universite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUniversite;
    private String nomUniversite;
    private String adresse;
    @OneToOne
    private Foyer foyer;

}
