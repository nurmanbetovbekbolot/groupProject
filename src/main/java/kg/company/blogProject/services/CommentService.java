package kg.company.blogProject.services;

import kg.company.blogProject.entities.Comment;

import java.util.List;

public interface CommentService {
    Comment saveComment(Comment comment);
    Comment getCommentById(Long id);
    List<Comment> getAllComments();
    Comment updateComment(Long id, Comment comment);
    String deleteCommentById(Long id);
    List<Comment> getAllCommentsByCommentText(String commentText);
    List<Comment> getAllCommentsByUserId(Long userId);
    List<Comment> getAllCommentsByPostId(Long postId);
}
