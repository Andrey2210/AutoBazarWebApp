package by.autobazar.dao;


import by.autobazar.entity.Car;
import org.apache.log4j.Logger;

import java.io.UnsupportedEncodingException;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Andrey on 21.02.2017.
 */
public class CarDAO extends AbstractDAO<Car> {

    private static final Logger log = Logger.getLogger(CarDAO.class);

    private static final String GET_ALL_QUERY = "SELECT cars.id, cars.mark, cars.model," +
            " cars.price, cars.year, cars.transmission, cars.body_type, cars.description, images.image_path" +
            " FROM cars JOIN images ON cars.id=images.car_id WHERE images.status='main'";

    private static final String GET_LIMIT_AMOUNT_CUERY = "SELECT cars.id, cars.mark, cars.model," +
            " cars.price, cars.year, cars.transmission, cars.body_type, cars.description, images.image_path, images.status" +
            " FROM cars JOIN images ON cars.id=images.car_id WHERE images.status='main' order by cars.id desc limit 4";

    private static final String GET_CARS_MARKS_CUERY = "SELECT DISTINCT cars.mark FROM cars ORDER BY cars.mark";

    private static final String GET_CAR_MODELS_CUERY = "SELECT DISTINCT cars.model FROM cars WHERE cars.mark=? " +
            "ORDER BY cars.model";

    private static final String GET_LIMIT_QUERY_ORDER_BY = "SELECT cars.id, cars.mark, cars.model," +
            " cars.price, cars.year, cars.transmission, cars.body_type, cars.description, images.image_path, images.status" +
            " FROM cars JOIN images ON cars.id=images.car_id WHERE images.status='main' ORDER BY ? limit ?,?";

    private static final String SEARCH_QUERY = "SELECT cars.id, cars.mark, cars.model," +
            " cars.price, cars.year, cars.transmission, cars.body_type, cars.description, cars.characteristics_id," +
            " cars.conditions_id, cars.locations_id, cars.additions_id, characteristics.id," +
            " characteristics.doors_number, characteristics.fuel_type, characteristics.engine_capacity," +
            " characteristics.driving, conditions.id, conditions.car_condition, conditions.mileage," +
            " locations.id, locations.region, locations.city, additions.id, additions.car_color," +
            " additions.interior_material, additions.interior_color, images.image_path, images.status" +
            " FROM cars JOIN images ON cars.id=images.car_id JOIN characteristics ON characteristics.id=cars.characteristics_id" +
            " JOIN conditions ON conditions.id=cars.conditions_id " +
            " JOIN locations ON locations.id=cars.locations_id JOIN additions ON additions.id=cars.additions_id" +
            " WHERE images.status='main' ";

    private static final String GET_AMOUNT_OF_CARS_QUERY = "SELECT COUNT(cars.id) as 'amount', cars.id, cars.mark, cars.model," +
            " cars.price, cars.year, cars.transmission, cars.body_type, cars.description, cars.characteristics_id," +
            " cars.conditions_id, cars.locations_id, cars.additions_id, characteristics.id," +
            " characteristics.doors_number, characteristics.fuel_type, characteristics.engine_capacity," +
            " characteristics.driving, conditions.id, conditions.car_condition, conditions.mileage," +
            " locations.id, locations.region, locations.city, additions.id, additions.car_color," +
            " additions.interior_material, additions.interior_color, images.image_path, images.status" +
            " FROM cars JOIN images ON cars.id=images.car_id JOIN characteristics ON characteristics.id=cars.characteristics_id" +
            " JOIN conditions ON conditions.id=cars.conditions_id " +
            " JOIN locations ON locations.id=cars.locations_id JOIN additions ON additions.id=cars.additions_id" +
            " WHERE images.status='main' ";

    public CarDAO(Connection connection) {
        super(connection);
    }

