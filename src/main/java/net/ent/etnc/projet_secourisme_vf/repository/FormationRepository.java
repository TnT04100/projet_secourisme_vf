package net.ent.etnc.projet_secourisme_vf.repository;

import net.ent.etnc.projet_secourisme_vf.models.Formation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FormationRepository extends JpaRepository<Formation, Long> {


    @Query("SELECT COUNT(f) FROM Formation f JOIN f.formateurs formateur WHERE formateur.id = :formateurId")
    long countFormationsByFormateurId(@Param("formateurId") Long formateurId);


    @Query("SELECT COUNT(f) FROM Formation f JOIN f.stagiaires stagiaire WHERE stagiaire.id = :stagiaireId")
    long countFormationsByStagiaireId(@Param("stagiaireId") Long stagiaireId);


    @Query("SELECT COUNT(f) FROM Formation f WHERE f.dateFin < CURRENT_DATE")
    long countCompletedFormations();

    @Query("SELECT COUNT(f) FROM Formation f")
    long countTotalFormations();
}
