package by.autobazar.dao;

import by.autobazar.entity.Entity;

/**
 * Created by Andrey on 15.03.2017.
 */
public interface Dao<T extends Entity> {
    void add(T t);

    void update(T t);

    T get(T t, long id);

     void delete(T t);

}
