package by.autobazar.dao;

import by.autobazar.entity.Comments;
import org.apache.log4j.Logger;

import java.io.UnsupportedEncodingException;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Andrey on 22.03.2017.
 */
public class CommentsDAO extends AbstractDAO<Comments> {

    private static final Logger log = Logger.getLogger(CommentsDAO.class);

    private static final String CREATE_COMMENT_QUERY = "INSERT INTO comments " +
            "(comments.car_id, comments.comment, comments.user_id) VALUES (?, ?, ?)";

    private static final String GET_ALL_BY_CAR_QUERY = "SELECT comments.id, comments.car_id, comments.comment, " +
            "comments.user_id FROM comments WHERE comments.car_id=?";

    /**
     * Creates a new DAO with a given connection object.
     *
     * @param connection - connection object.
     */
    public CommentsDAO(Connection connection) {
        super(connection);
    }

    @Override
    public List<Comments> getAll() throws DaoException {
        return null;
    }

    @Override
    public Comments getById(long id) throws DaoException {
        return null;
    }

    @Override
    public boolean delete(Comments entity) throws DaoException {
        return false;
    }

    @Override
    public boolean create(Comments comments) throws DaoException {
        log.info("create Additions : ");

        PreparedStatement statement = null;
        int result;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(CREATE_COMMENT_QUERY, Statement.RETURN_GENERATED_KEYS);
            statement.setLong(1, comments.getCarId());
            statement.setString(2, comments.getComment());
            statement.setLong(3, comments.getUserId());
            result = statement.executeUpdate();
            resultSet = statement.getGeneratedKeys();
            if (resultSet != null && resultSet.next()) {
                comments.setId(resultSet.getLong(1));
            }
        } catch (SQLException e) {
            log.warn("SQLException in create() " + e);
            throw new DaoException("Comments wasn't created" + e);
        } finally {
            close(statement);
        }
        return result == 1;
    }

    @Override
    public Comments update(Comments entity) throws DaoException {
        return null;
    }

    public List<Comments> getAllByCar(Long carId) throws DaoException {
        log.info("create getAllByCar : ");

        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Comments> commentsList = new LinkedList<>();
        try {
            statement = connection.prepareStatement(GET_ALL_BY_CAR_QUERY);
            statement.setLong(1, carId);
            resultSet = statement.executeQuery();
            while (resultSet != null && resultSet.next()) {
                String comment = new String(resultSet.getBlob("comment").getBytes(1L,
                        (int) resultSet.getBlob("comment").length()), "UTF-8");
                commentsList.add(new Comments(resultSet.getLong("id"), resultSet.getLong("car_id"),
                        comment, resultSet.getLong("user_id")));
            }
        } catch (SQLException e) {
            log.warn("SQLException in getAllByCar() " + e);
            throw new DaoException("Comments wasn't created" + e);
        } catch (UnsupportedEncodingException e) {
            log.warn("UnsupportedEncodingException in getAllByCar() " + e);
            throw new DaoException("Comments wasn't created" + e);
        } finally {
            close(statement);
        }
        return commentsList;
    }
}
