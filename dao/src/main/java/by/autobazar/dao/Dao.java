package by.autobazar.dao;

import by.autobazar.dao.exceptions.DaoException;
import java.io.Serializable;

/**
 * This is base interface of Data Access Object class, which defines common behavior of all Dao classes
 *
 * @param <T>
 */
interface Dao<T> {
    /**
     * This method save or update entity in database
     * @param t Entity for saving or updating
     * @throws DaoException
     */
    void saveOrUpdate(T t) throws DaoException;

    /**
     * This method gets entity from database
     *
     * @param id    Serializable Entity id
     * @return Object of Entity class
     */
    T get(Serializable id) throws  DaoException;

    /**
     * This method loads entity from database
     *
     * @param id    Serializable Entity id
     * @return Object of Entity class
     */
    T load(Serializable id) throws DaoException;

    /**
     * This method delete entity from database
     *
     * @param t Entity object, which should be deleted
     */
    void delete(T t) throws DaoException;
}

