package by.autobazar.dao;

import by.autobazar.entity.Locations;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.List;

/**
 * Created by Andrey on 21.03.2017.
 */
public class LocationsDAO extends AbstractDAO<Locations> {
    private static final Logger log = Logger.getLogger(LocationsDAO.class);

    private static final String CREATE_LOCATION= "INSERT INTO locations " +
            "(locations.region, locations.city) VALUES (?, ?)";

    private static final String GET_BY_ID = "SELECT locations.id, locations.region, locations.city " +
            "FROM locations WHERE locations.id=?";

    private static final String DELETE_QUERY = "DELETE FROM locations WHERE locations.id=?";


    /**
     * Creates a new DAO with a given connection object.
     *
     * @param connection - connection object.
     */
    public LocationsDAO(Connection connection) {
        super(connection);
    }

    @Override
    public List<Locations> getAll() throws DaoException {
        return null;
    }

    @Override
    public Locations getById(long id) throws DaoException {

        log.info("getById : ");

        Locations locations = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            statement = connection.prepareStatement(GET_BY_ID);
            statement.setLong(1, id);
            resultSet = statement.executeQuery();
            if (resultSet != null && resultSet.next()) {
                locations = new Locations(resultSet.getLong("id"), resultSet.getString("region"),
                        resultSet.getString("city"));
            }
        } catch (SQLException e) {
            log.warn("SQLException in getById()" + e);
            throw new DaoException(e);
        }  finally {
            close(statement);
        }
        return locations;
    }

    @Override
    public boolean delete(Locations locations) throws DaoException {
        log.info("deleteLocations : ");

        PreparedStatement statement = null;
        int result;
        try {
            statement = connection.prepareStatement(DELETE_QUERY);
            statement.setLong(1, locations.getId());
            result = statement.executeUpdate();
        } catch (SQLException e) {
            log.warn("SQLException in delete() " + e);
            throw new DaoException("Locations wasn't deleted" + e);
        } finally {
            close(statement);
        }
        return result == 1;
    }

    @Override
    public boolean create(Locations locations) throws DaoException {
        log.info("create Locations : ");

        PreparedStatement statement = null;
        int result;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(CREATE_LOCATION, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, locations.getRegion());
            statement.setString(2, locations.getCity());
            result = statement.executeUpdate();
            resultSet = statement.getGeneratedKeys();
            if (resultSet != null && resultSet.next()) {
                locations.setId(resultSet.getLong(1));
            }
        } catch (SQLException e) {
            log.warn("SQLException in create() " + e);
            throw new DaoException("Locations wasn't created" + e);
        } finally {
            close(statement);
        }
        return result == 1;
    }

    @Override
    public Locations update(Locations entity) throws DaoException {
        return null;
    }
}
