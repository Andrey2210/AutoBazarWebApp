package by.autobazar.services;

import by.autobazar.entity.Car;
import by.autobazar.entity.User;

import java.util.List;

/**
 * This class contains special methods for working with the entity User
 *
 */
public interface IUserService extends IService<User> {

    /**
     * This method loads all Users
     *
     * @return List of object-typed User
     */
    List<User> getAll();

    /**
     * This method load User by his login and password
     *
     * @param login    Users login in String
     * @param password Users password
     * @return Object of User appropriate
     */
    User getLoggedUser(String login, String password);

    /**
     * This method returns the list of Cars by the specified user
     *
     * @param id    Users id
     * @return List of object-typed Car
     */
    List<Car> getCarsByUserId(Long id);

    /**
     * This method create new users
     *
     * @param user User's object that will be created
     */
    User createUser(User user) throws ServiceException;

    /**
     * This method load User by his login
     *
     * @param login    Users login in String
     * @return Object of User appropriate
     */
    User findByUserName(String login);

    /**
     * This method load User by his email
     *
     * @param email    Users email in String
     * @return Object of User appropriate
     */
    User getByEmail(String email);

    /**
     * The method updates the changed fields of User's object
     *
     * @param user modified User's object
     */
    void updateUser(User user) throws ServiceException;

    User getUserById(Long id);

    void deleteUser(Long id) throws ServiceException;


}