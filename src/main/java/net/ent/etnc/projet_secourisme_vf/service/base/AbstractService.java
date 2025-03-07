package net.ent.etnc.projet_secourisme_vf.service.base;

import net.ent.etnc.projet_secourisme_vf.service.exceptions.ServiceException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public abstract class AbstractService<T, R extends JpaRepository<T, ID>, ID> implements ServiceGenerique<T, R, ID> {
    private final R repository;

    protected AbstractService(R repository) {
        this.repository = repository;
    }

    @Override
    public void delete(T entity) throws ServiceException {
        try {
            repository.delete(entity);
        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void deleteById(ID id) throws ServiceException {
        try {
            repository.deleteById(id);
        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<T> findAll() throws ServiceException {
        try {
            return repository.findAll();
        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public Page<T> findAll(int numPage, int nbLignes) throws ServiceException {
        try {
            Pageable pageable = PageRequest.of(numPage, nbLignes);
            return repository.findAll(pageable);
        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public T save(T entity) throws ServiceException {
        try {
            return repository.save(entity);
        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public T saveAndFlush(T entity) throws ServiceException {
        try {
            return repository.saveAndFlush(entity);
        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public Optional<T> findById(ID id) throws ServiceException {
        try {
            return repository.findById(id);
        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public long count() throws ServiceException {
        try {
            return repository.count();
        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public R getRepository() {
        return this.repository;
    }
}
