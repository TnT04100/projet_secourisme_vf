package net.ent.etnc.projet_secourisme_vf.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import net.ent.etnc.projet_secourisme_vf.models.commons.AbstractPersistableWithIdSetter;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = false, of = {"chemin"})
@Table(name = "document", uniqueConstraints = @UniqueConstraint(columnNames = {"chemin"}, name = "UK_document_chemin"))
public class Document extends AbstractPersistableWithIdSetter<Long> {

    @Getter
    @Setter
    @NotNull
    @NotBlank
    @Size(min = 1, max = 50)
    @Column(name = "nom", length = 50, nullable = false)
    private String nom;

    @Getter
    @Setter
    @NotNull
    @NotBlank
    @Size(min = 1, max = 255)
    @Column(name = "chemin", length = 255, nullable = false)
    private String chemin;

    @Getter
    @Setter
    @Column(name = "date_import", nullable = false)
    private LocalDate dateImport;

    @PrePersist
    public void prePersist() {
        if (dateImport == null) {
            dateImport = LocalDate.now();
        }
    }

}
