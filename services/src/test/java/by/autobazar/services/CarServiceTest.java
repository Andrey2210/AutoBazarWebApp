package by.autobazar.services;

import by.autobazar.entity.Car;
import org.junit.Assert;
import org.junit.Test;

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
    public void getCarsMakesTest() {

        List<String> makesList = CarService.getInstance().getCarsMakes();
        Assert.assertNotNull(makesList);
        Assert.assertTrue(makesList.size() > 0);
    }
}
