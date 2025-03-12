package net.ent.etnc.projet_secourisme_vf.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import net.ent.etnc.projet_secourisme_vf.models.commons.AbstractPersistableWithIdSetter;

import java.time.LocalDate;
import java.util.Set;

@Entity
@NoArgsConstructor
@ToString(of = {"dateDebut", "dateFin", "libelleFormation", "salleFormation", "codeCours"}, callSuper = true)
@EqualsAndHashCode(callSuper = false, of = {"codeCours"})
@Table(name = "formation", uniqueConstraints = @UniqueConstraint(name = "uk__formation__code_cours", columnNames = {"code_cours"}))
public class Formation extends AbstractPersistableWithIdSetter<Long> {
    @Getter
    @Setter
    @NotNull
    @Future
    @Column(name = "date_debut", nullable = false)
    private LocalDate dateDebut;

    @Getter
    @Setter
    @NotNull
    @Future
    @Column(name = "date_fin", nullable = false)
    private LocalDate dateFin;

    @Getter
    @Setter
    @NotNull
    @NotBlank
    @Size(max = 50)
    @Column(name = "libelle_formation", nullable = false, length = 50)
    private String libelleFormation;

    @Getter
    @Setter
    @NotNull
    @NotBlank
    @Size(max = 15)
    @Column(name = "salle_formation", nullable = false, length = 15)
    private String salleFormation;

    @Getter
    @Setter
    @NotNull
    @NotBlank
    @Size(max = 10)
    @Column(name = "code_cours", nullable = false, length = 10)
    private String codeCours;

    @Getter
    @Setter
    @NotNull
    @ManyToOne
    @JoinColumn(name = "localisation_id", nullable = false)
    private Localisation localisation;

    @Getter
    @Setter
    @NotNull
    @ManyToOne
    @JoinColumn(name = "unite_enseignement_id", nullable = false)
    private UniteEnseignement uniteEnseignement;

    @Getter
    @ManyToMany
    @JoinTable(name = "formation_formateur",
            joinColumns = @JoinColumn(name = "formation_id"),
            inverseJoinColumns = @JoinColumn(name = "formateur_id"))
    private Set<Formateur> formateurs;

    @Getter
    @ManyToMany
    @JoinTable(name = "formation_stagiaire",
            joinColumns = @JoinColumn(name = "formation_id"),
            inverseJoinColumns = @JoinColumn(name = "stagiaire_id"))
    private Set<Stagiaire> stagiaires;
}
