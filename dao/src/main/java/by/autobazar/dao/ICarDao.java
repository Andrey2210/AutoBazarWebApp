package by.autobazar.dao;

import by.autobazar.entity.Car;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Andrey
 * Date: 25.04.2017.
 * Time: 20:14
 */
public interface ICarDao extends Dao<Car> {

    List<Car> getLimitAmount();

    List<String> getCarsMakes();

    List<String> getAllCarsMakes();

    List<String> getAllCarsModels(String make);

    List<String> getCarsModels(String make);

    long getAmountOfCars(HashMap<String, Object> searchMap);

    List<Car> searchCars(HashMap<String, Object> searchMap, String order, int start, int amount);

}
