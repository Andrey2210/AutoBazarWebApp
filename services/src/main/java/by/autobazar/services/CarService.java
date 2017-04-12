package by.autobazar.services;

import by.autobazar.dao.CarDao;
import by.autobazar.dao.exceptions.DaoException;
import by.autobazar.entity.*;
import by.autobazar.entity.carEnum.*;
import by.autobazar.util.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Transaction;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Andrey on 13.03.2017.
 */
public class CarService extends AbstractService {

    private static final Logger log = Logger.getLogger(CarService.class);
    private static CarService INSTANCE = null;
    private CarDao carDao = CarDao.getInstance();

    private CarService() {
    }

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

    public long createCar(HashMap<String, String> parameters, long id) throws ServiceException {
        log.info("Service createCar(): ");

        carDao.session = session;
        User user = UserService.getInstance().getUserById(id);

        Car car = new Car();
        car.setMark(parameters.get("mark"));
        car.setModel(parameters.get("model"));
        car.setPrice(Integer.parseInt(parameters.get("price")));
        car.setYear(LocalDate.of(Integer.parseInt(parameters.get("year")), 1, 1));
        car.setTransmission(Transmission.valueOf(parameters.get("transmission")));
        car.setBodyType(BodyType.valueOf(parameters.get("bodyType")));
        car.setDescription(parameters.get("description"));
        car.setCarCondition(CarCondition.valueOf(parameters.get("carCondition")));
        car.setMilleage(Integer.parseInt(parameters.get("milleage")));
        car.setDoorsNumber(Integer.parseInt(parameters.get("doorsNumber")));
        car.setFuelType(FuelType.valueOf(parameters.get("fuelType")));
        car.setEngineCapacity(Double.parseDouble(parameters.get("engineCapacity")));
        car.setDriving(WheelDriving.valueOf(parameters.get("driving")));
        car.setCarColor(CarColor.valueOf(parameters.get("carColor")));
        car.setInteriorMaterial(InteriorMaterial.valueOf(parameters.get("interiorMaterial")));
        car.setInteriorColor(InteriorColor.valueOf(parameters.get("interiorColor")));
        car.setRegion(parameters.get("region"));
        car.setCity(parameters.get("city"));
        car.setVerified(false);

        Image image = new Image(parameters.get("image"), "main");
        image.setCar(car);
        car.getImageList().add(image);
        car.setUser(user);
        Transaction transaction = getTransaction();
        try {
            carDao.saveOrUpdate(car);
            transaction.commit();
        } catch (DaoException | HibernateException e) {
            log.info("Error in service createCar(): " + e);
            transaction.rollback();
            throw new ServiceException("Sorry, ad wasn't created, please try again later" + e);
        }
        return car.getId();
    }

    public List<Car> getLimitAmount() {
        log.info("Service getLimitAmount(): ");
        carDao.session = session;
        Transaction transaction = getTransaction();
        List<Car> carsList = null;
        try {
            carsList = carDao.getLimitAmount();
            transaction.commit();
        } catch (DaoException | HibernateException e) {
            log.info("Error in service getLimitAmount(): " + e);
            transaction.rollback();
        }
        return carsList;
    }

    public List<String> getCarsMakes() {
        log.info("Service getCarsMakes(): ");

        carDao.session = session;
        Transaction transaction = getTransaction();
        List<String> makesList = null;
        try {
            makesList = carDao.getCarsMakes();
            transaction.commit();
        } catch (DaoException | HibernateException e) {
            log.info("Error in service getCarsMakes(): " + e);
            transaction.rollback();
        }
        return makesList;
    }

    public List<String> getAllCarsMakes() {
        log.info("Service getCarsMakes(): ");

        carDao.session = session;
        Transaction transaction = getTransaction();
        List<String> makesList = null;
        try {
            makesList = carDao.getAllCarsMakes();
            transaction.commit();
        } catch (DaoException | HibernateException e) {
            log.info("Error in service getAllCarsMakes(): " + e);
            transaction.rollback();
        }
        return makesList;
    }

    public List<String> getAllCarsModels(String make) {
        log.info("Service getAllCarsModels(): ");

        carDao.session = session;
        Transaction transaction = getTransaction();
        List<String> modelsList = null;
        try {
            modelsList = carDao.getAllCarsModels(make);
            transaction.commit();
        } catch (DaoException | HibernateException e) {
            log.info("Error in service getAllCarsModels(): " + e);
            transaction.rollback();
        }
        return modelsList;
    }

    public List<String> getCarsModels(String make) {
        log.info("Service getCarsModels(): ");

        carDao.session = session;
        Transaction transaction = getTransaction();
        List<String> modelsList = null;
        try {
            modelsList = carDao.getCarsModels(make);
            transaction.commit();
        } catch (DaoException | HibernateException e) {
            log.info("Error in service getCarsModels(): " + e);
            transaction.rollback();
        }
        return modelsList;
    }

    public long getAmountOfCars(HashMap<String, String> searchMap) {

        log.info("Service getAmountOfCars(): ");

        carDao.session = session;
        Transaction transaction = getTransaction();
        long result = 0;
        verificationsParameters(searchMap);
        try {
            result = carDao.getAmountOfCars(parseParameters(searchMap));
            transaction.commit();
        } catch (DaoException | HibernateException e) {
            log.info("Error in service getAmountOfCars(): " + e);
            transaction.rollback();
        }
        return result;
    }

