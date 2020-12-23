package logic;

import data.entities.EntityWithId;

import java.util.List;

public interface Service<I, T extends EntityWithId<I>> {

    T findById(I id);

    List<T> findAll();

    List<T> add(T type);

    default List<T> update(I id, T type) {
        if (findById(id) != null) {
            if (type.getId() == null)
                type.setId(id);
            add(type);
        }
        return findAll();
    }

    void deleteById(I id);
}
