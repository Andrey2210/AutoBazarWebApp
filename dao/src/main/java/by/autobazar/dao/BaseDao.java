package by.autobazar.dao;


import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * This class is responsible for realizing common methods for all DAO (CRUID methods)
 *
 * @param <T> Class should be Entity
 */
@Repository
public abstract class BaseDao<T> implements Dao<T> {

    private static Logger log = Logger.getLogger(BaseDao.class);
    private SessionFactory sessionFactory;

    @Autowired
    protected BaseDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void saveOrUpdate(T t) {
        log.info("saveOrUpdate(t):" + t);
        getSession().saveOrUpdate(t);
    }

    @Override
    public T load(Class<T> clazz, Serializable id) {
        log.info("Load class by id:" + id);
        return (T) getSession().load(clazz, id);
    }

    @Override
    public void delete(T t) {
        log.info("saveOrUpdate(t):" + t);
        getSession().delete(t);

    }
}
