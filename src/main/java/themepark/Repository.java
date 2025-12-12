package themepark;

import java.util.Collection;
import java.util.Optional;

public interface Repository<ID, T> {
    T save(T entity);
    Optional<T> findById(ID id);
    Collection<T> findAll();
    void delete(ID id);
}

