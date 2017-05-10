package by.autobazar.dao.daoImp;


import by.autobazar.dao.Dao;
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
public class BaseDao<T> implements Dao<T> {

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
        getSession().saveOrUpdate(t);
    }

    @Override
    public T load(Class<T> clazz, Serializable id) {
        return (T) getSession().load(clazz, id);
    }

    @Override
    public void delete(T t) {
        getSession().delete(t);

    }
}
