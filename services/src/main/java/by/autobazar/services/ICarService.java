package by.autobazar.services;

import by.autobazar.entity.Car;

import java.util.HashMap;
import java.util.List;

/**
 * This interface defines special methods for CarssService
 */
public interface ICarService extends IService<Car> {

    long createCar(HashMap<String, String> parameters, long id);

    /**
     * This method return all cars
     *
     * @return List of object-typed Car
     */
    List<Car> getAll();

    /**
     * This method return last added 4 cars
     *
     * @return List of object-typed Car
     */
    List<Car> getLimitAmount();

    /**
     * This method return list of cars manufactured, added users
     *
     * @return List of String
     */
    List<String> getCarsMakes();

    /**
     * This method return all of cars manufactured
     *
     * @return List of String
     */
    List<String> getAllCarsMakes();

    /**
     * This method loads a list of models of a particular make
     *
     * @param make - Car make in String
     * @return List of string
     */
    List<String> getAllCarsModels(String make);

    /**
     * This method loads a list of models of a particular make
     *
     * @param make - Car make in String
     * @return List of string
     */
    List<String> getCarsModels(String make);

    /**
     * This method define actions before getting the number of cars by parameters
     *
     * @param searchMap Map with key fields for searching
     * @return Number of machines of long type
     */
    long getAmountOfCars(HashMap<String, String> searchMap);

    /**
     * This method will return a list of Cars that will be found by the given parameters
     *
     * @param searchMap MAP with key fields for searching
     * @param order     String parameter accepting type of sorting
     * @param start     indicating the starting position in database
     * @param amount    Indicates the number of Cars that will be listed in the list from the start position
     * @return List of object-typed Car
     */
    List<Car> searchCars(HashMap<String, String> searchMap, String order, int start, int amount);

    /**
     * This Method allows to update the state of the Car
     *
     * @param id       serial number of the cars entity in the database
     * @param verified String parameter accepting cars state
     */
    void verifiedCar(long id, String verified);

    /**
     * This method loads a specified number of Cars
     *
     * @param order  String parameter accepting type of sorting
     * @param start  indicating the starting position in database
     * @param amount Indicates the number of Cars that will be listed in the list from the start position
     * @return List of object-typed Car
     */
    List<Car> getAllCars(String order, int start, int amount);

    Car getCarById(Long id);

    void deleteCar(Long id);

    long updateCar(HashMap<String, String> parameters);
}
