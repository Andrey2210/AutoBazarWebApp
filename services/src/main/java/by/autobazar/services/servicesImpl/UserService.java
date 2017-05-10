package by.autobazar.services.servicesImpl;

import by.autobazar.dao.IUserDao;
import by.autobazar.dao.daoImp.UserDao;
import by.autobazar.entity.Car;
import by.autobazar.entity.User;
import by.autobazar.entity.carEnum.Role;
import by.autobazar.services.IUserService;
import by.autobazar.services.ServiceException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService extends BaseService<User> implements IUserService {

    private static final Logger log = Logger.getLogger(UserService.class);

    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserService(IUserDao userDao, BCryptPasswordEncoder passwordEncoder) {
        super(userDao);
        this.passwordEncoder = passwordEncoder;
    }

    public List<User> getAll() {
        log.info("Service getAll : ");
        List<User> userList = null;
        userList = ((IUserDao) baseDao).getAll();
        return userList;
    }

    public User createUser(User user) throws ServiceException {
        log.info("Service createUser : ");
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(Role.USER);
        baseDao.saveOrUpdate(user);
        return user;
    }

    public void updateUser(User user) throws ServiceException {
        log.info("Service updateUser : ");
        baseDao.saveOrUpdate(user);
    }

    public User getLoggedUser(String login, String password) {
        log.info("Service getLoggedUser : ");
        User loggedUser = ((IUserDao) baseDao).getLoggedUser(login, password);
        return loggedUser;
    }

    public List<Car> getCarsByUserId(Long id) {
        User user = getUserById(id);
        List<Car> carList = user.getCarList();
        return carList;
    }

    public User getUserById(Long id) {
        log.info("Service getUserById : ");
        User loggedUser = get(id);
        return loggedUser;
    }

    public void deleteUser(Long id) throws ServiceException {
        log.info("Service deleteUser(): ");
        User user = null;
        user = get(id);
        if (user != null) {
            baseDao.delete(user);
        }
    }

    public User findByUserName(String login) {
        log.info("Service findByUserName : ");
        return ((IUserDao) baseDao).findByUserName(login);
    }

    public User getByEmail(String email) {
        log.info("Service getByEmail : ");
        return ((IUserDao) baseDao).getByEmail(email);
    }

}
