package net.ent.etnc.projet_secourisme_vf.models.commons;

import org.springframework.data.jpa.domain.AbstractPersistable;

import java.io.Serializable;

public abstract class AbstractPersistableWithIdSetter<T extends Serializable> extends AbstractPersistable<T> {
    public void setId(T id) {
        super.setId(id);
    }
}
