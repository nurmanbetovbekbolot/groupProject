package kg.company.blogProject.repos;

import kg.company.blogProject.entities.Post;
import kg.company.blogProject.entities.Rating;
import kg.company.blogProject.models.RatingModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepo extends JpaRepository<Rating, Long> {
    @Query(value = "select new kg.company.blogProject.models.RatingModel(r.id, r.value, r.post.id, r.user.id)" +
            "from Rating r where r.id = :id")
    RatingModel getById(Long id);

    @Query(value = "select new kg.company.blogProject.models.RatingModel(r.id, r.value, r.post.id, r.user.id)" +
            "from Rating r")
    List<RatingModel> getAll();

    List<Rating> findAllByValue(Integer value);
    @Query(value = "select new kg.company.blogProject.models.RatingModel(r.id, r.value, r.post.id, r.user.id)" +
            "from Rating r where r.value = :value")
    List<RatingModel> getAllByValue(Integer value);

    List<Rating> findAllByUser_Id(Long id);
    @Query(value = "select new kg.company.blogProject.models.RatingModel(r.id, r.value, r.post.id, r.user.id)" +
            "from Rating r join r.user u where u.id = :id")
    List<RatingModel> getAllByUser(Long id);

    List<Rating> findAllByPost_Id(Long id);
    @Query(value = "select new kg.company.blogProject.models.RatingModel(r.id, r.value, r.post.id, r.user.id)" +
            "from Rating r join r.post p where p.id = :id")
    List<RatingModel> getAllByPost(Long id);

    @Query(value = "SELECT SUM(r.value) FROM Rating r left join r.post p where p.id = :postId")
    Long findOverall(Long postId);
}
