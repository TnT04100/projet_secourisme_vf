package net.ent.etnc.projet_secourisme_vf.payload.commons;

import java.util.Collection;

public interface Assembler<T, R> {
    R toRepresentation(T t);

    Collection<R> toRepresentation(Collection<T> ts);

    T toModel(R r) throws Exception;
}
