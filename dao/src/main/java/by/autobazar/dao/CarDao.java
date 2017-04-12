package by.autobazar.dao;


import by.autobazar.dao.exceptions.DaoException;
import by.autobazar.entity.Car;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 * This class contains special methods for working with the entity Car
 *
 */
public class CarDao extends BaseDao<Car> {
    private static Logger log = Logger.getLogger(CarDao.class);
    private static CarDao INSTANCE = null;

    private CarDao() {
    }

    public static CarDao getInstance() {
        if(INSTANCE == null) {
            synchronized(CarDao.class) {
                if(INSTANCE == null) {
                    INSTANCE = new CarDao();
                }
            }
        }

        return INSTANCE;
    }

    /**
     * This method load last added 4 cars
     *
     * @return List of object-typed Car
     * @throws DaoException
     */
    public List<Car> getLimitAmount() throws DaoException {
        log.info("getLimitAmount : ");
        List results = null;

        try {
            Query e = this.session.createQuery("FROM Car C WHERE  C.verified=true order by C.id desc ");
            e.setFirstResult(0);
            e.setMaxResults(4);
            results = e.list();
            log.info("getLimitAmount result list: " + results);
            return results;
        } catch (HibernateException e) {
            log.error("Error getLimitAmount() " + e);
            throw new DaoException(e);
        }
    }

    /**
     * This method load cars makes
     *
     * @return List of String
     * @throws DaoException
     */
    public List<String> getCarsMakes() throws DaoException {
        log.info("getCarsMakes : ");

        try {
            Query e = this.session.createQuery("SELECT DISTINCT mark FROM Car C WHERE  C.verified=true ORDER BY C.mark");
            List results = e.list();
            log.info("getCarsMakes result list: " + results);
            return results;
        } catch (HibernateException e) {
            log.error("Error getCarsMakes() " + e);
            throw new DaoException(e);
        }
    }

    /**
     * This method loads a list of models of a particular make
     *
     * @param make - Car make in String
     * @return List of string
     * @throws DaoException
     */
    public List<String> getCarsModels(String make) throws DaoException {
        log.info("getCarsModels : ");

        try {
            Query e = this.session.createQuery("SELECT DISTINCT C.model FROM Car C WHERE  C.verified=true AND C.mark=? ORDER BY C.model");
            e.setString(0, make);
            List results = e.list();
            log.info("getCarsModels result list: " + results);
            return results;
        } catch (HibernateException e) {
            log.error("Error getCarsModels() " + e);
            throw new DaoException(e);
        }
    }

    /**
     * This method load all cars makes
     *
     * @return List of String
     * @throws DaoException
     */
    public List<String> getAllCarsMakes() throws DaoException {
        log.info("getAllCarsMakes : ");

        try {
            SQLQuery e = this.session.createSQLQuery("SELECT make FROM T_MAKES ORDER BY make");
            List results = e.list();
            log.info("getAllCarsMakes result list: " + results);
            return results;
        } catch (HibernateException e) {
            log.error("Error getAllCarsMakes() " + e);
            throw new DaoException(e);
        }
    }

    /**
     * This method loads a list of models of a particular make
     *
     * @param make - Car make in String
     * @return List of string
     * @throws DaoException
     */
    public List<String> getAllCarsModels(String make) throws DaoException {
        log.info("getAllCarsModels : ");

        try {
            SQLQuery e = this.session.createSQLQuery("SELECT M.model FROM T_MODELS M INNER JOIN T_MAKES T ON M.make_id=T.id WHERE T.make=? ORDER BY M.model");
            e.setString(0, make);
            List results = e.list();
            log.info("getAllCarsModels result list: " + results);
            return results;
        } catch (HibernateException e) {
            log.error("Error getAllCarsModels() " + e);
            throw new DaoException(e);
        }
    }

