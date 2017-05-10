package by.autobazar.services;

import by.autobazar.dao.IUserDao;
import by.autobazar.entity.Car;
import by.autobazar.entity.User;
import by.autobazar.entity.carEnum.Role;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@ContextConfiguration(locations = {"classpath:test-service.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class UserServiceTest {
    @Autowired
    private IUserService userService;

    @Test
    public void getAllTest() throws ServiceException {
        List<User> userList = userService.getAll();
        Assert.assertNotNull(userList);
        Assert.assertTrue(userList.size() > 0);
    }

    @Test
    public void createUserTest() throws ServiceException {
        User user = new User("Andrei", "Andrey@mail.ru", "12345", "Andrey", "333-66-66", Role.USER);
        userService.createUser(user);
        Assert.assertTrue(user.getId() != 0);
        user.setName("Misha");
        userService.updateUser(user);
        Assert.assertNotNull(userService.getUserById(user.getId()));
        userService.delete(user);
    }

    @Test
    public void getLoggedUserTest() {
        Assert.assertNotNull(userService.findByUserName("ffffff"));
        Assert.assertNotNull(userService.getByEmail("ffffff@mmmm"));
    }

    @Test
    public void getCarsByUserIdTest() {
        List<Car> carList = userService.getCarsByUserId(503L);
        Assert.assertNotNull(carList);
        Assert.assertTrue(carList.size() > 0);
    }
}
