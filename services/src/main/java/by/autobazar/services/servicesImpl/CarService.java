package by.autobazar.services.servicesImpl;

import by.autobazar.dao.daoImp.CarDao;
import by.autobazar.dao.ICarDao;
import by.autobazar.entity.*;
import by.autobazar.entity.carEnum.*;
import by.autobazar.services.ICarService;
import by.autobazar.services.IUserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

@Service
public class CarService extends BaseService<Car> implements ICarService {

    private static final Logger log = Logger.getLogger(CarService.class);
    private IUserService userService;

    @Autowired
    private CarService(ICarDao carDao, IUserService userService) {
        super(carDao);
        this.userService = userService;
    }

    public long createCar(HashMap<String, String> parameters, long id) {
        log.info("Service createCar(): ");
        User user = ((IUserService) userService).getUserById(id);

        Car car = new Car();
        car.setMark(parameters.get("mark"));
        car.setModel(parameters.get("model"));
        car.setPrice(Integer.parseInt(parameters.get("price")));
        car.setYear(parameters.get("year"));
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
        baseDao.saveOrUpdate(car);
        return car.getId();
    }

    public List<Car> getAll() {
        log.info("Service getAll(): ");
        List<Car> carsList = null;
        carsList = ((ICarDao) baseDao).getAll();
        return carsList;
    }

    public List<Car> getLimitAmount() {
        log.info("Service getLimitAmount(): ");
        List<Car> carsList = null;
        carsList = ((ICarDao) baseDao).getLimitAmount();
        return carsList;
    }

    public List<String> getCarsMakes() {
        log.info("Service getCarsMakes(): ");
        List<String> makesList = null;
        makesList = ((ICarDao) baseDao).getCarsMakes();
        return makesList;
    }

    public List<String> getAllCarsMakes() {
        log.info("Service getCarsMakes(): ");
        List<String> makesList = null;
        makesList = ((ICarDao) baseDao).getAllCarsMakes();
        return makesList;
    }

    public List<String> getAllCarsModels(String make) {
        log.info("Service getAllCarsModels(): ");
        List<String> modelsList = null;
        modelsList = ((ICarDao) baseDao).getAllCarsModels(make);
        return modelsList;
    }

    public List<String> getCarsModels(String make) {
        log.info("Service getCarsModels(): ");
        List<String> modelsList = null;
        modelsList = ((ICarDao) baseDao).getCarsModels(make);
        return modelsList;
    }

    public long getAmountOfCars(HashMap<String, String> searchMap) {
        log.info("Service getAmountOfCars(): ");
        long result = 0;
        verificationsParameters(searchMap);
        result = ((ICarDao) baseDao).getAmountOfCars(parseParameters(searchMap));
        return result;
    }

    public List<Car> searchCars(HashMap<String, String> searchMap, String order, int start, int amount) {
        log.info("Service searchCars : ");
        List<Car> carList = null;
        verificationsParameters(searchMap);
        carList = ((ICarDao) baseDao).searchCars(parseParameters(searchMap), order, start, amount);
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
        Car car = get(id);
        return car;
    }

    public void deleteCar(Long id) {
        log.info("Service getCarById(): ");
        Car car = get(id);
        if (car != null) {
            baseDao.delete(car);
        }
    }

    public long updateCar(HashMap<String, String> parameters) {
        log.info("Service updateCar(): ");

        Car car = getCarById(Long.parseLong(parameters.get("carId")));
        car.setPrice(Integer.parseInt(parameters.get("price")));
        car.setYear(parameters.get("year"));
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

        baseDao.saveOrUpdate(car);
        return car.getId();
    }

    public void verifiedCar(long id, String verified) {
        log.info("Service verifiedCar(): ");
        Car car = getCarById(id);
        car.setVerified(Boolean.parseBoolean(verified));
        baseDao.saveOrUpdate(car);
    }

    public List<Car> getAllCars(String order, int start, int amount) {
        log.info("Service getAllCars : ");
        List<Car> carList = null;
        carList = ((ICarDao) baseDao).getAll(order, start, amount);
        return carList;
    }
}
