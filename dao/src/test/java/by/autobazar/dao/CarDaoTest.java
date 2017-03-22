package by.autobazar.dao;

import by.autobazar.connection.DbConnection;
import by.autobazar.entity.*;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

/**
 * Created by Andrey on 16.03.2017.
 */
public class CarDaoTest {

    @Test
    public void getAllTest() throws DaoException, SQLException {
        Connection connection = DbConnection.getConnection();
        CarDAO carDAO = new CarDAO(connection);
        List<Car> cars =  carDAO.getAll();
        Assert.assertNotNull(cars);
        Assert.assertTrue(cars.size() > 0);
        connection.close();
    }

    @Test
    public void getLimitAmountTest() throws DaoException, SQLException {
        Connection connection = DbConnection.getConnection();
        CarDAO carDAO = new CarDAO(connection);
        List<Car> cars =  carDAO.getLimitAmount();
        Assert.assertNotNull(cars);
        Assert.assertTrue(cars.size() > 0);
        connection.close();
    }

    @Test
    public void getCarsMakesTest() throws DaoException, SQLException {
        Connection connection = DbConnection.getConnection();
        CarDAO carDAO = new CarDAO(connection);
        List<String> carsMakes =  carDAO.getCarsMakes();
        Assert.assertNotNull(carsMakes);
        Assert.assertTrue(carsMakes.size() > 0);
        connection.close();
    }

    @Test
    public void getCarModelsTest() throws DaoException, SQLException {
        Connection connection = DbConnection.getConnection();
        CarDAO carDAO = new CarDAO(connection);
        List<String> carsModels =  carDAO.getCarModels("Bmw");
        Assert.assertNotNull(carsModels);
        Assert.assertTrue(carsModels.size() > 0);
        connection.close();
    }

    @Test
    public void searchCarsTest() throws DaoException, SQLException {
        Connection connection = DbConnection.getConnection();
        CarDAO carDAO = new CarDAO(connection);
        List<Car> cars =  carDAO.searchCars(" ", "price", 0, 10);
        Assert.assertNotNull(cars);
        Assert.assertTrue(cars.size() > 0);
        connection.close();
    }

    @Test
    public void getAmountOfCarsTest() throws DaoException, SQLException {
        Connection connection = DbConnection.getConnection();
        CarDAO carDAO = new CarDAO(connection);
        int amount =  carDAO.getAmountOfCars(" AND mark='BMW' AND model='M5' ");
        Assert.assertTrue(amount > 0);
        connection.close();
    }

    @Test
    public void getByIdTest() throws DaoException, SQLException {
        Connection connection = DbConnection.getConnection();
        CarDAO carDAO = new CarDAO(connection);
        Assert.assertNotNull(carDAO.getById(1L));
        connection.close();
    }

    @Test
    public void createTest() throws DaoException, SQLException {
        Connection connection = DbConnection.getConnection();
        CarDAO carDAO = new CarDAO(connection);
        Car car = new Car();
        car.setMark("Bmw");
        car.setModel("M5");
        car.setPrice(50000);
        car.setYear(LocalDate.now());
        car.setTransmission("AWD");
        car.setBodyType("Sedan");
        car.setDescription("car");
        Additions additions = new Additions();
        Characteristics characteristics  = new Characteristics();
        Conditions conditions = new Conditions();
        Locations locations = new Locations();
        User user = new User();
        additions.setId(1);
        characteristics.setId(1);
        conditions.setId(1);
        locations.setId(1);
        user.setId(1);
        car.setAdditions(additions);
        car.setCharacteristics(characteristics);
        car.setConditions(conditions);
        car.setLocations(locations);
        car.setUser(user);

        Assert.assertNotNull(carDAO.create(car));

        Assert.assertTrue(carDAO.delete(car));
        connection.close();

    }

    @Test
    public void getAllCarsMakesTest() throws DaoException, SQLException {
        Connection connection = DbConnection.getConnection();
        CarDAO carDAO = new CarDAO(connection);
        List<String> cars =  carDAO.getAllCarsMakes();
        Assert.assertNotNull(cars);
        Assert.assertTrue(cars.size() > 0);
        connection.close();
    }

    @Test
    public void getAllCarModelsTest() throws DaoException, SQLException {
        Connection connection = DbConnection.getConnection();
        CarDAO carDAO = new CarDAO(connection);
        List<String> cars =  carDAO.getAllCarModels("Bmw");
        Assert.assertNotNull(cars);
        Assert.assertTrue(cars.size() > 0);
        connection.close();
    }

}
