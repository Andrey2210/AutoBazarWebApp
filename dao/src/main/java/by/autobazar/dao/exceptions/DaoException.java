package by.autobazar.dao.exceptions;

/**
 * Created by Andrey
 * Date: 29.03.2017.
 * Time: 1:57
 */
public class DaoException extends Exception {

    public DaoException() {
    }

    public DaoException(String message, Throwable exception) {
        super(message, exception);
    }

    public DaoException(String message) {
        super(message);
    }

    public DaoException(Throwable exception) {
        super(exception);
    }
}
