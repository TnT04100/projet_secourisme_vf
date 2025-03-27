package net.ent.etnc.projet_secourisme_vf.controllers.commons;


import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import net.ent.etnc.projet_secourisme_vf.payload.commons.Assembler;
import net.ent.etnc.projet_secourisme_vf.payload.commons.Representation;
import net.ent.etnc.projet_secourisme_vf.service.base.ServiceGenerique;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@Slf4j
@CrossOrigin(origins = "*")
@RestController
public abstract class GenericController<T, ID, R extends Representation<ID>, S extends ServiceGenerique<T, ?, ID>, A extends Assembler<T, R>> {

    @Getter
    @Setter
    protected S service;
    @Getter
    @Setter
    protected A assembler;

    @GetMapping("/")
    public ResponseEntity<Collection<R>> getAll() {
        try {
            return ResponseEntity.ok(assembler.toRepresentation(service.findAll()));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/{id}/")
    public ResponseEntity<R> getById(@PathVariable("id") ID id) {
        try {
            T entity = service.findById(id).orElse(null);
            if (entity == null) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(assembler.toRepresentation(entity));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping("/")
    public ResponseEntity<R> create(@RequestBody R representation) {
        log.info("Création - données reçues: {}", representation);
        try {
            T entity = assembler.toModel(representation);
            entity = service.save(entity);
            return ResponseEntity.ok(assembler.toRepresentation(entity));
        } catch (Exception e) {
            log.error("Erreur lors de la suppression de la formation", e);
            return ResponseEntity.internalServerError().build();
        }
    }

    @DeleteMapping("/{id}/")
    public ResponseEntity<R> delete(@PathVariable("id") ID id) {
        try {
            T entity = service.findById(id).orElse(null);
            if (entity == null) {
                return ResponseEntity.notFound().build();
            }
            service.delete(entity);
            return ResponseEntity.ok(assembler.toRepresentation(entity));
        } catch (Exception e) {
            log.error("Erreur lors de la création de la formation", e);
            return ResponseEntity.internalServerError().build();
        }
    }

    @PutMapping("/{id}/")
    public ResponseEntity<R> update(@PathVariable("id") ID id, @RequestBody R representation) {
        log.info("Mise à jour de l'ID {} - données reçues: {}", id, representation);
        try {
            Optional<T> dinoOptional = service.findById(id);
            if (dinoOptional.isEmpty()) {
                return ResponseEntity.notFound().build();
            }
            if (representation.getId() == null || !representation.getId().equals(id)) {
                return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
            }
            T entity = service.save(assembler.toModel(representation));
            return ResponseEntity.ok(assembler.toRepresentation(entity));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

}
