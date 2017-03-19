package by.autobazar.dao;

/**
 * Created by Andrey on 19.03.2017.
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