package kg.company.blogProject.repos;

import kg.company.blogProject.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepo extends JpaRepository<Comment, Long> {
    List<Comment> getAllByCommentText(String commentText);
    List<Comment> getAllByUserId(Long id);
    @Query(value = "select c.created_date from b_comment c where c.id = ?1", nativeQuery = true)
    String getTime(Long commentId);
}
