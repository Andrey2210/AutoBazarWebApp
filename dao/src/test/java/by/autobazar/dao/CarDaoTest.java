package by.autobazar.dao;

import by.autobazar.entity.Car;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Created by Andrey on 16.03.2017.
 */
public class CarDaoTest {

    @Test
    public void getAllTest() {
        List<Car> cars =  CarDAO.getInstance().getAll();
        Assert.assertEquals("ff", 13 , cars.size());
    }
}
