package themepark;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryRepository<ID, T> implements Repository<ID, T> {
    protected final Map<ID, T> map = new ConcurrentHashMap<>();
    private final java.util.function.Function<T, ID> idExtractor;

    public InMemoryRepository(java.util.function.Function<T, ID> idExtractor) {
        this.idExtractor = idExtractor;
    }

    @Override
    public T save(T entity) {
        ID id = idExtractor.apply(entity);
        map.put(id, entity);
        return entity;
    }

    @Override
    public Optional<T> findById(ID id) { return Optional.ofNullable(map.get(id)); }

    @Override
    public Collection<T> findAll() { return Collections.unmodifiableCollection(map.values()); }

    @Override
    public void delete(ID id) { map.remove(id); }
}

