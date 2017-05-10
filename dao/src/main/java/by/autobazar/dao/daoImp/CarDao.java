package by.autobazar.dao.daoImp;


import by.autobazar.dao.ICarDao;
import by.autobazar.entity.Car;
import org.hibernate.*;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 * This class contains special methods for working with the entity Car
 */
@Repository
public class CarDao extends BaseDao<Car> implements ICarDao {

    @Autowired
    private CarDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public List<Car> getAll() {
        Query e = getSession().createQuery("FROM Car C WHERE  C.verified=true order by C.id desc ");
        return e.list();
    }

    public List<Car> getLimitAmount() {
        Query e = getSession().createQuery("FROM Car C WHERE  C.verified=true order by C.id desc ");
        e.setFirstResult(0);
        e.setMaxResults(4);
        return e.list();
    }

    public List<String> getCarsMakes() {
        Query e = getSession().createQuery("SELECT DISTINCT mark FROM Car C WHERE  C.verified=true ORDER BY C.mark");
        return e.list();
    }

    public List<String> getCarsModels(String make) {
        Query e = getSession().createQuery("SELECT DISTINCT C.model FROM Car C WHERE  C.verified=true AND C.mark=? ORDER BY C.model");
        e.setString(0, make);
        return e.list();

    }

    public List<String> getAllCarsMakes() {
        SQLQuery e = getSession().createSQLQuery("SELECT make FROM T_MAKES ORDER BY make");
        return e.list();

    }

    public List<String> getAllCarsModels(String make) {
        SQLQuery e = getSession().createSQLQuery("SELECT M.model FROM T_MODELS M INNER JOIN T_MAKES T ON M.make_id=T.id WHERE T.make=? ORDER BY M.model");
        e.setString(0, make);
        return e.list();
    }

    public List<Car> searchCars(HashMap<String, Object> search, String order, int start, int amount) {
        HashMap e = new HashMap(search);
        Criteria criteria = getSession().createCriteria(Car.class);
        criteria.add(Restrictions.between("price", Integer.valueOf(Integer.parseInt((String) e.remove("minPrice"))), Integer.valueOf(Integer.parseInt((String) e.remove("maxPrice")))));
        criteria.add(Restrictions.between("year", LocalDate.of(Integer.parseInt((String) e.remove("minYear")), 1, 1), LocalDate.of(Integer.parseInt((String) e.remove("maxYear")), 1, 1)));
        criteria.add(Restrictions.between("engineCapacity", Double.valueOf(Double.parseDouble((String) e.remove("minEngineCapacity"))), Double.valueOf(Double.parseDouble((String) e.remove("maxEngineCapacity")))));
        Iterator iterator = e.keySet().iterator();

        while (iterator.hasNext()) {
            String type = (String) iterator.next();
            criteria.add(Restrictions.eq(type, e.get(type)));
        }

        if (order.contains("desc")) {
            criteria.addOrder(Order.desc(order.replace(" desc", "")));
        } else {
            criteria.addOrder(Order.asc(order));
        }

        criteria.setFirstResult(start);
        criteria.setMaxResults(amount);
        return criteria.list();
    }

    public long getAmountOfCars(HashMap<String, Object> search) {
        HashMap e = new HashMap(search);
        Criteria criteria = getSession().createCriteria(Car.class);
        criteria.setProjection(Projections.count("id"));
        criteria.add(Restrictions.between("price", Integer.valueOf(Integer.parseInt((String) e.remove("minPrice"))), Integer.valueOf(Integer.parseInt((String) e.remove("maxPrice")))));
        criteria.add(Restrictions.between("year", LocalDate.of(Integer.parseInt((String) e.remove("minYear")), 1, 1), LocalDate.of(Integer.parseInt((String) e.remove("maxYear")), 1, 1)));
        criteria.add(Restrictions.between("engineCapacity", Double.valueOf(Double.parseDouble((String) e.remove("minEngineCapacity"))), Double.valueOf(Double.parseDouble((String) e.remove("maxEngineCapacity")))));
        Iterator iterator = e.keySet().iterator();

        while (iterator.hasNext()) {
            String type = (String) iterator.next();
            criteria.add(Restrictions.eq(type, e.get(type)));
        }
        return ((Long) criteria.list().get(0)).longValue();

    }

    public List<Car> getAll(String order, int start, int amount) {

        Criteria e = getSession().createCriteria(Car.class);
        if (order.contains("desc")) {
            e.addOrder(Order.desc(order.replace("desc", "")));
        } else {
            e.addOrder(Order.asc(order));
        }

        e.setFirstResult(start);
        e.setMaxResults(amount);
        return e.list();
    }
}
