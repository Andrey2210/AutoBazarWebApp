package by.autobazar.dao;


import by.autobazar.connection.DbConnection;
import by.autobazar.entity.Entity;
import by.autobazar.entity.User;

import java.sql.*;


/**
 * Created by Andrey on 02.03.2017.
 */
public class UserDAO implements Dao<User> {

    private static final String GET_LOGGED_USER = "SELECT users.id, users.login, users.email," +
            " users.password, users.name, users.phone, users.role FROM users WHERE " +
            "(users.login=? OR users.email=?) AND users.password=?";

    private static final String ADD_USER = "INSERT INTO users (users.login, users.email, users.password, users.name, " +
            "users.phone) VALUES (?, ?, ?, ?, ?)";


    private static UserDAO INSTANCE = null;

    private UserDAO() {}

    public static UserDAO getInstance() {
        if (INSTANCE == null) {
            synchronized (UserDAO.class) {
                if (INSTANCE == null) {
                    INSTANCE = new UserDAO();
                }
            }
        }
        return INSTANCE;
    }

    public User getLoggedUser(String login, String password) {
        User result = null;
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DbConnection.getConnection();
            statement = connection.prepareStatement(GET_LOGGED_USER);
            statement.setString(1, login);
            statement.setString(2, login);
            statement.setString(3, password);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet != null && resultSet.next()) {
                result = new User(resultSet.getLong("id"), resultSet.getString("login"),
                        resultSet.getString("email"), resultSet.getString("password"),
                        resultSet.getString("name"), resultSet.getString("phone"),
                        resultSet.getString("role"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }


    @Override
    public void add(User user) {
        Connection connection = null;
        PreparedStatement prepareStatement = null;
        ResultSet resultSet = null;
        try {
            connection = DbConnection.getConnection();
            prepareStatement = connection.prepareStatement(ADD_USER);
            prepareStatement.setString(1, user.getLogin());
            prepareStatement.setString(2, user.getEmail());
            prepareStatement.setString(3, user.getPassword());
            prepareStatement.setString(4, user.getName());
            prepareStatement.setString(5, user.getPhone());
            resultSet = prepareStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(User user) {

    }

    @Override
    public User get(User user, long id) {
        return null;
    }

    @Override
    public void delete(User user) {

    }
}
