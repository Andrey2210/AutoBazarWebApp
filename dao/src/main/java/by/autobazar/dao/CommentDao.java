package by.autobazar.dao;

import by.autobazar.entity.Comment;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * This class contains special methods for working with the entity Comment
 *
 */
@Repository
public class CommentDao extends BaseDao<Comment> implements ICommentDao {

    private static Logger log = Logger.getLogger(CommentDao.class);

    @Autowired
    private CommentDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }
}