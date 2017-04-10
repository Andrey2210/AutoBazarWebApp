package by.autobazar.services;

import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Created by Andrey
 * Date: 08.04.2017.
 * Time: 19:03
 */
public abstract class AbstractService {
    public static Session session;

    public Transaction getTransaction() {
        Transaction transaction = null;
        transaction = session.beginTransaction();
        return transaction;
    }

}
