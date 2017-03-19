package by.autobazar.dao;

import by.autobazar.connection.DbConnection;
import by.autobazar.entity.Car;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Created by Andrey on 16.03.2017.
 */
public class CarDaoTest {

    @Test
    public void getAllTest() throws DaoException {
        CarDAO carDAO = new CarDAO(DbConnection.getConnection());
        List<Car> cars =  carDAO.getAll();
        Assert.assertNotNull(cars);
        Assert.assertTrue(cars.size() > 0);
    }

    @Test
    public void getLimitAmountTest() throws DaoException {
        CarDAO carDAO = new CarDAO(DbConnection.getConnection());
        List<Car> cars =  carDAO.getLimitAmount();
        Assert.assertNotNull(cars);
        Assert.assertTrue(cars.size() > 0);
    }

    @Test
    public void getCarsMakesTest() throws DaoException {
        CarDAO carDAO = new CarDAO(DbConnection.getConnection());
        List<String> carsMakes =  carDAO.getCarsMakes();
        Assert.assertNotNull(carsMakes);
        Assert.assertTrue(carsMakes.size() > 0);
    }

    @Test
    public void getCarModelsTest() throws DaoException {
        CarDAO carDAO = new CarDAO(DbConnection.getConnection());
        List<String> carsModels =  carDAO.getCarModels("Bmw");
        Assert.assertNotNull(carsModels);
        Assert.assertTrue(carsModels.size() > 0);
    }

    @Test
    public void searchCarsTest() throws DaoException {
        CarDAO carDAO = new CarDAO(DbConnection.getConnection());
        List<Car> cars =  carDAO.searchCars(" AND mark='BMW' AND model='e92' ", "price", 0, 10);
        Assert.assertNotNull(cars);
        Assert.assertTrue(cars.size() > 0);
    }

    @Test
    public void getAmountOfCarsTest() throws DaoException {
        CarDAO carDAO = new CarDAO(DbConnection.getConnection());
        int amount =  carDAO.getAmountOfCars(" AND mark='BMW' AND model='e92' ");
        Assert.assertTrue(amount > 0);
    }
}
