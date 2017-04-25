package by.autobazar.dao;

import by.autobazar.entity.User;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * This class contains special methods for working with the entity User
 *
 */
@Repository
public class UserDao extends BaseDao<User> {
    private static Logger log = Logger.getLogger(UserDao.class);

    @Autowired
    private UserDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    /**
     * This method load User by his login and password
     *
     * @param login    Users login in String
     * @param password  Users password
     * @return Object of User appropriate
     */
    public User getLoggedUser(String login, String password) {
        log.info("getLoggedUser : ");
            Query e = getSession().createQuery("FROM User U WHERE (U.login=:login OR U.email=:login) AND U.password=:password ");
            e.setParameter("login", login);
            e.setParameter("password", password);
            return (User) e.uniqueResult();

    }

    /**
     * This method loads all Users from the database
     *
     * @return List of object-typed User
     */
    public List<User> getAll() {
        log.info("getAll : ");
            Query e = getSession().createQuery("FROM User");
            return e.list();
    }
}
