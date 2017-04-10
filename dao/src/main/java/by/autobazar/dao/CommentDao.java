package by.autobazar.dao;

import by.autobazar.entity.Comment;
import org.apache.log4j.Logger;
import org.hibernate.Session;

/**
 * Created by Andrey
 * Date: 31.03.2017.
 * Time: 0:14
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