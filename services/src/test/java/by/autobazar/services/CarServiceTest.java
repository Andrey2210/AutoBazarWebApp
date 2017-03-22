package by.autobazar.services;

import by.autobazar.entity.Car;
import by.autobazar.entity.Comments;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Andrey on 19.03.2017.
 */
public class CarServiceTest {

    @Test
    public void getLimitAmountTest() {

        List<Car> carsList = CarService.getInstance().getLimitAmount();
        Assert.assertNotNull(carsList);
        Assert.assertTrue(carsList.size() > 0);
    }

    @Test
    public void searchCarsTest() {
        HashMap<String,String> hashMap = new HashMap<>();
        List<Car> carsList = CarService.getInstance().searchCars(hashMap, "price", 0, 10);
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
    public void createCar() {

        HashMap<String,String> hashMap = new HashMap<>();

        hashMap.put("mark", "Bmw");
        hashMap.put("model", "X6");
        hashMap.put("body_type", "Suv");
        hashMap.put("fuel_type", "Petrol");
        hashMap.put("doors_number", "5");
        hashMap.put("year", "2010");
        hashMap.put("driving", "AWD");
        hashMap.put("transmission", "Automatic");
        hashMap.put("engine_capacity", "4.4");
        hashMap.put("price", "20000");
        hashMap.put("mileage", "90000");
        hashMap.put("car_color", "Black");
        hashMap.put("interior_material", "Leather");
        hashMap.put("interior_color", "Black");
        hashMap.put("name", "Andrey");
        hashMap.put("region", "Minsk");
        hashMap.put("city", "Minsk");
        hashMap.put("phone", "+375(44)557-52-21");
        hashMap.put("description", "Very good condition");
        hashMap.put("car_condition", "Used");
        hashMap.put("image_path", "......");

        Assert.assertTrue(CarService.getInstance().createCar(hashMap, 1L));

    }

    @Test
    public void getCarByIdTest() {

        Car car = CarService.getInstance().getCarById(1L);
        Assert.assertNotNull(car);
    }

    @Test
    public void createCommentTest() {

        Assert.assertTrue(CarService.getInstance().createComment("Hello", 2, 1));
    }

    @Test
    public void getAllCommentsByCarTest() {

        List<Comments> commentsList = CarService.getInstance().getAllCommentsByCar(1L);
        Assert.assertNotNull(commentsList);
        Assert.assertTrue(commentsList.size() > 0);

    }

//    @Test
//    public void deleteCarTest() {
//
//        Assert.assertTrue(CarService.getInstance().deleteCar(46L));
//
//    }
}
