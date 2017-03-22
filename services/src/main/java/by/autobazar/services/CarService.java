package by.autobazar.services;

import by.autobazar.connection.DbConnection;
import by.autobazar.dao.*;
import by.autobazar.entity.*;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Andrey on 13.03.2017.
 */
public class CarService {

    private static final Logger log = Logger.getLogger(CarService.class);

    private static CarService INSTANCE = null;

    private CarService() {
    }

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
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
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
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
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
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return modelList;
    }

    public List<String> getAllCarsMakes() {

        log.info("Service getAllCarsMakes(): ");

        Connection connection = DbConnection.getConnection();
        CarDAO carDAO = new CarDAO(connection);
        List<String> makesList = null;
        try {
            makesList = carDAO.getAllCarsMakes();
        } catch (DaoException e) {
            log.error("Service getAllCarsMakes wasn't executed: " + e);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return makesList;
    }

    public List<String> getAllCarModels(String make) {

        log.info("Service getAllCarModels(): ");

        Connection connection = DbConnection.getConnection();
        CarDAO carDAO = new CarDAO(connection);
        List<String> modelList = null;
        try {
            modelList = carDAO.getAllCarModels(make);
        } catch (DaoException e) {
            log.error("Service getAllCarModels wasn't executed: " + e);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return modelList;
    }

    public int getAmountOfCars(HashMap<String, String> searchMap) {

        log.info("Service getAmountOfCars(): ");

        Connection connection = DbConnection.getConnection();
        CarDAO carDAO = new CarDAO(connection);
        String searchOption = searchQuery(searchMap);
        int amount = 0;
        try {
            amount = carDAO.getAmountOfCars(searchOption);
        } catch (DaoException e) {
            log.error("Service getAmountOfCars wasn't executed: " + e);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return amount;
    }

    public List<Car> searchCars(HashMap<String, String> searchMap, String order, int start, int amount) {

        log.info("Service searchCars : ");

        Connection connection = DbConnection.getConnection();
        CarDAO carDAO = new CarDAO(connection);
        String searchOption = searchQuery(searchMap);
        List<Car> carList = null;
        AdditionsDAO additionsDAO = new AdditionsDAO(connection);
        CharacteristicsDAO characteristicsDAO = new CharacteristicsDAO(connection);
        ConditionsDAO conditionsDAO = new ConditionsDAO(connection);
        LocationsDAO locationsDAO = new LocationsDAO(connection);
        try {
            carList = carDAO.searchCars(searchOption, order, start, amount);
            for (Car car : carList) {
                car.setAdditions(additionsDAO.getById(car.getAdditions().getId()));
                car.setCharacteristics(characteristicsDAO.getById(car.getCharacteristics().getId()));
                car.setConditions(conditionsDAO.getById(car.getConditions().getId()));
                car.setLocations(locationsDAO.getById(car.getLocations().getId()));
            }
        } catch (DaoException e) {
            log.error("Service searchCars wasn't executed: " + e);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
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

    public boolean createCar(HashMap<String, String> parametersMap, Long userId) {

        log.info("Service createCar : ");

        Additions additions = new Additions();
        additions.setCarColor(parametersMap.get("car_color"));
        additions.setInteriorMaterial(parametersMap.get("interior_material"));
        additions.setInteriorColor(parametersMap.get("interior_color"));

        Characteristics characteristics = new Characteristics();
        characteristics.setDoorsNumber(Integer.parseInt(parametersMap.get("doors_number")));
        characteristics.setFuelType(parametersMap.get("fuel_type"));
        characteristics.setEngineCapacity(Double.parseDouble(parametersMap.get("engine_capacity")));
        characteristics.setDriving(parametersMap.get("driving"));

        Conditions conditions = new Conditions();
        conditions.setCarCondition(parametersMap.get("car_condition"));
        conditions.setMilleage(Integer.parseInt(parametersMap.get("mileage")));


        Locations locations = new Locations();
        locations.setRegion(parametersMap.get("region"));
        locations.setCity(parametersMap.get("city"));

        Car car = new Car();
        car.setMark(parametersMap.get("mark"));
        car.setModel(parametersMap.get("model"));
        car.setPrice(Integer.parseInt(parametersMap.get("price")));
        car.setYear(LocalDate.of(Integer.parseInt(parametersMap.get("year")), 1, 1));
        car.setTransmission(parametersMap.get("transmission"));
        car.setBodyType(parametersMap.get("body_type"));
        car.setDescription(parametersMap.get("description"));
        car.setImage(parametersMap.get("image_path"));

        Connection connection = DbConnection.getConnection();
        Savepoint savepoint = null;
        try {
            connection.setAutoCommit(false);
            savepoint = connection.setSavepoint();
            CarDAO carDAO = new CarDAO(connection);
            AdditionsDAO additionsDAO = new AdditionsDAO(connection);
            CharacteristicsDAO characteristicsDAO = new CharacteristicsDAO(connection);
            ConditionsDAO conditionsDAO = new ConditionsDAO(connection);
            LocationsDAO locationsDAO = new LocationsDAO(connection);
            UserDAO userDAO = new UserDAO(connection);

            if (additionsDAO.create(additions) && characteristicsDAO.create(characteristics) &&
                    conditionsDAO.create(conditions) && locationsDAO.create(locations)) {
                connection.commit();
                car.setAdditions(additions);
                car.setCharacteristics(characteristics);
                car.setConditions(conditions);
                car.setLocations(locations);

                User user = userDAO.getById(userId);
                car.setUser(user);
            }

            carDAO.create(car);
            connection.commit();

            carDAO.insertImage(car);
            connection.commit();

        } catch (SQLException | DaoException e) {
            log.error("Service createCar wasn't executed: " + e);
            try {
                connection.rollback(savepoint);
                return false;
            } catch (SQLException e1) {
                log.error("Service createCar wasn't executed: " + e);
                return false;
            }
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    public Car getCarById(Long id) {

        log.info("Service getCarById(): ");

        Connection connection = DbConnection.getConnection();
        CarDAO carDAO = new CarDAO(connection);
        AdditionsDAO additionsDAO = new AdditionsDAO(connection);
        CharacteristicsDAO characteristicsDAO = new CharacteristicsDAO(connection);
        ConditionsDAO conditionsDAO = new ConditionsDAO(connection);
        LocationsDAO locationsDAO = new LocationsDAO(connection);
        UserDAO userDAO = new UserDAO(connection);
        Car car = null;
        try {
            car = carDAO.getById(id);
            car.setUser(userDAO.getById(car.getUser().getId()));
            car.setAdditions(additionsDAO.getById(car.getAdditions().getId()));
            car.setCharacteristics(characteristicsDAO.getById(car.getCharacteristics().getId()));
            car.setConditions(conditionsDAO.getById(car.getConditions().getId()));
            car.setLocations(locationsDAO.getById(car.getLocations().getId()));
        } catch (DaoException e) {
            log.error("Service getCarById wasn't executed: " + e);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return car;
    }


    public boolean createComment(String comment, long carId, long userId) {

        log.info("Service createComment : ");

        Connection connection = DbConnection.getConnection();
        Comments comments = new Comments();
        comments.setCarId(carId);
        comments.setComment(comment);
        comments.setUserId(userId);
        try {
            CommentsDAO commentsDAO = new CommentsDAO(connection);

            commentsDAO.create(comments);

        } catch (DaoException e) {
            log.error("Service createComment wasn't executed: " + e);
            return false;
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    public List<Comments> getAllCommentsByCar(Long carId) {

        log.info("Service getAllCommentsByCar(): ");

        Connection connection = DbConnection.getConnection();
        CommentsDAO commentsDAO = new CommentsDAO(connection);
        List<Comments> commentsList = null;
        try {
            commentsList = commentsDAO.getAllByCar(carId);

            for (Comments comment : commentsList) {
                comment.setUser(UserService.getInstance().getUserById(comment.getUserId()));
            }
        } catch (DaoException e) {
            log.error("Service getAllCommentsByCar wasn't executed: " + e);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return commentsList;
    }

    public boolean deleteCar(Long carId) {

        log.info("Service deleteCar : ");

        Connection connection = DbConnection.getConnection();
        Savepoint savepoint = null;
        try {
            connection.setAutoCommit(false);
            savepoint = connection.setSavepoint();
            CarDAO carDAO = new CarDAO(connection);
            AdditionsDAO additionsDAO = new AdditionsDAO(connection);
            CharacteristicsDAO characteristicsDAO = new CharacteristicsDAO(connection);
            ConditionsDAO conditionsDAO = new ConditionsDAO(connection);
            LocationsDAO locationsDAO = new LocationsDAO(connection);
            UserDAO userDAO = new UserDAO(connection);

            Car car = carDAO.getById(carId);

            carDAO.delete(car);
            additionsDAO.delete(car.getAdditions());
            characteristicsDAO.delete(car.getCharacteristics());
            conditionsDAO.delete(car.getConditions());
            locationsDAO.delete(car.getLocations());
            connection.commit();

        } catch (SQLException | DaoException e) {
            log.error("Service deleteCar wasn't executed: " + e);
            try {
                connection.rollback(savepoint);
                return false;
            } catch (SQLException e1) {
                log.error("Service deleteCar wasn't executed: " + e);
                return false;
            }
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return true;
    }
}
