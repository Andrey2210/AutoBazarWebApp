package by.autobazar.services;

import by.autobazar.dao.CarDAO;
import by.autobazar.entity.Car;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Andrey on 13.03.2017.
 */
public class CarService {
    private static CarService INSTANCE = null;

    private CarService() {}

    public static CarService getInstance() {
        if (INSTANCE == null) {
            synchronized (CarService.class) {
                if (INSTANCE == null) {
                    INSTANCE = new CarService();
                }
            }
        }
        return INSTANCE;
    }

    public List<Car> getLimitAmount() {
        List<Car> carsList = new CarDAO().getLimitAmount();
        return carsList;
    }

}
