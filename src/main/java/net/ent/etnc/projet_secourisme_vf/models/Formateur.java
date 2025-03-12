package net.ent.etnc.projet_secourisme_vf.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.ToString;


@Entity
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
@Table(name = "formateur")
public class Formateur extends Stagiaire {

}
