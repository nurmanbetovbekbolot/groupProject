package kg.company.blogProject.repos;

import kg.company.blogProject.entities.Post;
import kg.company.blogProject.models.PostRatings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PostRepo extends JpaRepository<Post, Long> {
    List<Post> getAllByCategory_Name(String category);

    List<Post> getAllByTitle(String title);

    List<Post> getAllByUserId(Long user_id);

    List<Post> getAllByPublicationTime(Date publicationTime);

    List<Post> getAllByPublicationTimeBetween(Date initPublicationTime, Date finalPublicationTime);

    List<Post> getAllByPublicationTimeGreaterThan(Date initRegistrationDate);

    @Query(value = "select p.* from b_post p left join b_tag t on p.tag_id = t.id where t.id = ?1", nativeQuery = true)
    List<Post> getAllByTag(Long tagId);

    @Query(value = "select count(p.id) as post_count from b_post p right join b_user u on p.user_id = u.id where user_id = ?1", nativeQuery = true)
    Integer getPostCountByUserId(Long userId);

    @Query(value = "select count(c.id) from b_comment c right join b_post p on p.id = c.post_id where c.post_id = ?1", nativeQuery = true)
    Integer getCommentCountByPostId(Long postId);

    @Query(value = "select avg(r.value) from b_rating r left join b_post p on p.id = r.post_id where r.post_id = ?1", nativeQuery = true)
    Float getRatingByPostId(Long postId);

    @Query(value = "select new kg.company.blogProject.models.PostRatings(r.value, r.user.id)" +
            "from Rating r join r.post p where r.post.id = :postId")
    List<PostRatings> getAllRatings(Long postId);

    @Query(value = "select date_part('day', age(now(), p.publication_time)) from b_post p where p.id = ?1", nativeQuery = true)
    Double timePassed(Long postId);
}
