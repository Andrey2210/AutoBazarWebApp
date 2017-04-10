package by.autobazar.dao;

import by.autobazar.dao.exceptions.DaoException;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

/**
 * Created by Andrey
 * Date: 29.03.2017.
 * Time: 1:40
 */

public abstract class BaseDao<T> implements Dao<T> {

    private static Logger log = Logger.getLogger(BaseDao.class);
    public Session session = null;

    public BaseDao() {}

    @Override
    public void saveOrUpdate(T t) throws DaoException {
        try {
            log.info("saveOrUpdate(t):" + t);
            session.saveOrUpdate(t);
        } catch (HibernateException e) {
            log.error("Error save or update" + getPersistentClass() + " in Dao" + e);
            throw new DaoException(e);
        }

    }

    @Override
    public T get(Serializable id) throws DaoException {
        log.info("Get class by id:" + id);
        T t = null;
        try {
            t = (T) session.get(getPersistentClass(), id);
            log.info("get class:" + t);
        } catch (HibernateException e) {
            log.error("Error get " + getPersistentClass() + " in Dao" + e);
            throw new DaoException(e);
        }
        return t;
    }

    @Override
    public T load(Serializable id) throws DaoException {
        log.info("Load class by id:" + id);
        T t = null;
        try {
            t = (T) session.load(getPersistentClass(), id);
            log.info("load() class:" + t);
            session.isDirty();
        } catch (HibernateException e) {
            log.error("Error load() " + getPersistentClass() + " in Dao" + e);
            throw new DaoException(e);
        }
        return t;
    }

    @Override
    public void delete(T t) throws DaoException {
        try {
            session.delete(t);
            log.info("Delete:" + t);
        } catch (HibernateException e) {
            log.error("Error delete in Dao" + e);
            throw new DaoException(e);
        }
    }

    private Class getPersistentClass() {
        return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }
}
