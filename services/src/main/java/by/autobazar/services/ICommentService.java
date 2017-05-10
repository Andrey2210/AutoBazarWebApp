package by.autobazar.services;

import by.autobazar.entity.Comment;

/**
 * Created by Andrey
 * Date: 25.04.2017.
 * Time: 22:26
 */
public interface ICommentService extends IService<Comment> {

    long createComment(String text, long carId, long userId);
}