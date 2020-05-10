package kg.company.blogProject.repos;

import kg.company.blogProject.entities.Post;
import kg.company.blogProject.entities.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TagRepo extends JpaRepository<Tag, Long> {
    List<Tag> getAllByTagText(String tagText);
    @Query("FROM Post_Tag where post_id = :postId")
    List<Tag> getAllByPost(Long postId);
}
