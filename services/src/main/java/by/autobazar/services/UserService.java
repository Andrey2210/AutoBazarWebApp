package by.autobazar.services;

import by.autobazar.connection.DbConnection;
import by.autobazar.dao.DaoException;
import by.autobazar.dao.UserDAO;
import by.autobazar.entity.User;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Andrey on 19.03.2017.
 */
public class UserService {

    private static final Logger log = Logger.getLogger(UserService.class);

    private static UserService INSTANCE = null;

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

    public User createUser(User user) {

        log.info("Service createUser : ");

        if (user == null) {
            log.info("Not valid parameters, user wasn't created : ");
            return null;
        }

        Connection connection = DbConnection.getConnection();
        User loggedUser = null;
        try {
            assert connection != null;
            connection.setAutoCommit(false);
            UserDAO userDAO = new UserDAO(connection);
            userDAO.create(user);
            loggedUser = userDAO.getLoggedUser(user.getLogin(), user.getPassword());
            connection.commit();
        } catch (SQLException e) {
            log.error("Service createUser wasn't executed: not connection" + e);
        } catch (DaoException e) {
            log.error("Service createUser wasn't executed: " + e);
        }
        return loggedUser;
    }

    public User getLoggedUser(String login, String password) {


        log.info("Service getLoggedUser : ");
        if (login == null || password == null) {
            log.info("Not valid parameters : ");
            return null;
        }

        Connection connection = DbConnection.getConnection();
        UserDAO userDAO = new UserDAO(connection);
        User user = null;
        try {
            user = userDAO.getLoggedUser(login, password);
        } catch (DaoException e) {
            log.error("Service getLoggedUser wasn't executed: " + e);
        }
        return user;
    }

    public boolean deleteUser(User user) {

        log.info("Service deleteUser : ");

        if (user == null) {
            log.info("Not valid parameters, user wasn't created : ");
            return false;
        }

        Connection connection = DbConnection.getConnection();
        UserDAO userDAO = new UserDAO(connection);
        boolean flag = false;
        try {
            flag = userDAO.delete(user);
        } catch (DaoException e) {
            log.error("Service deleteUser wasn't executed, User wasn't deleted : " + e);
        }

        return flag;
    }
}
