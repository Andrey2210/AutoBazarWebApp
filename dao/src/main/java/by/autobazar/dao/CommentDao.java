package by.autobazar.dao;

import by.autobazar.entity.Comment;
import org.apache.log4j.Logger;
import org.hibernate.Session;

/**
 * This class contains special methods for working with the entity Comment
 *
 */
public class CommentDao extends BaseDao<Comment> {

    private static Logger log = Logger.getLogger(CommentDao.class);
    private static CommentDao INSTANCE = null;

    private CommentDao() {}

    public static CommentDao getInstance() {
        if (INSTANCE == null) {
            synchronized (CommentDao.class) {
                if (INSTANCE == null) {
                    INSTANCE = new CommentDao();
                }
            }
        }
        return INSTANCE;
    }

}