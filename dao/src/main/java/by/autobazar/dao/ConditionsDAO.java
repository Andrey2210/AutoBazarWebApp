package by.autobazar.dao;

import by.autobazar.entity.Conditions;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.List;

/**
 * Created by Andrey on 21.03.2017.
 */
public class ConditionsDAO extends AbstractDAO<Conditions> {
    private static final Logger log = Logger.getLogger(ConditionsDAO.class);

    private static final String CREATE_CONDITIONS = "INSERT INTO conditions " +
            "(conditions.car_condition, conditions.mileage) VALUES (?, ?)";

    private static final String GET_BY_ID = "SELECT conditions.id, conditions.car_condition, " +
            "conditions.mileage FROM conditions WHERE conditions.id=?";

    private static final String DELETE_QUERY = "DELETE FROM conditions WHERE conditions.id=?";

    /**
     * Creates a new DAO with a given connection object.
     *
     * @param connection - connection object.
     */
    public ConditionsDAO(Connection connection) {
        super(connection);
    }

    @Override
    public List<Conditions> getAll() throws DaoException {
        return null;
    }

    @Override
    public Conditions getById(long id) throws DaoException {

        log.info("getById : ");

        Conditions conditions = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            statement = connection.prepareStatement(GET_BY_ID);
            statement.setLong(1, id);
            resultSet = statement.executeQuery();
            if (resultSet != null && resultSet.next()) {
                conditions = new Conditions(resultSet.getLong("id"), resultSet.getString("car_condition"),
                        resultSet.getInt("mileage"));
            }
        } catch (SQLException e) {
            log.warn("SQLException in getById()" + e);
            throw new DaoException(e);
        }  finally {
            close(statement);
        }
        return conditions;
    }

    @Override
    public boolean delete(Conditions conditions) throws DaoException {
        log.info("deleteConditions : ");

        PreparedStatement statement = null;
        int result;
        try {
            statement = connection.prepareStatement(DELETE_QUERY);
            statement.setLong(1, conditions.getId());
            result = statement.executeUpdate();
        } catch (SQLException e) {
            log.warn("SQLException in delete() " + e);
            throw new DaoException("Conditions wasn't deleted" + e);
        } finally {
            close(statement);
        }
        return result == 1;
    }

    @Override
    public boolean create(Conditions conditions) throws DaoException {
        log.info("create Conditions : ");

        PreparedStatement statement = null;
        int result;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(CREATE_CONDITIONS, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, conditions.getCarCondition());
            statement.setInt(2, conditions.getMilleage());
            result = statement.executeUpdate();
            resultSet = statement.getGeneratedKeys();
            if (resultSet != null && resultSet.next()) {
                conditions.setId(resultSet.getLong(1));
            }
        } catch (SQLException e) {
            log.warn("SQLException in create() " + e);
            throw new DaoException("Conditions wasn't created" + e);
        } finally {
            close(statement);
        }
        return result == 1;
    }

    @Override
    public Conditions update(Conditions entity) throws DaoException {
        return null;
    }
}
