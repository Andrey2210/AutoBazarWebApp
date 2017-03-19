package by.autobazar.services;

import by.autobazar.dao.DaoException;
import by.autobazar.entity.User;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Andrey on 19.03.2017.
 */
public class UserServiceTest {

    @Test
    public void createUserTest() {
        User user = new User(1,"ivan", "ivam@mail.ru", "123", "Ivan", "111-11-11", "user");
        Assert.assertNotNull(UserService.getInstance().createUser(user));
    }

    @Test
    public void getLoggedUserTest() {
        Assert.assertNotNull(UserService.getInstance().getLoggedUser("andrey2210", "12345"));
    }

    @Test
    public void deleteUserTest() {
        User user = UserService.getInstance().getLoggedUser("ivan", "123");
        Assert.assertTrue(UserService.getInstance().deleteUser(user));
    }
}
