package by.autobazar.services;

import by.autobazar.entity.Car;
import by.autobazar.entity.carEnum.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;


@ContextConfiguration(locations = {"classpath:test-service.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class CommentServiceTest {

    @Autowired
    private ICommentService commentService;

    @Test
    public void createTest() {
        long id = commentService.createComment("HI", 134L, 503L);
        Assert.assertNotNull(id);
        Assert.assertTrue(id > 0);
        commentService.deleteComment(id);
    }
}
