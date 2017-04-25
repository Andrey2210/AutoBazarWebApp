package by.autobazar.services;


import by.autobazar.dao.Dao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

@Transactional
@Service
public class BaseService<T> implements IService<T> {

    protected Dao<T> baseDao;

    protected BaseService(Dao<T> baseDao) {
        this.baseDao = baseDao;
    }

    @Override
    public void saveOrUpdate(T entity) {
        baseDao.saveOrUpdate(entity);
    }

    @Override
    public T get(Serializable id) {
        return (T) baseDao.load(getPersistentClass(), id);
    }

    @Override
    public void delete(T entity) {
        baseDao.delete(entity);
    }

    protected Class getPersistentClass() {
        return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }
}