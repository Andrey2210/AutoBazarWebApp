package by.autobazar.dao;

import by.autobazar.dao.exceptions.DaoException;
import by.autobazar.entity.User;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;

import java.util.List;

/**
 * This class contains special methods for working with the entity User
 *
 */
public class UserDao extends BaseDao<User> {
    private static Logger log = Logger.getLogger(UserDao.class);
    private static UserDao INSTANCE = null;

    private UserDao() {
    }

    public static UserDao getInstance() {
        if(INSTANCE == null) {
            Class var0 = UserDao.class;
            synchronized(UserDao.class) {
                if(INSTANCE == null) {
                    INSTANCE = new UserDao();
                }
            }
        }

        return INSTANCE;
    }

    /**
     * This method load User by his login and password
     *
     * @param login    Users login in String
     * @param password  Users password
     * @return Object of User appropriate
     * @throws DaoException
     */
    public User getLoggedUser(String login, String password) throws DaoException {
        log.info("getLoggedUser : ");

        try {
            Query e = this.session.createQuery("FROM User U WHERE (U.login=:login OR U.email=:login) AND U.password=:password ");
            e.setParameter("login", login);
            e.setParameter("password", password);
            User user = (User)e.uniqueResult();
            log.info("getLoggedUser result list: " + user);
            return user;
        } catch (HibernateException var5) {
            log.error("Error getLoggedUser() " + var5);
            throw new DaoException(var5);
        }
    }

    /**
     * This method loads all Users from the database
     *
     * @return List of object-typed User
     * @throws DaoException
     */
    public List<User> getAll() throws DaoException {
        log.info("getAll : ");

        try {
            Query e = this.session.createQuery("FROM User");
            List userList = e.list();
            log.info("getAll result list: " + userList);
            return userList;
        } catch (HibernateException var3) {
            log.error("Error getAll() " + var3);
            throw new DaoException(var3);
        }
    }
}
