package by.autobazar.services;

import by.autobazar.entity.Car;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Andrey
 * Date: 25.04.2017.
 * Time: 21:43
 */
public interface ICarService extends IService<Car> {

    long createCar(HashMap<String, String> parameters, long id);

    List<Car> getAll();

    List<Car> getLimitAmount();

    List<String> getCarsMakes();

    List<String> getAllCarsMakes();

    List<String> getAllCarsModels(String make);

    List<String> getCarsModels(String make);

    long getAmountOfCars(HashMap<String, String> searchMap);

    List<Car> searchCars(HashMap<String, String> searchMap, String order, int start, int amount);

    Car getCarById(Long id);

    void deleteCar(Long id);

    long updateCar(HashMap<String, String> parameters);

    void verifiedCar(long id, String verified);

    List<Car> getAllCars(String order, int start, int amount);
}