    @Override
    public List<Car> getAll() throws DaoException {

        log.info("Get all cars : ");

        List<Car> resultList = new LinkedList<>();
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(GET_ALL_QUERY);
            while (resultSet != null && resultSet.next()) {
                String description = new String(resultSet.getBlob("description").getBytes(1L,
                        (int) resultSet.getBlob("description").length()), "UTF-8");
                resultList.add(new Car(resultSet.getLong("id"), resultSet.getString("mark"),
                        resultSet.getString("model"), resultSet.getInt("price"),
                        resultSet.getDate("year").toLocalDate(), resultSet.getString("transmission"),
                        resultSet.getString("body_type"), description, resultSet.getString("image_path")));
            }
        } catch (SQLException e) {
            log.warn("SQLException in getAll()" + e);
            throw new DaoException(e);
        } catch (UnsupportedEncodingException e) {
            log.warn("UnsupportedEncodingException in getAll()" + e);
            throw new DaoException(e);
        } finally {
            close(statement);
        }
        return resultList;
    }

    public List<Car> getLimitAmount() throws DaoException {

        log.info("getLimitAmount : ");

        List<Car> resultList = new LinkedList<>();
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(GET_LIMIT_AMOUNT_CUERY);
            while (resultSet != null && resultSet.next()) {
                String description = new String(resultSet.getBlob("description").getBytes(1l,
                        (int) resultSet.getBlob("description").length()), "UTF-8");
                resultList.add(new Car(resultSet.getLong("id"), resultSet.getString("mark"),
                        resultSet.getString("model"), resultSet.getInt("price"),
                        resultSet.getDate("year").toLocalDate(), resultSet.getString("transmission"),
                        resultSet.getString("body_type"), description, resultSet.getString("image_path")));
            }
        } catch (SQLException e) {
            log.warn("SQLException in getLimitAmount() " + e);
            throw new DaoException(e);
        } catch (UnsupportedEncodingException e) {
            log.warn("UnsupportedEncodingException in getLimitAmount() " + e);
            throw new DaoException(e);
        } finally {
            close(statement);
        }
        return resultList;
    }

    public List<String> getCarsMakes() throws DaoException {

        log.info("getCarsMakes : ");

        List<String> resultList = new LinkedList<>();
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(GET_CARS_MARKS_CUERY);
            while (resultSet != null && resultSet.next()) {
                resultList.add(resultSet.getString("mark"));
            }
        } catch (SQLException e) {
            log.warn("SQLException in getCarsMakes() " + e);
            throw new DaoException(e);
        } finally {
            close(statement);
        }
        return resultList;
    }

    public List<String> getCarModels(String make) throws DaoException {

        log.info("getCarModels : " + make);

        List<String> resultList = new LinkedList<>();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(GET_CAR_MODELS_CUERY);
            statement.setString(1, make);
            resultSet = statement.executeQuery();
            while (resultSet != null && resultSet.next()) {
                resultList.add(resultSet.getString("model"));
            }
        } catch (SQLException e) {
            log.warn("SQLException in getCarModels() " + e);
            throw new DaoException(e);
        }  finally {
            close(statement);
        }
        return resultList;
    }

    @Override
    public Car getById(int id) {
        return null;
    }

    @Override
    public boolean delete(Car entity) {
        return false;
    }

    @Override
    public boolean create(Car entity) {
        return false;
    }

    @Override
    public Car update(Car entity) {
        return null;
    }

    public List<Car> searchCars(String searchOptions, String order, int start, int amount) throws DaoException {

        log.info("searchCars : ");

        List<Car> resultList = new LinkedList<>();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(SEARCH_QUERY + searchOptions + " ORDER BY ? limit ?,?");
            statement.setString(1, order);
            statement.setInt(2, start);
            statement.setInt(3, amount);
            resultSet = statement.executeQuery();
            while (resultSet != null && resultSet.next()) {
                String description = new String(resultSet.getBlob("description").getBytes(1L,
                        (int) resultSet.getBlob("description").length()), "UTF-8");
                resultList.add(new Car(resultSet.getLong("id"), resultSet.getString("mark"),
                        resultSet.getString("model"), resultSet.getInt("price"),
                        resultSet.getDate("year").toLocalDate(), resultSet.getString("transmission"),
                        resultSet.getString("body_type"), description, resultSet.getString("image_path")));
            }
        } catch (SQLException e) {
            log.warn("SQLException in searchCars() " + e);
            throw new DaoException(e);
        } catch (UnsupportedEncodingException e) {
            log.warn("UnsupportedEncodingException in searchCars() " + e);
            throw new DaoException(e);
        } finally {
            close(statement);
        }
        return resultList;
    }

    public int getAmountOfCars(String searchOptions) throws DaoException {

        log.info("getAmountOfCars : ");

        Statement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(GET_AMOUNT_OF_CARS_QUERY + searchOptions);
            if (resultSet != null && resultSet.next()) {
                return resultSet.getInt("amount");
            }
        } catch (SQLException e) {
            log.warn("SQLException in getAmountOfCars() " + e);
            throw new DaoException(e);
        } finally {
            close(statement);
        }
        return 0;
    }

}
