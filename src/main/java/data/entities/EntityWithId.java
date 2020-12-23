package data.entities;

public interface EntityWithId<I> {

    void setId(I id);

    I getId();
}
