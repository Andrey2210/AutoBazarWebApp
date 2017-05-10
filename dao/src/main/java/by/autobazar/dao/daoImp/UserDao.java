package by.autobazar.dao.daoImp;

import by.autobazar.dao.IUserDao;
import by.autobazar.entity.User;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * This class contains special methods for working with the entity User
 */
@Repository
public class UserDao extends BaseDao<User> implements IUserDao {

    @Autowired
    private UserDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public User getLoggedUser(String login, String password) {
        Query e = getSession().createQuery("FROM User U WHERE (U.login=:login OR U.email=:login) AND U.password=:password ");
        e.setParameter("login", login);
        e.setParameter("password", password);
        return (User) e.uniqueResult();
    }

    public List<User> getAll() {
        Query e = getSession().createQuery("FROM User");
        return e.list();
    }

    public User findByUserName(String login) {
        Query e = getSession().createQuery("FROM User U WHERE U.login=:login");
        e.setParameter("login", login);
        return (User) e.uniqueResult();
    }

    public User getByEmail(String email) {
        Query e = getSession().createQuery("FROM User U WHERE U.email=:email");
        e.setParameter("email", email);
        return (User) e.uniqueResult();
    }
}

