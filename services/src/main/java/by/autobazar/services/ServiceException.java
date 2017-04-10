package by.autobazar.services;

/**
 * Created by Andrey
 * Date: 08.04.2017.
 * Time: 17:16
 */
public class ServiceException extends Exception {

    public ServiceException() {    }

    public ServiceException(String message, Throwable exception) {
        super(message, exception);
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(Throwable exception) {
        super(exception);
    }
}
