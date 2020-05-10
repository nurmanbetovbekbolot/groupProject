package kg.company.blogProject.repos;

import kg.company.blogProject.entities.Post;
import kg.company.blogProject.entities.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepo extends JpaRepository<Rating, Long> {
    List<Rating> findAllByValue(Integer value);
    List<Rating> findAllByUser_Id(Long id);
    List<Rating> findAllByPost_Id(Long id);
    @Query(value = "SELECT SUM(r.value) FROM Rating r left join Post p where p.id = :postId")
    Long findOverall(Long postId);
}
