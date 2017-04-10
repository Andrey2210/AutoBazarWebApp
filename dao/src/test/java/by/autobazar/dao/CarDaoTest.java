package by.autobazar.dao;

import by.autobazar.dao.exceptions.DaoException;
import by.autobazar.entity.*;
import by.autobazar.entity.carEnum.*;
import by.autobazar.util.HibernateUtil;
import org.hibernate.Transaction;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.time.LocalDate;

/**
 * Created by Andrey on 16.03.2017.
 */
public class CarDaoTest {
    private static Car car = null;
    private static CarDao carDao = CarDao.getInstance();
    private Transaction transaction = null;

    @BeforeClass
    public static void setCar() {
        car = new Car("Bmw", "X5", 10000, LocalDate.now(), Transmission.AUTOMATIC, BodyType.SUV, "good car",
                CarCondition.USED, 150000, 5, FuelType.PETROL, 5.5, WheelDriving.AWD, CarColor.BLACK,
                InteriorMaterial.ALCANTARA, InteriorColor.BLACK, "Minsk", "Minsk", false);
        carDao.session = HibernateUtil.getHibernateUtil().getSession();
    }

    @AfterClass
    public static void deleteCar() throws DaoException {
        Transaction transactionl = carDao.session.beginTransaction();
        carDao.delete(car);
        transactionl.commit();
        carDao.session.close();
    }

    @Test
    public void saveOrUpdateTest() throws DaoException {
        transaction = carDao.session.beginTransaction();
        carDao.saveOrUpdate(car);
        transaction.commit();
        Assert.assertNotNull(car.getId());

    }

    @Test
    public void getCarTest() throws DaoException {
        transaction = carDao.session.beginTransaction();
        Car getCar = carDao.get(car.getId());
        transaction.commit();
        Assert.assertNotNull(getCar);
    }

    @Test
    public void loadCarTest() throws DaoException {
        transaction = carDao.session.beginTransaction();
        Car loadCar = carDao.load(car.getId());
        transaction.commit();
        Assert.assertNotNull(loadCar);
    }

}
