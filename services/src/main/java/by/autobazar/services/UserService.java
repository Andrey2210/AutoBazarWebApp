package by.autobazar.services;

import by.autobazar.dao.UserDao;
import by.autobazar.dao.exceptions.DaoException;
import by.autobazar.entity.Car;
import by.autobazar.entity.User;
import by.autobazar.util.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.jws.soap.SOAPBinding;
import java.util.List;


@Repository
public class UserService extends BaseService<User> {

    private static final Logger log = Logger.getLogger(UserService.class);

    @Autowired
    private UserService(UserDao userDao) {
        super(userDao);
    }

    public List<User> getAll() throws ServiceException {
        log.info("Service getAll : ");

        List<User> userList = null;
        userList = ((UserDao) baseDao).getAll();
        return userList;
    }

    public User createUser(User user) throws ServiceException {
        log.info("Service createUser : ");
        baseDao.saveOrUpdate(user);
        return user;
    }

    public User getLoggedUser(String login, String password) {
        log.info("Service getLoggedUser : ");
        User loggedUser = ((UserDao) baseDao).getLoggedUser(login, password);
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

    public User updateUser(User user) throws ServiceException {
        log.info("Service updateUser : ");
        baseDao.saveOrUpdate(user);
        return user;
    }
}
