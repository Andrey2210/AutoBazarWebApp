package by.autobazar.services;


import by.autobazar.dao.ICarDao;
import by.autobazar.entity.Car;
import by.autobazar.entity.carEnum.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

@ContextConfiguration(locations = {"classpath:test-service.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class CarServiceTest {
    @Autowired
    private ICarService carService;

    @Test
    public void get() {
        Car car = new Car("Bmw", "X5", 10000, LocalDate.now(), Transmission.AUTOMATIC, BodyType.SUV, "good car",
                CarCondition.USED, 150000, 5, FuelType.PETROL, 5.5, WheelDriving.AWD, CarColor.BLACK,
                InteriorMaterial.ALCANTARA, InteriorColor.BLACK, "Minsk", "Minsk", false);
        carService.saveOrUpdate(car);
        Assert.assertNotNull(car.getId());
        Car getCar = carService.get(car.getId());
        Assert.assertNotNull(getCar);

        carService.deleteCar(car.getId());
    }


        @Test
    public void getLimitAmountTest() {
        List<Car> carsList = carService.getLimitAmount();
        Assert.assertNotNull(carsList);
        Assert.assertTrue(carsList.size() > 0);
    }

    @Test
    public void getCarsMakesTest() {
        List<String> makesList = carService.getCarsMakes();
        List<String> allAMkeList = carService.getAllCarsMakes();
        Assert.assertNotNull(makesList);
        Assert.assertTrue(makesList.size() > 0);
        Assert.assertNotNull(allAMkeList);
        Assert.assertTrue(allAMkeList.size() > 0);
    }

    @Test
    public void getCarModelTest() {
        List<String> makesList = carService.getCarsModels("Ford");
        List<String> allMakesList = carService.getAllCarsModels("Ford");
        Assert.assertNotNull(makesList);
        Assert.assertTrue(makesList.size() > 0);
        Assert.assertNotNull(allMakesList);
        Assert.assertTrue(allMakesList.size() > 0);
    }

    @Test
    public void createCar() throws ServiceException {
        HashMap<String, String> hashMap = new HashMap<>();
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
        long id = carService.createCar(hashMap, 503);
        Assert.assertNotNull(id);
        carService.verifiedCar(id, "true");
        carService.deleteCar(id);
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

        List<Car> carsList = carService.searchCars(searchParam, "id", 0, 10);
        Assert.assertNotNull(carsList);
        Assert.assertTrue(carsList.size() > 0);
    }

    @Test
    public void getCarByIdTest() {
        Car car = new Car("Bmw", "X5", 10000, LocalDate.now(), Transmission.AUTOMATIC, BodyType.SUV, "good car",
                CarCondition.USED, 150000, 5, FuelType.PETROL, 5.5, WheelDriving.AWD, CarColor.BLACK,
                InteriorMaterial.ALCANTARA, InteriorColor.BLACK, "Minsk", "Minsk", false);
        carService.saveOrUpdate(car);
        Assert.assertNotNull(car.getId());
        Assert.assertNotNull(carService.getCarById(car.getId()));
        carService.deleteCar(car.getId());
    }

    @Test
    public void getAllCarsTest() {
        List<Car> carsList = carService.getAllCars("id", 0, 10);
        Assert.assertNotNull(carsList);
        Assert.assertTrue(carsList.size() > 0);
    }
}
