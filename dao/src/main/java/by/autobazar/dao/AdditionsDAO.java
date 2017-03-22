package by.autobazar.dao;

import by.autobazar.entity.Additions;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.List;

/**
 * Created by Andrey on 21.03.2017.
 */
public class AdditionsDAO extends AbstractDAO<Additions> {

    private static final Logger log = Logger.getLogger(AdditionsDAO.class);

    private static final String CREATE_ADDITION = "INSERT INTO additions " +
            "(additions.car_color, additions.interior_material, additions.interior_color) VALUES (?, ?, ?)";

    private static final String GET_BY_ID = "SELECT additions.id, additions.car_color, additions.interior_material, " +
            "additions.interior_color FROM additions WHERE additions.id=?";

    private static final String DELETE_QUERY = "DELETE FROM additions WHERE additions.id=?";

    /**
     * Creates a new DAO with a given connection object.
     *
     * @param connection - connection object.
     */
    public AdditionsDAO(Connection connection) {
        super(connection);
    }

    @Override
    public List<Additions> getAll() throws DaoException {
        return null;
    }

    @Override
    public Additions getById(long id) throws DaoException {

        log.info("getById : ");

        Additions additions = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            statement = connection.prepareStatement(GET_BY_ID);
            statement.setLong(1, id);
            resultSet = statement.executeQuery();
            if (resultSet != null && resultSet.next()) {
                additions = new Additions(resultSet.getLong("id"), resultSet.getString("car_color"),
                        resultSet.getString("interior_material"), resultSet.getString("interior_color"));
            }
        } catch (SQLException e) {
            log.warn("SQLException in getById()" + e);
            throw new DaoException(e);
        }  finally {
            close(statement);
        }
        return additions;
    }

    @Override
    public boolean delete(Additions additions) throws DaoException {
        log.info("deleteAdditions : ");

        PreparedStatement statement = null;
        int result;
        try {
            statement = connection.prepareStatement(DELETE_QUERY);
            statement.setLong(1, additions.getId());
            result = statement.executeUpdate();
        } catch (SQLException e) {
            log.warn("SQLException in delete() " + e);
            throw new DaoException("Additions wasn't deleted" + e);
        } finally {
            close(statement);
        }
        return result == 1;
    }

    @Override
    public boolean create(Additions additions) throws DaoException {
        log.info("create Additions : ");

        PreparedStatement statement = null;
        int result;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(CREATE_ADDITION, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, additions.getCarColor());
            statement.setString(2, additions.getInteriorMaterial());
            statement.setString(3, additions.getInteriorColor());
            result = statement.executeUpdate();
            resultSet = statement.getGeneratedKeys();
            if (resultSet != null && resultSet.next()) {
                additions.setId(resultSet.getLong(1));
            }
        } catch (SQLException e) {
            log.warn("SQLException in create() " + e);
            throw new DaoException("Additions wasn't created" + e);
        } finally {
            close(statement);
        }
        return result == 1;
    }

    @Override
    public Additions update(Additions entity) throws DaoException {
        return null;
    }
}
