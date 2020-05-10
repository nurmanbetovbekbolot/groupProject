package kg.company.blogProject.services.impls;

import kg.company.blogProject.entities.Comment;
import kg.company.blogProject.repos.CommentRepo;
import kg.company.blogProject.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentRepo commentRepo;

    @Override
    public Comment saveComment(Comment comment) {
        return commentRepo.save(comment);
    }

    @Override
    public Comment getCommentById(Long id) {
        Optional<Comment> comment = commentRepo.findById(id);
        return comment.get();
    }

    @Override
    public List<Comment> getAllComments() {
        return commentRepo.findAll();
    }

    @Override
    public Comment updateComment(Long id, Comment comment) {
        if(commentRepo.findById(id).isPresent()) {
            Comment existingComment = commentRepo.findById(id).get();
            existingComment.setCommentText(comment.getCommentText());
            existingComment.setUser(comment.getUser());
            existingComment.setPost(comment.getPost());
            Comment updatedComment = commentRepo.save(existingComment);
            return updatedComment;
        }
        else return null;
    }

    @Override
    public String deleteCommentById(Long id) {
        String result = "deleted " + commentRepo.findById(id);
        commentRepo.deleteById(id);
        return result;
    }

    @Override
    public List<Comment> getAllCommentsByCommentText(String commentText) {
        return commentRepo.getAllByCommentText(commentText);
    }

    @Override
    public List<Comment> getAllCommentsByUserId(Long userId) {
        return commentRepo.getAllByUserId(userId);
    }

    @Override
    public List<Comment> getAllCommentsByPostId(Long postId) {
        return commentRepo.getAllByPostId(postId);
    }
}
