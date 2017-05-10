package by.autobazar.dao;

import by.autobazar.entity.User;

import java.util.List;

/**
 * Created by Andrey
 * Date: 25.04.2017.
 * Time: 21:22
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

    User findByUserName(String login);

    User getByEmail(String email);

    }

