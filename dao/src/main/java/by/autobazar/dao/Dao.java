package by.autobazar.dao;

import java.io.Serializable;

/**
 * This is base interface of Data Access Object class, which defines common behavior of all Dao classes
 *
 * @param <T>
 */
public interface Dao<T> {
    /**
     * This method save or update entity in database
     * @param t Entity for saving or updating
     */
    void saveOrUpdate(T t);

    /**
     * This method loads entity from database
     *
     * @param id    Serializable Entity id
     * @return Object of Entity class
     */
    T load(Class<T> clazz, Serializable id);

    /**
     * This method delete entity from database
     *
     * @param t Entity object, which should be deleted
     */
    void delete(T t);
}

