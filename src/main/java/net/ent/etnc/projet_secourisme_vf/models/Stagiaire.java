package net.ent.etnc.projet_secourisme_vf.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import net.ent.etnc.projet_secourisme_vf.models.commons.AbstractPersistableWithIdSetter;
import net.ent.etnc.projet_secourisme_vf.models.references.Civilite;

import java.time.LocalDate;
import java.util.Set;

@Entity
@NoArgsConstructor
@ToString(callSuper = true, of = {"numeroIdentifiantDefense", "nom", "prenom", "dateDeNaissance", "villeDeNaissance", "civilite"})
@EqualsAndHashCode(callSuper = false, of = {"numeroIdentifiantDefense"})
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "stagiaire", uniqueConstraints = @UniqueConstraint(name = "uk__stagiaire__numero_identifiant_defense", columnNames = {"numero_identifiant_defense"}))
public class Stagiaire extends AbstractPersistableWithIdSetter<Long> {

    @Getter
    @Setter
    @Pattern(regexp = "^\\d{10}$")
    @Column(name = "numero_identifiant_defense", nullable = false, length = 10)
    private String numeroIdentifiantDefense;

    @Getter
    @Setter
    @NotNull
    @NotBlank
    @Size(max = 50)
    @Column(name = "nom", nullable = false, length = 50)
    private String nom;

    @Getter
    @Setter
    @NotNull
    @NotBlank
    @Size(max = 50)
    @Column(name = "prenom", nullable = false, length = 50)
    private String prenom;


    @Getter
    @Setter
    @NotNull
    @Past
    @Column(name = "date_de_naissance", nullable = false)
    private LocalDate dateDeNaissance;

    @Getter
    @Setter
    @NotNull
    @NotBlank
    @Size(max = 85) // -> Car le nom de la ville la plus longue dans le monde est de 85 caractères
    @Column(name = "ville_de_naissance", nullable = false, length = 85)
    private String villeDeNaissance;

    @Getter
    @Setter
    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "civilite", nullable = false, length = 10)
    private Civilite civilite;

    @Getter
    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "stagiaire_aptitude",
            joinColumns = @JoinColumn(name = "stagiaire_id", foreignKey = @ForeignKey(name = "stagiaire__aptitude__stagiaire_id__FK")),
            inverseJoinColumns = @JoinColumn(name = "aptitude_id", foreignKey = @ForeignKey(name = "stagiaire__aptitude__aptitude_id__FK")))
    private Set<Aptitude> aptitudes;

    @Getter
    @Setter
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "unite_id", foreignKey = @ForeignKey(name = "stagiaire__unite_id__FK"))
    private Unite unite;
}
