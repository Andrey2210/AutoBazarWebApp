package by.autobazar.services;

import by.autobazar.entity.Car;
import by.autobazar.entity.User;
import by.autobazar.entity.carEnum.Role;
import by.autobazar.util.HibernateUtil;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.jws.soap.SOAPBinding;
import java.util.List;

/**
 * Created by Andrey on 19.03.2017.
 */
public class UserServiceTest {
    private static User user;
    private static UserService userService = UserService.getInstance();

    @BeforeClass
    public static void setUser() {
        user = new User("Andrei", "Andrey@mail.ru", "12345", "Andrey", "333-66-66", Role.USER);
        AbstractService.session = HibernateUtil.getHibernateUtil().getSession();
    }

    @AfterClass
    public static void deleteCar() throws ServiceException {
        userService.deleteUser(user.getId());
        HibernateUtil.getHibernateUtil().closeSession(AbstractService.session);
    }

    @Test
    public void getAllTest() throws ServiceException {
        List<User> userList = userService.getAll();
        Assert.assertNotNull(userList);
        Assert.assertTrue(userList.size() > 0);
    }

    @Test
    public void createUserTest() throws ServiceException {
        userService.createUser(user);
        Assert.assertNotNull(user.getId());
    }

    @Test
    public void getLoggedUserTest() {
        Assert.assertNotNull(userService.getLoggedUser("ivan123", "12345"));
    }

    @Test
    public void getCarsByUserIdTest() {
        List<Car> carList = userService.getCarsByUserId(3L);
        Assert.assertNotNull(carList);
        Assert.assertTrue(carList.size() > 0);
    }

    @Test
    public void getUserByIdTest() {
        Assert.assertNotNull(userService.getUserById(3L));
    }
}
