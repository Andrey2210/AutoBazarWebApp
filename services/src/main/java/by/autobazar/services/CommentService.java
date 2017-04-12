package by.autobazar.services;

import by.autobazar.dao.CommentDao;
import by.autobazar.dao.exceptions.DaoException;
import by.autobazar.entity.Car;
import by.autobazar.entity.Comment;
import by.autobazar.entity.User;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Transaction;

import java.time.LocalDateTime;

/**
 * Created by Andrey
 * Date: 09.04.2017.
 * Time: 22:50
 */
public class CommentService extends AbstractService{

    private static final Logger log = Logger.getLogger(CommentService.class);
    private static CommentService INSTANCE = null;
    private CommentDao commentDao = CommentDao.getInstance();

    private CommentService() {
    }

    public static CommentService getInstance() {
        if (INSTANCE == null) {
            synchronized (CommentService.class) {
                if (INSTANCE == null) {
                    INSTANCE = new CommentService();
                }
            }
        }
        return INSTANCE;
    }

    public long createComment(String text, long carId, long userId)  {
        log.info("Service createComment(): ");

        commentDao.session = session;
        User user = UserService.getInstance().getUserById(userId);
        Car car = CarService.getInstance().getCarById(carId);

        Comment comment = new Comment(text, LocalDateTime.now());
        comment.setUser(user);
        comment.setCar(car);
        Transaction transaction = getTransaction();
        try {
            commentDao.saveOrUpdate(comment);
            transaction.commit();
        } catch (DaoException | HibernateException e) {
            log.info("Error in service createComment(): " + e);
            transaction.rollback();
        }
        return car.getId();
    }

    public void deleteComment(Long id) {
        log.info("Service deleteComment(): ");

        commentDao.session = session;
        Transaction transaction = getTransaction();
        Comment comment= null;
        try {
            comment = commentDao.get(id);
            transaction.commit();
            if(comment != null) {
                transaction = getTransaction();
                commentDao.delete(comment);
                transaction.commit();
            }
        } catch (DaoException | HibernateException e) {
            log.info("Error in service deleteComment(): " + e);
            transaction.rollback();
        }
    }
}
