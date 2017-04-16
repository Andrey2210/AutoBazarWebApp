package by.autobazar.services;

import by.autobazar.util.HibernateUtil;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;


/**
 * Created by Andrey
 * Date: 14.04.2017.
 * Time: 16:00
 */
public class CommentServiceTest {
    private static long id;
    private static CommentService commentService = CommentService.getInstance();

    @BeforeClass
    public static void set() {
        AbstractService.session = HibernateUtil.getHibernateUtil().getSession();
    }

    @AfterClass
    public static void deleteComment() {
        commentService.deleteComment(id);
        AbstractService.session.close();
    }

    @Test
    public void createTest() {
        id = commentService.createComment("HI", 48L, 3L);
        Assert.assertNotNull(id);
        Assert.assertTrue(id > 0);
    }
}
