package by.autobazar.dao;

import by.autobazar.entity.Characteristics;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.List;

/**
 * Created by Andrey on 21.03.2017.
 */
public class CharacteristicsDAO extends AbstractDAO<Characteristics> {

    private static final Logger log = Logger.getLogger(CharacteristicsDAO.class);

    private static final String CREATE_CHARACTERISTIC = "INSERT INTO characteristics " +
            "(characteristics.doors_number, characteristics.fuel_type, characteristics.engine_capacity, " +
            "characteristics.driving) VALUES (?, ?, ?, ?)";

    private static final String GET_BY_ID = "SELECT characteristics.id, characteristics.doors_number, " +
            "characteristics.fuel_type, characteristics.engine_capacity, characteristics.driving FROM characteristics " +
            "WHERE characteristics.id=?";

    private static final String DELETE_QUERY = "DELETE FROM characteristics WHERE characteristics.id=?";

    /**
     * Creates a new DAO with a given connection object.
     *
     * @param connection - connection object.
     */
    public CharacteristicsDAO(Connection connection) {
        super(connection);
    }

    @Override
    public List<Characteristics> getAll() throws DaoException {
        return null;
    }

    @Override
    public Characteristics getById(long id) throws DaoException {

        log.info("getById : ");

        Characteristics characteristics = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            statement = connection.prepareStatement(GET_BY_ID);
            statement.setLong(1, id);
            resultSet = statement.executeQuery();
            if (resultSet != null && resultSet.next()) {
                characteristics = new Characteristics(resultSet.getLong("id"), resultSet.getInt("doors_number"),
                        resultSet.getString("fuel_type"), resultSet.getDouble("engine_capacity"),
                        resultSet.getString("driving"));
            }
        } catch (SQLException e) {
            log.warn("SQLException in getById()" + e);
            throw new DaoException(e);
        }  finally {
            close(statement);
        }
        return characteristics;
    }

    @Override
    public boolean delete(Characteristics characteristics) throws DaoException {
        log.info("deleteCharacteristics : ");

        PreparedStatement statement = null;
        int result;
        try {
            statement = connection.prepareStatement(DELETE_QUERY);
            statement.setLong(1, characteristics.getId());
            result = statement.executeUpdate();
        } catch (SQLException e) {
            log.warn("SQLException in delete() " + e);
            throw new DaoException("characteristics wasn't deleted" + e);
        } finally {
            close(statement);
        }
        return result == 1;
    }

    @Override
    public boolean create(Characteristics characteristics) throws DaoException {
        log.info("create Characteristics : ");

        PreparedStatement statement = null;
        int result;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(CREATE_CHARACTERISTIC, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, characteristics.getDoorsNumber());
            statement.setString(2, characteristics.getFuelType());
            statement.setDouble(3, characteristics.getEngineCapacity());
            statement.setString(4, characteristics.getDriving());
            result = statement.executeUpdate();
            resultSet = statement.getGeneratedKeys();
            if (resultSet != null && resultSet.next()) {
                characteristics.setId(resultSet.getLong(1));
            }
        } catch (SQLException e) {
            log.warn("SQLException in create() " + e);
            throw new DaoException("Characteristics wasn't created" + e);
        } finally {
            close(statement);
        }
        return result == 1;
    }

    @Override
    public Characteristics update(Characteristics entity) throws DaoException {
        return null;
    }
}
