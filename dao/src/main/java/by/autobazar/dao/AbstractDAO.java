package by.autobazar.dao;

import by.autobazar.entity.Entity;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * Created by Andrey on 15.03.2017.
 */

/**
 * An abstract base class for DAO classes
 * @param <T> - entity class
 */
public abstract class AbstractDAO <T extends Entity> {

    private static final Logger log = Logger.getLogger(AbstractDAO.class);

    protected Connection connection;

    /**
     * Creates a new DAO with a given connection object.
     * @param connection - connection object.
     */
    public AbstractDAO(Connection connection) {
        this.connection = connection;
    }

    /**
     * Returns a list of all objects for entity class object <T>
     * @return
     * @throws DaoException
     */
    public abstract List<T> getAll() throws DaoException;

    /**
     * Returns a object of entity class object <T>
     * @param id - unique identificator for getting a entity class object <T>
     * @return
     * @throws DaoException
     */
    public abstract T getById(long id) throws DaoException;

    /**
     * Removes an entity object from the database
     * @param entity
     * @return If successfully returns true, if failure returns false
     * @throws DaoException
     */
    public abstract boolean delete(T entity) throws DaoException;

    /**
     * Creates a new entity object in the database.
     * @param entity
     * @return If successfully returns true, if failure returns false
     * @throws DaoException
     */
    public abstract boolean create(T entity) throws DaoException;

    /**
     * Updates the entity object
     * @param entity
     * @return Returns the updated entity object
     * @throws DaoException
     */
    public abstract T update(T entity) throws DaoException;


    /**
     * Releases this Statement object's database
     * @param st - Statement object
     */
    public void close(Statement st) {
        try {
            if (st != null) {
                st.close();
            }
        } catch (SQLException e) {
            log.error("Can't close statement: " + e);
        }
    }
}

