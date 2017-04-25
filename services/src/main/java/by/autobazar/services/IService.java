package by.autobazar.services;

import java.io.Serializable;

/**
 * This is base interface of all Services, which defines common methods for all Services(CRUID methods)
 *
 * @param <T>Class should be Entity
 */
public interface IService<T> {
    /**
     * This method defines actions before saving or updating Entity
     * and then call appropriate dao method
     *
     * @param entity Entity for saving or updating
     */
    void saveOrUpdate(T entity);

    /**
     * This method defines actions before getting entity from database
     * and then call appropriate dao method
     *
     * @param id Serializable Entity id
     * @return Object of Entity class or its child
     */
    T get(Serializable id);

    /**
     * This method defines actions before deleting Entity from database
     * and then call appropriate dao method
     *
     * @param entity Entity object, which should be deleted
     */
    void delete(T entity);
}