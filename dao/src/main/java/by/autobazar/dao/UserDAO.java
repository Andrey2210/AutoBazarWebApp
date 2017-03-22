package by.autobazar.dao;


import by.autobazar.connection.DbConnection;
import by.autobazar.entity.User;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.List;


/**
 * Created by Andrey on 02.03.2017.
 */
public class UserDAO extends AbstractDAO<User> {

    private static final Logger log = Logger.getLogger(UserDAO.class);

    private static final String GET_LOGGED_USER = "SELECT users.id, users.login, users.email," +
            " users.password, users.name, users.phone, users.role FROM users WHERE " +
            "(users.login=? OR users.email=?) AND users.password=?";

    private static final String ADD_USER = "INSERT INTO users (users.login, users.email, users.password, users.name, " +
            "users.phone) VALUES (?, ?, ?, ?, ?)";

    private static final String GET_USER_BY_ID = "SELECT users.id, users.login, users.email," +
            " users.password, users.name, users.phone, users.role FROM users WHERE users.id=?";

    private static final String DELETE_USER = "DELETE FROM users WHERE id=?";

    public UserDAO(Connection connection) {
        super(connection);
    }



    public User getLoggedUser(String login, String password) throws DaoException {

        log.info("getLoggedUser : ");

        User result = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            statement = connection.prepareStatement(GET_LOGGED_USER);
            statement.setString(1, login);
            statement.setString(2, login);
            statement.setString(3, password);
            resultSet = statement.executeQuery();
            if (resultSet != null && resultSet.next()) {
                result = new User(resultSet.getLong("id"), resultSet.getString("login"),
                        resultSet.getString("email"), resultSet.getString("password"),
                        resultSet.getString("name"), resultSet.getString("phone"),
                        resultSet.getString("role"));
            }
        } catch (SQLException e) {
            log.warn("SQLException in getLoggedUser() " + e);
            throw new DaoException(e);
        } finally {
            close(statement);
        }
        return result;
    }



    @Override
    public boolean create(User user) throws DaoException {

        log.info("create User : ");

        PreparedStatement statement = null;
        int result;
        try {
            statement = connection.prepareStatement(ADD_USER);
            statement.setString(1, user.getLogin());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getPassword());
            statement.setString(4, user.getName());
            statement.setString(5, user.getPhone());
            result = statement.executeUpdate();
        } catch (SQLException e) {
            log.warn("SQLException in create() " + e);
            throw new DaoException("User wasn't created" + e);
        } finally {
            close(statement);
        }
        return result == 1;
    }

    @Override
    public User update(User entity) throws DaoException {
        return null;
    }

    @Override
    public List<User> getAll() throws DaoException {
        return null;
    }

    @Override
    public User getById(long id) throws DaoException {
        log.info("getById : ");

        User result = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            statement = connection.prepareStatement(GET_USER_BY_ID);
            statement.setLong(1, id);
            resultSet = statement.executeQuery();
            if (resultSet != null && resultSet.next()) {
                result = new User(resultSet.getLong("id"), resultSet.getString("login"),
                        resultSet.getString("email"), resultSet.getString("password"),
                        resultSet.getString("name"), resultSet.getString("phone"),
                        resultSet.getString("role"));
            }
        } catch (SQLException e) {
            log.warn("SQLException in getById() " + e);
            throw new DaoException(e);
        } finally {
            close(statement);
        }
        return result;
    }

    @Override
    public boolean delete(User user) throws DaoException {

        log.info("deleteUser : ");

        PreparedStatement statement = null;
        int result;
        try {
            statement = connection.prepareStatement(DELETE_USER);
            statement.setLong(1, user.getId());
            result = statement.executeUpdate();
        } catch (SQLException e) {
            log.warn("SQLException in deleteUser() " + e);
            throw new DaoException("User wasn't created" + e);
        } finally {
            close(statement);
        }
        return result == 1;
    }

}
