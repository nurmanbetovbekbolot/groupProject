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
    List<Comment> getAllByPostId(Long id);

    @Query(value = "select date_part('day', age(now(), c.created_date)) from b_comment c where c.id = ?1", nativeQuery = true)
    Double timePassed(Long commentId);
}
