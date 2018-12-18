package persistence;

public interface Repository<T> {
    T getObject(T tmp);

    void addObject(T tmp);

    void removeObject(T tmp);

    void updateObject(T tmp);
}