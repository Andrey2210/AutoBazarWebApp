package by.autobazar.services;

import by.autobazar.connection.DbConnection;
import by.autobazar.dao.CarDAO;
import by.autobazar.dao.DaoException;
import by.autobazar.entity.Car;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Andrey on 13.03.2017.
 */
public class CarService {

    private static final Logger log = Logger.getLogger(CarService.class);

    private static CarService INSTANCE = null;

    private CarService() {}

    public static CarService getInstance() {
        if (INSTANCE == null) {
            synchronized (CarService.class) {
                if (INSTANCE == null) {
                    INSTANCE = new CarService();
                }
            }
        }
        return INSTANCE;
    }

    public List<Car> getLimitAmount() {

        log.info("Service getLimitAmount(): ");

        Connection connection = DbConnection.getConnection();
        CarDAO carDAO = new CarDAO(connection);
        List<Car> carsList = null;
        try {
            carsList = carDAO.getLimitAmount();
        } catch (DaoException e) {
            log.error("Service getLimitAmount wasn't executed: " + e);
        }

        return carsList;
    }

    public List<String> getCarsMakes() {
        log.info("Service getCarsMakes(): ");

        Connection connection = DbConnection.getConnection();
        CarDAO carDAO = new CarDAO(connection);
        List<String> makesList = null;
        try {
            makesList = carDAO.getCarsMakes();
        } catch (DaoException e) {
            log.error("Service getCarsMakes wasn't executed: " + e);
        }
        return makesList;
    }

    public List<String> getCarsModels(String make) {
        log.info("Service getCarsModels(): ");

        Connection connection = DbConnection.getConnection();
        CarDAO carDAO = new CarDAO(connection);
        List<String> modelList = null;
        try {
            modelList = carDAO.getCarModels(make);
        } catch (DaoException e) {
            log.error("Service getCarsModels wasn't executed: " + e);
        }
        return modelList;
    }

    public int getAmountOfCars(HashMap<String, String> searchMap) {

        log.info("Service getAmountOfCars(): ");

        Connection conn = DbConnection.getConnection();
        CarDAO carDAO = new CarDAO(conn);
        String searchOption = searchQuery(searchMap);
        int amount = 0;
        try {
            amount = carDAO.getAmountOfCars(searchOption);
        } catch (DaoException e) {
            log.error("Service getAmountOfCars wasn't executed: " + e);
        }
        return amount;
    }

    public List<Car> searchCars(HashMap<String, String> searchMap, String order, int start, int amount) {

        log.info("Service searchCars : ");

        Connection connection = DbConnection.getConnection();
        CarDAO carDAO = new CarDAO(connection);
        String searchOption = searchQuery(searchMap);
        List<Car> carList = null;
        try {
            carList = carDAO.searchCars(searchOption, order, start, amount);
        } catch (DaoException e) {
            log.error("Service searchCars wasn't executed: " + e);
        }
        return carList;
    }

    private String searchQuery(HashMap<String, String> search) {

        log.info("searchQuery : ");

        StringBuilder query = new StringBuilder();
        for (String type : search.keySet()) {
            switch (type) {
                case "minYear":
                    query.append(" AND year>=").append(search.get("minYear"));
                    break;
                case "maxYear":
                    query.append(" AND year<").append(search.get("maxYear"));
                    break;
                case "minPrice":
                    query.append(" AND price>").append(search.get("minPrice"));
                    break;
                case "maxPrice":
                    query.append(" AND price<").append(search.get("maxPrice"));
                    break;
                case "minEngineCapacity":
                    query.append(" AND engine_capacity>").append(search.get("minEngineCapacity"));
                    break;
                case "maxEngineCapacity":
                    query.append(" AND engine_capacity<").append(search.get("maxEngineCapacity"));
                    break;
                case "command":
                    break;
                default:
                    query.append(" AND ").append(type).append("='").append(search.get(type)).append("'");
            }
        }
        return query.toString();
    }
}
