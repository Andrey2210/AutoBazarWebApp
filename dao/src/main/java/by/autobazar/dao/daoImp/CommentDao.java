package by.autobazar.dao.daoImp;

import by.autobazar.dao.ICommentDao;
import by.autobazar.entity.Comment;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * This class contains special methods for working with the entity Comment
 *
 */
@Repository
public class CommentDao extends BaseDao<Comment> implements ICommentDao {

    @Autowired
    private CommentDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }
}