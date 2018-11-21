package persistence;

abstract class Repository<T> {
    abstract T getObject(T tmp);

    abstract void addObject(T tmp);

    abstract void removeObject(T tmp);

    abstract void updateObject(T tmp);
}