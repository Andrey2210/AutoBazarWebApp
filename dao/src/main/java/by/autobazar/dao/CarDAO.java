package by.autobazar.dao;


import by.autobazar.entity.*;
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
            " FROM cars JOIN images ON cars.id=images.car_id WHERE cars.verified=1";

    private static final String GET_LIMIT_AMOUNT_QUERY = "SELECT cars.id, cars.mark, cars.model," +
            " cars.price, cars.year, cars.transmission, cars.body_type, cars.description, images.image_path, images.status" +
            " FROM cars JOIN images ON cars.id=images.car_id WHERE cars.verified=1 order by cars.id desc limit 4";

    private static final String GET_CARS_MARKS_QUERY = "SELECT DISTINCT cars.mark FROM cars ORDER BY cars.mark";

    private static final String GET_CAR_MODELS_QUERY = "SELECT DISTINCT cars.model FROM cars WHERE cars.mark=? " +
            "ORDER BY cars.model";

    private static final String GET_LIMIT_QUERY_ORDER_BY = "SELECT cars.id, cars.mark, cars.model," +
            " cars.price, cars.year, cars.transmission, cars.body_type, cars.description, images.image_path, images.status" +
            " FROM cars JOIN images ON cars.id=images.car_id WHERE cars.verified=1 ORDER BY ? limit ?,?";

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
            " WHERE cars.verified=1 ";

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
            " WHERE cars.verified=1 ";

    private static final String GET_ALL_CARS_MARKS_QUERY = "SELECT cars_makes.id, cars_makes.make" +
            " FROM cars_makes ";
    private static final String GET_All_CAR_MODELS_QUERY = "SELECT cars_models.model FROM cars_models INNER JOIN  cars_makes" +
            " ON cars_models.make_id=cars_makes.id WHERE cars_makes.make=? ORDER BY cars_models.model";

    private static final String CREATE_CAR= "INSERT INTO cars " +
            "(cars.mark, cars.model, cars.price, cars.year, cars.transmission, cars.body_type, cars.description, " +
            "cars.additions_id, cars.characteristics_id, cars.conditions_id, cars.locations_id, cars.user_id) " +
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    private static final String INSERT_IMAGE= "INSERT INTO images " +
            "(images.car_id, images.image_path) VALUES (?, ?)";

    private static final String GET_BY_ID_QUERY = "SELECT cars.mark, cars.model, cars.price, cars.year, " +
            "cars.transmission, cars.body_type, cars.description, cars.additions_id, cars.characteristics_id, " +
            "cars.conditions_id, cars.locations_id, cars.user_id, images.image_path" +
            " FROM cars JOIN images ON cars.id=images.car_id WHERE cars.id=?";


    private static final String DELETE_QUERY = "DELETE FROM cars WHERE cars.id=?";

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
            resultSet = statement.executeQuery(GET_LIMIT_AMOUNT_QUERY);
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
            resultSet = statement.executeQuery(GET_CARS_MARKS_QUERY);
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
            statement = connection.prepareStatement(GET_CAR_MODELS_QUERY);
            statement.setString(1, make);
            resultSet = statement.executeQuery();
            while (resultSet != null && resultSet.next()) {
                resultList.add(resultSet.getString("model"));
            }
        } catch (SQLException e) {
            log.error("SQLException in getCarModels() " + e);
            throw new DaoException(e);
        }  finally {
            close(statement);
        }
        return resultList;
    }

    @Override
    public Car getById(long id) throws DaoException {

        log.info("getById : " + id);

        Car car = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(GET_BY_ID_QUERY);
            statement.setLong(1, id);
            resultSet = statement.executeQuery();
            if (resultSet != null && resultSet.next()) {
                String description = new String(resultSet.getBlob("description").getBytes(1L,
                        (int) resultSet.getBlob("description").length()), "UTF-8");
                car = new Car(id, resultSet.getString("mark"),
                        resultSet.getString("model"), resultSet.getInt("price"),
                        resultSet.getDate("year").toLocalDate(), resultSet.getString("transmission"),
                        resultSet.getString("body_type"), description, resultSet.getString("image_path"));


                car.setAdditions(new Additions());
                car.setCharacteristics(new Characteristics());
                car.setConditions(new Conditions());
                car.setLocations(new Locations());
                car.setUser(new User());

                car.getAdditions().setId(resultSet.getLong("additions_id"));
                car.getCharacteristics().setId(resultSet.getLong("characteristics_id"));
                car.getConditions().setId(resultSet.getLong("conditions_id"));
                car.getLocations().setId(resultSet.getLong("locations_id"));
                car.getUser().setId(resultSet.getLong("user_id"));
            }
        } catch (SQLException e) {
            log.warn("SQLException in getById() " + e);
            throw new DaoException(e);
        } catch (UnsupportedEncodingException e) {
            log.warn("UnsupportedEncodingException in getById() " + e);
        } finally {
            close(statement);
        }
        return car;
    }

    @Override
    public boolean delete(Car car) throws DaoException {

            log.info("deleteCar : ");

            PreparedStatement statement = null;
            int result;
            try {
                statement = connection.prepareStatement(DELETE_QUERY);
                statement.setLong(1, car.getId());
                result = statement.executeUpdate();
            } catch (SQLException e) {
                log.warn("SQLException in delete() " + e);
                throw new DaoException("Car wasn't deleted" + e);
            } finally {
                close(statement);
            }
            return result == 1;
    }

    @Override
    public boolean create(Car car) throws DaoException {
        log.info("create Car : ");

        PreparedStatement statement = null;
        int result;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(CREATE_CAR, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, car.getMark());
            statement.setString(2, car.getModel());
            statement.setInt(3, car.getPrice());
            statement.setInt(4, car.getYear().getYear());
            statement.setString(5, car.getTransmission());
            statement.setString(6, car.getBodyType());
            statement.setString(7, car.getDescription());
            statement.setLong(8, car.getAdditions().getId());
            statement.setLong(9, car.getCharacteristics().getId());
            statement.setLong(10, car.getConditions().getId());
            statement.setLong(11, car.getLocations().getId());
            statement.setLong(12, car.getUser().getId());
            result = statement.executeUpdate();
            resultSet = statement.getGeneratedKeys();
            if (resultSet != null && resultSet.next()) {
                car.setId(resultSet.getLong(1));
            }
        } catch (SQLException e) {
            log.warn("SQLException in create() " + e);
            throw new DaoException("Car wasn't created" + e);
        } finally {
            close(statement);
        }
        return result == 1;
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
            statement = connection.prepareStatement(SEARCH_QUERY + searchOptions + " ORDER BY " + order + " limit ?,?");
            statement.setInt(1, start);
            statement.setInt(2, amount);
            resultSet = statement.executeQuery();
            while (resultSet != null && resultSet.next()) {
                String description = new String(resultSet.getBlob("description").getBytes(1L,
                        (int) resultSet.getBlob("description").length()), "UTF-8");
                Car car = new Car(resultSet.getLong("id"), resultSet.getString("mark"),
                        resultSet.getString("model"), resultSet.getInt("price"),
                        resultSet.getDate("year").toLocalDate(), resultSet.getString("transmission"),
                        resultSet.getString("body_type"), description, resultSet.getString("image_path"));

                car.setAdditions(new Additions());
                car.setCharacteristics(new Characteristics());
                car.setConditions(new Conditions());
                car.setLocations(new Locations());

                car.getAdditions().setId(resultSet.getLong("additions_id"));
                car.getCharacteristics().setId(resultSet.getLong("characteristics_id"));
                car.getConditions().setId(resultSet.getLong("conditions_id"));
                car.getLocations().setId(resultSet.getLong("locations_id"));

                resultList.add(car);
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

    public List<String> getAllCarsMakes() throws DaoException {

        log.info("getAllCarsMakes : ");

        List<String> resultList = new LinkedList<>();
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(GET_ALL_CARS_MARKS_QUERY);
            while (resultSet != null && resultSet.next()) {
                resultList.add(resultSet.getString("make"));
            }
        } catch (SQLException e) {
            log.warn("SQLException in getAllCarsMakes() " + e);
            throw new DaoException(e);
        } finally {
            close(statement);
        }
        return resultList;
    }

    public List<String> getAllCarModels(String make) throws DaoException {

        log.info("getAllCarModels : " + make);

        List<String> resultList = new LinkedList<>();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(GET_All_CAR_MODELS_QUERY);
            statement.setString(1, make);
            resultSet = statement.executeQuery();
            while (resultSet != null && resultSet.next()) {
                resultList.add(resultSet.getString("model"));
            }
        } catch (SQLException e) {
            log.warn("SQLException in getAllCarModels() " + e);
            throw new DaoException(e);
        }  finally {
            close(statement);
        }
        return resultList;
    }

    public boolean insertImage(Car car) throws DaoException {
        log.info("insertImage : ");

        PreparedStatement statement = null;
        int result;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(INSERT_IMAGE);
            statement.setLong(1, car.getId());
            statement.setString(2, car.getImage());
            result = statement.executeUpdate();
        } catch (SQLException e) {
            log.warn("SQLException in insertImage() " + e);
            throw new DaoException("Image wasn't created" + e);
        } finally {
            close(statement);
        }
        return result == 1;
    }
}
