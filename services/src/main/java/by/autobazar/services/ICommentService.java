package by.autobazar.services;

import by.autobazar.entity.Comment;

public interface ICommentService extends IService<Comment> {

    long createComment(String text, long carId, long userId);

    void deleteComment(Long id);
}