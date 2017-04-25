package by.autobazar.dao;

import by.autobazar.entity.*;
import by.autobazar.entity.carEnum.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@ContextConfiguration(locations = {"classpath:test-dao.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class CarDaoTest {

    @Autowired
    private ICarDao<Car> carDao;

    @Test
    public void get() {
        Car car = new Car("Bmw", "X5", 10000, LocalDate.now(), Transmission.AUTOMATIC, BodyType.SUV, "good car",
                CarCondition.USED, 150000, 5, FuelType.PETROL, 5.5, WheelDriving.AWD, CarColor.BLACK,
                InteriorMaterial.ALCANTARA, InteriorColor.BLACK, "Minsk", "Minsk", false);
        carDao.saveOrUpdate(car);
        Assert.assertNotNull(car.getId());
        Car getCar = (Car) carDao.load(Car.class, 1L);
        Assert.assertNotNull(getCar);
    }
}
