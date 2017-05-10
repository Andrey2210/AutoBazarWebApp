package by.autobazar.dao;

import by.autobazar.entity.Car;

import java.util.HashMap;
import java.util.List;

/**
 * This interface defines special methods for working with the entity Car
 *
 */
public interface ICarDao extends Dao<Car> {

    /**
     * This method load all cars from database
     *
     * @return List of object-typed Car
     */
    List<Car> getAll();

    /**
     * This method load last added 4 cars
     *
     * @return List of object-typed Car
     */
    List<Car> getLimitAmount();

    /**
     * This method load cars makes
     *
     * @return List of String
     */
    List<String> getCarsMakes();

    /**
     * This method loads a list of models of a particular make
     *
     * @param make - Car make in String
     * @return List of string
     */
    List<String> getCarsModels(String make);

    /**
     * This method load all cars makes
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
     * This method search a Cars in the database according to the specified criteria
     *
     * @param search MAP with key fields for searching
     * @param order  String parameter accepting type of sorting
     * @param start  indicating the starting position in database
     * @param amount Indicates the number of Cars that will be listed in the list from the start position
     * @return List of object-typed Car
     */
    public List<Car> searchCars(HashMap<String, Object> search, String order, int start, int amount);

    /**
     * This method search a number of Cars that match the search parameters
     *
     * @param search Map with key fields for searching
     * @return Number of machines of long type
     */
    long getAmountOfCars(HashMap<String, Object> search);

    /**
     * This method loads a specified number of Cars from the database
     *
     * @param order  String parameter accepting type of sorting
     * @param start  indicating the starting position in database
     * @param amount Indicates the number of Cars that will be listed in the list from the start position
     * @return List of object-typed Car
     */
    List<Car> getAll(String order, int start, int amount);
}
