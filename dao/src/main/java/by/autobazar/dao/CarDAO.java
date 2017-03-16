package by.autobazar.dao;


import by.autobazar.connection.DbConnection;
import by.autobazar.entity.Car;
import by.autobazar.entity.Entity;

import java.io.UnsupportedEncodingException;
import java.sql.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Andrey on 21.02.2017.
 */
public class CarDAO implements Dao<Car>{

    private static final String GET_ALL_QUERY = "SELECT cars.id, cars.mark, cars.model," +
            " cars.price, cars.year, cars.transmission, cars.body_type, cars.description, images.image_path, images.status" +
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
            " cars.price, cars.year, cars.transmission, cars.body_type, cars.description, cars.characteristic_id," +
            " cars.condition_id, cars.location_id, cars.addition_id, characteristics.id," +
            " characteristics.doors_number, characteristics.fuel_type, characteristics.engine_capacity," +
            " characteristics.driving, conditions.id, conditions.car_condition, conditions.mileage," +
            " locations.id, locations.region, locations.city, additions.id, additions.car_color," +
            " additions.interior_material, additions.interior_color, images.image_path, images.status" +
            " FROM cars JOIN images ON cars.id=images.car_id JOIN characteristics ON characteristics.id=cars.characteristic_id" +
            " JOIN conditions ON conditions.id=cars.condition_id " +
            " JOIN locations ON locations.id=cars.location_id JOIN additions ON additions.id=cars.addition_id" +
            " WHERE images.status='main'";

    private static final String GET_AMOUNT_OF_CARS_QUERY = "SELECT COUNT(cars.id) as 'amount' FROM cars";

    public List<Car> getAll() {
        List<Car> resultList = new LinkedList<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DbConnection.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(GET_ALL_QUERY);
            while (resultSet != null && resultSet.next()) {
                String description = new String(resultSet.getBlob("description").getBytes(1l,
                        (int) resultSet.getBlob("description").length()), "UTF-8");
                resultList.add(new Car(resultSet.getLong("id"), resultSet.getString("mark"),
                       resultSet.getString("model"), resultSet.getInt("price"),
                       resultSet.getDate("year").toLocalDate(), resultSet.getString("transmission"),
                        resultSet.getString("body_type"), description, resultSet.getString("image_path")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return resultList;
    }

    public List<Car> getLimitAmount() {
        List<Car> resultList = new LinkedList<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DbConnection.getConnection();
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
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return resultList;
    }

    public List<String> getCarsMakes() {
        List<String> resultList = new LinkedList<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DbConnection.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(GET_CARS_MARKS_CUERY);
            while (resultSet != null && resultSet.next()) {
                resultList.add(resultSet.getString("mark"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultList;
    }

    public List<String> getCarModels(String make) {
        List<String> resultList = new LinkedList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DbConnection.getConnection();
            statement = connection.prepareStatement(GET_CAR_MODELS_CUERY);
            statement.setString(1, make);
            resultSet = statement.executeQuery();
            while (resultSet != null && resultSet.next()) {
                resultList.add(resultSet.getString("model"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultList;
    }

    public List<Car> getLimitOrderBy(String order,int start, int amount) {
        List<Car> resultList = new LinkedList<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DbConnection.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT cars.id, cars.mark, cars.model," +
                    " cars.price, cars.year, cars.transmission, cars.body_type, cars.description, images.image_path, images.status" +
                    " FROM cars JOIN images ON cars.id=images.car_id WHERE images.status='main' ORDER BY " + order +
                    " LIMIT " + start + "," + amount);
            while (resultSet != null && resultSet.next()) {
                String description = new String(resultSet.getBlob("description").getBytes(1l,
                        (int) resultSet.getBlob("description").length()), "UTF-8");
                resultList.add(new Car(resultSet.getLong("id"), resultSet.getString("mark"),
                        resultSet.getString("model"), resultSet.getInt("price"),
                        resultSet.getDate("year").toLocalDate(), resultSet.getString("transmission"),
                        resultSet.getString("body_type"), description, resultSet.getString("image_path")));
            }
        } catch (SQLException  e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return resultList;
    }

    public List<Car> searchCars(HashMap<String, String> search) {
        List<Car> resultList = new LinkedList<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        String query = seqarchQuery(search);
        try {
            connection = DbConnection.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            while (resultSet != null && resultSet.next()) {
                String description = new String(resultSet.getBlob("description").getBytes(1l,
                        (int) resultSet.getBlob("description").length()), "UTF-8");
                resultList.add(new Car(resultSet.getLong("id"), resultSet.getString("mark"),
                        resultSet.getString("model"), resultSet.getInt("price"),
                        resultSet.getDate("year").toLocalDate(), resultSet.getString("transmission"),
                        resultSet.getString("body_type"), description, resultSet.getString("image_path")));
            }
        } catch (SQLException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return resultList;
    }

    private String seqarchQuery(HashMap<String, String> search) {
        StringBuilder query = new StringBuilder(SEARCH_QUERY);
        for (String type : search.keySet()) {
        switch(type) {
            case "minYear": query.append(" AND year>=").append(search.get("minYear"));
                break;
            case "maxYear": query.append(" AND year<").append(search.get("maxYear"));
                break;
            case "minPrice": query.append(" AND price>").append(search.get("minPrice"));
                break;
            case "maxPrice": query.append(" AND price<").append(search.get("maxPrice"));
                break;
            case "minEngineCapacity": query.append(" AND engine_capacity>").append(search.get("minEngineCapacity"));
                break;
            case "maxEngineCapacity": query.append(" AND engine_capacity<").append(search.get("maxEngineCapacity"));
                break;
            default: query.append(" AND ").append(type).append("='").append(search.get(type)).append("'");
        }
        }
        return  query.toString();
    }

    public int getAmountOfCars() {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DbConnection.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(GET_AMOUNT_OF_CARS_QUERY);
            if (resultSet != null && resultSet.next()) {
                return resultSet.getInt("amount");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public void add(Car car) {

    }

    @Override
    public void update(Car car) {

    }

    @Override
    public Car get(Car car, long id) {
        return null;
    }

    @Override
    public void delete(Car car) {

    }
}
