package kg.company.blogProject.services.impls;

import kg.company.blogProject.entities.Comment;
import kg.company.blogProject.repos.CommentRepo;
import kg.company.blogProject.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentRepo commentRepo;

    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

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
    public Boolean deleteCommentById(Long id) {
        commentRepo.deleteById(id);
        if(commentRepo.findById(id).isPresent()) {
            return false;
        } else return true;
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
    public String getTime(Long commentId) {
        String result = "";
        String createdDate = commentRepo.getTime(commentId);
        String now = null;
        Date n = null;
        Date tp = null;
        try {
            now = format.format(new Date());
            n = format.parse(now);
            tp = format.parse(createdDate);

            long diff = Math.abs(n.getTime() - tp.getTime());

            int diffSeconds = (int) (diff/1000);
            int diffMinutes = diffSeconds / 60;
            short diffHours = (short) (diffMinutes/60);
            short diffDays = (short) (diffHours/ 24);

            if(diffDays != 0 && diffDays == 1) {
                result = diffDays + " day";
            } else if (diffDays != 0 && diffDays != 1) {
                result = diffDays + " days";
            } else if (diffHours != 0 && diffHours == 1) {
                result = diffHours + " hour";
            } else if (diffHours != 0 && diffHours != 1) {
                result = diffHours + " hours";
            } else if (diffMinutes != 0 && diffMinutes == 1) {
                result = diffMinutes + " minute";
            } else if (diffMinutes != 0 && diffMinutes != 1) {
                result = diffMinutes + " minutes";
            } else result = diffSeconds + " seconds";
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result;
    }
}
