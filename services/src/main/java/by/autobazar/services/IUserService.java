package by.autobazar.services;

import by.autobazar.entity.Car;
import by.autobazar.entity.User;

import java.util.List;

/**
 * Created by Andrey
 * Date: 25.04.2017.
 * Time: 22:26
 */
public interface IUserService extends IService<User> {

    List<User> getAll();

    User getLoggedUser(String login, String password);

    List<Car> getCarsByUserId(Long id);

    User createUser(User user) throws ServiceException;

    User findByUserName(String login);

    User getByEmail(String email);

    void updateUser(User user) throws ServiceException;


}