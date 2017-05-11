package by.autobazar.dao;

import by.autobazar.entity.User;

import java.util.List;

/**
 * This interface defines special methods for working with the entity User
 *
 */
public interface IUserDao extends Dao<User> {

    /**
     * This method load User by his login and password
     *
     * @param login    Users login in String
     * @param password Users password
     * @return Object of User appropriate
     */
    User getLoggedUser(String login, String password);

    /**
     * This method loads all Users from the database
     *
     * @return List of object-typed User
     */
    List<User> getAll();

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

    }