    /**
     * This method search a Cars in the database according to the specified criteria
     * @param search MAP with key fields for searching
     * @param order String parameter accepting type of sorting
     * @param start  indicating the starting position in database
     * @param amount  Indicates the number of Cars that will be listed in the list from the start position
     * @return List of object-typed Car
     * @throws DaoException
     */
    public List<Car> searchCars(HashMap<String, Object> search, String order, int start, int amount) throws DaoException {
        log.info("searchCars : ");

        try {
            HashMap e = new HashMap(search);
            Criteria criteria = this.session.createCriteria(Car.class);
            criteria.add(Restrictions.between("price", Integer.valueOf(Integer.parseInt((String)e.remove("minPrice"))), Integer.valueOf(Integer.parseInt((String)e.remove("maxPrice")))));
            criteria.add(Restrictions.between("year", LocalDate.of(Integer.parseInt((String)e.remove("minYear")), 1, 1), LocalDate.of(Integer.parseInt((String)e.remove("maxYear")), 1, 1)));
            criteria.add(Restrictions.between("engineCapacity", Double.valueOf(Double.parseDouble((String)e.remove("minEngineCapacity"))), Double.valueOf(Double.parseDouble((String)e.remove("maxEngineCapacity")))));
            Iterator iterator = e.keySet().iterator();

            while(iterator.hasNext()) {
                String type = (String)iterator.next();
                criteria.add(Restrictions.eq(type, e.get(type)));
            }

            if(order.contains("desc")) {
                criteria.addOrder(Order.desc(order.replace(" desc", "")));
            } else {
                criteria.addOrder(Order.asc(order));
            }

            criteria.setFirstResult(start);
            criteria.setMaxResults(amount);
            List results = criteria.list();
            log.info("searchCars result list: " + results);
            return results;
        } catch (HibernateException var10) {
            log.error("Error searchCars() " + var10);
            throw new DaoException(var10);
        }
    }

    /**
     * This method search a number of Cars that match the search parameters
     * @param search Map with key fields for searching
     * @return Number of machines of long type
     * @throws DaoException
     */
    public long getAmountOfCars(HashMap<String, Object> search) throws DaoException {
        log.info("getAmountOfCars : ");

        try {
            HashMap e = new HashMap(search);
            Criteria criteria = this.session.createCriteria(Car.class);
            criteria.setProjection(Projections.count("id"));
            criteria.add(Restrictions.between("price", Integer.valueOf(Integer.parseInt((String)e.remove("minPrice"))), Integer.valueOf(Integer.parseInt((String)e.remove("maxPrice")))));
            criteria.add(Restrictions.between("year", LocalDate.of(Integer.parseInt((String)e.remove("minYear")), 1, 1), LocalDate.of(Integer.parseInt((String)e.remove("maxYear")), 1, 1)));
            criteria.add(Restrictions.between("engineCapacity", Double.valueOf(Double.parseDouble((String)e.remove("minEngineCapacity"))), Double.valueOf(Double.parseDouble((String)e.remove("maxEngineCapacity")))));
            Iterator iterator = e.keySet().iterator();

            while(iterator.hasNext()) {
                String type = (String)iterator.next();
                criteria.add(Restrictions.eq(type, e.get(type)));
            }

            List results = criteria.list();
            log.info("getAmountOfCars result list: " + results);
            return ((Long)results.get(0)).longValue();
        } catch (HibernateException e) {
            log.error("Error getAmountOfCars() " + e);
            throw new DaoException(e);
        }
    }

    /**
     * This method loads a specified number of Cars from the database
     *
     * @param order String parameter accepting type of sorting
     * @param start  indicating the starting position in database
     * @param amount  Indicates the number of Cars that will be listed in the list from the start position
     * @return List of object-typed Car
     * @throws DaoException
     */
    public List<Car> getAll(String order, int start, int amount) throws DaoException {
        log.info("getAll : ");

        try {
            Criteria e = this.session.createCriteria(Car.class);
            if(order.contains("desc")) {
                e.addOrder(Order.desc(order.replace("desc", "")));
            } else {
                e.addOrder(Order.asc(order));
            }

            e.setFirstResult(start);
            e.setMaxResults(amount);
            List results = e.list();
            log.info("getAll result list: " + results);
            return results;
        } catch (HibernateException e) {
            log.error("Error getAll() " + e);
            throw new DaoException(e);
        }
    }
}
