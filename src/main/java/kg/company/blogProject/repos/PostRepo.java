package kg.company.blogProject.repos;

import kg.company.blogProject.entities.Post;
import kg.company.blogProject.models.CommentsOfPostModel;
import kg.company.blogProject.models.PostModel;
import kg.company.blogProject.models.PostRatingsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepo extends JpaRepository<Post, Long> {
    @Query(value = "select new kg.company.blogProject.models.PostModel(p.id, p.title, p.textBody, p.user.id, p.category.name, p.publicationTime, p.shortDescription)" +
            "from Post p where p.id = :id")
    PostModel getById(Long id);

    @Query(value = "select new kg.company.blogProject.models.PostModel(p.id, p.title, p.textBody, p.user.id, p.category.name, p.publicationTime, p.shortDescription)" +
            "from Post p")
    List<PostModel> getAll();

    List<Post> getAllByCategoryName(String category);
    @Query(value = "select new kg.company.blogProject.models.PostModel(p.id, p.title, p.textBody, p.user.id, p.category.name, p.publicationTime, p.shortDescription)" +
            "from Post p join p.category c where c.name = :category")
    List<PostModel> getByCategoryName(String category);

    List<Post> getAllByTitle(String title);
    @Query(value = "select new kg.company.blogProject.models.PostModel(p.id, p.title, p.textBody, p.user.id, p.category.name, p.publicationTime, p.shortDescription)" +
            "from Post p where p.title = :title")
    List<PostModel> getByTitle(String title);

    List<Post> getAllByUserId(Long userId);
    @Query(value = "select new kg.company.blogProject.models.PostModel(p.id, p.title, p.textBody, p.user.id, p.category.name, p.publicationTime, p.shortDescription)" +
            "from Post p join p.user u where u.id = :userId")
    List<PostModel> getPostsByUserId(Long userId);

    @Query(value = "select p from Post p join p.tags t where t.tagText = :tag")
    List<Post> getByTag(String tag);

    @Query(value = "select new kg.company.blogProject.models.PostModel(p.id, p.title, p.textBody, p.user.id, p.category.name, p.publicationTime, p.shortDescription)" +
            "from Post p join p.tags t where t.tagText = :tag")
    List<PostModel> getAllByTag(String tag);

    @Query(value = "select t.tagText from Post p join p.tags t where p.id = :postId")
    public List<String> getTagsByPost(Long postId);

    @Query(value = "select count(p.id) as post_count from b_post p right join b_user u on p.user_id = u.id where user_id = ?1", nativeQuery = true)
    Integer getPostCountByUserId(Long userId);

    @Query(value = "select count(c.id) from b_comment c right join b_post p on p.id = c.post_id where c.post_id = ?1", nativeQuery = true)
    Integer getCommentCountByPostId(Long postId);

    @Query(value = "select avg(r.value) from b_rating r left join b_post p on p.id = r.post_id where r.post_id = ?1", nativeQuery = true)
    Float getRatingByPostId(Long postId);

    @Query(value = "select new kg.company.blogProject.models.PostRatingsModel(r.value, r.user.id)" +
            "from Rating r join r.post p where r.post.id = :postId")
    List<PostRatingsModel> getAllRatings(Long postId);

    @Query(value = "select p.publication_time from b_post p where p.id = ?1", nativeQuery = true)
    String getPublicationTime(Long postId);

    @Query(value = "select new kg.company.blogProject.models.CommentsOfPostModel(c.commentText, c.user.id)" +
            "from Comment c join c.post p where c.post.id = :postId")
    List<CommentsOfPostModel> getComments(Long postId);


}
