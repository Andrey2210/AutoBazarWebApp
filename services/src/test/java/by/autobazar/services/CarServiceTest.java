package by.autobazar.services;

import by.autobazar.entity.Car;
import by.autobazar.entity.Image;
import by.autobazar.entity.carEnum.*;
import by.autobazar.util.HibernateUtil;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Andrey on 19.03.2017.
 */
public class CarServiceTest {
    private static long id;
    private static HashMap<String, String> hashMap;
    private static CarService carService = CarService.getInstance();

    @BeforeClass
    public static void setCar() {
        hashMap = new HashMap<>();
        hashMap.put("mark", "Bmw");
        hashMap.put("model", "X5");
        hashMap.put("price", "10000");
        hashMap.put("year", "2010");
        hashMap.put("transmission", "AUTOMATIC");
        hashMap.put("bodyType", "SUV");
        hashMap.put("description", "FFFFF");
        hashMap.put("carCondition", "USED");
        hashMap.put("milleage", "1200000");
        hashMap.put("doorsNumber", "5");
        hashMap.put("fuelType", "PETROL");
        hashMap.put("engineCapacity", "3.5");
        hashMap.put("driving", "AWD");
        hashMap.put("carColor", "BLACK");
        hashMap.put("interiorMaterial", "LEATHER");
        hashMap.put("interiorColor", "BLACK");
        hashMap.put("region", "Minsk");
        hashMap.put("city", "Minsk");
        hashMap.put("image", "image/20000.jpeg");
        AbstractService.session = HibernateUtil.getHibernateUtil().getSession();
    }

    @AfterClass
    public static void deleteCar() {
        carService.deleteCar(id);
        HibernateUtil.getHibernateUtil().closeSession(AbstractService.session);
    }

        @Test
    public void getLimitAmountTest() {

        List<Car> carsList = CarService.getInstance().getLimitAmount();
        Assert.assertNotNull(carsList);
        Assert.assertTrue(carsList.size() > 0);
    }

    @Test
    public void getCarsMakesTest() {

        List<String> makesList = CarService.getInstance().getCarsMakes();
        Assert.assertNotNull(makesList);
        Assert.assertTrue(makesList.size() > 0);
    }

    @Test

    public void getCarModelTest() {

        List<String> makesList = CarService.getInstance().getCarsModels("Bmw");
        Assert.assertNotNull(makesList);
        Assert.assertTrue(makesList.size() > 0);
    }

    @Test
    public void getAllCarsMakesTest() {

        List<String> makesList = CarService.getInstance().getAllCarsMakes();
        Assert.assertNotNull(makesList);
        Assert.assertTrue(makesList.size() > 0);
    }

    @Test
    public void getAllCarModelTest() {

        List<String> makesList = CarService.getInstance().getAllCarsModels("Bmw");
        Assert.assertNotNull(makesList);
        Assert.assertTrue(makesList.size() > 0);
    }
    @Test
    public void createCar() throws ServiceException {

        id = carService.createCar(hashMap, 3L);
        Assert.assertNotNull(id);
    }

    @Test
    public void getAmountOfCarsTest() {
        HashMap<String, String> searchParam = new HashMap<>();
        searchParam.put("minPrice", "0");
        searchParam.put("minYear", "2000");
        searchParam.put("minEngineCapacity", "0");
        searchParam.put("maxPrice", "1000000");
        searchParam.put("maxYear", "2017");
        searchParam.put("maxEngineCapacity", "5.5");
        Assert.assertNotNull(carService.getAmountOfCars(searchParam));
    }

    @Test
    public void searchCarsTest() {
        HashMap<String, String> searchParam = new HashMap<>();
        searchParam.put("minPrice", "0");
        searchParam.put("minYear", "2000");
        searchParam.put("minEngineCapacity", "0.0");
        searchParam.put("maxPrice", "1000000");
        searchParam.put("maxYear", "2017");
        searchParam.put("maxEngineCapacity", "5.5");

        List<Car> carsList = CarService.getInstance().searchCars(searchParam, "id", 0, 10);
        Assert.assertNotNull(carsList);
        Assert.assertTrue(carsList.size() > 0);
    }

    @Test
    public void getCarByIdTest() {
        Car car = CarService.getInstance().getCarById(68L);
        Assert.assertNotNull(car);
    }

    @Test
    public void getAllCarsTest() {
        List<Car> carsList = carService.getAllCars("id", 0, 10);
        Assert.assertNotNull(carsList);
        Assert.assertTrue(carsList.size() > 0);
    }
}
