package by.autobazar.dao;

import by.autobazar.connection.DbConnection;
import by.autobazar.entity.User;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Andrey on 19.03.2017.
 */
public class UserDaoTest {

    @Test
    public void createTest() throws DaoException {
        UserDAO userDAO = new UserDAO(DbConnection.getConnection());
        User user = new User(1,"ivan", "ivam@mail.ru", "123", "Ivan", "111-11-11", "user");
        Assert.assertTrue(userDAO.create(user));
    }

    @Test
    public void getLoggedUserTest() throws DaoException {
        UserDAO userDAO = new UserDAO(DbConnection.getConnection());
        User user =  userDAO.getLoggedUser("andrey2210", "12345");
        Assert.assertNotNull(user);
    }

    @Test
    public void deleteTest() throws DaoException {
        UserDAO userDAO = new UserDAO(DbConnection.getConnection());
        User user =  userDAO.getLoggedUser("ivan", "123");
        Assert.assertTrue(userDAO.delete(user));
    }

    @Test
    public void getByIdTest() throws DaoException {
        UserDAO userDAO = new UserDAO(DbConnection.getConnection());
        User user =  userDAO.getById(1);
        Assert.assertNotNull(user);
    }

}
