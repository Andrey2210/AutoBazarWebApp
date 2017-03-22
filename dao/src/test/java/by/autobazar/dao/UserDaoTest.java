package by.autobazar.dao;

import by.autobazar.connection.DbConnection;
import by.autobazar.entity.User;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Andrey on 19.03.2017.
 */
public class UserDaoTest {

    @Test
    public void createTest() throws DaoException, SQLException {
        Connection connection = DbConnection.getConnection();
        UserDAO userDAO = new UserDAO(connection);
        User user = new User(1,"ivan", "ivam@mail.ru", "123", "Ivan", "111-11-11", "user");
        Assert.assertTrue(userDAO.create(user));
        connection.close();
    }

    @Test
    public void getLoggedUserTest() throws DaoException, SQLException {
        Connection connection = DbConnection.getConnection();
        UserDAO userDAO = new UserDAO(connection);
        User user =  userDAO.getLoggedUser("andrey2210", "12345");
        Assert.assertNotNull(user);
        connection.close();
    }

    @Test
    public void deleteTest() throws DaoException, SQLException {
        Connection connection = DbConnection.getConnection();
        UserDAO userDAO = new UserDAO(connection);
        User user =  userDAO.getLoggedUser("ivan", "123");
        Assert.assertTrue(userDAO.delete(user));
        connection.close();
    }

    @Test
    public void getByIdTest() throws DaoException, SQLException {
        Connection connection = DbConnection.getConnection();
        UserDAO userDAO = new UserDAO(connection);
        User user =  userDAO.getById(1);
        Assert.assertNotNull(user);
        connection.close();
    }

}
