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
        try {
            session.beginTransaction();
            carDao.saveOrUpdate(car);
            session.getTransaction().commit();
        } catch (DaoException | HibernateException e) {
            log.info("Error in service createCar(): " + e);
            session.getTransaction().rollback();
            throw new ServiceException("Sorry, ad wasn't created, please try again later" + e);
        }
        return car.getId();
    }

    public List<Car> getLimitAmount() {
        log.info("Service getLimitAmount(): ");
        carDao.session = session;
        List<Car> carsList = null;
        try {
            session.beginTransaction();
            carsList = carDao.getLimitAmount();
            session.getTransaction().commit();
        } catch (DaoException | HibernateException e) {
            log.info("Error in service getLimitAmount(): " + e);
            session.getTransaction().rollback();
        }
        return carsList;
    }

    public List<String> getCarsMakes() {
        log.info("Service getCarsMakes(): ");

        carDao.session = session;
        List<String> makesList = null;
        try {
            session.beginTransaction();
            makesList = carDao.getCarsMakes();
            session.getTransaction().commit();
        } catch (DaoException | HibernateException e) {
            log.info("Error in service getCarsMakes(): " + e);
            session.getTransaction().rollback();
        }
        return makesList;
    }

    public List<String> getAllCarsMakes() {
        log.info("Service getCarsMakes(): ");

        carDao.session = session;
        List<String> makesList = null;
        try {
            session.beginTransaction();
            makesList = carDao.getAllCarsMakes();
            session.getTransaction().commit();
        } catch (DaoException | HibernateException e) {
            log.info("Error in service getAllCarsMakes(): " + e);
            session.getTransaction().rollback();
        }
        return makesList;
    }

    public List<String> getAllCarsModels(String make) {
        log.info("Service getAllCarsModels(): ");

        carDao.session = session;
        List<String> modelsList = null;
        try {
            session.beginTransaction();
            modelsList = carDao.getAllCarsModels(make);
            session.getTransaction().commit();
        } catch (DaoException | HibernateException e) {
            log.info("Error in service getAllCarsModels(): " + e);
            session.getTransaction().rollback();
        }
        return modelsList;
    }

    public List<String> getCarsModels(String make) {
        log.info("Service getCarsModels(): ");

        carDao.session = session;
        List<String> modelsList = null;
        try {
            session.beginTransaction();
            modelsList = carDao.getCarsModels(make);
            session.getTransaction().commit();
        } catch (DaoException | HibernateException e) {
            log.info("Error in service getCarsModels(): " + e);
            session.getTransaction().rollback();
        }
        return modelsList;
    }

    public long getAmountOfCars(HashMap<String, String> searchMap) {

        log.info("Service getAmountOfCars(): ");

        carDao.session = session;
        long result = 0;
        verificationsParameters(searchMap);
        try {
            session.beginTransaction();
            result = carDao.getAmountOfCars(parseParameters(searchMap));
            session.getTransaction().commit();
        } catch (DaoException | HibernateException e) {
            log.info("Error in service getAmountOfCars(): " + e);
            session.getTransaction().rollback();
        }
        return result;
    }

    public List<Car> searchCars(HashMap<String, String> searchMap, String order, int start, int amount) {

        log.info("Service searchCars : ");

        carDao.session = session;
        List<Car> carList = null;
        verificationsParameters(searchMap);
        try {
            session.beginTransaction();
            carList = carDao.searchCars(parseParameters(searchMap), order, start, amount);
            session.getTransaction().commit();
        } catch (DaoException | HibernateException e) {
            log.info("Error in service searchCars(): " + e);
            session.getTransaction().rollback();
        }
        return carList;
    }

    private void verificationsParameters(HashMap<String, String> searchParameters) {

        int minPrice = Integer.parseInt(searchParameters.get("minPrice"));
        int maxPrice = Integer.parseInt(searchParameters.get("maxPrice"));

        if (minPrice != 0 && maxPrice != 0) {
            searchParameters.replace("minPrice", String.valueOf(minPrice), String.valueOf(Math.min(minPrice, maxPrice)));
            searchParameters.replace("maxPrice", String.valueOf(maxPrice), String.valueOf(Math.max(minPrice, maxPrice)));
        }
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
        Car car = null;
        try {
            session.beginTransaction();
            car = carDao.get(id);
            session.refresh(car);
            session.getTransaction().commit();
        } catch (DaoException | HibernateException e) {
            log.info("Error in service getCarById(): " + e);
            session.getTransaction().rollback();
        }
        return car;
    }

    public void deleteCar(Long id) {

        log.info("Service getCarById(): ");

        carDao.session = session;
        Car car = null;
        try {
            session.beginTransaction();
            car = carDao.get(id);
            session.getTransaction().commit();
            if (car != null) {
                session.beginTransaction();
                carDao.delete(car);
                session.getTransaction().commit();
            }
        } catch (DaoException | HibernateException e) {
            log.info("Error in service deleteCar(): " + e);
            session.getTransaction().rollback();
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

        try {
            session.beginTransaction();
            carDao.saveOrUpdate(car);
            session.getTransaction().commit();
        } catch (DaoException | HibernateException e) {
            log.info("Error in service updateCar(): " + e);
            session.getTransaction().rollback();
            throw new ServiceException("Sorry, update failed, please try again later" + e);
        }
        return car.getId();
    }

    public void verifiedCar(long id, String verified) {
        log.info("Service verifiedCar(): ");

        carDao.session = session;
        Car car = getCarById(id);
        car.setVerified(Boolean.parseBoolean(verified));
        try {
            session.beginTransaction();
            carDao.saveOrUpdate(car);
            session.getTransaction().commit();
        } catch (DaoException | HibernateException e) {
            log.info("Error in service updateCar(): " + e);
            session.getTransaction().rollback();
        }
    }

    public List<Car> getAllCars(String order, int start, int amount) {

        log.info("Service getAllCars : ");

        carDao.session = session;
        List<Car> carList = null;
        try {
            session.beginTransaction();
            carList = carDao.getAll(order, start, amount);
            session.getTransaction().commit();
        } catch (DaoException | HibernateException e) {
            log.info("Error in service getAllCars(): " + e);
            session.getTransaction().rollback();
        }
        return carList;
    }
}