    public List<Car> searchCars(HashMap<String, String> searchMap, String order, int start, int amount) {

        log.info("Service searchCars : ");

        carDao.session = session;
        Transaction transaction = getTransaction();
        List<Car> carList = null;
        verificationsParameters(searchMap);
        try {
            carList = carDao.searchCars(parseParameters(searchMap), order, start, amount);
            transaction.commit();
        } catch (DaoException | HibernateException e) {
            log.info("Error in service searchCars(): " + e);
            transaction.rollback();
        }
        return carList;
    }

    private void verificationsParameters(HashMap<String, String> searchParameters) {

        int minPrice = Integer.parseInt(searchParameters.get("minPrice"));
        int maxPrice = Integer.parseInt(searchParameters.get("maxPrice"));

        searchParameters.replace("minPrice", String.valueOf(minPrice), String.valueOf(Math.min(minPrice, maxPrice)));
        searchParameters.replace("maxPrice", String.valueOf(maxPrice), String.valueOf(Math.max(minPrice, maxPrice)));

    }

    private HashMap<String, Object> parseParameters(HashMap<String, String> params) {
        Iterator iterator = params.keySet().iterator();
        HashMap<String, Object> hashMap = new HashMap<>();
        while (iterator.hasNext()) {
            String param = (String) iterator.next();
            switch (param) {
                case "transmission":
                    hashMap.put(param, Transmission.valueOf(params.get(param)));
                    break;
                case "carCondition":
                    hashMap.put(param, CarCondition.valueOf(params.get(param)));
                    break;
                case "bodyType":
                    hashMap.put(param, BodyType.valueOf(params.get(param)));
                    break;
                case "fuelType":
                    hashMap.put(param, FuelType.valueOf(params.get(param)));
                    break;
                case "driving":
                    hashMap.put(param, WheelDriving.valueOf(params.get(param)));
                    break;
                default:
                    hashMap.put(param, params.get(param));
            }
        }
        return hashMap;
    }

    public Car getCarById(Long id) {

        log.info("Service getCarById(): ");

        carDao.session = session;
        Transaction transaction = getTransaction();
        Car car = null;
        try {
            car = carDao.get(id);
            session.refresh(car);
            transaction.commit();
        } catch (DaoException | HibernateException e) {
            log.info("Error in service getCarById(): " + e);
            transaction.rollback();
        }
        return car;
    }

    public void deleteCar(Long id) {

        log.info("Service getCarById(): ");

        carDao.session = session;
        Transaction transaction = getTransaction();
        Car car = null;
        try {
            car = carDao.get(id);
            transaction.commit();
            if (car != null) {
                transaction = getTransaction();
                carDao.delete(car);
                transaction.commit();
            }
        } catch (DaoException | HibernateException e) {
            log.info("Error in service deleteCar(): " + e);
            transaction.rollback();
        }
    }

    public long updateCar(HashMap<String, String> parameters) throws ServiceException {
        log.info("Service updateCar(): ");

        carDao.session = session;
        Car car = getCarById(Long.parseLong(parameters.get("carId")));
        car.setPrice(Integer.parseInt(parameters.get("price")));
        car.setYear(LocalDate.of(Integer.parseInt(parameters.get("year")), 1, 1));
        car.setTransmission(Transmission.valueOf(parameters.get("transmission")));
        car.setBodyType(BodyType.valueOf(parameters.get("bodyType")));
        car.setDescription(parameters.get("description"));
        car.setCarCondition(CarCondition.valueOf(parameters.get("carCondition")));
        car.setMilleage(Integer.parseInt(parameters.get("milleage")));
        car.setDoorsNumber(Integer.parseInt(parameters.get("doorsNumber")));
        car.setFuelType(FuelType.valueOf(parameters.get("fuelType")));
        car.setEngineCapacity(Double.parseDouble(parameters.get("engineCapacity")));
        car.setDriving(WheelDriving.valueOf(parameters.get("driving")));
        car.setCarColor(CarColor.valueOf(parameters.get("carColor")));
        car.setInteriorMaterial(InteriorMaterial.valueOf(parameters.get("interiorMaterial")));
        car.setInteriorColor(InteriorColor.valueOf(parameters.get("interiorColor")));
        car.setRegion(parameters.get("region"));
        car.setCity(parameters.get("city"));

        Transaction transaction = getTransaction();
        try {
            carDao.saveOrUpdate(car);
            transaction.commit();
        } catch (DaoException | HibernateException e) {
            log.info("Error in service updateCar(): " + e);
            transaction.rollback();
            throw new ServiceException("Sorry, update failed, please try again later" + e);
        }
        return car.getId();
    }

    public void verifiedCar(long id, String verified) {
        log.info("Service verifiedCar(): ");

        carDao.session = session;
        Car car = getCarById(id);
        car.setVerified(Boolean.parseBoolean(verified));
        Transaction transaction = getTransaction();
        try {
            carDao.saveOrUpdate(car);
            transaction.commit();
        } catch (DaoException | HibernateException e) {
            log.info("Error in service updateCar(): " + e);
            transaction.rollback();
        }
    }

    public List<Car> getAllCars(String order, int start, int amount) {

        log.info("Service getAllCars : ");

        carDao.session = session;
        Transaction transaction = getTransaction();
        List<Car> carList = null;
        try {
            carList = carDao.getAll(order, start, amount);
            transaction.commit();
        } catch (DaoException | HibernateException e) {
            log.info("Error in service getAllCars(): " + e);
            transaction.rollback();
        }
        return carList;
    }
}
