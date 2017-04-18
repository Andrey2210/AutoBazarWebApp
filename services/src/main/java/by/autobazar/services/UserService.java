package by.autobazar.services;

import by.autobazar.dao.UserDao;
import by.autobazar.dao.exceptions.DaoException;
import by.autobazar.entity.Car;
import by.autobazar.entity.User;
import by.autobazar.util.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Transaction;

import javax.jws.soap.SOAPBinding;
import java.util.List;

/**
 * Created by Andrey on 19.03.2017.
 */
public class UserService extends AbstractService {

    private static final Logger log = Logger.getLogger(UserService.class);
    private static UserService INSTANCE = null;
    private UserDao userDao = UserDao.getInstance();
    private UserService() {
    }

    public static UserService getInstance() {
        if (INSTANCE == null) {
            synchronized (UserService.class) {
                if (INSTANCE == null) {
                    INSTANCE = new UserService();
                }
            }
        }
        return INSTANCE;
    }

    public List<User> getAll() throws ServiceException {
        log.info("Service getAll : ");
        userDao.session = session;
        Transaction transaction = getTransaction();

        List<User> userList = null;
        try {
            userList =  userDao.getAll();
            transaction.commit();
        } catch (DaoException | HibernateException e) {
            log.info("Error in service getAll(): " + e);
            transaction.rollback();
            throw new ServiceException("Error getting the list of users, try again later");
        }
            return userList;
    }

    public User createUser(User user) throws ServiceException {

        log.info("Service createUser : ");

        userDao.session = session;
        Transaction transaction = getTransaction();
        try {
            userDao.saveOrUpdate(user);
            transaction.commit();
        } catch (DaoException | HibernateException e) {
            log.info("Error in service createUser(): " + e);
            transaction.rollback();
            throw new ServiceException("Sorry, Registration failed, please try again later" + e);
        }
        return user;
    }

    public User getLoggedUser(String login, String password) {

        log.info("Service getLoggedUser : ");

        userDao.session = session;
        Transaction transaction = getTransaction();
        User loggedUser = null;
        try {
            loggedUser = userDao.getLoggedUser(login, password);
            transaction.commit();
        } catch (DaoException | HibernateException e) {
            log.info("Error in service getLoggedUser(): " + e);
            transaction.rollback();
        }
        return loggedUser;
    }

    public List<Car> getCarsByUserId(Long id) {
    User user = getUserById(id);
        List<Car> carList = user.getCarList();
        return  carList;
    }

    public User getUserById(Long id) {
        log.info("Service getUserById : ");

        userDao.session = session;
        Transaction transaction = getTransaction();
        User loggedUser = null;
        try {
            loggedUser = userDao.get(id);
            transaction.commit();
        } catch (DaoException | HibernateException e) {
            log.info("Error in service getUserById(): " + e);
            transaction.rollback();
        }
        return loggedUser;
    }

    public void deleteUser(Long id) throws ServiceException {

        log.info("Service deleteUser(): ");

        userDao.session = session;
        Transaction transaction = getTransaction();
        User user= null;
        try {
            user = userDao.get(id);
            transaction.commit();
            if(user != null) {
                transaction = getTransaction();
                userDao.delete(user);
                transaction.commit();
            }
        } catch (DaoException | HibernateException e) {
            log.info("Error in service deleteUser(): " + e);
            transaction.rollback();
            throw new ServiceException("User wasn't deleted, try again later");
        }
    }

    public User updateUser(User user) throws ServiceException {

        log.info("Service updateUser : ");

        userDao.session = session;
        Transaction transaction = getTransaction();
        try {
            userDao.saveOrUpdate(user);
            transaction.commit();
        } catch (DaoException | HibernateException e) {
            log.info("Error in service updateUser(): " + e);
            transaction.rollback();
            throw new ServiceException("Sorry, Updated failed, please try again later" + e);
        }
        return user;
    }
}
