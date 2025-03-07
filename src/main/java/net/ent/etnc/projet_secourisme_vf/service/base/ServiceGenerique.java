package net.ent.etnc.projet_secourisme_vf.service.base;


import net.ent.etnc.projet_secourisme_vf.service.exceptions.ServiceException;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface ServiceGenerique<T, R, ID> {
    void delete(T entity) throws ServiceException;

    void deleteById(ID id) throws ServiceException;

    List<T> findAll() throws ServiceException;

    Page<T> findAll(int numPage, int nbLignes) throws ServiceException;

    T save(T entity) throws ServiceException;

    T saveAndFlush(T entity) throws ServiceException;

    Optional<T> findById(ID id) throws ServiceException;

    long count() throws ServiceException;

    R getRepository();
}
